resource "aws_internet_gateway" "dev_gw" {
  vpc_id = aws_vpc.dev.id

  tags = local.common_tags
}
