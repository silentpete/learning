resource "aws_security_group" "globo_web_app_sg" {
  name   = "globo_web_app_sg"
  vpc_id = aws_vpc.dev.id

  tags = local.common_tags

  ingress {
    from_port = 80
    to_port   = 80
    protocol  = "tcp"
    # cidr_blocks = [var.class_any_cidr_block]
    cidr_blocks = [var.class_1b_cidr_blocks[0]]
  }

  ingress {
    from_port = 22
    to_port   = 22
    protocol  = "tcp"
    # cidr_blocks = [var.class_any_cidr_block]
    cidr_blocks = [var.allowed_cidr_block]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = [var.class_any_cidr_block]
  }
}

resource "aws_security_group" "globo_web_app_alb_sg" {
  name   = "globo_web_app_alb_sg"
  vpc_id = aws_vpc.dev.id

  tags = local.common_tags

  ingress {
    from_port = 80
    to_port   = 80
    protocol  = "tcp"
    # cidr_blocks = [var.class_any_cidr_block]
    cidr_blocks = [var.allowed_cidr_block]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = [var.class_any_cidr_block]
  }
}
