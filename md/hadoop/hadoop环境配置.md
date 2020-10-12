
#### hadoop配置

###  hadoop1  是机器1    hadoop2  是机器2

#### vi core-site.xml

* fs.defaultFS ： 这个属性用来指定namenode的hdfs协议的文件系统通信地址，可以指定一个主机+端口，也可以指定为一个namenode服务（这个服务内部可以有多台namenode实现ha的namenode服务

* hadoop.tmp.dir : hadoop集群在工作的时候存储的一些临时文件的目录


    <configuration>
            <property>
                    <name>fs.defaultFS</name>
                    <value>master:9000</value>
            </property>
            <property>
                    <name>hadoop.tmp.dir</name>
                    <value>/home/hadoop/data/hadoopdata</value>
            </property>
    </configuration>

#### vi hdfs-site.xml

* dfs.namenode.name.dir：namenode数据的存放地点。也就是namenode元数据存放的地方，记录了hdfs系统中文件的元数据。

* dfs.datanode.data.dir： datanode数据的存放地点。也就是block块存放的目录了。

* dfs.replication：hdfs的副本数设置。也就是上传一个文件，其分割为block块后，每个block的冗余副本个数，默认配置是3。

* dfs.secondary.http.address：secondarynamenode 运行节点的信息，和 namenode 不同节点


    <configuration>
            <property>
                    <name>dfs.namenode.name.dir</name>
                    <value>/home/hadoop/data/hadoopdata/name</value>
                    <description>为了保证元数据的安全一般配置多个不同目录</description>
            </property>
    
            <property>
                    <name>dfs.datanode.data.dir</name>
                    <value>/home/hadoop/data/hadoopdata/data</value>
                    <description>datanode 的数据存储目录</description>
            </property>
    
            <property>
                    <name>dfs.replication</name>
                    <value>2</value>
                    <description>HDFS 的数据块的副本存储个数, 默认是3</description>
            </property>
    
            <property>
                    <name>dfs.secondary.http.address</name>
                    <value>master:50090</value>
                    <description>secondarynamenode 运行节点的信息，和 namenode 不同节点</description>
            </property>
    </configuration>
    


#### mapred-site.xml

    cp mapred-site.xml.template mapred-site.xml
    vi mapred-site.xml

*  mapreduce.framework.name：指定mr框架为yarn方式,Hadoop二代MP也基于资源管理系统Yarn来运行 。


       <configuration>
               <property>
                       <name>mapreduce.framework.name</name>
                       <value>yarn</value>
               </property>
       </configuration>

#### yarn-site.xml


*   yarn.resourcemanager.hostname：yarn总管理器的IPC通讯地址


        <configuration>
        
        <!-- Site specific YARN configuration properties -->
        
                <property>
                        <name>yarn.resourcemanager.hostname</name>
                        <value>master</value>
                </property>
        
                <property>
                        <name>yarn.nodemanager.aux-services</name>
                        <value>mapreduce_shuffle</value>
                        <description>YARN 集群为 MapReduce 程序提供的 shuffle 服务</description>
                </property>
        
        </configuration>
        

hadoop version