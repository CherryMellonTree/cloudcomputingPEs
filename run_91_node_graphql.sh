cd ./91_node_graphql
docker build -t graphapp .
echo "Built gql properly, now running!"
docker run -p 4000:4000 graphapp
