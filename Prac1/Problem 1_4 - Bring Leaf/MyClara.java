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
        turnLeft();
        x3steps();
        move();
        move();
        turnLeft();
        x3steps();
        removeLeaf();
        turnAround();
        x3steps();
        turnRight();
        x3steps();
        x3steps();
        turnLeft();
        move();
        putLeaf();
        turnAround();
        move();
        move();
    }

    void turnAround() {
        turnLeft();
        turnLeft();
    }

    void x3steps() {
        move();
        move();
        move();
    }
}