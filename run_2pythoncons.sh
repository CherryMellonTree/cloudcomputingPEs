cd ./2_python_cons/
docker build --tag quotecons:latest . 
echo "Built quotes properly, now running!"
docker run --network host quotecons:latest 