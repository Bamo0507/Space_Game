import greenfoot.*;

public class Gas extends Actor {
    private int velocidad;
    
    public Gas() {
        velocidad = Greenfoot.getRandomNumber(3) + 1; // Velocidad aleatoria entre 1 y 3
    }
    
    public void act() {
        moverGas();
        verificarBorde();
    }
    
    private void moverGas() {
        setLocation(getX(), getY() + velocidad);
    }
    
    private void verificarBorde() {
        if (getY() >= getWorld().getHeight() - 1) {
            World world = getWorld();
            world.removeObject(this); // Elimina el objeto de gasolina cuando llega al borde inferior del mundo
        }
    }
}



