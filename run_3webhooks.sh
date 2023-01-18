cd ./3_node_auctionwebsockets/
docker build --tag websockets:latest .
docker build --tag webhookclient:latest --file ./Dockerfile2 . 
echo "built server correctly"
docker run -p 3269:3269 websockets:latest & echo "docker started"
docker run -p 8080:8080 webhookclient:latest & echo "client started"

echo "now going to localhost:8080/auctionclient.html should be working"
