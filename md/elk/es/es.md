# ================= Elasticsearch Configuration ===================
# 配置es的集群名称, es会自动发现在同一网段下的es,如果在同一网段下有多个集群,就可以用这个属性来区分不同的集群｡
cluster.name: my-elasticsearch
# 节点名称
node.name: node-000
# 指定该节点是否有资格被选举成为node
node.master: true
# 指定该节点是否存储索引数据,默认为true｡
node.data: true
# 设置绑定的ip地址还有其它节点和该节点交互的ip地址,本机ip
network.host: 127.0.0.1
# 指定http端口,你使用head､kopf等相关插件使用的端口
http.port: 9220
# 设置节点间交互的tcp端口,默认是9300｡
transport.tcp.port: 9300
#设置集群中master节点的初始列表,可以通过这些节点来自动发现新加入集群的节点｡
#因为下两台elasticsearch的port端口会设置成9301 和 9302 所以写入两台#elasticsearch地址的完整路径
discovery.zen.ping.unicast.hosts: ["127.0.0.1:9300","127.0.0.1:9301","127.0.0.1:9302"]
#如果要使用head,那么需要解决跨域问题,使head插件可以访问es
http.cors.enabled: true
http.cors.allow-origin: "*"