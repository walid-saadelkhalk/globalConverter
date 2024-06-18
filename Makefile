# Définir les variables
JAVAC = javac
JAVA = java
SRC_DIRS = text convert crypt

# Trouver tous les fichiers Java dans les sous-répertoires
SRC_FILES = $(wildcard $(foreach dir, $(SRC_DIRS), $(dir)/*.java)) Main.java

# Règle par défaut
all: run

# Compilation
compile:
	$(JAVAC) $(SRC_FILES)

# Exécution
run: compile
	$(JAVA) Main

# Nettoyage
clean:
	find $(SRC_DIRS) -name "*.class" -type f -delete
	rm -f Main.class

# Règle pour afficher l'aide
help:
	@echo "Utilisation :"
	@echo "  make          - Compile et exécute le fichier Main.java"
	@echo "  make run      - Compile et exécute le fichier Main.java"
	@echo "  make clean    - Supprime les fichiers compilés"
	@echo "  make help     - Affiche cette aide"

.PHONY: all compile run clean help
