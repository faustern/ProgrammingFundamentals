/**
 * Dot Class
 * 
 * Available methods (see Assignment document for explanations on what each method does):
 * onEarth
 * setDirection,
 * move(speed),
 * animate, animateInvisible,
 * intersects(Character), intersectsWithName(String)
 * moveToClara
 * wrapAroundWorld
 * playShotSound
 */
class Dot extends Character {
    // Declare variables to manage bullet states
    boolean isVisible = false;
    boolean isActive = false;
    boolean reloadTimePassed = true;
    
    int RELOAD_DELAY = 1;
    int reloadCounter = 0;
    int bulletCounter = 0;
    int moveSpeed = 10;  // Speed of the bullet
    int lifetime = 300; // Lifetime of the bullet (e.g., 5 seconds)
    int counter = 0;    // Counter to track bullet lifetime

    public void act() {
        // If bullet is not active, it should be invisible

        if (!isActive) {
            animateInvisible();
        } else {
            moveBullet();
            checkCollisions();
        }

        //Fire a bullet when press "s" key
        if (Keyboard.isKeyDown("s") && reloadTimePassed && !MyClara.deadClara) {
            fireBullet();
            startReloadTimer();
        }

        // Handle the reload timer
        if (reloadCounter > 0) {
            reloadCounter--;  // Decrease the reload counter each frame
        } else {
            reloadTimePassed = true;  // Allow firing again after the delay
        }
    }

    // Method to fire the bullet (takes Clara's direction as input)
    public void fireBullet() {
        if (!isActive) {
            moveToClara(); // Move bullet to Clara's position
            setDirection(MyClara.ClaraDirection);  // Set bullet's direction based on Clara's direction
            isVisible = true;
            isActive = true;
            animate();  // Make the bullet visible
            counter = lifetime;  // Set bullet lifetime counter
            playShotSound();  // Play bullet firing sound
            startReloadTimer();  // Start the reload timer
        }
    }

    // Method to move the bullet
    private void moveBullet() {
        move(moveSpeed);  // Move the bullet forward

        // Decrease counter for the bullet's lifetime
        counter--;
        
        // If the lifetime has expired, make the bullet inactive and invisible
        if (counter <= 0) {
            isActive = false;
            animateInvisible();  // Hide the bullet
        }
    }

    // Method to check for collisions
    private void checkCollisions() {
        // Check if the bullet hits a wall
        if (onEarth()) {
            isActive = false;  // Stop the bullet
            animateInvisible();  // Make the bullet disappear
        }
    }

    //Start reload timer for the bullet
    public void startReloadTimer() {
        reloadCounter = RELOAD_DELAY;
        reloadTimePassed = false;
    }

    
}
