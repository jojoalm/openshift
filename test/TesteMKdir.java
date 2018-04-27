
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josia
 */
public class TesteMKdir {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        // Cria o diretório. Todos os diretórios e subdiretórios devem existir
    boolean success = (new File("web//Diretório")).mkdir();
    if (!success) {
        // Falha no momento de criar o diretório
    }
    
    // Cria o diretorio. Todos os diretórios e subdiretórios são           
    // criados automaticamente
    success = (new File("Nome do Diretório")).mkdirs();
    if (!success) {
        // Falha no momento de criar o diretório
    }
    }
    
}
