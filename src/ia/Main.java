package ia;
public class Main {
    public static void main(String[] args){
        CarrinhoMaps maps = new CarrinhoMaps("/res/maps/map01.txt");

        String caminho = maps.gerarCaminho(0, 0, 16, 0);
        System.out.println(caminho);
    }
}
