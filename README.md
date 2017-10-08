# Crypto-Compare (Work in Progress)

### This is a final working project of CodingNomads Thailand 2018 Cohort 

#### API + MVC application to monitor, predict and alert users on various CrytoCurrency prices

##### Technologies Used:
* Apache Tomcat
* Java
* Maven
* Spring Framework
* Mybatis
* Hibernate
* Mysql
* AWS EC2
** Autoscaling groups
** Load balancers
* AWS RDS
* AWS Route53
* Apache Gemfire (caching)

##### Deployment Instructions:
* clone this repo
* create a local (or AWS RDS) MySql instance and restore it using the sql dump file provided in the resouces folder
* update DB url, username, password application.properties file accordingly to your new DB
* Install and start Apache Tomcat in your deployment environment - be sure Java 8 is installed
* Build project from the root directory of the project using Maven "mvn clean package"
* A .war file will be created in the target directory of the project
* Copy this .war file to the "webapps" directory of Apache Tomcat 
** This will automatically deploy the application to Tomcats default port :8080 in your environment

##### Notes:
* All API resources can be found in crypto.rest_controllers package
* ALL MVC resources can be found in crypto.mvc_controllers package
* All MVC client-side resources can be found in resources/static and resources/templates
