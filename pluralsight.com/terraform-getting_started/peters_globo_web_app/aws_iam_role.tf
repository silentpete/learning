resource "aws_iam_role" "globo_web_app_to_bucket" {
  name               = "globo_web_app_to_bucket"
  path               = "/system/"
  assume_role_policy = data.aws_iam_policy_document.globo_web_app_assume_s3_policy_doc.json

  tags = local.common_tags
}
