resource "aws_lb_listener" "globo_web_app_alb_http_listener" {
  load_balancer_arn = aws_lb.globo_web_app_alb.arn
  port              = "80"
  protocol          = "HTTP"

  default_action {
    type             = "forward"
    target_group_arn = aws_lb_target_group.globo_web_app_alb_http_tg.arn
  }

  tags = local.common_tags
}
