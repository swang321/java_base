
#### hadoop启动

1、主节点　　从节点

2、master　　slave

3、管理者　　工作者

4、leader　　follower

Hadoop集群中各个角色的名称：

    服务	主节点	从节点
    HDFS	NameNode	DataNode
    YARN	ResourceManager	NodeManager

hadoop节点初始化HDFS初始化 只能在主节点上进行

* hadoop namenode -format

启动HDFS

* start-dfs.sh

jps 查看 hadoop是否启动

    [root@localhost hadoop]# jps
    10227 Jps
    9956 DataNode
    10116 SecondaryNameNode
    9830 NameNode
    
启动YARN 只能在主节点中进行启动

    start-yarn.sh