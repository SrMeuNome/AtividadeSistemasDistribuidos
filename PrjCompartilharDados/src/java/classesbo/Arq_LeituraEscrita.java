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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import objetos.Pet;

/**
 *
 * @author SrMeuNome
 */
public class Arq_LeituraEscrita
{
    public List<Pet> leitura(String nomeArq) throws FileNotFoundException, IOException
    {
        File f = new File("C:\\Users\\SrMeuNome\\Documents\\AtividadesPet\\" + nomeArq);
        
        FileReader fr = new FileReader(f);
        
        BufferedReader br = new BufferedReader(fr);
        
        Gson g = new Gson();
        Pet p = new Pet();
        List<Pet> lstP = new LinkedList<>();
        
        while(br.ready())
        {
            p = g.fromJson(br.readLine(), Pet.class);
            lstP.add(p);
        }
        
        return lstP;
    }
    
    public void escrita(Pet pet) throws IOException
    {
        if(pet.getNome().trim().length() != 0)
        {
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");
            String strData = formatarDate.format(date);
            
            File f = new File("C:\\Users\\SrMeuNome\\Documents\\AtividadesPet\\dados_" + strData + ".txt");
            
            FileWriter fw = new FileWriter(f, true);
            
            PrintWriter pw = new PrintWriter(fw);
            
            Gson g = new Gson();
            
            String strPet = g.toJson(pet);
            
            pw.println(strPet);
            
            fw.close();
        }
    }
    
    public String[] getArquivos()
    {
        File f = new File("C:\\Users\\SrMeuNome\\Documents\\AtividadesPet");
        String lst [] = f.list();
        return lst;
    }
}
