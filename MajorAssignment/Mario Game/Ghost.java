/**
 * Ghost Class
 * 
 * Available methods (see Assignment document for explanations on what each method does):
 * earthFront
 * getDirection, setDirection,
 * move(speed),
 * animate, animateDead,
 * intersects(Character), intersectsWithName(String)
 * getClara,
 * makeClaraDead,
 * wrapAroundWorld
 * playGameOverSound
 */
class Ghost extends Character
{
    //Add and initialise Ghost variables here
    
    /**
     * Act method, runs every frame
     */
    final int ANIMATION_DELAY = 10;

    public static boolean GhostDead = false;
    public static int dead = 0;
    boolean isAlive = true;
    int animationFrameCounter = 0;
    int initialnum = MyClara.getRandomNumber(10);
    int speed = initialnum;
    int respawnTimer = 180;
    boolean isFacingLeft = false;
    boolean levelStart = true;

    public void act()
    {
        //Make the Ghost do things here

        // Respawn Ghost
        if (!isAlive) {
            handleRespawn();
            return;
        }

        animateGhost();
        startGhost();

        GhostMovement();
        checkBulletHit();
        killClara();

        wrapAroundWorld();
    }

    // Check if Ghost is hit by a bullet
    public void checkBulletHit() {
        if (intersectsWithName("Dot")) {
            isAlive = false;  // Mark ghost as dead
            dead++;
            animateDead(); 
        }
    }

    // Revive Ghost after death
    public void handleRespawn() {
        respawnTimer--;
        if (respawnTimer <= 0) {
            isAlive = true;  // Revive the ghost
            respawnTimer = 180;  // Reset respawn timer
        }
    }

    // Set Ghost to move to the left when the level starts
    public void startGhost() {
        if (levelStart == true) {
            if (initialnum % 2 == 0) {
                setDirection("left");
            } else {
                setDirection("right");
            }
            isFacingLeft = true;
            levelStart = false;
        }
    }

    // Ghost move when on earth and fall when not on earth
    public void GhostMovement() {
        if (earthBelow()) {
            GhostDirection();
            if(speed == 0) {
                speed = 1;
            }
            move(speed);
        } else {
            GhostFall();
        }
    }

    // Handle Ghost's direction
    public void GhostDirection() {
        if(earthFront()) {   
            if (isFacingLeft == false) {
                setDirection("left");
                isFacingLeft = true;
            } else {
                setDirection("right");
                isFacingLeft = false;
            }
        }
    }

    //Ghost falls when not on earth
    public void GhostFall() {
        setDirection("down");
        move(5);
    }

    // Make Ghost kills clara if both intersect
    public void killClara() {
        if (intersects(getClara()) == true) {
            makeClaraDead();
        }
    }

    // Handle Ghost's animation
    public void animateGhost() {
        animationFrameCounter++;
        if (animationFrameCounter >= ANIMATION_DELAY) {
            animate();
            animationFrameCounter = 0;
        }
    }
}