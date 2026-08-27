output "database_endpoint" {
  value       = aws_db_instance.postgres.address
}

output "ecs_tasks_console_url" {
  value       = "https://amazon.com{aws_ecs_cluster.app.name}/tasks?region=us-east-1"
}