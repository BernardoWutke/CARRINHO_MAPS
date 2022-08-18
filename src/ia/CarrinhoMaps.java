package ia;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CarrinhoMaps {
    
    private Queue<Ponto> queue = new LinkedList<Ponto>();
    private int[][] movimentos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private Ponto[][] mapaPontos;

    public CarrinhoMaps(String path){
        mapaPontos = gerarMapa(path);
    }
 
    public String gerarCaminho(int xInicial,int yInical, int xDestino, int yDestino) {
        String caminho = "";
        boolean encontrou = false;
        for (Ponto[] pontos : mapaPontos) {
            for (Ponto ponto : pontos) {
                ponto.setVisitado(false);
            }
        }

        queue.add(mapaPontos[xInicial][yInical]);
        while (queue.size() != 0) {
            Ponto ponto = queue.poll();
            ponto.setVisitado(true);

            if(ponto.getCoordenadaX() == xDestino && ponto.getCoordenadaY() == yDestino){
                encontrou = true;
                break;
            }

            for(int i = 0; i < 4; i++){
                int newX = ponto.getCoordenadaX() + movimentos[i][0];
                int newY = ponto.getCoordenadaY() + movimentos[i][1];
                if(newX >= 0 && newX < mapaPontos.length && newY >= 0 && newY < mapaPontos[0].length){
                    Ponto newPonto = mapaPontos[newX][newY];
                    if(!newPonto.foiVisitado() && newPonto.getEstradaLivre()) {
                        queue.add(newPonto);
                        newPonto.setCoordenadaXPai(ponto.getCoordenadaX());
                        newPonto.setCoordenadaYPai(ponto.getCoordenadaY());
                    }
                }
            }
        }
        if(encontrou){
            int x = xDestino, y = yDestino;
            while(x != xInicial || y != yInical){
                Ponto ponto = mapaPontos[x][y];
                int movX = x - ponto.getCoordenadaXPai();
                int movY = y - ponto.getCoordenadaYPai();
                caminho = movX + "," + movY + ";" + caminho;

                x = ponto.getCoordenadaXPai();
                y = ponto.getCoordenadaYPai();

            }
        }
        return caminho;
    }

    public Ponto[][] mapearEstradas(ArrayList<ArrayList<Integer>> mapaNumeros){
        int qtdLinhas = mapaNumeros.size();
        int qtdColunas = mapaNumeros.get(0).size();

        Ponto[][] mapa = new Ponto[qtdLinhas][qtdColunas];

        for(int i = 0; i < qtdLinhas; i++){
            for(int j = 0; j < qtdColunas; j++){
                mapa[i][j] = new Ponto(i, j);
                int num = mapaNumeros.get(i).get(j);
                if(num == 10 || num == 11 || num == 12) mapa[i][j].setEstradaLivre(true);
                else mapa[i][j].setEstradaLivre(false);
            }
        }
        return mapa;
    }

    public Ponto[][] gerarMapa(String path) {

        Ponto[][] mapa = null;

        try {
            InputStream is = getClass().getResourceAsStream(path);
            BufferedReader buffReader = new BufferedReader(new InputStreamReader(is));
            
            String linha = buffReader.readLine();
            ArrayList<ArrayList<Integer>> mapaNumeros = new ArrayList<ArrayList<Integer>>();
            
            while(linha != null){
                String[] stringNumeros = linha.split(" ");
                ArrayList<Integer> vetorNumeros = new ArrayList<Integer>();

                for (String string : stringNumeros) {
                    Integer num = Integer.parseInt(string);
                    vetorNumeros.add(num);
                }

                mapaNumeros.add(vetorNumeros);
                linha = buffReader.readLine();
            }
            buffReader.close();
            is.close();
            mapa = mapearEstradas(mapaNumeros);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return mapa;
    }
}