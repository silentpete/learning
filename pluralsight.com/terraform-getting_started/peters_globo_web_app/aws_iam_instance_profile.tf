resource "aws_iam_instance_profile" "globo_web_app_instance_profile" {
  name = "globo_web_app_instance_profile"
  role = aws_iam_role.globo_web_app_to_bucket.name

  tags = local.common_tags
}
