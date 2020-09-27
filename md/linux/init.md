
#### 最小化安装 ip
    cd /etc/sysconfig/network-scripts/
    
    vi ifcfg-eno*****
    
    找到ONBOOT=no，修改为ONBOOT=yes，然后保存退出：
    
    然后执行命令 service network restart 重启网卡服务：
    
    执行ip addr命令 查看是否分配到IP地址：
    
    然后我们执行命令yum provides ifconfig 查看哪个包提供了ifconfig命令，然后可以看到net-tools包提供ifconfig包：
    
    然后我们执行命令安装net-tools包，执行命令：yum install net-tools。
    
    执行ifconfig ：
 
 #### 修改yum
 
    cd /etc/yum.repos.d/
    
    rm -f CentOS-Base.repo
    
    curl -O http://mirrors.163.com/.help/CentOS7-Base-163.repo
    
#### yum install java 

    yum list java*
    
    yum -y install java-1.8.0-openjdk.x86_64
    
#### yum install java 工具  （jps jmap  jstack。。。。）

    yum list |grep jdk-devel
    yum install java-1.8.0-openjdk-devel.x86_64
 
 
     yum install -y firewalld
     yum install -y firewall-config 