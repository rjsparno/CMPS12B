#Makefile for NQueens
NQueens: NQueens.class
	echo Main-class: NQueens > Manifest
	jar cvfm NQueens.jar Manifest NQueens.class
	rm Manifest
NQueens.class: NQueens.java
	javac NQueens.java
clean:
	rm -f NQueens.jar NQueens.class


