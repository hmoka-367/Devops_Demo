# DevOps Demo

This is a simple Java application built with Maven and deployed using Docker and Terraform.

## Build & Run

```sh
mvn clean package
docker build -t devops-demo .
docker run -d --name devops-demo devops-demo
```

## Terraform Commands

```sh
cd terraform
terraform init
terraform apply -auto-approve
```
