#!/usr/bin/env groovy
package com.awsec2

class TerragruntPipeline {

    // String terragruntConfig

    // TerragruntPipeline(String terragruntConfig) {
    //     this.terragruntConfig = terragruntConfig
    // }

    void init() {
     
         String command = "terragrunt -v"
        runCommand(command)
    }

    // void plan() {
    //     sh "terragrunt plan  "
    // }

    // void apply() {
    //     input message: 'Approve deployment?', ok: 'Deploy'
    //     sh "terragrunt apply   -auto-approve"
    // }

    // void output() {
    //     sh "terragrunt output"
    // }
}