# Java backend for "fitMe" app. 
Project on Java spring boot framework (rest) for fit me application by Futsur Dmitriy.

# Steps to read and do

1. Clone project from https://github.com/futsurdmitriy/fitMe_java
2. Run maven clean and maven install to get "target" directory in your project folder.
3. Do docker commands to setup environment:
    1. Build docker by Dockerfile ``` docker build --tag fit-me-java-docker . ```
    2. Run container ``` docker run -d -p 8080:8080 --name fit-me-java-server fit-me-java-docker ```
    3. Check in browser results of rest backend route ``` http://localhost:8080/api/v1/test/hello ```
    4. Response should be ``` {"response": "Hello from com.fuda.fitMe.api.v1.controller.TestController"} ```
    5. Here you can search for info for next steps (if you will be confused) 
        * https://docs.docker.com/language/java/develop/ 
        * https://docs.docker.com/storage/volumes/ 
        * https://www.google.com/search?channel=fs&client=ubuntu&q=postgres+configuration+directory 
        * https://www.google.com/search?q=postgres+main+directory&client=ubuntu&hs=tih&channel=fs&sxsrf=ALeKk03ey3wfIvlpnIDokB0yx0mNT2q0Mw%3A1627377963445&ei=K9H_YNDJGq6urgTD2rzIDg&oq=postgres+main+directory&gs_lcp=Cgdnd3Mtd2l6EAMyAggAOgcIIxCwAxAnOgcIABBHELADOgYIABAHEB46CAgAEAgQBxAeOgoIABAIEAcQChAeOggIABAHEAUQHkoECEEYAFDBHFiCIGCDImgCcAJ4AIABvAGIAbUFkgEDMC41mAEAoAEBqgEHZ3dzLXdpesgBCcABAQ&sclient=gws-wiz&ved=0ahUKEwiQi7Sr94LyAhUul4sKHUMtD-kQ4dUDCA4&uact=5 
        * https://hub.docker.com/_/postgres
    6. Do following commands to set up config volume for postgres ``` docker volume create postgres_config ```  
    7. Do following commands to set up data volume for postgres ``` docker volume create postgres_data ```  
    8. Do following commands to set up network for docker containers for postgres ``` docker network create postgres_net ```
    9. Then run container and set up all the configuration to it ``` docker run -it --rm -d -v "postgres_data:/var/lib/postgresql/12/main" -v "postgres_config:/etc/postgresql/12/main/conf.d" --network postgres_net --name postgres_server -e "POSTGRES_PASSWORD=fitme" -e "POSTGRES_USER=fitme" -e "POSTGRES_DB=fitme" -p 5432:5432 postgres:12 ```
    10. Let`s build our image ```  docker build --tag fit-me-java-docker . ```
    11. Run ``` docker run --rm -d --name fit-me-java-server --network postgres_net -e "POSTGRES_URL=jdbc:postgresql://postgres_server/fitme" -p 5432:5432 fit-me-java-docker ```
        if there is a problem with "already existing container" just remove it by ``` docker rm "container id" ```
    12. To enable remote debugging follow that link https://docs.docker.com/language/java/develop/#connect-a-debugger (this may help in case of errors -> https://intellij-support.jetbrains.com/hc/en-us/community/posts/206844695-handshake-failed-error-with-Remote-Debugging)
    13. 