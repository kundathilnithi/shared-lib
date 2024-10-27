@Library('mylibrary') _

import com.cleverbuilder.GlobalVars
import com.cleverbuilder.SampleClass

pipeline {
    agent any
    stages {
        stage('Demo') {
            steps {
                echo 'Hello, world'
                sayHello 'Dave'

                echo 'The value of foo is : ' + GlobalVars.foo

                script {
                    properties([
                        parameters { string(name1: 'Age', defaultValue: '10', description: 'Age', trim: true) }

                    ]) }
                    def person = new SampleClass()
                    person.age = 21
                    person.increaseAge(60)
                    echo 'Incremented age, is now : ' + person.age
                }
            }
        }
    }
}