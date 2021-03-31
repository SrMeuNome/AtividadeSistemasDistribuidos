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
public class ServerController
{
    
    public static FileWriter initFile(){
        String now = LocalDateTime.now()
                            .format(DateTimeFormatter.ofPattern("ddMMyy"));
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
 
    public static void iniciarGerenciarProdutos(Socket conexaoCli, List<Socket> conexoes, List<BufferedReader> entradas, List<PrintStream> saidas, FileWriter writer){
        int position = conexoes.size();
        try{
            Socket conexao = conexaoCli;
            conexoes.add(conexao);

            System.out.println("Conexão realizada");

            entradas.add(new BufferedReader(new InputStreamReader(conexao.getInputStream(), Charset.forName("ISO-8859-1"))));
            saidas.add(new PrintStream(conexao.getOutputStream(), true, "ISO-8859-1"));

            String linha = entradas.get(position).readLine();

            while(linha == null | (!linha.trim().isEmpty())){
                
                //Salvando informações
                writer.append(linha + "\n");
                writer.flush();
                
                System.out.println("Produto salvo no servidor: " + linha);

                for(PrintStream saida : saidas)
                {
                    int index = saidas.indexOf(saida);
                    if(index == position)
                    {
                        saida.println("Produto salvo com sucesso!!!");
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
