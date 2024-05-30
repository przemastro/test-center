from flask import Flask, render_template, request, redirect
from mongoDBConnector import getBugsCount, connectDB, getBugsCountPerPriority, getResponseTimes, getBugs, updateMongoDB
from plots import pieChart, performanceChart
import pandas as pd

app = Flask(__name__)
address = "10.169.101.169"
#address = "localhost"

@app.route("/")
def getData():
    count = getBugsCount()
    countPerPriority = getBugsCountPerPriority()
    plotHelper(countPerPriority)
    performanceChart(getResponseTimes())
    return render_template("index.html", count=count,
                           mobileApiBugs=getBugsHelper(getBugs(), 'mobileApiBugs'),
                           webApiBugs=getBugsHelper(getBugs(), 'webApiBugs'),
                           androidBugs=getBugsHelper(getBugs(), 'androidBugs'),
                           iOSBugs=getBugsHelper(getBugs(), 'iOSBugs'),
                           webBugs=getBugsHelper(getBugs(), 'webBugs'))

@app.route('/restart')
def restart():
    func = request.environ.get('werkzeug.server.shutdown')
    if func is None:
        raise RuntimeError('Not running with the Werkzeug Server')
    func()

@app.route('/addbug', methods=['POST'])
def addbug():
    severity = request.form['severity']
    number = request.form['number']
    area = request.form['area']
    updateMongoDB(severity, number, area, "PUT")
    return redirect("http://"+address+":5000", code=302)

@app.route('/removebug', methods=['POST'])
def removebug():
    number = request.form['number']
    area = request.form['area']
    updateMongoDB("", number, area, "DELETE")
    return redirect("http://"+address+":5000", code=302)

def plotHelper(countPerPriority):
    iterateTable = 0
    for i in countPerPriority:
        label = []
        data = []
        for j in i:
            label.append(j.get("count"))
            data.append(j.get("_id"))
        pieChart(label, data, tables[iterateTable])
        iterateTable = iterateTable + 1

def getBugsHelper(data, collection):
    severity = []
    number = []
    bugs = data[collection]
    for x in bugs:
        severity.append(x["priority"])
        number.append(x["number"])
    data = {"Jira Number":number, "Severity":severity}
    df = pd.DataFrame(data)
    new_header = df.iloc[0] #grab the first row for the header
    df = df[1:] #take the data less the header row
    df.columns = new_header #set the header row as the df header
    df.reset_index(drop=True, inplace=True)
    return df



tables = ["mobileApiBugs", "webApiBugs", "androidBugs", "iOSBugs", "webBugs"]

# Handling COR requests
@app.after_request
def after_request(response):
    response.headers.add('Access-Control-Allow-Origin', '*')
    response.headers.add('Access-Control-Allow-Headers', 'Content-Type,Authorization,SessionId,Email')
    response.headers.add('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE')
    response.headers.add("Access-Control-Max-Age", "3600");
    response.headers.add("Access-Control-Allow-Headers", "x-requested-with");
    response.headers.add("Connection", "keep-alive");
    response.headers.add("Vary", "Accept-Encoding");
    return response

if __name__ == "__main__":
    app.config['TEMPLATES_AUTO_RELOAD'] = True
    app.run(debug=False, host=address, port=5000, threaded=True, use_reloader=True)
