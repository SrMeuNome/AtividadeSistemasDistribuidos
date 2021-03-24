/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadechat;

import Controller.ThreadController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 *
 * @author SrMeuNome
 */
public class Principal
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try{
            System.out.println("Conectando com o Servidor");
            Socket conexao = new Socket("127.0.0.1", 8085);
            ThreadController threadController = new ThreadController(conexao.getInputStream());
            threadController.startMessagesInNewThread();
            PrintStream saida = new PrintStream(conexao.getOutputStream(), true, "ISO-8859-1");
            
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));
            
            String linha;
            
            do{
                System.out.print("Digite>> ");
                linha = teclado.readLine();
                
                saida.println(linha);
                
            }while(linha == null | !linha.isEmpty());
            
        } catch(IOException err){
            err.printStackTrace();
        }
    }
    
}
