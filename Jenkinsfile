@Library('mylibrary') _

import com.cleverbuilder.GlobalVars
import com.cleverbuilder.SampleClass

pipeline {
    agent any
    parameters {
        string(defaultValue: "20", description: 'This is my parameter', name: 'increment_age') ;
    }
    
    stages {
        stage('Demo') {
            steps {
                echo 'Hello, world'
                sayHello 'Dave'

                echo 'The value of foo is : ' + GlobalVars.foo
                def age = ${params.increment_age}"
                script {
       
                    def person = new SampleClass()
                    person.age = 21
                    person.increaseAge(${increment_age})
                    echo 'Incremented age, is now : ' + person.age
                }
            }
        }
    }
}