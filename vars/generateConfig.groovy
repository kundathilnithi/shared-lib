import groovy.text.SimpleTemplateEngine

def call(Map params) {

echo "${params.bucket}"

def templateFile = libraryResource('config.template')
echo "$templateFile"
 def engine = new SimpleTemplateEngine()
     def binding = [
        bucket: "${params.bucket}",
        key: "${params.key}",
        region: "${params.region}"
    ]
   def template = engine.createTemplate(templateFile)
   def configContent = template.make(binding).toString()
   return "${configContent}"  
   
} 

