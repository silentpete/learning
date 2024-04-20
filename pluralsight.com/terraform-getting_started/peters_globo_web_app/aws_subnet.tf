resource "aws_subnet" "primary_subnet" {
  cidr_block              = var.class_1c_cidr_blocks[0]
  vpc_id                  = aws_vpc.dev.id
  map_public_ip_on_launch = var.map_public_ip_on_launch
  availability_zone       = data.aws_availability_zones.available_azs.names[0]

  tags = local.common_tags
}

resource "aws_subnet" "secondary_subnet" {
  cidr_block              = var.class_1c_cidr_blocks[1]
  vpc_id                  = aws_vpc.dev.id
  map_public_ip_on_launch = var.map_public_ip_on_launch
  availability_zone       = data.aws_availability_zones.available_azs.names[1]

  tags = local.common_tags
}
