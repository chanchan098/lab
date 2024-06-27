rm -rf lab-12-sc-k8s
scp -r "116@192.168.0.116:C:\liaoyj-c\Developer\Java\labs\lab-12-sc-k8s" ./
cd lab-12-sc-k8s/deploy/scripts
chmod +x build-lab-12-sc-k8s-service.sh
chmod +x launch-lab-12-sc-k8s-service.sh