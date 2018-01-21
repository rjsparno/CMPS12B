ChessBoard.jar: ChessBoard.class 
	echo Main-class: ChessBoard > Manifest
	jar cvfm ChessBoard.jar Manifest ChessBoard.class *.class
	rm Manifest

ChessBoard.class: ChessBoard.java
	javac *.java

clean:
	rm *.class
	rm *.jar

