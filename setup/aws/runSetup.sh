#!/bin/sh
sudo su - root
cd /opt
mkdir apps
chown ec2-user:ec2-user apps
exit
cd /opt/apps
mkdir tomcat solr
cd tomcat
wget http://mirror.cogentco.com/pub/apache/tomcat/tomcat-8/v8.0.22/bin/apache-tomcat-8.0.22.zip
unzip apache-tomcat-8.0.22.zip
chmod 770 apache-tomcat-8.0.22/bin/*.sh
sh apache-tomcat-8.0.22/bin/startup.sh
cd ../solr
wget http://apache.mesi.com.ar/lucene/solr/5.0.0/solr-5.0.0.zip
unzip solr-5.0.0.zip
sh solr-5.0.0/bin/solr start
echo "server setup complete"
