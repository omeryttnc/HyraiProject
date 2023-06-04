
pipeline {
  agent any

  tools {nodejs "20.2.0"}


  stages {

    stage('clean workspace'){
      steps{
          cleanWs()
      }
    }

    stage('git '){
      steps{
          git 'https://github.com/omeryttnc/HyraiProject.git/'
      }
    }

    // stage('Install Postman CLI') {
    //   steps {
    //     bat 'powershell.exe -NoProfile -InputFormat None -ExecutionPolicy AllSigned -Command "[System.Net.ServicePointManager]::SecurityProtocol = 3072; iex ((New-Object System.Net.WebClient).DownloadString(\'https://dl-cli.pstmn.io/install/win64.ps1\'))"'
    //     bat 'npm i -g newman-reporter-htmlextra'
    //     bat 'npm install -g newman'

    //   }
    // }

    stage('Postman CLI Login') {
      steps {
        bat 'postman login --with-api-key PMAK-647caa9bee1a430efe9f4ddf-a763a881d789bfed13d5c5dd8bf93aed42'
      }
    }

    // stage('Running collection') {
    //   steps {
    //     bat 'postman collection run "11910468-8656536c-4695-4533-8700-72a6d10d7a38" -e "11910468-303dcde1-4d8b-425e-83a0-b2bc3fba56fd" -d "src/test/resources/search.json"'
    //   }
    // }


    stage('Running collection') {
      steps {
        bat 'newman run https://api.getpostman.com/collections/11910468-8656536c-4695-4533-8700-72a6d10d7a38?apikey=PMAK-647cb1b5b0d2701910faa8df-2bb484df25aecbc134d9a96c05f2078edf --environment https://api.getpostman.com/environments/11910468-303dcde1-4d8b-425e-83a0-b2bc3fba56fd?apikey=PMAK-647cb1b5b0d2701910faa8df-2bb484df25aecbc134d9a96c05f2078edf -d "src/test/resources/search.json" -r htmlextra --reporter-htmlextra-export "src/test/resources/"'
      }
    }


    stage('mail gonder'){
        steps{
            emailext attachmentsPattern: 'src\\test\\resources\\*.html', body: '', subject: '', to: 'omeryttnc@gmail.com'
        }
    }


  }
}