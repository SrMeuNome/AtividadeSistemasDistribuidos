/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.InputStream;

/**
 *
 * @author SrMeuNome
 */
public class ThreadController implements Runnable
{
    InputStream inputEntrada;
    
    public ThreadController(InputStream inputEntrada){
        this.inputEntrada = inputEntrada;
    }
    
    public void startMessagesInNewThread(){
        Thread threadAux = new Thread(this);
        threadAux.start();
    }
    
    @Override
    public void run()
    {
        new ClientController(inputEntrada).showMensage();
    }
    
}
