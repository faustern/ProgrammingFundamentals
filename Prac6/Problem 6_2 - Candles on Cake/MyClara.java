/* PERMITTED COMMANDS
   move, turnLeft, turnRight, treeLeft, treeRight, treeFront, onLeaf, putLeaf, removeLeaf, mushroomFront
   JAVA
   if, while, for
*/
   
class MyClara extends Clara { 
    /**
     * In the 'run()' method you can write your program for Clara 
     */
    boolean isFacingWest = false;

    void run() {
        // TODO: Write your code below

        //Enter cake's grid dimensions
        int width = readInt("Enter cake's width: ");
        int height = readInt("Enter cake's height: ");

        if(width > 18 || height > 13) {
            System.out.println("Invalid number"); // If the dimensions exceed the maximum allowed, print an error message
        } else {

            // Outer loop iterates over each row (height)
            for(int i = 0; i < height; i++) {

                // Inner loop iterates over each column (width)
                for(int j = 0; j < width; j++) {
                    placeLeaf();
                }
                
                reposition(); // After completing a row, reposition Clara to the next row
            }

            // Check if there is space for candles
            if (height < 12) {

                // Place candles
                for(int k = 0; k < width/2; k++) {
                    placeCandle();
                    move();
                    move();
                }

                // If width is odd, place an additional candle in the last cell
                if (width % 2 != 0) {
                    placeCandle();
                }
            }
        }
    }

    // Place a leaf and move to the next cell
    void placeLeaf() {
        putLeaf();
        move();
    }

    // Turn 180 degrees
    void turnAround() {
        turnLeft();
        turnLeft();
    }

    // Place a candle and reposition
    void placeCandle() {
        checkDirection();

        for(int m = 0; m < 3; m++) {
            placeLeaf();
        }

        turnAround();
        
        for(int n = 0; n < 3; n++) {
            move();
        }
        checkDirection();
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
    void checkDirection(){
        if(isFacingWest){
            turnRight();
        } else {
            turnLeft();
        }
    }
}