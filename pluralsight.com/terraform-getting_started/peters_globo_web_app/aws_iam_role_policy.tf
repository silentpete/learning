resource "aws_iam_role_policy" "app_to_bucket" {
  name   = "app_to_bucket"
  role   = aws_iam_role.globo_web_app_to_bucket.id
  policy = data.aws_iam_policy_document.globo_web_app_s3_allow_all_policy_doc.json
}
