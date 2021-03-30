package beans;

import classesbo.Arq_Leitura;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import objetos.Produto;

/**
 *
 * @author Maxsuel
 */
@ManagedBean
@SessionScoped
public class BeanArq {

    Produto produto;
    Arq_Leitura a_LE;
    String nomeArquivo;
    
    List<Produto> lstProduto = new LinkedList<>();
    
    public List<Produto> getLstPRoduto()
    {
        return lstProduto;
    }
    
    public void setLstPet(List<Produto> lstProduto)
    {
        this.lstProduto = lstProduto;
    }
    
    public String getNomeArquivo()
    {
        return nomeArquivo;
    }
    
    public void setNomeArquivo(String nomeArquivo)
    {
        this.nomeArquivo = nomeArquivo;
    }
    
    public Produto getProduto()
    {
        return produto;
    }
    
    public void setProduto(Produto produto)
    {
        this.produto = produto;
    }
    
    public Arq_Leitura getA_LE()
    {
        return a_LE;
    }
    
    public void setA_LE(Arq_Leitura a_LE)
    {
        this.a_LE = a_LE;
    }
    
    public BeanArq()
    {
        this.setA_LE(new Arq_Leitura());
        this.setProduto(new Produto());
    }
    
    public void listar() throws IOException
    {
        lstProduto = a_LE.leitura(nomeArquivo);
    }
    
    public String[] getArquivos()
    {
        return a_LE.getArquivos();
    }
    
}
