
#### hadoop组件

    重点组件：
    
    HDFS：Hadoop的分布式文件存储系统。
    
    MapReduce：Hadoop的分布式程序运算框架，也可以叫做一种编程模型。
    
    Hive：基于Hadoop的类SQL数据仓库工具
    
    Hbase：基于Hadoop的列式分布式NoSQL数据库
    
    ZooKeeper：分布式协调服务组件
    
    Mahout：基于MapReduce/Flink/Spark等分布式运算框架的机器学习算法库
    
    Oozie/Azkaban：工作流调度引擎
    
    Sqoop：数据迁入迁出工具
    
    Flume：日志采集工具
    
 

export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.262.b10-0.el7_8.x86_64/
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$JAVA_HOME/jre/lib/rt.jar
export PATH=$PATH:$JAVA_HOME/bin

export MAVEN_HOME=/usr/local/env/apache-maven-3.6.3
export PATH=$MAVEN_HOME/bin:$PATH

export HADOOP_HOME=/usr/local/env/hadoop-2.9.2
export PATH=$PATH:$HADOOP_HOME/bin:$HADOOP_HOME/sbin
