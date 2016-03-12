call mvn clean install
if errorlevel 1 GOTO error
git add -A
git commit -m checkPoint
copy target\NasNexus.war "C:\Users\Joseph\Desktop\Dev tools\wildfly-10.0.0.Final\standalone\deployments\NasNexus.war"
GOTO noerror
:error

pause
:noerror

