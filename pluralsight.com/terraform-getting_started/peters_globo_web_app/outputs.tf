output "aws_instance_public_dns_for_ssh_01" {
  value       = "ssh ec2-user@${aws_instance.globo-web-app-ec2-01.public_dns}, http://${aws_instance.globo_web_app_ec2_02.public_dns}"
  description = "Public DNS of the globo-web-app-ec2-01 server"
}

output "aws_instance_public_dns_for_ssh_02" {
  value       = "ssh ec2-user@${aws_instance.globo_web_app_ec2_02.public_dns}"
  description = "Public DNS of the globo_web_app_ec2_02 server"
}

output "aws_lb_public_dns" {
  value       = "http://${aws_lb.globo_web_app_alb.dns_name}"
  description = "Public DNS URL of the globo-web-app"
}
