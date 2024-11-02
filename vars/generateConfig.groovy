import groovy.text.SimpleTemplateEngine

def call(Map params) {

echo "${params.bucket}"

def templateFile = libraryResource('config.template')
echo "$templateFile"
 def engine = new SimpleTemplateEngine()
     def binding = [
        bucket    : "${params.bucket}",
        key: "${params.key}",
        region     : "${params.region}"
    ]
   def template = engine.createTemplate(templateFile)
   def configContent = template.make(binding).toString()
   echo "${configContent}"
   def content = "Hello"
   script {
   // Write the populated backend configuration to a temporary file
    writeFile file: 'backend.tf', text: content
   }
} 

// def call(Map params) {
//     // Check if required parameters are provided
//     if (!params.appName || !params.environment || !params.region) {
//         error("Missing required parameters: appName, environment, region")
//     }

//     // Read the template file from the resources
//     def templateFile = libraryResource('config.template')

//     // Create a new SimpleTemplateEngine instance
//     def engine = new SimpleTemplateEngine()

//     // Create a binding with the parameters
//     def binding = [
//         appName    : 'myapp',
//         environment: 'dev',
//         region     : 'us-east1'
//     ]

//     // Create the template and replace the placeholders with values
//     def template = engine.createTemplate(templateFile)
//     def configContent = template.make(binding).toString()

//     // Write the populated configuration to a new file
//     writeFile file: 'config.properties', text: configContent

//     // Optionally print the generated config for debugging
//     echo "Generated config:\n${configContent}"
// }
