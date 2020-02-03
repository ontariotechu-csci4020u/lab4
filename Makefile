.PHONY: compile check run

compile:
	mkdir -p target
	javac -d target -sourcepath ./src src/*.java

run:
	java -cp ./target Check

check:
	check

clean:
	rm -f target/*.class
