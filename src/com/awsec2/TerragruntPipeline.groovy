#!/usr/bin/env groovy
package com.awsec2

class TerragruntPipeline {

    // String terragruntConfig
    String command

    // TerragruntPipeline(String terragruntConfig) {
    //     this.terragruntConfig = terragruntConfig
    // }

    void init() {
     
         command = "terragrunt -v"
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