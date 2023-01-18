### Current Overall Status:
Done:
> -SoapService: dockerised C# with SOAP (prod)  [1/5 mand prod]  
> -PythonCons: dockerised python with REST (cons)  [1/5 man cons]  
> -NodeAuctionwebsockets: dockerised node with websockets (prod & cons) [2/5 mand prod, 2/5 man cons]   
> -PythonProd: dockerised python with REST (prod) [1/3 opt prod]  
> -Grpc java [3/5 mand prod, 3/5 man cons]   
> -Node axios: dockerised node with axios (cons) [4/5 mand cons]  
> -Laravel shoppinglist [4/5 mand prod, 5/5 mand cons]  
> -Python+graphql prod [5/5 mand prod]  
> -Python+graphql cons [ 6/5 extra cons, technically a repeat opt prod]  
> -Node+graphql [2/3 opt prod]
> -Node+REST [3/3 opt prod]

services with container:
- 1 (soap dotnet)
- 2 & 4 (python prod & cons)
- 3 (websockets prod & cons)
- 8 (graphql prod, on VM, does this count?)
- 91 & 92 (node + graphql/rest)

### Service 1:
Soap-service in C#, designed to share payment over multiple people so they can return to split the bill at a later date  
/etc/init.d/apache2 stop  
run_1soapdotnet.sh  
http://localhost/Service.asmx  

### Service 2:
consumes the quotes from 4.  
Requires service 4 to be running to test.  
run_2pythoncons.sh  

### Service 3:
An auction service using websockets in Node.  
run_3websockets.sh

### Service 4:  
generates some quotes  
run_pythonprod4.sh

### Service 5:
grpc/java, contains both the server-side ("demo") and the client-side ("client")
It has both a very simplistic client, and some 'questionable' internal working. The focus while writing this was on making the gRPC-elements work properly, although I plan to revisit this at a later date.  
just use the button to run both client & server seperately.  

### Service 6
Runs a small user & password generating service in Node. Consumes https://randomuser.me/api/. Available commands are:  
> password --req="lower" (or other flags) to ask for a user with a password satisfying above requirements.   
> multi=5 to return 5 (or a different number of) users.  
> getFemaleUser --isFemale=true : (or false) to get a female or male user respectively.  

example commands:
- node namegenerator.js password --req="lower"  
- node namegenerator.js multi 5 --numberOfUsers=7
- node namegenerator.js getFemaleUser --isFemale=true


### Service 7: laravel
A service to keep track of your shopping list across multiple stores. Could use some additions to its functionality, 
1. sudo /opt/lampp/manager-linux-x64.run & start sql-server
2. php artisan serve (from within shoppinglist)

if needed (for apache-server):
- sudo netstat -nlpt |grep 80
- sudo service apache2 stop

### Service 8: graphql
a small gradebook-like service using graphQL.  
to run this from a seperate location:
1. start the VM & the service
2. ssh -L 8080:localhost:8080 potato@192.168.1.130

### Service 9:
Consumption of service 8 with a web interface.

### Service 91:
A graphQL service that, if properly working, would provide deepfakes of certain statements. Unfortunately, that technology is not available to me right now so it simply returns text :).  
It has a couple of simple test-calls, including a deprecated one. I may revisit this later in an attempt to add more constraints to the submitted data

### Serivce 92
node/rest/express, a very simple API meant to demonstrate the basic implementation of some things I hadn't covered yet, like error handling & authorization.  
It contains 2 versions. Firstly, there is POC.js, which is simply a POC and stores unspecified 'messages' and is simply here for my own future use.  
The second one is nodeapp.js and should make more sense in the context of some of the other services. It is meant to be a paymentservice app, similar to service1, but functions as a log of transactions where service#1 focusses on people's relative debt to each other.



