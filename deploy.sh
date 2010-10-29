GLASSFISH_BIN_HOME=/home/whiter4bbit/dev/glassfishv3/bin                                  
APP_NAME=minebudget-1.0-SNAPSHOT
APP_PATH=target/minebudget-1.0-SNAPSHOT.war

mvn clean install
$GLASSFISH_BIN_HOME/asadmin undeploy $APP_NAME
$GLASSFISH_BIN_HOME/asadmin deploy $APP_PATH


