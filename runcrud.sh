#!/usr/bin/env bash

export CATALINA_HOME=/Users/szymonrosol/Desktop/apache-tomcat-9.0.55

stop_tomcat()
{
   $CATALINA_HOME/bin/catalina.sh stop
}

start_tomcat()
{
   $CATALINA_HOME/bin/catalina.sh start
   end1
}

rename() {
   if mv /Users/szymonrosol/Development/kodilla-App-main/build/libs/tasks-0.0.1-SNAPSHOT.war /Users/szymonrosol/Development/kodilla-App-main/build/libs/crud.war; then
      echo "Successfully renamed file"
   else
      echo "Cannot rename file"
      fail
   fi
}

copy_file() {
   if sudo cp /Users/szymonrosol/Development/kodilla-App-main/build/libs/crud.war $CATALINA_HOME/webapps; then
      start_tomcat
   else
      fail
   fi
}

fail() {
   echo "There were errors"
}

end1() {
   echo "Work is finished"
}

if ./gradlew build; then
   rename
   copy_file
else
   stop_tomcat
   fail
fi