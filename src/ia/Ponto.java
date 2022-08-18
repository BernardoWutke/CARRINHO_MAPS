package ia;

public class Ponto {
    private String value;
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private boolean visitado;
    private boolean estradaLivre;
    private int coordenadaX;
    private int coordenadaY;
    private int coordenadaXPai;
    private int coordenadaYPai;
    
    public Ponto(int coordenadaX, int coordenadaY){
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public boolean foiVisitado(){
        return visitado;
    }

    public void setEstradaLivre(boolean bool){
        this.estradaLivre = bool;
    }
    public boolean getEstradaLivre(){
        return estradaLivre;
    }

    public void setCoordenadaX(int coordenadaX){
        this.coordenadaX = coordenadaX;
    }
    public int getCoordenadaX(){
        return coordenadaX;
    }

    public void setCoordenadaY(int coordenadaY){
        this.coordenadaY = coordenadaY;
    }
    public int getCoordenadaY(){
        return coordenadaY;
    }
    public void setCoordenadaXPai(int coordenadaXPai){
        this.coordenadaXPai = coordenadaXPai;
    }
    public int getCoordenadaXPai(){
        return coordenadaXPai;
    }

    public void setCoordenadaYPai(int coordenadaYPai){
        this.coordenadaYPai = coordenadaYPai;
    }
    public int getCoordenadaYPai(){
        return coordenadaYPai;
    }

    public String toString(){
        return("[" + getCoordenadaX() + ", " + getCoordenadaY() + "]");
    }
}