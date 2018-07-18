def pipelinescript = new JobsBuilder(this).pipelineFromScript()

pipelinescript.job("Nightly-Trigger") {
    htmlDescription(['Nightly trigger job for Catroid/develop, Paintroid/develop and Build-Standalone.'])

    jenkinsUsersPermissions(Permission.JobRead, Permission.JobBuild, Permission.JobCancel)
    anonymousUsersPermissions(Permission.JobRead) 

    nightly()

    jenkinsfileScriptPath('job_dsl/src/main/resources/jobs/jenkinsfiles/nightly_trigger.jenkinsfile')
}
