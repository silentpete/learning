resource "aws_instance" "globo-web-app-ec2-01" {
  depends_on = [aws_iam_role_policy.app_to_bucket]

  ami                    = nonsensitive(data.aws_ssm_parameter.amzn2_linux_pri.value)
  instance_type          = var.instance_type
  subnet_id              = aws_subnet.primary_subnet.id
  vpc_security_group_ids = [aws_security_group.globo_web_app_sg.id]
  key_name               = aws_key_pair.peters_public_key.id
  iam_instance_profile   = aws_iam_instance_profile.globo_web_app_instance_profile.name

  tags = local.common_tags

  user_data = <<EOF
#! /bin/bash
sudo amazon-linux-extras install -y nginx1
sudo service nginx start
aws s3 cp s3://${aws_s3_bucket.globo_web_app_bucket.id}/website/index.html /home/ec2-user/index.html
aws s3 cp s3://${aws_s3_bucket.globo_web_app_bucket.id}/website/Globo_logo_Vert.png /home/ec2-user/Globo_logo_Vert.png
sudo rm /usr/share/nginx/html/index.html
sudo cp /home/ec2-user/index.html /usr/share/nginx/html/index.html
sudo cp /home/ec2-user/Globo_logo_Vert.png /usr/share/nginx/html/Globo_logo_Vert.png
EOF

}

resource "aws_instance" "globo_web_app_ec2_02" {
  depends_on = [aws_iam_role_policy.app_to_bucket]

  ami                    = nonsensitive(data.aws_ssm_parameter.amzn2_linux_sec.value)
  instance_type          = var.instance_type
  subnet_id              = aws_subnet.secondary_subnet.id
  vpc_security_group_ids = [aws_security_group.globo_web_app_sg.id]
  key_name               = aws_key_pair.peters_public_key.id
  iam_instance_profile   = aws_iam_instance_profile.globo_web_app_instance_profile.name

  tags = merge(local.common_tags, {Name = "globo-web-app-ec2-02"})

  user_data = <<EOF
#! /bin/bash
sudo amazon-linux-extras install -y nginx1
sudo service nginx start
aws s3 cp s3://${aws_s3_bucket.globo_web_app_bucket.id}/website/index.html /home/ec2-user/index.html
aws s3 cp s3://${aws_s3_bucket.globo_web_app_bucket.id}/website/Globo_logo_Vert.png /home/ec2-user/Globo_logo_Vert.png
sudo rm /usr/share/nginx/html/index.html
sudo cp /home/ec2-user/index.html /usr/share/nginx/html/index.html
sudo cp /home/ec2-user/Globo_logo_Vert.png /usr/share/nginx/html/Globo_logo_Vert.png
EOF

}
