kubectl create namespace lab-12-sc-k8s
kubectl apply -f ../k8s/clusterrole.yaml -n default
kubectl create serviceaccount api-service-account -n lab-12-sc-k8s
kubectl create clusterrolebinding service-pod-reader-lab-12-sc-k8s --clusterrole=lab-12-sc-k8s-kubernetes-namespace-reader --serviceaccount=lab-12-sc-k8s:api-service-account

kubectl delete -f ../k8s/deployment-service.yaml -n lab-12-sc-k8s
kubectl apply -f ../k8s/cmap-application-local.yaml -n lab-12-sc-k8s
kubectl apply -f ../k8s/deployment-service.yaml -n lab-12-sc-k8s
#kubectl rollout restart deployment/lab-12-sc-k8s-service -n lab-12-sc-k8s

kubectl delete -f ../k8s/deployment-caller.yaml -n lab-12-sc-k8s
kubectl apply -f ../k8s/deployment-caller.yaml -n lab-12-sc-k8s


