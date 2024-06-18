# Définir les variables
JAVAC = javac
JAVA = java
SRC_DIRS = text convert crypt
OUT_DIR = out

# Fichier source et classe principale
MAIN_SRC = Main.java
MAIN_CLASS = Main

# Trouver tous les fichiers Java dans les sous-répertoires
SRC_FILES = $(wildcard $(foreach dir, $(SRC_DIRS), $(dir)/*.java)) $(MAIN_SRC)

# Règle par défaut
all: run

# Compilation
compile:
	@mkdir -p $(OUT_DIR)
	$(JAVAC) -d $(OUT_DIR) $(SRC_FILES)

# Exécution
run: compile
	$(JAVA) -cp $(OUT_DIR) $(MAIN_CLASS)

# Nettoyage
clean:
	rm -rf $(OUT_DIR)

# Règle pour afficher l'aide
help:
	@echo "Utilisation :"
	@echo "  make          - Compile et exécute le fichier Main.java"
	@echo "  make run      - Compile et exécute le fichier Main.java"
	@echo "  make clean    - Supprime les fichiers compilés"
	@echo "  make help     - Affiche cette aide"

.PHONY: all compile run clean help
