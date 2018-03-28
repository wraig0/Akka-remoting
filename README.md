# Akka-remoting
Scala scripts for connection speed testing using actors.

## Description: 
		This package allows connection speed testing through two actors, each on separate Ports (and can be configured to 
		run on separate machines), one receiving messages and echoing them back, the other sending messages and recording 
		the time it takes for the receiver to echo them back.
	
###	Applications: 
		Receiver.scala: 
			Self sufficient Scala application that binds itself to a local Port and echoes back incoming connections.
		Sender.scala:	
			Self sufficient Scala application that sends batches data to the Receiver.
	
###	Instructions: 
		Each needs to be run separately, they will not both be run at the same time by Eclipse, they are two separate Scala 
		objects/applications.
			=> Click the file (Receiver.scala and Sender.scala) and hit Run.
		
		Try first starting the Sender, then after a few seconds the Receiver. 
