docker rm mongodb_master
docker run --network tcsens-platform -dit --name mongodb_master -p 27020:27017 -v D:/mongodb/data/master:/data mongo mongod --replSet mongo-rep-set