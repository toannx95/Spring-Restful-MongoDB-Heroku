# Spring-Restful-MongoDB-Heroku Demo

# *** Deploying spring RESTful to Heroku

1. Create Spring project by STS
	- need config port as: 
		+ server.port=${PORT:8080}
		
2. Create Procfile file with below content:
	- web: java -Dserver.port=$PORT -jar target/*.jar
	
3. Execute below commands from project root by Heroku CLI
	- heroku login
	- git init (for first deploy)
	- git add .
	- git commit -m "first commit"
	- heroku create name-app (for first deploy)
		+ if need rename: heroku rename new-name-app
	- git push heroku master
	- heroku open
