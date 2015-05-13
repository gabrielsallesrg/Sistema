/*

AUTORES:

Alan Frigerio

Gabriel Salles


*/

package br.com.library;

import java.security.SecureRandom;


public class GeraToken {
    
    private String codigo;
    private final int tamToken = 8; //Este define o tamanho do token.
    private final String[] letras;
    private int i;
    
    private String TOKEN;
    
   
    public GeraToken(){  
        
        this.i = 0;
        this.letras = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};     
        this.TOKEN = "";
        this.codigo = "";

    }
    
     
    public String TOKEN(){
        
        String retorno = "";
        String auxiliar = "";
        
        int i;      
        
        SecureRandom gerado = new SecureRandom();
        
        for(i=0;i<letras.length;i++){
            
            auxiliar = pegarLetra(gerado.nextInt(23));  
            retorno += auxiliar;
            
        }
        
        return retorno;
        
    }
    
    private String pegarLetra(int $numero){
        
        String letra = "";        
        letra = this.letras[$numero]; 
        return letra;
        
    }

    
}
