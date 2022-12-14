import requests
def printFancy(opening, closing):
    print("----------------------------------")
    print(opening)
    print(closing)

print("This is a small console program sending out a test to 4_python_prod. I hope you enjoy it!")
helloWorld = requests.request(method="GET", url="http://127.0.0.1:5000")
printFancy("Hello World", helloWorld.text )
goodQuote = requests.request(
    method="GET",
    url="http://127.0.0.1:5000/quote/good"
)
printFancy("A Good quote:", goodQuote.text)
goodQuote = requests.request(
    method="GET",
    url="http://127.0.0.1:5000/quote/mediocre"
)
printFancy("A mediocre quote:", goodQuote.text)
newQuote = requests.request(method="POST",url="http://127.0.0.1:5000/quote/add",json={'content':'This is a brand-new quote'} )
printFancy("Trying to add new quote", newQuote.json()['message'])

getNewQuote = requests.request(method="GET", url="http://127.0.0.1:5000/quote/added")
printFancy("The most recently added quote is:", getNewQuote.text)

print("done!")

