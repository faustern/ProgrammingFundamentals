/* PERMITTED COMMANDS
   move(); turnLeft(); putLeaf(); removeLeaf();
*/
   
class MyClara extends Clara { 
    /**
     * In the 'run()' method you can write your program for Clara 
     */
    void run() {
        // TODO: Write your code below
        move();
        turnRight();
        move();
        removeLeafx8();
        turnAroundLeft();
        moveX4();
        turnRight();
        removeLeafx2();
        turnRight();
        moveX5();
        turnAroundLeft();
        removeLeafx8();
        move();
        turnRight();
        moveX2();
        turnRight();
        removeLeafx8();
        turnLeft();
        removeLeafx3();
    }

    void removeLeafx8() {
        removeLeafx2();
        removeLeaf();
        removeLeafx2();
        removeLeaf();
        move();
        removeLeaf();
        move();
        removeLeaf();
    }

    void removeLeafx2() {
        move();
        removeLeaf();
        move();
        removeLeaf();
        move();        
    }

    void removeLeafx3() {
        removeLeafx2();
        removeLeaf();
        move();          
    }

    void moveX2() {
        move();
        move();
    }

    void moveX4() {
        moveX2();
        moveX2();
    }

    void moveX5() {
        moveX2();
        moveX2();
        move();
    }


    void turnAroundLeft() {
        turnLeft();
        turnLeft();
    }
}