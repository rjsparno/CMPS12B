Bard.jar: Bard.class
	echo Main-class: Bard > Manifest
	jar cvfm Bard.jar Manifest Bard.class
	rm Manifest

Bard.class:
	javac Bard.java
clean:
	rm *.class
	rm *.jar

