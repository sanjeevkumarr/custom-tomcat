FROM docker.io/tomcat:8.0.39-jre8

ENV APP_HOST 172.16.31.50
ENV APP_PASSWORD password
ENV DB_HOST 172.16.31.50
ENV DB_PORT 3306
ENV DB_NAME fogpanel
ENV DB_USERNAME root
ENV DB_PASSWORD 1234

ADD faas-config.groovy /etc/cloudops/faas-config.groovy
ADD mysql-connector-java-5.1.3.jar /usr/local/tomcat/lib/mysql-connector-java-5.1.3.jar
ADD sample_db-1.war /usr/local/tomcat/webapps/app.war
ADD tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
ADD server.xml /usr/local/tomcat/conf/server.xml

#CMD ["/usr/bin/tail", "-f","/usr/local/tomcat/RUNNING.txt"]

CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]
