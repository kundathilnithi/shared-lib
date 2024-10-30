#!/usr/bin/env groovy
package com.awsec2

class TerragruntPipeline {

    String terragruntConfig

    TerragruntPipeline(String terragruntConfig) {
        this.terragruntConfig = terragruntConfig
    }

    void init() {
        sh "terragrunt init --terragrunt-config ${terragruntConfig}"
    }

    void plan() {
        sh "terragrunt plan --terragrunt-config ${terragruntConfig}"
    }

    void apply() {
        input message: 'Approve deployment?', ok: 'Deploy'
        sh "terragrunt apply --terragrunt-config ${terragruntConfig} -auto-approve"
    }

    void output() {
        sh "terragrunt output"
    }
}