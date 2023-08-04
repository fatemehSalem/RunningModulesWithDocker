# RunningModulesWithDocker
Kafka+Redis+Consul Discovery+Spring Boot
runnig all services on docker-compose: 
first step: create your jar file based on Maven Instruction: mvn clean package -DskipTests  
secound step: run your services with docker: docker compose up --buiild    
you can find your services details based on this instruction: docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' kafka
