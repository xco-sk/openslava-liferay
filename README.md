# openslava-liferay
Materials for OSGi in Liferay environment workshop

#Installing JAR file to local repository
mvn install:install-file -Dfile=demo.whois.simple.provider.jar -DgroupId=demo.whois -DartifactId=whois.provider -Dversion=1.0.0 -Dpackaging=jar
