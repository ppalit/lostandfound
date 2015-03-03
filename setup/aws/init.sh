echo "Starting setup for AWS instances"
key='/Users/priyabrata/Documents/aws-keypair.pem'
instance='ec2-52-11-56-54.us-west-2.compute.amazonaws.com'
echo "Working with Key=$key  and instance=$instance"
ssh -i $key ec2-user@ec2-52-11-56-54.us-west-2.compute.amazonaws.com < runSetup.sh
echo "server has been setup!!"
echo "running tests to check if URLS are reachable.."
wget --spider -S "http://$instance:8080" 2>&1 | grep "HTTP/" | awk '{print $2}'
wget --spider -S "http://$instance:8983/solr" 2>&1 | grep "HTTP/" | awk '{print $2}'
