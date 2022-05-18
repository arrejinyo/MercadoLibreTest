/* Pipeline para ejecutar en Jenkins */

pipeline {
    agent any

    options {
        skipDefaultCheckout(true)
    }

    stages{
        stage('Checkout'){
            steps {
                checkout scm
            }
        }
        stage('Test'){
            steps {
                script {
                    try{
                        withMaven(
                            maven: 'mvn',
                            mavenSettingsConfig: 'mvn',
                            mavenLocalRepo: '.repository') {
                            sh 'mvn -f pom.xml test -Dsurefire.suiteXmlFiles=src/test/resources/suites/$suiteXmlFiles -Dambiente=$ambiente -Dbrowser=chrome -Denvironment=hub -DhubURL=$hubURL -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -DuserAPM=$userAPM -Dpass=$pass -DuserComet=$userComet -DpassComet=$passComet -DuserGrafana=$userGrafana -DpassGrafana=$passGrafana -DuserSolrFiltro=$userSolrFiltro -DpassSolrFiltro=$passSolrFiltro -DuserSolrReferencia=$userSolrReferencia -DpassSolrReferencia=$passSolrReferencia -DuserKibana=$userKibana -DpassKibana=$passKibana'
                        }
                    } catch(err) {
                        emailext (
                            subject: "[FAILED] | Matinal: ${suiteXmlFiles}",
                            mimeType: 'text/html',
                            body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}<br> Más información en: ${env.BUILD_URL} <br> <br> <a href='http://10.250.6.155:5601/login?next=%2Fs%2Fauditor-a%2Fapp%2Fkibana#/dashboard/6849c370-0a78-11eb-bf3c-3b5831c31c4a?_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:now-240m,to:now))&_a=(description:'Dashboard%20que%20incluye%20todos%20los%20servicios%20que%20deben%20ser%20controlados%20con%20frecuencia',filters:!(),fullScreenMode:!f,options:(hidePanelTitles:!f,useMargins:!t),panels:!((embeddableConfig:(vis:(params:(sort:(columnIndex:3,direction:desc)))),gridData:(h:121,i:'2',w:48,x:0,y:14),id:'1552aad0-0a76-11eb-bf3c-3b5831c31c4a',panelIndex:'2',type:visualization,version:'7.1.1'),(embeddableConfig:(),gridData:(h:14,i:'3',w:48,x:0,y:0),id:'97160d60-2523-11eb-aa5a-83f397986bcc',panelIndex:'3',title:'',type:visualization,version:'7.1.1')),query:(language:kuery,query:''),timeRestore:!f,title:'Automation%20Service',viewMode:view)'>Estado de Servicios Criticos</a>",
                            attachLog: true,
                            attachmentsPattern: "TestReport/Test-Automation-Report.html",
                            from: "arrejinyo@gmail.com",
                            to: "arrejinyo@gmail.com, ${email}"
                    )
                        throw err
                    }
                }
            }
        }

        stage('Notify Build'){
            steps {
                emailext (
                    subject: "[SUCCESS] | Matinal: ${suiteXmlFiles}",
                    mimeType: 'text/html',
                    body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}<br> Más información en: ${env.BUILD_URL} <br> <br> <a href='http://10.250.6.155:5601/login?next=%2Fs%2Fauditor-a%2Fapp%2Fkibana#/dashboard/6849c370-0a78-11eb-bf3c-3b5831c31c4a?_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:now-240m,to:now))&_a=(description:'Dashboard%20que%20incluye%20todos%20los%20servicios%20que%20deben%20ser%20controlados%20con%20frecuencia',filters:!(),fullScreenMode:!f,options:(hidePanelTitles:!f,useMargins:!t),panels:!((embeddableConfig:(vis:(params:(sort:(columnIndex:3,direction:desc)))),gridData:(h:121,i:'2',w:48,x:0,y:14),id:'1552aad0-0a76-11eb-bf3c-3b5831c31c4a',panelIndex:'2',type:visualization,version:'7.1.1'),(embeddableConfig:(),gridData:(h:14,i:'3',w:48,x:0,y:0),id:'97160d60-2523-11eb-aa5a-83f397986bcc',panelIndex:'3',title:'',type:visualization,version:'7.1.1')),query:(language:kuery,query:''),timeRestore:!f,title:'Automation%20Service',viewMode:view)'>Estado de Servicios Criticos</a>",
                    attachLog: true,
                    attachmentsPattern: "TestReport/Test-Automation-Report.html",
                    from: "arrejinyo@gmail.com",
                    to: "arrejinyo@gmail.com, ${email}"
                )
            }
        }
    }
}
