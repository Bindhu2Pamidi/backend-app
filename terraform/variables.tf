variable "aws_region" {
  type    = string
  default = "us-east-1"
}

variable "docker_image" {
  type    = string
  default = "bindhup/report-app-testing:latest"
}

variable "db_name" {
  type    = string
  default = "report_db"
}

variable "db_username" {
  type    = string
  default = "app"
}

variable "db_password" {
  type      = string
  sensitive = true
}