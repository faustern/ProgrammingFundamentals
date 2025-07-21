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
                    putLeaf();
                    move();
                }
                
                reposition(); // After completing a row, reposition Clara to the next row
            }
        }
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