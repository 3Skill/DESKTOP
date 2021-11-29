package com.example.kadamm.ui.connexio;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import ParteSwing.PanelConcurs;
import ParteSwing.PanelSalaDeEspera;
import kadamm.hibernate.dao.RespostesDao;
import kadamm.hibernate.model.Kahoot;
import kadamm.hibernate.model.Preguntes;
import kadamm.hibernate.model.Respostes;
import lipermi.handler.CallHandler;
import lipermi.net.IServerListener;
import lipermi.net.Server;

public class ServerRMI implements InterRMI{
    private ArrayList<String> kahootActual;
    private PanelSalaDeEspera sde;
    
    private boolean isWaitingRoom;
    private boolean isWaitingRoom2 = false;
    private ArrayList<Preguntes> infoPreguntas;
    private RespostesDao rd = new RespostesDao();
    public ServerRMI(ArrayList<String> infoKahoot, ArrayList<Preguntes> llistaPreguntes) {
    	this.kahootActual = infoKahoot;
    	this.infoPreguntas = llistaPreguntes;
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
    //Funcion de SERVERRMI
    private ArrayList<Respostes> getArrayRespostes(int i) {
		ArrayList<Respostes> respostes  = (ArrayList<Respostes>) rd.getRespostesByPreguntaId(infoPreguntas.get(i).getIdPreguntes());
		return respostes; 
		
		 
	}
    //-------------
	//Implementacio de interface InterRMI
	public void setNickName(String nickname) {
		sde.addElementList(nickname);
	}
	
	@Override
	public boolean getWaitingRoomStatus() {
		// TODO Auto-generated method stub
		return isWaitingRoom;
	}
	public boolean getWaitingRoom2Status() {
		// TODO Auto-generated method stub
		return isWaitingRoom2;
	}
	public void setWaitingRoom2Status(boolean isWaitingRoom2) {
		// TODO Auto-generated method stub
		this.isWaitingRoom2 = isWaitingRoom2;
	}
	
	public boolean isUserAvailable(String nickname) {
		//If true then is not available
		return sde.getElementList(nickname) ? false : true;
				
	}

	
	@Override
	public ArrayList<String> getConcurs(int i) {
		ArrayList<String> array = new ArrayList<String>();
		try {
			
			
			array.add(infoPreguntas.get(i).getDescripcio());
			ArrayList<Respostes> respostes  = getArrayRespostes(i);
			
			
			//Añadimos el tiempo
			for (String element : kahootActual) {
				array.add(element);
			}
			//Cogemos las respuestas
			for (Respostes pregunta : respostes) {
				array.add(pregunta.getDescripcio());
			}
			System.out.println("++++++++++++Datos Enviados++++++++++++");
			
		}catch(Exception e) {
			System.out.println("++++++++++++Error Datos Enviados++++++++++++");
		}
		return array;
		
	}

	

	
	
}
