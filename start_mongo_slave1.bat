docker rm mongodb_slave1
docker run --network tcsens-platform -dit --name mongodb_slave1 -p 27018:27017 -v D:/mongodb/data/slave1:/data mongo mongod --replSet mongo-rep-set