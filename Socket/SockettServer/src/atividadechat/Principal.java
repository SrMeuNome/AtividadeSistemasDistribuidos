/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadechat;

import Controller.ChatController;
import Controller.ThreadController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javafx.util.converter.LocalDateTimeStringConverter;

/**
 *
 * @author SrMeuNome
 */
public class Principal
{
    static List<Socket> conexoes;
    static List<BufferedReader> entradas;
    static List<PrintStream> saidas;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        conexoes = new ArrayList();
        entradas = new ArrayList();
        saidas = new ArrayList();
        
        
        try{
            ServerSocket server = new ServerSocket(8085);
            FileWriter writer = ChatController.initFile();
            
            while(true){
                System.out.println("Aguardando conexão...");
                Socket conexao = server.accept();
                System.out.println("Conexão aceita!");
                new ThreadController(conexao, conexoes, entradas, saidas, writer)
                        .startConexaoInNewThread();
                System.out.println("Conexão " + conexoes.size() + " aceita!");
            }
        } catch(IOException err){
            err.printStackTrace();
        }
    }
    
}
