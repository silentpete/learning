resource "aws_vpc" "dev" {
  cidr_block           = var.class_1b_cidr_blocks[0] # (Optional) The IPv4 CIDR block for the VPC. CIDR can be explicitly set or it can be derived from IPAM using ipv4_netmask_length.
  enable_dns_support   = true                        # (Optional) A boolean flag to enable/disable DNS support in the VPC. Defaults to true.
  enable_dns_hostnames = var.enable_dns_hostnames    # (Optional) A boolean flag to enable/disable DNS hostnames in the VPC. Defaults false.

  tags = local.common_tags
}
