import groovy.text.SimpleTemplateEngine

    // Method to render the Terraform backend template
def renderTerraformBackendConfig(Map config) {
def engine = new SimpleTemplateEngine()
def templateText = '''
terraform {
  backend "s3" {
    bucket         = "${bucket}"
    key            = "${key}"
    region         = "${region}"
   
  }
}
'''
  // Default values for the backend configuration
    def binding = [
        bucket: config.bucket ?: "default-terraform-state-bucket",
        key: config.key ?: "path/to/terraform.tfstate",
        region: config.region ?: "us-east-1",
        
    ]

    def template = engine.createTemplate(templateText)
    def backendContent = template.make(binding).toString()
    writeFile file: 'backend.tf', text: backendContent
     // Run Terraform commands to initialize the backend with the custom config
    sh """
      terraform init -backend-config=backend.tf
    """
}
    
    

   
}