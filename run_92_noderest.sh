cd ./92_node_rest
docker build -t restapp .
echo "Built rest properly, now running!"
docker run -p 3000:3000 restapp
