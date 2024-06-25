# Variables are defined using the syntax VAR = value
JAVAC = javac
JAVA = java
SRC_DIRS = text convert crypt

# Find all .java files in the SRC_DIRS directories
SRC_FILES = $(wildcard $(foreach dir, $(SRC_DIRS), $(dir)/*.java)) Main.java

# Default target
all: run

# Compilation
compile:
	$(JAVAC) $(SRC_FILES)

# Executing
run: compile
	$(JAVA) Main

# Clean
clean:
	PowerShell -Command "Get-ChildItem -Path . -Filter *.class -Recurse | Remove-Item"

# Rules to print help
help:
	@echo "Utilisation :"
	@echo "  make          - Compile et exécute le fichier Main.java"
	@echo "  make run      - Compile et exécute le fichier Main.java"
	@echo "  make clean    - Supprime les fichiers compilés"
	@echo "  make help     - Affiche cette aide"

.PHONY: all compile run clean help
