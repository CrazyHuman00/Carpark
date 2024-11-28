ARCHIVE	= $(shell basename `pwd`)
SOURCES	= $(shell find . -name "*.java")
JAVAC := javac
JAVA := java
DEFAULT_CAPACITY = 10
DEFAULT_SIMULATION_TIME = 1000


all: $(CLASSES)

%.class: %.java
	$(JAVAC) $<

test :
	@if [ -z "$(capacity)" ] && [ -z "$(time)" ]; then \
		echo "Using default capacity: $(DEFAULT_CAPACITY) and default time: $(DEFAULT_SIMULATION_TIME)"; \
		$(JAVA) example/Carpark.java $(DEFAULT_CAPACITY) $(DEFAULT_SIMULATION_TIME); \
	elif [ -z "$(time)" ]; then \
		echo "Using provided capacity: $(capacity) and default time: $(DEFAULT_SIMULATION_TIME)"; \
		$(JAVA) example/Carpark.java $(capacity) $(DEFAULT_SIMULATION_TIME); \
	elif [ -z "$(capacity)" ]; then \
		echo "Using default capacity: $(DEFAULT_CAPACITY) and provided time: $(time)"; \
		$(JAVA) example/Carpark.java $(DEFAULT_CAPACITY) $(time); \
	else \
		echo "Using provided capacity: $(capacity) and provided time: $(time)"; \
		$(JAVA) example/Carpark.java $(capacity) $(time); \
	fi

compile:
	$(JAVAC) -d classes $(SOURCES)

clean:
	rm -f $(shell find . -name "*.class")

.PHONY: all test clean