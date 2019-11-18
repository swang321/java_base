## tomcat 部署 web项目绑定端口和域名 

# 修改 server.xml  
    
 1 8080改成对应的 域名
   
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
     