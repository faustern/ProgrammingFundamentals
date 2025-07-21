/* PERMITTED COMMANDS
   move(); turnLeft(); turnRight(); treeLeft(); treeRight(); treeFront(); onLeaf(); putLeaf(); removeLeaf();
   JAVA
   if, else, for, while, do, !, ||, && 
   variables
*/
   
class MyClara extends Clara { 
    /**
     * In the 'run()' method you can write your program for Clara 
     */
    boolean isFacingWest = false;
    boolean isEnd = false;
    boolean isTurned = false;
    boolean canPlacedLeaf = true;
 
    void run() {
        // Continue moving until Clara has turned and there's a tree in front, with trees either on the left or right
        while(!(isTurned && treeFront() && (treeRight() || treeLeft())))
        {
            if(canPlacedLeaf) {
                putLeaf(); // Place a leaf if allowed
            }
            if(treeFront()){
                reposition(); // Reposition if encounter a tree in front
            } else{
                move();
            }
            canPlacedLeaf = !canPlacedLeaf; // Toggle leaf placement for the next move
        }
    }

    // Repositions Clara when she hits an obstacle
    void reposition() {
        checkDirection();
        move();
        checkDirection();
        isFacingWest = !isFacingWest; // Flip facing direction
        isTurned = true;
    }

    // Check Clara's direction and turn her appropriately
    void checkDirection(){
        if(isFacingWest){
            turnRight();
        } else {
            turnLeft();
        }
    }
}