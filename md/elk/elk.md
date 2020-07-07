
### 首先下载 对应文件

    * elasticsearch-7.6.0       (elasticsearch-head-master,elasticsearch-analysis-ik-7.6.0)
    * logstash-6.2.4
    * kibana-7.0.0-windows-x86_64
    
### 分别启动 head ik插件安装  

###  启动 es 集群  

###  启动 logstash  新建配置文件    logstash.conf  添加对应的配置

    启动  进入bin目录下面    logstash -f ..\config\logstash.conf
    

###  启动 kibana   在对应配置文件中 配置  es集群 所有 host地址

    启动  进入bin目录下面    kibana.bat

### 打开  kibana 界面 设置 索引 匹配规则


### 启动 filebeat

     启动  进入bin目录下面    filebeat.exe -e -c filebeat.yml
    

1  启动 es
2  启动  logstash
3  启动  kibana

    filebeat  --->   logstash   -->  es  索引