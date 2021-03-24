/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classesbo.Arq_LeituraEscrita;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import objetos.Pet;

/**
 *
 * @author SrMeuNome
 */
@ManagedBean
@RequestScoped
public class BeanArq implements Serializable
{

    Pet pet;
    Arq_LeituraEscrita a_LE;
    String nomeArquivo;
    
    List<Pet> lstPet = new LinkedList<>();
    
    public List<Pet> getLstPet()
    {
        return lstPet;
    }
    
    public void setLstPet(List<Pet> lstPet)
    {
        this.lstPet = lstPet;
    }
    
    public String getNomeArquivo()
    {
        return nomeArquivo;
    }
    
    public void setNomeArquivo(String nomeArquivo)
    {
        this.nomeArquivo = nomeArquivo;
    }
    
    public Pet getPet()
    {
        return pet;
    }
    
    public void setPet(Pet pet)
    {
        this.pet = pet;
    }
    
    public Arq_LeituraEscrita getA_LE()
    {
        return a_LE;
    }
    
    public void setA_LE(Arq_LeituraEscrita a_LE)
    {
        this.a_LE = a_LE;
    }
    
    public BeanArq()
    {
        this.setA_LE(new Arq_LeituraEscrita());
        this.setPet(new Pet());
    }
    
    public void listar() throws IOException
    {
        lstPet = a_LE.leitura(nomeArquivo);
    }
    
    public void gravar() throws IOException
    {
        System.out.println(pet.getNome());
        a_LE.escrita(pet);
    }
    
    public String[] getArquivos()
    {
        return a_LE.getArquivos();
    }
}
