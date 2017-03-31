faas {
    singleSignOnUrl=""
    environments {
        development {
		
		 applicationUrl="https://"+ System.getenv("APP_HOST")+"/faas"
		 dojoExternalUrl="https://10.29.4.17/dojo/dojo-1.10.4"
		 cssExternalUrl="https://10.29.4.17/css"		
                 //Config based on the LDAP/AD you have connedted to.
		 isOpenLDAP=true
                 //Since we have enbaled multi user managment 
		 isSelfUserManagement=true
                 password=System.getenv("APP_PASSWORD")
                 authURL = "http://localhost:8080/api"		            
				 
            uploadFolder = "D:/temp/metadata/"
        }
        production { 
            applicationUrl="http://192.168.1.25:8090/portal"
            dojoExternalUrl="https://192.168.1.25/dojo/dojo-1.8"
            cssExternalUrl="https://192.168.1.25/ui"
            isOpenLDAP=true
            isSelfUserManagement=true
            password="@dm1n!Icp"
            authURL = "http://localhost:8080/api"
            uploadFolder = "D:/temp/metadata/"
	}
    }
}

saml {
    lb {
        scheme="https"
        serverName="idp.fogpanel.com"
        serverPort="443"
        includeServerPortInRequestURL="false"
        contextPath="/faas"
    } 
}

billing {
        defaultCurrency = "USD"
        defaultCurrencySymbol = "\$"
}
debug {
   log = true
}
license {
    ssl {
      noverify = true
    }
}

rabbitmq {
  connectionfactory {
        username = 'demo'
        password = 'Wq25jvpA6e~T8Cn1111111111'
        hostname = '162.252.80.98'
  }

    queues = {
        exchange name: "zenoss-mails", type: topic, durable: true, {
          "zenoss-mail-queue" durable: true, binding: 'zenoss-mail-queue'
        }
  }
}

mailTemplate {
	environments {
	    development {
		 internalTemplateURL="src/java/com/assistanz/fogpanel/mailtemplate/"
	    }
	    production {
		 internalTemplateURL="WEB-INF/classes/com/assistanz/fogpanel/mailtemplate/"
	    }
	}
	useUserlanguage=true
	externalTemplateURL="/etc/fogpanel/templates"
	useExternalTemplate=false
}
grails {
   mail {
     host = "smtp.gmail.com"
     port = 465
     username = "assistanz.test@gmail.com"
     password = "l3tm3intest"
     props = ["mail.smtp.auth":"true",
              "mail.smtp.socketFactory.port":"465",
              "mail.smtp.socketFactory.class":"javax.net.ssl.SSLSocketFactory",
              "mail.smtp.socketFactory.fallback":"false"]
   }
}
grails.mail.default.from = "fogpanel@assistanz.com"
environments {
    development {
        dataSource {
            dbCreate = ""
            driverClassName = "com.mysql.jdbc.Driver"
            url = "jdbc:mysql://"+System.getenv("DB_HOST")+":"+System.getenv("DB_PORT")+"/"+System.getenv("DB_NAME")
            username = System.getenv("DB_USERNAME")
            password = System.getenv("DB_PASSWORD")
        }

    }
    test {
        dataSource {
            dbCreate = ""
        }
    }
    production {
        dataSource {
                dbCreate = ""
                jndiName = "java:comp/env/jdbc/FogPanelDataSource"

        }
    }
}

