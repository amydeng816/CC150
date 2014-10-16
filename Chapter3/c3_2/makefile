JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	MinStack.java \
	MinStack2.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
