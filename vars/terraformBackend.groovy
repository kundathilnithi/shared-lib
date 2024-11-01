import groovy.text.SimpleTemplateEngine

// Define a function to configure Terraform backend for AWS
def call(Map config) {
    // Define default backend configuration parameters
    def backendConfig = [
        bucket: config.bucket ?: "default-terraform-state-bucket",
        key: config.key ?: "terraform/${config.appName}/${config.environment}/terraform.tfstate",
        region: config.region ?: "us-west-2",
        dynamodb_table: config.dynamodb_table ?: "terraform-lock-table"
    ]

    // Read the backend template file
    def templateFile = libraryResource('terraform/awsBackendConfig.hcl')
    def engine = new SimpleTemplateEngine()
    def backendContent = engine.createTemplate(templateFile).make(backendConfig).toString()

    // Write the populated backend configuration to a temporary file
    writeFile file: 'backend.tf', text: backendContent

    // Run Terraform commands to initialize the backend with the custom config
    sh """
      terraform init -backend-config=backend.tf
    """
}