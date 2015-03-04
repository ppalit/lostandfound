echo "Starting setup for AWS instances"
key='/Users/priyabrata/Documents/aws/aws-keypair2.pem'
instance='54.165.125.72'
echo "Working with Key=$key  and instance=$instance"
ssh -i $key ec2-user@$instance < runSetup.sh
echo "server has been setup!!"
echo "running tests to check if URLS are reachable.."
wget --spider -S "http://$instance:8080" 2>&1 | grep "HTTP/" | awk '{print $2}'
wget --spider -S "http://$instance:8983/solr" 2>&1 | grep "HTTP/" | awk '{print $2}'
