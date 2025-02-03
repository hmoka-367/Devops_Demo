provider "aws" {
  region = "us-east-1"
}

resource "aws_instance" "devops_demo" {
  ami           = "ami-0c55b159cbfafe1f0"
  instance_type = "t2.micro"

  tags = {
    Name = "DevOps-Demo-Server"
  }
}
