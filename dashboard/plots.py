import plotly.graph_objects as go
from plotly.subplots import make_subplots
import plotly as plotly
import plotly.express as px
import pandas as pd
import math
import datetime


def performanceChart(data):
  endpoints = []
  timestamps = []
  responsetimes = []
  sizes = []
  runs = []

  rawData = data
  x = datetime.datetime.now().strftime("%m/%d/%Y, %H:%M:%S")
  print(x+': performance chart build started...')

  for d in rawData:
    endpoints.append(d[u'endpoint'])
    timestamps.append(d[u'dateTime'].strftime("%m/%d/%Y, %H:%M:%S"))
    responsetimes.append(int(d[u'responseTime']))
    sizes.append(int(math.log(int(d[u'responseTime']),10)*50))
  i = endpoints.count('/api/v1/user/notifications')


  x = datetime.datetime.now().strftime("%m/%d/%Y, %H:%M:%S")
  print(x+': performance chart data collected')

  for x in range(1,i+1):
    for z in range(len(set(endpoints))+1):
      runs.append(x)

  runsRange = i*2

  x = datetime.datetime.now().strftime("%m/%d/%Y, %H:%M:%S")
  print(x+': performance chart runs range defined')
  finalData = {"endp":endpoints, "endpoint":endpoints,"datetime":timestamps,
          "responseTime":responsetimes,"pop":sizes,
          "dateTime":runs}
  df2 = pd.DataFrame(finalData)

  fig = px.scatter(df2, x="dateTime", y="responseTime", size="pop", size_max=100, animation_frame="datetime", animation_group="endp",
                 color="endp", hover_name="endp",
                 log_x=False, range_x=[1,runsRange], range_y=[0,10000],
                 labels=dict(dateTime="Run Number",responseTime="Response Time [ms]"))
  x = datetime.datetime.now().strftime("%m/%d/%Y, %H:%M:%S")
  print(x+': performance chart fig created')

  plotly.offline.plot(fig, filename ='templates/performance.html', auto_open=False)
  x = datetime.datetime.now().strftime("%m/%d/%Y, %H:%M:%S")
  print(x+': performance chart build completed')


def pieChart(data, label, plotName):

  labels = label
  colorsList = []
  for x in label:
    for y in colorsdict:
      if x == y:
        colorsList.append(colorsdict[y])

  colors = colorsList
  # Create subplots: use 'domain' type for Pie subplot
  fig = make_subplots(rows=1, cols=1, specs=[[{'type':'domain'}]])
  fig.add_trace(go.Pie(labels=labels, values=data, marker_colors=colors), 1, 1)
  fig.update_layout(legend=dict(x=-.9, y=.4),width=380, height=380, margin=dict(l=215,r=0,b=155,t=0,pad=4))

  # Use `hole` to create a donut-like pie chart
  fig.update_traces(hole=.8, hoverinfo="label+percent+name", textinfo='value')

  plotly.offline.plot(fig, filename ='static/'+plotName+'.html', auto_open=False)


colorsdict =	{
  "Minor": "rgb(151, 204, 100)",
  "Blocker": "rgb(255, 208, 80)",
  "Critical": "rgb(253, 90, 62)",
  "Major": "rgb(0, 115, 205)",
  "Trivial": "rgb(211, 224, 228)"
}
