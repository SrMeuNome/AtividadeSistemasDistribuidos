/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesbo;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import objetos.Produto;

/**
 *
 * @author SrMeuNome
 */
public class Arq_Leitura
{
    public List<Produto> leitura(String nomeArq) throws FileNotFoundException, IOException
    {
        //File f = new File("C:\\Users\\SrMeuNome\\Documents\\AtividadesPet\\" + nomeArq);        
        File f = new File("D:\\TesteJava\\" + nomeArq);
        
        FileReader fr = new FileReader(f);
        
        BufferedReader br = new BufferedReader(fr);
        
        Gson g = new Gson();
        Produto p = new Produto();
        List<Produto> lstP = new LinkedList<>();
        
        while(br.ready())
        {
            p = g.fromJson(br.readLine(), Produto.class);
            lstP.add(p);
        }
        
        return lstP;
    }
    
    public String[] getArquivos()
    {
        //File f = new File("C:\\Users\\SrMeuNome\\Documents\\AtividadesPet\\");
        File f = new File("D:\\TesteJava\\");
        String lst [] = f.list();
        return lst;
    }
}
