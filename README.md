###springboot 整合 elasticsearch(分词)

####博客
https://blog.csdn.net/chenxihua1/article/details/94546282

####elasticsearch
插件地址：
https://github.com/elastic/elasticsearch/tree/5.5.3
####elasticsearch-head
插件地址：
https://github.com/mobz/elasticsearch-head
####elasticsearch-bigdesk
插件地址：
https://github.com/lukas-vlcek/bigdesk
安装命令：
./bin/elasticsearch-plugin install https://codeload.github.com/lukas-vlcek/bigdesk/zip/v2.5.0
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