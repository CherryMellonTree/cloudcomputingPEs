cd ./5_python_cons/
docker build --tag quotecons:latest . 
echo "Built quotes properly, now running!"
docker run -p 4000:4000 quotecons:latest