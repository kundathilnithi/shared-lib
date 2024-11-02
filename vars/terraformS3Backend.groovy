import groovy.text.SimpleTemplateEngine

// Function to configure the Terraform backend for AWS S3
def call(Map config) {
    // Define default configuration parameters, allowing overrides
    def backendConfig = [
        bucket: config.get('bucket', 'default-terraform-state-bucket'),
        key: config.get('key', "terraform/${config.appName}/${config.environment}/terraform.tfstate"),
        region: config.get('region', 'us-west-2'),
        dynamodb_table: config.get('dynamodb_table', 'terraform-lock-table')
    ]

    // Load the backend template file
    def templateFile = libraryResource('terraform/backendConfig.tf')
    def engine = new SimpleTemplateEngine()
    def backendContent = engine.createTemplate(templateFile).make(backendConfig).toString()

    // Write the backend configuration to a temporary file in the workspace
    writeFile file: 'backend.tf', text: backendContent

    // Initialize Terraform with the generated backend configuration
    sh """
      terraform init -backend-config=backend.tf
    """
}