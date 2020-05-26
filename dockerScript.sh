
git clone https://github.com/VladTvardovskyi/DB.git

cd DB
docker volume create docker_database
docker-compose up -d

docker logs -f rest
