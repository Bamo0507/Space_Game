import greenfoot.*;

public class Rocket extends Actor {
    private int velocidad;
    
    public Rocket() {
        velocidad = 7; 
    }
    
    public void act() {
        moverRocket();
        verificarColision();
    }
    
    private void moverRocket() {
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - velocidad);
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + velocidad);
        }
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - velocidad, getY());
        }
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + velocidad, getY());
        }
    }
    
    private void verificarColision() {
        Actor gasolina = getOneIntersectingObject(Gas.class);
        if (gasolina != null) {
            World world = getWorld();
            Space space = (Space) world;
            space.incrementarGasolina(); // Incrementa el contador de gasolina en la clase Space
            world.removeObject(gasolina); // Elimina la botella de gasolina
        }
        
        Actor asteroide = getOneIntersectingObject(Asteroids.class);
        if (asteroide != null) {
            World world = getWorld();
            Space space = (Space) world;
            space.finalizarJuego(); // Llama al método finalizarJuego() en la clase Space
        }
    }
}







