/**
 * MyClara is a subclass of Clara. Therefore, it inherits all methods of Clara: <p>
 * 
 * 
 * PERMITTED COMMANDS
 * Actions:     move(), turnLeft(), turnRight(), putLeaf(), removeLeaf()
 *              mushroomFront(), canPushMushroom(), setNumberOfMoves(),
 *              testLevelComplete(), setDirectionUp(), setDirectionDown(),
 *              setDirectionLeft(), setDirectionRight(), getKey()
 * Sensors:     onLeaf(), treeFront(), mushroomFront(), loadLevel()
 * JAVA:        if, else, while, for, !, &&, ||
 */
class MyClara extends Clara {

    private char[][] level1 = {
        {'#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' '},
        {'#', ' ', '|', '#', ' ', ' ', ' ', ' ', ' ', ' '},
        {'#', ' ', ' ', '#', '#', '#', ' ', ' ', ' ', ' '},
        {'#', ' ', '@', ' ', ' ', '#', ' ', ' ', ' ', ' '},
        {'#', ' ', ' ', '$', ' ', '#', ' ', ' ', ' ', ' '},
        {'#', ' ', ' ', '#', '#', '#', ' ', ' ', ' ', ' '},
        {'#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' '}
    };

    private char[][] level2 = {
        {'#', '#', '#', '#', '#', ' ', ' ', ' ', ' '},
        {'#', '@', ' ', ' ', '#', ' ', ' ', ' ', ' '},
        {'#', ' ', '$', '$', '#', ' ', '#', '#', '#'},
        {'#', ' ', '$', ' ', '#', ' ', '#', '|', '#'},
        {'#', '#', '#', ' ', '#', '#', '#', '|', '#'},
        {' ', '#', '#', ' ', ' ', ' ', ' ', '|', '#'},
        {' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#'},
        {' ', '#', ' ', ' ', ' ', '#', '#', '#', '#'},
        {' ', '#', '#', '#', '#', '#', ' ', ' ', ' '},
    };

    private char[][] level3 = {
        {'#', '#', '#', '#', '#', '#', ' '},
        {'#', ' ', ' ', ' ', ' ', '#', ' '},
        {'#', ' ', '#', '@', ' ', '#', ' '},
        {'#', ' ', '$', '*', ' ', '#', ' '},
        {'#', ' ', '|', '*', ' ', '#', ' '},
        {'#', ' ', ' ', ' ', ' ', '#', ' '},
        {'#', '#', '#', '#', '#', '#', ' '},
    };

    private int numberOfMoves = 0; // Track the number of moves
    private static int currentLevel = 1; // Track current level
    private boolean isLevelComplete = false; // Flag to check if the level is complete

    public void act() {
        // Get the pressed key
        String key = getKey();

        // Handle movement
        if (key != null && !isLevelComplete) {
            if (key == "left") {
                setDirectionLeft(); // Move left
                move();
                numberOfMoves++;
            } else if (key == "right") {
                setDirectionRight(); // Move right
                move();
                numberOfMoves++;
            } else if (key == "up") {
                setDirectionUp(); // Move up
                move();
                numberOfMoves++;
            } else if (key == "down") {
                setDirectionDown(); // Move down
                move();
                numberOfMoves++;
            }
        }

        // Check if the level is complete
        if (testLevelComplete() && !isLevelComplete) {
            levelComplete();
            isLevelComplete = true;
        }
    }

    // Print level completion message and number of moves
    public void levelComplete() {
        showWarning("Level Complete!");
        setNumberOfMoves(numberOfMoves);
        currentLevel++;
        loadNextLevel();
    }

    // Load the next level
    private void loadNextLevel() {
        if (currentLevel == 2) {
            loadLevel(level2); // Load level 2
            resetLevel();
        } else if (currentLevel == 3) {
            loadLevel(level3); // Load level 3
            resetLevel();
        } else {
            showWarning("All levels complete!"); // All levels are complete
        }
    }

    // Reset values for the new level
    private void resetLevel() {
        numberOfMoves = 0;
        isLevelComplete = false;
    }
}