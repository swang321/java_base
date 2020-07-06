input { 
  #使用 Filebeat 收集日志
  beats {
    port => 5044  #提供给 Filebeat 传入日志的端口，即 logstash 的服务务端口
  }
}

output {
  #输出到控制台方便调试
  stdout{  codec => rubydebug  { metadata => true }} 
  #输出到 elasticsearch
  elasticsearch {  
    hosts => ["http://localhost:9220"]
    index => "%{[@metadata][beat]}-%{[@metadata][version]}-%{+YYYY.MM.dd}"
    #user => "root"
    #password => "root"
  }
}