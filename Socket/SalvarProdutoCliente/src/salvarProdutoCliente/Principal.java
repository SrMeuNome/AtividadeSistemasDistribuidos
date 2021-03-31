/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salvarProdutoCliente;

import Controller.ThreadController;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.charset.Charset;
import objetos.Produto;

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
            
            Produto produto = new Produto();
            String resposta = "S";
            
            do{
                //Setando Nome
                System.out.println("Nome do Produto: ");
                System.out.print("Digite>> ");
                linha = teclado.readLine();
                
                //Tratando Nome
                while(linha == null || linha.trim().isEmpty()){
                    System.out.println("Formato de nome incorreto, digite novamente: ");
                    System.out.print("Digite>> ");
                    linha = teclado.readLine();
                }
                produto.setNome(linha);
                
                //Setando Quantidade
                System.out.println("Quantidade do Produto: ");
                System.out.print("Digite>> ");
                linha = teclado.readLine();
                
                //Tratando Quantidade
                boolean correct = false;
                while(!correct){
                    try{
                        Integer.parseInt(linha);
                        correct = true;
                    }catch(NumberFormatException e){
                        System.out.println("Formato de quantidade incorreto, digite novamente: ");
                        System.out.print("Digite>> ");
                        linha = teclado.readLine();
                        correct = false;
                    }
                }
                produto.setQuantidade(Integer.parseInt(linha));
                
                //Setando Categoria
                System.out.println("Categoria do Produto: ");
                System.out.print("Digite>> ");
                linha = teclado.readLine();
                
                //Tratando Categoria
                while(linha == null || linha.trim().isEmpty()){
                    System.out.println("Formato de categoria incorreto, digite novamente: ");
                    System.out.print("Digite>> ");
                    linha = teclado.readLine();
                }
                produto.setCategoria(linha);
                
                //Setando Descricao
                System.out.println("Descrição do Produto: ");
                System.out.print("Digite>> ");
                linha = teclado.readLine();
                
                //Tratando Descricao
                while(linha == null || linha.trim().isEmpty()){
                    System.out.println("Formato de descrição incorreto, digite novamente: ");
                    System.out.print("Digite>> ");
                    linha = teclado.readLine();
                }
                produto.setDescricao(linha);
                
                //Setando Marca
                System.out.println("Marca do Produto: ");
                System.out.print("Digite>> ");
                linha = teclado.readLine();
                
                //Tratando Marca
                while(linha == null || linha.trim().isEmpty()){
                    System.out.println("Formato de Marca incorreto, digite novamente: ");
                    System.out.print("Digite>> ");
                    linha = teclado.readLine();
                }
                produto.setDescricao(linha);
                
                //Setando Quantidade
                System.out.println("Preço do Produto: ");
                System.out.print("Digite>> ");
                linha = teclado.readLine();
                
                //Tratando preco
                correct = false;
                while(!correct){
                    try{
                        Double.parseDouble(linha);
                        correct = true;
                    }catch(NumberFormatException e){
                        System.out.println("Formato de preço incorreto, digite novamente: ");
                        System.out.print("Digite>> ");
                        linha = teclado.readLine();
                        correct = false;
                    }
                }
                produto.setQuantidade(Integer.parseInt(linha));
                
                //Enviando Produto
                Gson g = new Gson();
                String strProduto = g.toJson(produto);
                saida.println(strProduto);
                
                //Pergunta para continuar
                System.out.println("Deseja continuar (S = SIM / N = NÃO): ");
                System.out.print("Digite>> ");
                linha = teclado.readLine();
                
                //Pergunta para continuar
                while(!linha.equalsIgnoreCase("S") && !linha.equalsIgnoreCase("N")){
                    System.out.println("Não entendi, digite somente S ou N: ");
                    System.out.print("Digite>> ");
                    linha = teclado.readLine();
                }
                resposta = linha;
                
            }while(resposta == null | resposta.trim().isEmpty() | !resposta.equalsIgnoreCase("N"));
            
        } catch(IOException err){
            err.printStackTrace();
        }
    }
    
}
