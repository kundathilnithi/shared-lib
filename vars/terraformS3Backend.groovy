import groovy.text.SimpleTemplateEngine

// Define a function to configure Terraform S3 backend for AWS
def call(Map config) {
    // Define default configuration parameters if not provided
    def backendConfig = [
        bucket: config.bucket ?: "default-terraform-state-bucket",
        key: config.key ?: "terraform/${config.appName}/${config.environment}/terraform.tfstate",
        region: config.region ?: "us-west-2",
        dynamodb_table: config.dynamodb_table ?: "terraform-lock-table"
    ]

    // Load the backend template file
    def templateFile = libraryResource('terraform/s3BackendConfig.tf')
    def engine = new SimpleTemplateEngine()
    def backendContent = engine.createTemplate(templateFile).make(backendConfig).toString()

    // Write the backend configuration to a file in the workspace
    writeFile file: 'backend.tf', text: backendContent

    // Initialize Terraform with the generated backend configuration
    sh """
      terraform init -backend-config=backend.tf
    """
}