### Current Overall Status:
Done:
> SoapService: dockerised C# with SOAP (prod)  
> PythonCons: dockerised python with REST (cons)  
> nodeAuctionwebsockets: dockerised node with websockets (prod & cons)  
> PythonProd: dockerised python with REST (prod)
> node axios: dockerised node with axios (REST?) (cons)

TODO:
> 5x service (prod) van in de les => SOAP c#, node websockets => **3**

> 3x service (prod) *buiten* de les => **3**
> 1x VM, 4x docker => **1VM, 1/0docker**
> 5x consumption (over 2 talen)
1x python rest, 1x websockets node, 1x rest node => **2**
> 1x swarm/kubernetes => **1**
> 1x creatief SOA concept => **1**


### Service 1:
Soap-service in C#, designed to share payment over multiple people so they can return to split the bill at a later date
Finished
run_soap1.sh

### Service 2:
consumes the quotes from 4, unsure if elaborate enough to qualify for this assignment.
Requires service 4 to be running to test.
Finished
run_2pythoncons.sh

### Service 3:
An auction service using websockets in Node.
Finished
run_3websockets.sh

### Service 4:
generates some quotes
Finished
run_pythonprod4.sh


### Service 6
Runs a small user generating service in Node. Available commands are:
> password --req="lower" (or other flags) to ask for a user with a password satisfying above requirements.  
--multi=5 to return 5 (or a different number of) users.  
getFemaleUser --isFemale=true : (or false) to get a female or male user respectively.

example command: node namegenerator.js password --req="lower"  
needs testing, docker & script

### Service 99:
Service 1's SOAP consuming app in Node. Out of personal experience, I can assure you that consuming soap is not recommended.
NOT finished whatsoever lmao what is soap


### Service 7: laravel
in: /PEs/7_2_laravel_restart/activity_tracker
./vendor/bin/sail up
phpmyadmin op: -8081:80, logt automatisch in?