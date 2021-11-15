package ConnRMILipe;

import java.net.Socket;
import java.util.ArrayList;

import lipermi.handler.CallHandler;
import lipermi.net.IServerListener;
import lipermi.net.Server;

public class ServerRMI implements InterRMI{
	
   
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
}
