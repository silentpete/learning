resource "aws_lb_target_group" "globo_web_app_alb_http_tg" {
  name     = "globo-web-app-lb-http-tg"
  port     = 80
  protocol = "HTTP"
  vpc_id   = aws_vpc.dev.id

  tags = local.common_tags
}
