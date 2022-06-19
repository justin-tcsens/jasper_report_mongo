docker network create tcsens_universe

docker rm jpj_secure_prgm_db
docker run --name jpj_secure_prgm_db --network tcsens_universe --network-alias jpj_secure_prgm_db -v D:\Workspace\data_file\tcsens_training:/var/lib/mysql -w /app -e MYSQL_USER=app -e MYSQL_DATABASE=vehicle_management -e MYSQL_PASSWORD=password -e MYSQL_ROOT_PASSWORD=password -p 3306:3306 mariadb:10.6.5