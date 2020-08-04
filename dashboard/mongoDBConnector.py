from pymongo import MongoClient
import datetime
from datetime import date, timedelta

def connectDB():
    try:
        myclient = MongoClient('localhost',27017)
        mydb = myclient["Oikotie"]
        myclient.close()
        return mydb
    except:
        print('errors in getMongoDBData function')

def getBugsCount():
    data = []
    mydb = connectDB()
    for x in tables:
        mycoll=mydb[x]
        data.append(mycoll.count())
    return data

def getBugsCountPerPriority():
    data = []
    mydb = connectDB()
    for x in tables:
        mycoll=mydb[x]
        data.append(groupCounts(mycoll))
    return data

def getResponseTimes():
    data = []
    mydb = connectDB()
    mycoll = mydb["mobileApiPerformance"]
    dt = datetime.datetime.now() - timedelta(days=7)
    for x in mycoll.find({"dateTime":{ "$gte": dt }}):
        data.append(x)
    return data

def getBugs():
    myDict = {}
    mydb = connectDB()
    for x in tables:
        data = []
        mycoll=mydb[x]
        for xx in mycoll.find():
          data.append(xx)
        myDict[x] = data
    return myDict

def groupCounts(collection):
    count = list(collection.aggregate([
        {"$group" : {"_id":"$priority", "count":{"$sum":1}}}
    ]))
    return count

def updateMongoDB(severity, number, area, method):
    if method == 'PUT':
        mydb = connectDB()
        document = {"priority":severity, "number":number}
        mydb[area].insert_one(document)
    elif method == 'DELETE':
        mydb = connectDB()
        mydb[area].delete_one({"number" : number })

tables = ["mobileApiBugs", "webApiBugs", "androidBugs", "iOSBugs", "webBugs"]