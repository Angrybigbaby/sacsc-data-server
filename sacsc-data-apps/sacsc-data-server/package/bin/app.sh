#!/bin/bash

source /etc/profile

# === basic config
SpringBoot="sacsc-data-server"
PROFILES_ACTIVE="prod"

JVM_HEAP_MIN_SIZE="1024m"
JVM_HEAP_MAX_SIZE="1024m"
JVM_METASPACE_SIZE="128m"
# ===

CMD_PATH=$(dirname "$0")
CMD_HOME=$(
    cd "$CMD_PATH"/../ || exit
    pwd
)
echo "CMD_HOME: ${CMD_HOME}"
cd "${CMD_HOME}" || exit

# java.io.tmpdir
LS_TEMP_HOME=$CMD_HOME/temp
# Spring loader.path
LS_LIB_DIR=$CMD_HOME/lib
# Application log
LS_LOG_DIR=$CMD_HOME/logs
# Spring properties config file
LS_CONF_DIR=$CMD_HOME/config
# GC Log
GC_LOG="${CMD_HOME}/logs/${SpringBoot}.gc"
# Heap Dump file
heapdump="${CMD_HOME}/${SpringBoot}.hprof"

if [ "$1" = "" ]; then
    echo -e "\033[0;31m 未输入操作名 \033[0m  \033[0;34m {start|stop|restart|status} \033[0m"
    exit 1
fi

function start_app() {

    echo "Starting $SpringBoot "

    test ! -d $LS_TEMP_HOME && mkdir -p $LS_TEMP_HOME
    test ! -d $LS_LIB_DIR && mkdir -p $LS_LIB_DIR
    test ! -d $LS_LOG_DIR && mkdir -p $LS_LOG_DIR
    test ! -d $LS_CONF_DIR && mkdir -p $LS_CONF_DIR

    jar_count=$(find "${CMD_HOME}" -name '*.jar' | wc -l)
    if [ "$jar_count" == 0 ]; then
        echo -e "\033[0;31m can't find jars, please check... \033[0m"
        exit 1
    fi
    jar_path=$(find "${CMD_HOME}" -maxdepth 1 -name '*.jar')
    echo "JAR_PATH: ${jar_path}"

    # java params
    JAVA_OPTS="-Xmx$JVM_HEAP_MAX_SIZE -Xms$JVM_HEAP_MIN_SIZE -XX:MetaspaceSize=$JVM_METASPACE_SIZE -Djava.io.tmpdir=$LS_TEMP_HOME -XX:+PrintGCDateStamps -XX:+PrintGCDetails -Xloggc:$GC_LOG -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=10 -XX:GCLogFileSize=100M -XX:HeapDumpPath=$heapdump -XX:+HeapDumpOnOutOfMemoryError"
    # spring params
    args="-Dfile.encoding=utf-8 -Dloader.path=$LS_LIB_DIR -Dspring.profiles.active=$PROFILES_ACTIVE -Dspring.config.location=${LS_CONF_DIR}"

    nohup java -server $JAVA_OPTS -jar $jar_path $args 1>/dev/null 2>&1 &
}

function start() {
    count=$(ps -ef | grep java | grep -c $SpringBoot)
    if [ "$count" != 0 ]; then
        echo "$SpringBoot is running..."
    else
        start_app
        echo "Start $SpringBoot success..."
    fi
}

function stop() {
    echo "Stop $SpringBoot"
    boot_id=$(ps -ef | grep java | grep $SpringBoot | grep -v grep | awk '{print $2}')
    count=$(ps -ef | grep java | grep -c $SpringBoot)

    if [ "$count" != 0 ]; then
        kill "$boot_id"
        kill -9 "$boot_id"
    fi
}

function restart() {
    stop
    sleep 2
    start
}

function status() {
    count=$(ps -ef | grep java | grep -c $SpringBoot)
    if [ "$count" != 0 ]; then
        echo "$SpringBoot is running..."
    else
        echo "$SpringBoot is not running..."
    fi
}

case $1 in
start)
    start
    ;;
stop)
    stop
    ;;
restart)
    restart
    ;;
status)
    status
    ;;
*)

    echo -e "\033[0;31m Usage: \033[0m  \033[0;34m sh  $0  {start|stop|restart|status}  {SpringBootJarName} \033[0m
\033[0;31m Example: \033[0m
      \033[0;33m sh  $0  start esmart-test.jar \033[0m"
    ;;
esac
