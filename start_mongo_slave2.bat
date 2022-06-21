docker rm mongodb_slave2
docker run --network tcsens-platform -dit --name mongodb_slave2 -p 27019:27017 -v D:/mongodb/data/slave2:/data mongo mongod --replSet mongo-rep-set