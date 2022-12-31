import requests
from flask import Flask, request, jsonify

import json

quotes = ["dummy"]

app = Flask(__name__)

@app.route("/", methods=["GET"])
def hello_world():
    return jsonify({"message":"Goodbye cruel world"})

@app.route("/quote/good", methods=["GET"])
def get_quote():
    return jsonify({"message":"People who go looking for good quotes don't deserve good quotes"})

@app.route("/quote/mediocre", methods=["GET"])
def somewhat_quote():
    return jsonify({"message":"It was the best of quotes. It was the worst of quotes. It was a quote as much as recent quotes that those in a position of power only wanted it to be seen in superlatives."})
@app.route("/quote/added", methods=["GET"])
def returnQuote():
    return jsonify({"message":quotes[-1]})

@app.route("/quote/add", methods=["POST"])
def add_quote():
    try:
        input_json = json.loads(request.data)
        quotes.append(input_json["content"])
        return jsonify({"success": True, "message": "Added the quote to the repository. Getting a random quote from them will be implemented at a later date :)."})
    except:
        return jsonify({"success": False, "message": "Body must be in a JSON-format, or something went wrong later down the line :)"})


@app.route("/quote", methods=["GET"])
def quote_thing():
    return "A person once said: 'This is a quote'"

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)