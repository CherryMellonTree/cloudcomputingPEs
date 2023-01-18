cd ./4_python_prod/
docker build --tag quoteprod:latest . 
echo "Built quotes properly, now running!"
docker run -p 5000:5000 quoteprod:latest