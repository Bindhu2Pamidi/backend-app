output "application_url" {
  value = "http://${aws_lb.app.dns_name}"
}

output "database_endpoint" {
  value = aws_db_instance.postgres.address
}