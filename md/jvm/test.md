


docker exec -it mine_pool /bin/bash
    进入 容器


top  
top -Hp 15979      各个线程的资源使用率

810137
printf "%x\n" 553085     
printf "%x\n" 15984     
printf "%x\n" 15984     
printf "%x\n" 15981     
 
3e6f   3e70    3e6d    


 
 线程id转化为十六进制

    jstack 15979 > ./1.txt
    
31   1f  
30   1e 

test

nohup java -jar -Xmx5g -Xms5g -Xmn1g -XX:MaxPermSize=256M -XX:SurvivorRatio=8 -XX:MetaspaceSize=1g -XX:CMSInitiatingOccupancyFraction=75 mine-pool.jar &


rm -rf ipb.log
printf "%x\n" 26701     
nohup java -jar -XX:+PrintHeapAtGC -Xloggc:/data/mine-pool/gc.log -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/data/mine-pool  -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PreserveFramePointer -Xmx4g -Xms4g -Xmn1g -XX:MaxPermSize=128M  mine-pool.jar &
nohup java -jar -XX:+PrintHeapAtGC -Xloggc:/data/mine-pool/gc.log -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/data/mine-pool  -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PreserveFramePointer -Xmx4g -Xms4g -Xmn1g -XX:MaxPermSize=128M  demo-0.0.1-SNAPSHOT.jar &

14:51:55
jmap -dump:live,format=b,file=/opt/thread/0948.hprof 1

"-XX:+PrintHeapAtGC","-Xloggc:/data/mine-pool/gc.log", "-XX:+HeapDumpOnOutOfMemoryError", "-XX:HeapDumpPath=/data/mine-pool", "-XX:+PrintGCDetails", "-XX:+PrintGCDateStamps"


tar -zcvf hprofprof.tar.gz 1441.hprof



Java HotSpot(TM) 64-Bit Server VM warning: INFO: os::commit_memory(0x00007fc1adf21000, 12288, 0) failed; error='Cannot allocate memory' (errno=12)
#
# There is insufficient memory for the Java Runtime Environment to continue.
# Native memory allocation (mmap) failed to map 12288 bytes for committing reserved memory.
# An error report file with more information is saved as:
# /data/mine-pool/hs_err_pid614268.log



top -Hp 553058
553085
printf "%x\n" 553085            8707d
jstack 553058|grep -A 20 8707d

jstat -gc 553058 5000