## linux 命令

## 命令

    清空文本
    cat /dev/null > filename
    
    查看端口使用情况
    netstat -tunlp   netstat -tunlp|grep 8080


firewall-cmd --zone=public --list-ports

firewall-cmd --zone=public --add-port=2181/tcp --permanent

firewall-cmd --reload

2、查看firewall的状态

firewall-cmd --state

service firewalld start

service firewalld restart

service firewalld stop

1、查看firewall服务状态

systemctl status firewalld

给用户权限
chown es_user /usr/local/elk/kibana/kibana-7.6.1-linux-x86_64 -R


192.168.0.213:22        es_user

./logstash -f logstash.conf

虚拟机关机命令
    
    halt