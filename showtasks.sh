#!/usr/bin/env bash

start_runcrud() {
  sh /Users/szymonrosol/Development/kodilla-App-main/runcrud.sh
}

start_browsware() {
  if open -a Safari http://localhost:8080/crud/v1/task/getTasks; then
    end1
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

if start_runcrud build; then
  start_browsware
else
   fail
fi