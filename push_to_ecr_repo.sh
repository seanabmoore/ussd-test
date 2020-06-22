 profile=$1
 account_number=$2
 source package.sh
 docker build -t ${account_number}.dkr.ecr.eu-west-1.amazonaws.com/ussd-test .
 eval $(aws --profile $profile ecr get-login --no-include-email )
 docker push ${account_number}.dkr.ecr.eu-west-1.amazonaws.com/ussd-test