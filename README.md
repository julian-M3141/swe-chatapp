# swe-chatapp

Chatapp zum Schreiben von Messages, die von allen Benutzern gesehen werden kann und einer Statstik, wie viele Nachrichten pro Tag verschickt werden.

Verwendet Jenkins zum Bauen der Applikation, Jenkins läuft bei mir auf einem Raspberry Pi, genauso wie eine lokale Dockerregistry. 
Applikation kann mit docker-compose zum Laufen gebracht werden und läuft auf Port 5555.
Leider funktioniert mit dokcer-compose das Fetchen der Konfig-Datei vom config-Server nicht, beim Starten in der IDE aber schon. 

Verwendete Faktoren
 1. git-Monorepository verwendet, mittels Jenkinsfile wird jede Applikation einzeln deployed. Es wird kein Code geteilt, würde aber mit Bibliothek gelöst werden. 
 2. Alle Abhängigkeiten werden von Maven in der pom .xml deklariert und beim Bauen geladen.
 3. Für die Konfiguration würde ich die Datenbankname, -user und -password in eine Umgebungsvariable auslagern und in der application.yml nur auf die Umgebungsvariable referenzieren
 4. Änderung der Datenbank ist leicht über die application.yml machbar.
 5. In jedem Jenkinsfile wird die Applikation gebaut und an die Docker-Registry gepushed. Zum deployen könnte man zB noch mittels Ansible und docker-compose jede einzelne Applikation starten.
 6. Alle Applikationen sind zustandslos und speichern die Daten in der Datenbank. Die Daten von chatservice und statisticservice werden in der gleichen DB, aber in verschiedenen Schemas gespeichert und haben keinen Zugriff auf die jeweils anderen Daten.

 7. (Punkt 9) Die StartUp und Stop Zeiten sind gering
 8. (Punkt 10) Selben Dienste werden beim Testen und Deployen verwendet (zB DB und Kafka im docker-compose mit definiert).
 9. (Punkt 11) Logs werden an stdout geschickt. 
