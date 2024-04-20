resource "aws_s3_object" "globo_web_app_index_html" {
  bucket = aws_s3_bucket.globo_web_app_bucket.bucket
  key    = "/website/index.html"
  source = "./website/index.html"

  tags = local.common_tags
}

resource "aws_s3_object" "globo_web_app_logo" {
  bucket = aws_s3_bucket.globo_web_app_bucket.bucket
  key    = "/website/Globo_logo_Vert.png"
  source = "./website/Globo_logo_Vert.png"

  tags = local.common_tags
}
