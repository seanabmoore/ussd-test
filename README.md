
# ussd-test  

Repo for the USSD Test Application.

The application consists of

 1. A Spring Boot Java Application
 2. Redis for state management

## How to run locally

```sh
sh package.sh
docker-compose up --build
```

Then use swagger ui or the following curl commands to interact with application:
* Swagger UI.   [http://localhost/swagger-ui.html](http://localhost/swagger-ui.html)
* `curl -X POST localhost:80/ussd -H 'Content-type:application/json' -d '{"msisdn": "1", "userEntry": "1", "sessionId": "1000"}'`


## Access the AWS Deployed version

The application has also been deployed on an AWS EC2 instance, and is available at:

[https://ussd.seansapps.co.za/swagger-ui.html](https://ussd.seansapps.co.za/swagger-ui.html)
