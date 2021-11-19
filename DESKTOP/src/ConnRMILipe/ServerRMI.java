package ConnRMILipe;

import java.net.Socket;


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
                    sde.addElementList(arg0.toString());//Aqui esta el problema
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
	
}
