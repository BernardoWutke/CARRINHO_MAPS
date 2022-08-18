package editmap;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import main.GamePanel;

public class EditMap {
    GamePanel gp;
    public EditMap(GamePanel gp) {
        this.gp = gp;
    }

    public void criarBuraco(String path,int x, int y) {
        int[][] mapa = gerarMatrizMapa(path);
        if(mapa[y][x] == 10 || mapa[y][x] == 11 || mapa[y][x] == 12) {
            mapa[y][x] = 13;
            writeFile(path, mapa);
        } 
    }

    public void writeFile(String path, int[][] mapa) {

        try {
            int[][] mapaPontos = mapa;
            FileWriter writer = new FileWriter("./src"+path);
                 
            for (int[] pontos : mapaPontos) {
                for (int ponto : pontos) {
                    writer.write(ponto + " ");
                }
                writer.write("\n");
            }
            writer.flush();
            writer.close();
            gp.loadMaps();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void reset(String path) {
        try {
            int[][] mapaPontos = gerarMatrizMapa("/res/maps/mapaReset.txt");
            FileWriter writer = new FileWriter("./src"+path);
                
            for (int[] pontos : mapaPontos) {
                for (int ponto : pontos) {
                    writer.write(ponto + " ");
                }
                writer.write("\n");
            }
            writer.flush();
            writer.close();
            gp.loadMaps();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int[][] gerarMatrizMapa(String path) {

        int[][] matrizNumeros = null;

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
            matrizNumeros = new int[mapaNumeros.size()][mapaNumeros.get(0).size()];

            for(int i = 0; i < mapaNumeros.size(); i++){
                for(int j = 0; j < mapaNumeros.get(0).size(); j++){
                    matrizNumeros[i][j] = mapaNumeros.get(i).get(j);
                }
            }
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return matrizNumeros;
    }

  
}
