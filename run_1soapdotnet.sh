cd ./1_soap_dotnet/
docker build --tag transactsoap:latest . 
echo "Built soap properly, now running!"
docker run -p 80:80 transactsoap:latest