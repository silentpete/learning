resource "aws_lb" "globo_web_app_alb" {
  depends_on = [aws_s3_bucket_policy.globo_web_app_bucket_policy]

  name               = "globo-web-app-alb"
  internal           = false
  load_balancer_type = "application"
  security_groups    = [aws_security_group.globo_web_app_alb_sg.id]
  subnets            = [aws_subnet.primary_subnet.id, aws_subnet.secondary_subnet.id]

  enable_deletion_protection = false

  access_logs {
    bucket  = aws_s3_bucket.globo_web_app_bucket.bucket
    prefix  = "alb-logs"
    enabled = true
  }

  tags = local.common_tags
}
