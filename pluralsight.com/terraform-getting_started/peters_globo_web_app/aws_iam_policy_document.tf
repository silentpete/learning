data "aws_iam_policy_document" "globo_web_app_bucket_policy_doc" {
  # statement {
  #   principals {
  #     type        = "AWS"
  #     identifiers = ["648884528371"]
  #   }

  #   actions = [
  #     "s3:GetObject",
  #     "s3:ListBucket",
  #   ]

  #   resources = [
  #     aws_s3_bucket.globo_web_app_bucket.arn,
  #     "${aws_s3_bucket.globo_web_app_bucket.arn}/*",
  #   ]
  # }

  statement {
    principals {
      type        = "AWS"
      identifiers = [data.aws_elb_service_account.main.arn]
    }

    actions = [
      "s3:PutObject",
    ]

    effect = "Allow"

    resources = [
      "${aws_s3_bucket.globo_web_app_bucket.arn}/alb-logs/*",
    ]
  }

  statement {
    principals {
      type        = "Service"
      identifiers = ["delivery.logs.amazonaws.com"]
    }

    actions = [
      "s3:PutObject",
    ]

    resources = [
      "${aws_s3_bucket.globo_web_app_bucket.arn}/alb-logs/*",
    ]

    condition {
      test     = "StringEquals"
      variable = "s3:x-amz-acl"
      values = [
        "bucket-owner-full-control",
      ]
    }
  }

  statement {
    principals {
      type        = "Service"
      identifiers = ["delivery.logs.amazonaws.com"]
    }

    actions = [
      "s3:GetBucketAcl",
    ]

    effect = "Allow"

    resources = [
      aws_s3_bucket.globo_web_app_bucket.arn,
    ]
  }

}

data "aws_iam_policy_document" "globo_web_app_assume_s3_policy_doc" {
  statement {
    actions = ["sts:AssumeRole"]
    effect = "Allow"

    principals {
      type        = "Service"
      identifiers = ["ec2.amazonaws.com"]
    }
  }
}

data "aws_iam_policy_document" "globo_web_app_s3_allow_all_policy_doc" {
  statement {
    actions = ["s3:*"]
    effect = "Allow"
    resources = [
      aws_s3_bucket.globo_web_app_bucket.arn,
      "${aws_s3_bucket.globo_web_app_bucket.arn}/*",
    ]
  }
}
