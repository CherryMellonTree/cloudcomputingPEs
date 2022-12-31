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
    return "click <a href=" + url + "/graphql> here </a> to head to the graphql dashboard!"
    
myWebApp.run(port=8080)