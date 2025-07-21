/* PERMITTED COMMANDS
   move(); turnLeft(); putLeaf(); removeLeaf();
*/
   
class MyClara extends Clara { 
    /**
     * In the 'run()' method you can write your program for Clara 
     */
    void run() {
        move();
        turnRight();
        move();
        Left();
        Left();
        Right();
        Right();
        Left();
        move();
        turnLeft();
        move();
        removeLeaf();
        turnRight();
        move();
    }

    void Left() {
        turnLeft();
        move();
        move();
    }

    void Right() {
        turnRight();
        move();
        move();
    }
}