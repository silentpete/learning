resource "aws_route_table" "dev_rt" {
  vpc_id = aws_vpc.dev.id

  route {
    cidr_block = var.class_any_cidr_block
    gateway_id = aws_internet_gateway.dev_gw.id
  }
}
