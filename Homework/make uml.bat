@ECHO OFF
dir>*.txt
set /p fileName=Enter file name:
java -jar plantuml.jar %fileName%.txt