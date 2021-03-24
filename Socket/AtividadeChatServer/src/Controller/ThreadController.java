/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author SrMeuNome
 */
public class ThreadController implements Runnable
{
    Socket conexao;
    List<Socket> conexoes;
    List<BufferedReader> entradas;
    List<PrintStream> saidas;
    FileWriter writer;

    public ThreadController(Socket conexao, List<Socket> conexoes, List<BufferedReader> entradas, List<PrintStream> saidas, FileWriter writer)
    {
        this.conexao = conexao;
        this.conexoes = conexoes;
        this.entradas = entradas;
        this.saidas = saidas;
        this.writer = writer;
    }  
    
    public void startConexaoInNewThread(){
        Thread threadAux = new Thread(this);
        threadAux.start();
    }
    
    @Override
    public void run()
    {
        ChatController.iniciarChat(conexao, conexoes, entradas, saidas, writer);
    }
    
}
