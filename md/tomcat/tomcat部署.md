## tomcat 部署 web项目绑定端口和域名 

# 修改 server.xml  
    
 1 8080改成对应的 端口
   
    <Connector port="8080" protocol="HTTP/1.1"
                   connectionTimeout="20000"
                   redirectPort="8443" />
                   
2  engine 标签 defaultHost改成 对应的域名

    <Engine name="Catalina" defaultHost="localhost">

3   Engine标签下的 host标签改成对应的 域名

     <Host name="wwjmg.palmpk.com"  appBase="webapps"
                unpackWARs="true" autoDeploy="true">
     appBase 项目文件夹
    
4    Engine标签下的 host标签下面添加一个新的标签 

     <Context docBase="sdklog" path="" reloadable="true"/>
     
     docBase 对应的 项目文件名


#### 防止 oom 设置JVM内存设置

    修改 tomcat目录bin目录下的 catalina.sh

     CATALINA_OPTS="-Xms256M
                    -Xmx256M
                    -XX:NewSize=500m 
                    -XX:MaxNewSize=500m
                    -XX:+PrintCommandLineFlags 
                    -XX:MaxMetaspaceSize=100m 
                    -XX:MetaspaceSize=100m 
                    -Xss512K 
                    -XX:+PrintGCDetails
                    -XX:+PrintHeapAtGC
                    -XX:+PrintGCDateStamps
                    -Xloggc:/usr/local/tomcats/tomcat8.0-1/logs/gc.log"
                    
     
     
     -Xmx    Java Heap最大值，默认值为物理内存的1/4，最佳设值应该视物理内存大小及计算机内其他内存开销而定；
     
     -Xms    Java Heap初始值，Server端JVM最好将-Xms和-Xmx设为相同值，开发测试机JVM可以保留默认值；
     
     -Xmn    Java Heap Young区大小，不熟悉最好保留默认值；
     
     -Xss   每个线程的Stack大小，不熟悉最好保留默认值；


nohup java -jar -Xms256M -Xmx256M -XX:PermSize=256M -XX:MaxPermSize=512M  back-0.0.1-SNAPSHOT.jar &

nohup java -jar -Xms256M -Xmx256M  back-0.0.1-SNAPSHOT.jar >/mnt/logs/test.log &

Xms:堆内存初始大小
Xmx:堆内存最大值
PermSize:永久内存初始大小
MaxPermSize：永久内存最大值
堆内存和永久内存区别以及其他参数设置，参考jvm运行机制


java -jar -Xms512M -Xmx512M -XX:NewSize=128M -XX:MaxNewSize=128M 
-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/home/admin/customer/heap_dump.hprof 
-XX:+PrintGCDetails back-0.0.1-SNAPSHOT.jar &