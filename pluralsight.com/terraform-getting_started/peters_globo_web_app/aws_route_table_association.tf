resource "aws_route_table_association" "dev_rt_to_pri_subnet" {
  subnet_id      = aws_subnet.primary_subnet.id
  route_table_id = aws_route_table.dev_rt.id
}

resource "aws_route_table_association" "dev_rt_to_sec_subnet" {
  subnet_id      = aws_subnet.secondary_subnet.id
  route_table_id = aws_route_table.dev_rt.id
}
