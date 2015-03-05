echo "downloading latest from master.."
curl -LkSs https://github.com/ppalit/lostandfound/archive/master.zip -o master.zip
unzip master.zip
cd lostandfound-master
mvn clean install