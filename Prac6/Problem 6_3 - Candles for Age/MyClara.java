/* PERMITTED COMMANDS
   move, turnLeft, turnRight, treeLeft, treeRight, treeFront, onLeaf, putLeaf, removeLeaf, mushroomFront
   JAVA
   if, while, for
*/
   
class MyClara extends Clara { 
    boolean isFacingWest = false;

    void run() {
        int age = readInt("Enter age:");

        // Bake an 18x4 cake
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 18; j++) {
                    placeLeaf();
                }
                reposition();
        }

        // Move Clara to the starting position for placing candles
        for (int a = 0; a < 9 - (age / 10) + 1; a++) move();

        // Place candles
        for (int k = 0; k < (age / 10); k++) {
            checkDirection();

            int candles = (age % 10 == 0) ? 1 : (age % 10); // Calculate number of candles to place
            
            // Place candles
            for (int m = 0; m < candles; m++) placeLeaf();
            turnAround();
            for (int m = 0; m < candles; m++) move();
            toNextCandle();
        }
    }

    //Go to next candle
    void toNextCandle() {
        checkDirection();
        move();
        move();
    }

    //Move and place leaf
    void placeLeaf() {
        if (!onLeaf()) putLeaf();
        move();
    }

    //Turn 180 degrees
    void turnAround() {
        turnLeft();
        turnLeft();
    }

    // Reposition Clara at the end of a row
    void reposition() {
        Turning();
        Turning();
        isFacingWest = !isFacingWest;
    }

    // Handle turning and moving Clara to the next row
    void Turning() {
        checkDirection();
        move();
    }

    // Check Clara's current direction and turn accordingly
    void checkDirection() {
        if (isFacingWest) turnRight();
        else turnLeft();
    }
}