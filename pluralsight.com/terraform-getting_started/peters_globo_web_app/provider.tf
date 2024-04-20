provider "aws" {
  region = var.primary_region
}

provider "aws" {
  alias  = "secondary"
  region = var.secondary_region
}

provider "random" {
  # Block not needed, but here for visual/mental reference
}
