locals {
  common_tags = {
    company      = var.company
    project      = "${var.company}-${var.project}"
    billing_code = "${var.billing_code}"
  }
  eng_tags = {
    company      = var.company
    project      = "${var.company}-${var.project}"
    billing_code = "${var.billing_code}"
  }
  acct_tags = {
    company      = var.company
    project      = "${var.company}-${var.project}"
    billing_code = "${var.billing_code}"
  }
}
