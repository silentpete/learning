resource "aws_s3_bucket" "globo_web_app_bucket" {
  bucket        = "globo-web-app-${random_integer.five_digit.result}"
  force_destroy = true
  tags          = local.common_tags
}
