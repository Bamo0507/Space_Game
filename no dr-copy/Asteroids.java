import greenfoot.*;

public class Asteroids extends Actor {
    private int velocidad;
    
    public Asteroids() {
        velocidad = Greenfoot.getRandomNumber(5) + 1; // Velocidad aleatoria entre 1 y 3
    }
    
    public void act() {
        moverAsteroid();
        verificarBorde();
    }
    
    private void moverAsteroid() {
        setLocation(getX(), getY() + velocidad);
    }
    
    private void verificarBorde() {
        if (getY() >= getWorld().getHeight() - 1) {
            World world = getWorld();
            world.removeObject(this); // Elimina el asteroide cuando llega al borde inferior del mundo
        }
    }
}




