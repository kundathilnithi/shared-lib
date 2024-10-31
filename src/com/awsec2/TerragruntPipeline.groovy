#!/usr/bin/env groovy
package com.awsec2

class TerragruntPipeline {

    // String terragruntConfig

    // TerragruntPipeline(String terragruntConfig) {
    //     this.terragruntConfig = terragruntConfig
    // }

    void init() {
        sh "pwd"
        sh "terragrunt init  "
    }

    void plan() {
        sh "terragrunt plan  "
    }

    void apply() {
        input message: 'Approve deployment?', ok: 'Deploy'
        sh "terragrunt apply   -auto-approve"
    }

    void output() {
        sh "terragrunt output"
    }
}