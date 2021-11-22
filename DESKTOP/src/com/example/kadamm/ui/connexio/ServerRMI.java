package com.example.kadamm.ui.connexio;

import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import ParteSwing.PanelConcurs;
import ParteSwing.PanelSalaDeEspera;

import lipermi.handler.CallHandler;
import lipermi.net.IServerListener;
import lipermi.net.Server;

public class ServerRMI implements InterRMI{
    
    private PanelSalaDeEspera sde ;
    
    public ServerRMI() {
    	
        try {
            CallHandler callHandler = new CallHandler();
            callHandler.registerGlobal(InterRMI.class, this);
            Server server = new Server();
            server.bind(1110, callHandler);
            server.addServerListener(new IServerListener() {
                
                @Override
                public void clientDisconnected(Socket arg0) {
                    System.out.println("Cliente Desconectado = "+arg0);
                    //Aqui faltara implememtar que se borre el nombre de la sala de espera cuando se desconecte
                    //Se podria hacer almacenando los clientes en un hash 
                }
                
                @Override
                public void clientConnected(Socket arg0) {
                    System.out.println("Cliente Conectado = "+arg0);
                    
                }
            });
            System.out.println("Servidor iniciado correctamente");
            
        }catch (Exception e) {
            System.err.println("Error: No se ha podido iniciar el Servidor");
        }
    }
    
    public void setSalaEspera(PanelSalaDeEspera sde) {
    	this.sde =  sde;
    }

	//Implementacio de interface InterRMI
	public void setNickName(String nickname) {
		sde.setNickname(nickname);
	}
	
	
}
