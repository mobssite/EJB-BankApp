# EJB-BankApp
# Learning project
# Bank Online

Application client / serveur de gestion de compte bancaire. 


# Architecture

Client / serveur -> 4 Modules  :

		* EBank-V1-JEE-EJB3-core 			([Pom EJB] EJB Module - Business, DOA, SOAP Service)	
		* EBank-V1-JEE-EJB3-web-JSF			([Pom WAR] Web Module - Servlet-JSP-JSTL )
		* EBank-V1-JEE-EJB3-web-JSP			([Pom WAR] Web Module - JSF2 )
		* EBank-V1-JEE-EJB3-remote-client	([Pom JAR] Remote client )
		
		* EBank-V1-JEE-EJB3-EAR				([Pom EAR] EAR Module - to package entire Enterprise application)
	
# Environment Used

	* Stack Technique 

		* Plateform : JDK 1.7 / JEE6
		* Object Lifecycle & IOC : EJB 3
		* DAO : JPA / Hibernate
		* UI : JSP JSTL / JSF 2
	
	* Tools
	
		* IDE : Eclipse Mars 
		* Application Server : Jboss AS 7
		* SCM : Git
		* Build : Maven 3
		* SGBD : WampServer (MySQL 5) - Workbench

# Features
