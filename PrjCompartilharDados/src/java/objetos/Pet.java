/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author SrMeuNome
 */
public class Pet
{
    private String nome;
    private String especie;
    private String raca;
    private String data_nascimento;
    private String porte;

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getEspecie()
    {
        return especie;
    }

    public void setEspecie(String especie)
    {
        this.especie = especie;
    }

    public String getRaca()
    {
        return raca;
    }

    public void setRaca(String raca)
    {
        this.raca = raca;
    }

    public String getData_nascimento()
    {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento)
    {
        this.data_nascimento = data_nascimento;
    }

    public String getPorte()
    {
        return porte;
    }

    public void setPorte(String porte)
    {
        this.porte = porte;
    }
}
