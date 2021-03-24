/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 *
 * @author SrMeuNome
 */
public class ClientController
{
    InputStream inputEntrada;
    
    public ClientController(InputStream inputEntrada){
        this.inputEntrada = inputEntrada;
    }
    
    public void showMensage(){
        BufferedReader entrada = new BufferedReader(new InputStreamReader(inputEntrada, Charset.forName("ISO-8859-1")));
        String linha = "";
        do
        {
            try{
                linha = entrada.readLine();
                System.out.println("\r" + linha);
                System.out.print("Digite>> ");
            }
            catch(IOException err){
                err.printStackTrace();
            }  
        }while(linha == null | !linha.trim().isEmpty());
        
        //Limpar o "Digite>> " ao encerrar
        System.out.print("\r");
        System.out.println(" ");
    }
}
