output "database_endpoint" {
  value       = aws_db_instance.postgres.address
}

output "application_url" {
   value = "https://console.aws.amazon.com/ecs/v2/clusters/${aws_ecs_cluster.app.name}/tasks?region=us-east-1"
}