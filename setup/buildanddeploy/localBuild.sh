echo "downloading latest from master.."
rm -rf master.zip sample-laf-master
curl -LkSs https://github.com/ppalit/sample-laf/archive/master.zip -o master.zip
unzip master.zip
cd sample-laf-master
mvn clean install
cd ..
#ssh -i aws-keypair2.pem ec2-user@54.165.125.72
#cd /opt/apps/
scp -i aws-keypair2.pem sample-laf-master/webface/target/webface.war ec2-user@54.165.125.72:/opt/apps/tomcat/apache-tomcat-8.0.20/webapps/
scp -i aws-keypair2.pem sample-laf-master/businessServices/target/business-services.war ec2-user@54.165.125.72:/opt/apps/tomcat/apache-tomcat-8.0.20/webapps/
