import helper as helper
import graphene as gph
from flask import Flask, request
from graphql_server.flask import GraphQLView


# student42 = helper.student(name="Jack Smiths", coursedict={"law": 7})
# repo = helper.graderepo()
# repo.add_student(helper.student(name = "Jack Smith", coursedict = {"lawson": 19}))
# repo.add_student(helper.student(name = "Jack Smith",coursedict = {"law": 4}))

# result = repo.get_student("Jack Smith")
#print(result)


schema = gph.Schema(query=helper.Query)

myWebApp = Flask("My App")
myWebApp.add_url_rule('/graphql', view_func = GraphQLView.as_view('graphql', schema=schema, graphiql=True))

@myWebApp.route("/")
def hello_world():
    url = request.url
    return "click <a href=" + url + "graphql?query=%7BaddClassToStudent(name%3A%22%20%22%2C%20course%3A%22%20%22%2C%20score%3A%22%20%22)%7B%0A%20%20%20%20name%0A%20%20%20%20coursedict%7B%0A%20%20%20%20%20%20coursename%0A%20%20%20%20%20%20coursescore%0A%20%20%20%20%7D%7D%0A%20%20allstudents%7B%0A%20%20name%0A%20%20coursedict%7B%0A%20%20%20%20coursename%0A%20%20%20%20coursescore%0A%20%20%7D%0A%7D%0A%20%20getstudent(name%3A%22%20%22)%7B%0A%20%20%20%20name%0A%20%20%20%20coursedict%7B%0A%20%20%20%20%20%20coursename%0A%20%20%20%20%20%20coursescore%0A%20%20%20%20%7D%0A%20%20%7D%0A%7D> here </a> to head to the graphql dashboard!"
    
myWebApp.run(port=8080)