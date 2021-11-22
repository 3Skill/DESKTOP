package funciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import kadamm.hibernate.dao.*;
import kadamm.hibernate.model.*;

public class TestHibernate {

	public static void main(String[] args) {
		UsuariDao ud = new UsuariDao();
		KahootDao kd = new KahootDao();
		PreguntesDao pd = new PreguntesDao();
		RespostesDao rd = new RespostesDao();
		ConcursantDao ctd = new ConcursantDao();
		ConcursDao cd = new ConcursDao();
		
		
		
		Usuari usuari1 = new Usuari("Arzzet", "pepe1234");
		Usuari usuari2 = new Usuari("VMV", "VMerchanHitler");
		Usuari usuari3 = new Usuari("JoseMRN", "Coleta69");
		
		Kahoot kahoot1 = new Kahoot("testKahoot", usuari1);
		Kahoot kahoot2 = new Kahoot("testKahoot2", usuari1);
		Kahoot kahoot3 = new Kahoot("DAM2", usuari3);
		
		ud.saveUsuari(usuari1);
		ud.saveUsuari(usuari2);
		ud.saveUsuari(usuari3);
		
		kd.saveKahoot(kahoot1);
		kd.saveKahoot(kahoot2);
		kd.saveKahoot(kahoot3);
		
		ArrayList<Kahoot>listaKahoots = (ArrayList<Kahoot>) kd.getAllKahoots();
		for (Kahoot kahoot : listaKahoots) {
			System.out.println(kahoot.getNom());
		}
		
		
		
		
		Preguntes pregunta1 = new Preguntes("Pregunta1", kahoot1);
		Preguntes pregunta2 = new Preguntes("Pregunta2", kahoot1);
		Preguntes pregunta3 = new Preguntes("Pregunta3", kahoot1);
		
		pd.savePregunta(pregunta1);
		pd.savePregunta(pregunta2);
		pd.savePregunta(pregunta3);
		
		
		Kahoot kahootRecuperat = kd.getKahoot(1);
		ArrayList<Preguntes>listaPreguntes = (ArrayList<Preguntes>) pd.getAllPreguntesByKahoot(kahootRecuperat.getIdKahoot());
		for (Preguntes pregunta : listaPreguntes) {
			System.out.println(pregunta.getDescripcio());
		}
		
		Respostes resposta1 = new Respostes("Correcte", true,  pregunta1);
		Respostes resposta2 = new Respostes("Incorrecte", false,  pregunta1);
		Respostes resposta3 = new Respostes("Fals", false,  pregunta2);
		Respostes resposta4 = new Respostes("Vertader", true,  pregunta2);
		
		rd.saveResposta(resposta1);
		rd.saveResposta(resposta2);
		rd.saveResposta(resposta3);
		rd.saveResposta(resposta4);
		
		
		Concursant concursant1 = new Concursant("Pepe", "Password");
		Concurs concurs1 = new Concurs(kahoot1.getIdKahoot());
		
		ctd.saveConcursant(concursant1);
		Concursant concursantRecuperat = ctd.getConcursantById(1);
		ArrayList<Concursant> concursants = new ArrayList<Concursant>();
		concursants.add(concursantRecuperat);
		Concurs concurs2 = new Concurs(kahoot1.getIdKahoot(), concursants);
		cd.addConcurs(concurs2);
		
		
		
		
		
		
		
//			
//		usuariDao.saveUsuari(usuari1);
//		usuariDao.saveUsuari(usuari2);
//		usuariDao.saveUsuari(usuari3);
//		
//		
//		Kahoot kahoot1 = new Kahoot("M06-Kahoot", usuari1.getIdUsuaris());
//		Kahoot kahoot2 = new Kahoot("KahootDelXavi", usuari2.getIdUsuaris());
//		Kahoot kahoot3 = new Kahoot("Otro Kahoot", usuari3.getIdUsuaris());
//		
//		kd.saveKahoot(kahoot1);
//		kd.saveKahoot(kahoot2);
//		kd.saveKahoot(kahoot3);
//		
//		System.out.println(kahoot2.getNom());		
//		kahoot2.setNom("Kahoot sobre Java");
//		kd.updateKahoot(kahoot2);
//		System.out.println(kahoot2.getNom());
//		
//		kd.removeKahoot(kahoot2);
//		
//		Preguntes preguntes1 = new Preguntes("¿Eres VictorM, JoseR, o IwoP?", kahoot2.getIdKahoot());
//		Preguntes preguntes2 = new Preguntes("¿Jose tiene el pelo...?", kahoot3.getIdKahoot());
//		Preguntes preguntes3 = new Preguntes("Taiwan es un pais?", kahoot3.getIdKahoot());
//		
//		pd.savePregunta(preguntes1);
//		pd.savePregunta(preguntes2);
//		pd.savePregunta(preguntes3);
//		
////		pd.getAllPreguntesByKahoot(kahoot3.getIdKahoot());
//		
////		System.out.println(kd.getAllKahoots());
//		
//		Respostes resposta1 = new Respostes("IwoP", true, preguntes1.getIdPreguntes());
//		Respostes resposta2 = new Respostes("VictorM", false, preguntes1.getIdPreguntes());
//		Respostes resposta3 = new Respostes("Corto", false, preguntes2.getIdPreguntes());
//		Respostes resposta4 = new Respostes("Largo", true, preguntes2.getIdPreguntes());
//		Respostes resposta5 = new Respostes("Si, -100000 de social cledit", false, preguntes3.getIdPreguntes());
//		Respostes resposta6 = new Respostes("No, +15000 social cledit", true, preguntes3.getIdPreguntes());
//		
//		rd.saveResposta(resposta1);
//		rd.saveResposta(resposta2);
//		rd.saveResposta(resposta3);
//		rd.saveResposta(resposta4);
//		rd.saveResposta(resposta5);
//		rd.saveResposta(resposta6);
//		
////		System.out.println(rd.getRespostaCorrecta(preguntes2));
//		
//		
//		System.out.println(pd.getAllPreguntes().toString());
//		
//		Usuari recuperat = usuariDao.getUsuariByName("Arzzet");
//		String nom = recuperat.getNickName();
//		
//		System.out.println(nom);
//		String pass = recuperat.getPassword();
//		
//		System.out.println(pass);
//		
//		login("Arzzet","pep1234");
//	}
//		
//		public static boolean login(String nom, String pass) {
//			UsuariDao ud = new UsuariDao();
//			// comentat a la espera de establir connexio entre repos
//			Usuari usuari = ud.getUsuariByName(nom);
//			
//			System.out.println(usuari.getPassword());
//			
//			
//			if (usuari.getPassword().equals(pass)) {
//				System.out.println("Contrasenya correcta");
//				return true;
//			} else {
//				System.out.println("Contrasenya incorrecta");
//			}
//			return false;
//			
//		}
		
		

	

	}
}


