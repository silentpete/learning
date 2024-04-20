resource "aws_lb_target_group_attachment" "globo_web_app_ec2_01_http" {
  target_group_arn = aws_lb_target_group.globo_web_app_alb_http_tg.arn
  target_id        = aws_instance.globo-web-app-ec2-01.id
}

resource "aws_lb_target_group_attachment" "globo_web_app_ec2_02_http" {
  target_group_arn = aws_lb_target_group.globo_web_app_alb_http_tg.arn
  target_id        = aws_instance.globo_web_app_ec2_02.id
}
