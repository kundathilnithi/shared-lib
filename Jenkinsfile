@Library('mylibrary') _

import com.cleverbuilder.GlobalVars
import com.cleverbuilder.SampleClass

pipeline {
    agent any
    parameters {
      text(name: 'VARS_CONTENT', defaultValue: 'CHICKEN: ', description: 'Favorite Bird')
    }
    stages {
        stage('Demo') {
            steps {
                echo 'Hello, world'
                sayHello 'Dave'

                echo 'The value of foo is : ' + GlobalVars.foo

                script {
       
                    def person = new SampleClass()
                    person.age = 21
                    person.increaseAge(60)
                    echo 'Incremented age, is now : ' + person.age
                }
            }
        }
    }
}