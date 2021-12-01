package com.example.kadamm.ui.connexio;

import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import ParteSwing.PanelConcurs;
import ParteSwing.PanelSalaDeEspera;
import kadamm.hibernate.dao.TornDao;
import kadamm.hibernate.model.Respostes;
import kadamm.hibernate.model.Torn;
import lipermi.handler.CallHandler;
import lipermi.net.IServerListener;
import lipermi.net.Server;

public class ServerRMI implements InterRMI{
    
    private PanelSalaDeEspera sde ;
    private PanelConcurs pc;
    private boolean isWaitingRoom;
    private TornDao td = new TornDao();
    
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
            isWaitingRoom = true;
            
        }catch (Exception e) {
            System.err.println("Error: No se ha podido iniciar el Servidor");
            isWaitingRoom = false;
        }
    }
    
    public void setSalaEspera(PanelSalaDeEspera sde) {
    	this.sde =  sde;
    }
    
    public void concursReceiver(PanelConcurs pc) {
    	this.pc = pc;
    }
    
    public void recieveResposta(Torn torn, Respostes resposta) {
    	torn.setResposta(resposta.getIdResposta());
    }

	//Implementacio de interface InterRMI
	public void setNickName(String nickname) {
		sde.addElementList(nickname);
	}

	@Override
	public boolean getWaitingRoomStatus() {
		// TODO Auto-generated method stub
		return isWaitingRoom;
	}
	
	
	public boolean isUserAvailable(String nickname) {
		//If true then is not available
		return sde.getElementList(nickname) ? false : true;
				
	}

	
	
}
