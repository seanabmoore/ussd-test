 profile=$1
 source package.sh
 docker build -t 264788100915.dkr.ecr.eu-west-1.amazonaws.com/ussd-test
 eval $(aws --profile $profile ecr get-login --no-include-email )
 docker push 264788100915.dkr.ecr.eu-west-1.amazonaws.com/ussd-test