JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	AnimalShelter.java \
	AnimalShelter2.java \
	Animal.java \
	Cat.java \
	Dog.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
