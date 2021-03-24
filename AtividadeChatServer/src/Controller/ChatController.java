/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author SrMeuNome
 */
public class ChatController
{
    
    public static FileWriter initFile(){
        String now = LocalDateTime.now()
                            .format(DateTimeFormatter.ofPattern("ddMMyyhhmmss"));
        try{
            File path = new File(System.getenv("USERPROFILE") +
                    "\\Documents\\logsChat");
            if(!path.exists()){
                path.mkdirs();
            }

            File myObj = new File(System.getenv("USERPROFILE") +
                    "\\Documents\\logsChat", "file_" + now + ".txt");
            if (myObj.createNewFile()) {
              System.out.println("Arquivo criado: " + myObj.getName());
            } else {
              System.out.println("Arquivo já existe.");
            }

            FileWriter writer = new FileWriter(myObj);
            return writer;
        } catch(IOException err){
            err.printStackTrace();
        }
        return null;
    }
 
    public static void iniciarChat(Socket conexaoCli, List<Socket> conexoes, List<BufferedReader> entradas, List<PrintStream> saidas, FileWriter writer){
        int position = conexoes.size();
        try{
            Socket conexao = conexaoCli;
            conexoes.add(conexao);

            System.out.println("Conexão realizada");

            entradas.add(new BufferedReader(new InputStreamReader(conexao.getInputStream(), Charset.forName("ISO-8859-1"))));
            saidas.add(new PrintStream(conexao.getOutputStream(), true, "ISO-8859-1"));

            String linha = entradas.get(position).readLine();

            while(linha == null | (!linha.trim().isEmpty())){
                System.out.println("Mensagem recebida no servidor: " + linha);

                if( linha.toLowerCase().contains("cola") |
                    linha.toLowerCase().contains("avaliação") |
                    linha.toLowerCase().contains("prova") )
                {
                    writer.append("Cliente " + position + ": " + linha + "\n");
                    writer.flush();
                }

                for(PrintStream saida : saidas)
                {
                    int index = saidas.indexOf(saida);
                    if(index != position)
                    {
                        saida.println("Retorno do Cliente " + position + ": " + linha);
                    }
                }
                linha = entradas.get(position).readLine();
            }
            saidas.get(position).println("");
            System.out.println("Conexão encerrada com o Cliente " + position);
            System.out.println("Aguardando conexão...");
            //writer.close();
            conexao.close();
            entradas.get(position).close();
            saidas.get(position).close();
        } catch(IOException err){
            err.printStackTrace();
        }
    }
}
