import greenfoot.*;

public class Space extends World {
    private int gasolinaRecolectada;
    
    public Space() {
        super(800, 600, 1);
        prepare();
    }
    
    private void prepare() {
        Rocket rocket = new Rocket();
        addObject(rocket, getWidth() / 2, getHeight() - 50);
    }
    
    public void act() {
        generarAsteroides();
        generarGasolina();
        mostrarGasolinaRecolectada();
        verificarFinJuego();
    }
    
    private void generarAsteroides() {
        if (Greenfoot.getRandomNumber(100) < 2) {
            Asteroids asteroides = new Asteroids();
            int x = Greenfoot.getRandomNumber(getWidth() - 100) + 50;
            addObject(asteroides, x, 0);
        }
    }
    
    private void generarGasolina() {
        if (Greenfoot.getRandomNumber(100) < 2) {
            Gas gasolina = new Gas();
            int x = Greenfoot.getRandomNumber(getWidth() - 100) + 50;
            addObject(gasolina, x, 0);
        }
    }
    
    public void incrementarGasolina() {
        gasolinaRecolectada++;
    }
    
    private void mostrarGasolinaRecolectada() {
        showText("Gasolina: " + gasolinaRecolectada, 70, 20);
    }
    
    private void verificarFinJuego() {
        if (gasolinaRecolectada >= 50) {
            showText("¡Felicidades! Has recolectado suficiente gasolina.", getWidth() / 2, getHeight() / 2);
            Greenfoot.stop();
        }
    }
    
    public void finalizarJuego() {
        showText("¡Has chocado con un asteroide! Juego terminado.", getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();
    }
}




