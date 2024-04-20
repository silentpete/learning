variable "primary_region" {
  type        = string
  description = "Default AWS Region for resources."
  default     = "us-east-2"
  sensitive   = false
}

variable "secondary_region" {
  type        = string
  description = "Secondary AWS Region for resources."
  default     = "us-west-2"
  sensitive   = false
}

variable "map_public_ip_on_launch" {
  type        = bool
  description = "Default for public AMI IP"
  default     = true
  sensitive   = false
}

variable "enable_dns_hostnames" {
  type        = bool
  description = "Default for DNS hostnames"
  default     = true
  sensitive   = false
}

# NETWORK CIDRs #
# https://techlibrary.hpe.com/docs/otlink-wo/CIDR-Conversion-Table.html

variable "allowed_cidr_block" {
  type        = string
  description = "my home CIDR block"
  default     = "73.153.149.181/32" # old "67.176.23.234/32"
  sensitive   = false
}

variable "class_any_cidr_block" {
  type        = string
  description = "The 0.0.0.0/0 CIDR block"
  default     = "0.0.0.0/0"
  sensitive   = false
}

variable "class_1b_cidr_blocks" {
  type        = list(any)
  description = "List of Class 1 B CIDR blocks starting at 10.x.0.0/16, sn: 255.255.0.0, 65,024 addresses."
  default     = ["10.0.0.0/16", "10.1.0.0/16", "10.2.0.0/16"]
  sensitive   = false
}

variable "class_1c_cidr_blocks" {
  type        = list(any)
  description = "List of Class 1 C CIDR blocks starting at 10.0.x.0/24, sn: 255.255.255.0, 254 addresses."
  default     = ["10.0.0.0/24", "10.0.1.0/24", "10.0.2.0/24"]
  sensitive   = false
}

# INSTANCE VARS #

variable "instance_type" {
  type        = string
  description = "The Instance Type"
  default     = "t3.micro"
  sensitive   = false
}

# TAGS #

variable "company" {
  type        = string
  description = "company name for resource tagging"
  default     = "Globomantics"
  sensitive   = false
}

variable "project" {
  type        = string
  description = "project name for resource tagging"
  default     = ""
  sensitive   = false
}

variable "billing_code" {
  type        = string
  description = "billing code for resource tagging"
  default     = ""
  sensitive   = false
}
