###springboot 整合 elasticsearch(分词)

####博客
https://blog.csdn.net/chenxihua1/article/details/94546282

####elasticsearch
https://www.newbe.pro/Mirrors/Mirrors-Elasticsearch/   Elasticsearch 国内加速下载
插件地址：
https://github.com/elastic/elasticsearch/tree/5.5.3
启动：../bin/elasticsearch.bat
####elasticsearch-head
插件地址：
https://github.com/mobz/elasticsearch-head
启动：cd ../  grunt server &
访问：http://ip:9100/
####elasticsearch-bigdesk
插件地址：
https://github.com/lukas-vlcek/bigdesk
安装命令：
./bin/elasticsearch-plugin install https://codeload.github.com/lukas-vlcek/bigdesk/zip/v2.5.0
启动：python -m http.server 9999
访问：http://ip:9999
####elasticsearch-sql
插件地址：
https://github.com/NLPchina/elasticsearch-sql/tree/5.5.3.0
安装命令：
./bin/elasticsearch-plugin install https://github.com/NLPchina/elasticsearch-sql/releases/download/5.3.3.0/elasticsearch-sql-5.5.3.0.zip
####elasticsearch-sql (可视化页面)
插件地址：
https://github.com/NLPchina/elasticsearch-sql/releases/download/5.4.1.0/es-sql-site-standalone.zip
下载完成后解压缩
cd site-server
npm install express --save
node node-server.js 
可视化页面访问地址
http://ip:8080/

####自定义分词器 mytokenizer
http://127.0.0.1:9200/search_my_user/

{
	"settings": {
    	"analysis": {
    		"analyzer": {
        		"myanalyzer": {
        			"tokenizer": "mytokenizer"
        		}
    		},
    		"tokenizer": {
        		"mytokenizer": {
        		"type": "ngram",
        		"min_gram": 1,
        		"max_gram": 2,
        		"token_chars": [
            		"letter",
            		"digit",
            		"whitespace",
            		"punctuation",
            		"symbol"
        		]
        		}
    		}
    	}
	},
    "mappings":{
        "user":{
            "properties":{
                "id":{
                    "type":"long",
                    "store": true,
                    "index": false,
                    "fields":{
                        "keyword":{
                            "type":"keyword"
                        }
                    }
                },
                "username":{
                    "type":"text",
                    "store": true,
                    "index": true,
                    "analyzer": "myanalyzer",
                    "fields":{
                        "keyword":{
                            "type":"keyword"
                        }
                    }
                },
                "password":{
                    "type":"text",
                    "store": true,
                    "index": true,
                    "analyzer": "myanalyzer",
                    "fields":{
                        "keyword":{
                            "type":"keyword"
                        }
                    }
                },
                "age":{
                    "type":"integer",
                    "fields":{
                        "keyword":{
                            "type":"keyword"
                        }
                    }
                },
                "ip":{
                    "type":"text",
                    "store": true,
                    "index": true,
                    "analyzer": "myanalyzer",
                    "fields":{
                        "keyword":{
                            "type":"keyword"
                        }
                    }
                },
                "created":{
                    "type":"date",
                    "fields":{
                        "keyword":{
                            "type":"keyword"
                        }
                    }
                },
                "@timestamp":{
                       "format":"strict_date_optional_time||epoch_millis",
                       "type":"date",
                       "enabled":true
                }
            }
        }
    }
}


####Logstash 国内加速下载
https://www.newbe.pro/Mirrors/Mirrors-Logstash/       Logstash 国内加速下载
conf目录下新建 logstash.conf
input {
    file {
		type => "nginx_access"
        path => "D:\nginx\logs\access.log"
    }
}
output {
    elasticsearch {
        hosts => ["127.0.0.1:9200"]
        index => "access-%{+YYYY.MM.dd}"
    }
    stdout {
        codec => json_lines
    }
}
启动：logstash.bat -f  ../config/logstash.conf
启动：logstash.bat -f  ../config/jdbc.conf (mysql同步数据到logstash)
启动：logstash.bat -f  ../config/demoLog.conf (同步应用日志到elasticsearch)

访问：http://localhost:9600/

####Kibana 国内加速下载
https://www.newbe.pro/Mirrors/Mirrors-Kibana/  Kibana 国内加速下载
打开config路径下文件kibana.yml 。设置elasticsearch.url为启动的elasticsearch（http://localhost:9200/）
进入kibana的bin目录，双击kibana.bat
访问：http://localhost:5601/

guide：https://www.elastic.co/guide/cn/kibana/current/connect-to-elasticsearch.html