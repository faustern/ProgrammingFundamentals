/* PERMITTED COMMANDS
   move(); turnLeft(); turnRight(); treeLeft(); treeRight(); treeFront(); onLeaf(); putLeaf(); removeLeaf();
   JAVA
   if, else, for, while, do, !, ||, && 
   variables
*/
   
class MyClara extends Clara { 
    // Represent: 0 - East, 1 - South, 2 - West, 3 - North
    int currentFace = 0; // Clara's current facing direction
    int currRow = 1; // Clara's current row position
    int currCol = 1; // Clara's current column position
    int tunnelRow = 1; // Row where the tunnel entrance is found
    int rows = 1; // Total number of rows in the grid
    int cols = 1; // Total number of columns in the grid

    void run() {
        getBoardInfo();
        findMushRoom();
        pushMushRoom();
    }
    
    // Gather info about the grid's dimensions
    void getBoardInfo(){
        while (true) {

            // Find tunnel row
            if (!treeLeft()) {
                tunnelRow = rows; // Update tunnel row if there's no tree on the left
            }
            if (treeFront()) {
                turnRight();
                currentFace = (currentFace + 1) % 4; // Update facing direction

                // If facing East again, the grid's perimeter is fully explored
                if (currentFace == 0) return;
            } else {
                move();

                // Update dimensions based on the current facing direction
                if (currentFace == 0) cols++; // Increase columns if facing East
                else if (currentFace == 1) rows++; // Increase rows if facing South
            }
        }
    }
    
    // Find the mushroom in the grid
    void findMushRoom(){
        while(!mushroomFront()){
            if(treeFront()){
                if(currentFace == 0){
                    turnRight();
                    move();
                    turnRight();
                } else if (currentFace == 2){
                    turnLeft();
                    move();
                    turnLeft();
                }
                currRow += 1; // Increase row after maneuvering around the tree
                currentFace = (currentFace + 2) % 4; // Update facing direction
            } else {
                if(currentFace == 0){
                    currCol += 1; // Increase columns if facing East
                } else if(currentFace == 2){
                    currCol -= 1; // Decrease columns if facing East
                }
                move();
            }
        }
    }

    // Push the mushroom to the tunnel entrance and exit
    void pushMushRoom(){

        // Adjust Clara's position relative to the mushroom based on her current direction
        if(currentFace == 2){
            moveDiagonal(1);
            currCol -= 1;
            currRow -= 1;
        } else if(currentFace == 0){
            moveDiagonal(2);
            currCol += 1;
            currRow -= 1;
        }

        // Move Clara to the top of the tunnel row
        currentFace = 3; // Set direction to North
        moveWithStep(tunnelRow - currRow - 1); // Move up to the tunnel row
        currRow += tunnelRow - currRow - 1; // Update current row position
        
        // Move Clara diagonally and push the mushroom into the tunnel
        moveDiagonal(1);
        moveWithStep(2 * cols + 4 - currCol); // Move to the tunnel exit
        
        // Unless Clara reaches the bottom row, continue to push the mushroom to the bottom of the grid
        if(currRow + 1 == rows) return;
        moveDiagonal(2);
        moveWithStep(rows - currRow - 1); // Move down to the bottom row
    }
    
    // Move Clara forward by a specified number of steps
    void moveWithStep(int steps) {
        for (int i = 0; i < steps; i++) {
            move();
        }
    }

    // Move Clara diagonally based on the specified type
    void moveDiagonal(int type){

        // Type 1 movement pattern (move right then up)
        if(type == 1){
            turnRight();
            move();
            turnLeft();
            move();
            turnLeft();

        // Type 2 movement pattern (move left then up)
        } else if (type == 2){
            turnLeft();
            move();
            turnRight();
            move();
            turnRight();
        }
    }
}
