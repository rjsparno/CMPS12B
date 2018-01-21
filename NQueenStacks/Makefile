NQueens.jar: NQueens.class
	echo Main-class: NQueens > Manifest
	jar cvfm NQueens.jar Manifest NQueens.class
	rm Manifest

NQueens.class:
	javac NQueens.java
clean:
	rm *.class
	rm *.jar

