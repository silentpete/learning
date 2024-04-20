resource "aws_s3_bucket_policy" "globo_web_app_bucket_policy" {
  bucket = aws_s3_bucket.globo_web_app_bucket.id
  policy = data.aws_iam_policy_document.globo_web_app_bucket_policy_doc.json
}
