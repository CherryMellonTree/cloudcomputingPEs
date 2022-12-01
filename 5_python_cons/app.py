import requests
def printFancy(opening, closing):
    print("----------------------------------")
    print(opening)
    print(closing)

print("This is a small console program sending out a test to 4_pyton_prod. I hope you enjoy it!")
helloWorld = requests.request(method="GET", url="127.0.0.1:5000/")
printFancy("Hello World", helloWorld )
goodQuote = requests.request(
    method="GET",
    url="127.0.0.1:5000/quote/good"
)
printFancy("A Good quote:", goodQuote)
goodQuote = requests.request(
    method="GET",
    url="127.0.0.1:5000/quote/mediocre"
)
printFancy("A mediocre quote:", goodQuote)
newQuote = requests.request(method="POST",url="127.0.0.1:5000/quote/add",json={"content":"This is a brand-new quote"} )
printFancy("Trying to add new quote", newQuote)

getNewQuote = requests.request(method="GET", url="127.0.0.1:5000/quote/added")
printFancy("The newly added quote is:", getNewQuote)

print("done!")

