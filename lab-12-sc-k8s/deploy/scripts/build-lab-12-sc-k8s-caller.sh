proxyHost="192.168.0.116"
proxyPort="10809"
proxyStr="-Dhttp.proxyHost=$proxyHost -Dhttp.proxyPort=$proxyPort -Dhttps.proxyHost=$proxyHost -Dhttps.proxyPort=$proxyPort"
registry="192.168.0.244:5000"


cd ../../lab-12-sc-k8s-caller

mvn $proxyStr clean
mvn $proxyStr -P k8s package

docker rmi $registry/lab-12-sc-k8s-caller:latest
docker build -t $registry/lab-12-sc-k8s-caller:latest .
docker push $registry/lab-12-sc-k8s-caller:latest
docker images | grep lab-12-sc-k8s-caller

cd ../deploy/scripts

./launch-lab-12-sc-k8s-caller.sh