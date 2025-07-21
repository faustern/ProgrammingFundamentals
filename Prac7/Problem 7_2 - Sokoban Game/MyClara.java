/**
 * MyClara is a subclass of Clara. Therefore, it inherits all methods of Clara: <p>
 * 
 * 
 * PERMITTED COMMANDS
 * Actions:     move(), turnLeft(), turnRight(), putLeaf(), removeLeaf()
 *              mushroomFront(), canPushMushroom(), setNumberOfMoves(),
 *              testLevelComplete(), setDirectionUp(), setDirectionDown(),
 *              setDirectionLeft(), setDirectionRight(), getKey()
 * Sensors:     onLeaf(), treeFront(), mushroomFront()
 * JAVA:        if, else, while, for, !, &&, ||
 */
class MyClara extends Clara {

    private int numberOfMoves = 0; // Track the number of moves
    private boolean isLevelComplete = false; // Flag to check if the level is complete

    public void act() {
        // Get the pressed key
        String key = getKey();

        // Handle movement
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
        
        // Check if the level is complete
        if (testLevelComplete() && !isLevelComplete) {
            levelComplete();
            isLevelComplete = true;
        }
    }

    // Handling level completion
    public void levelComplete() {
        showWarning("Level Complete!");
        setNumberOfMoves(numberOfMoves);
    }
}