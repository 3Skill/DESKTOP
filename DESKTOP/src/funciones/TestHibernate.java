package funciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import kadamm.hibernate.dao.*;
import kadamm.hibernate.model.*;
import kadamm.hibernate.model.Torn.TornId;


public class TestHibernate {

	public static void main(String[] args) {
		UsuariDao ud = new UsuariDao();
		KahootDao kd = new KahootDao();
		PreguntesDao pd = new PreguntesDao();
		RespostesDao rd = new RespostesDao();
		ConcursantDao ctd = new ConcursantDao();
		ConcursDao cd = new ConcursDao();
		TornDao td = new TornDao();
		
		
		
		Usuari usuari1 = new Usuari("Arzzet", "pepe1234");
		Usuari usuari2 = new Usuari("VMV", "VMerchanHitler");
		Usuari usuari3 = new Usuari("JoseMRN", "Coleta69");
		
		Kahoot kahoot1 = new Kahoot("Animales", usuari2);
		Kahoot kahoot2 = new Kahoot("Blockchain", usuari1);
		Kahoot kahoot3 = new Kahoot("DAM2", usuari3);
		Kahoot kahoot4 = new Kahoot("Sprint4", usuari1);
		
		ud.saveUsuari(usuari1);
		ud.saveUsuari(usuari2);
		ud.saveUsuari(usuari3);
		
		kd.saveKahoot(kahoot1);
		kd.saveKahoot(kahoot2);
		kd.saveKahoot(kahoot3);
		kd.saveKahoot(kahoot4);
		
		ArrayList<Kahoot>listaKahoots = (ArrayList<Kahoot>) kd.getAllKahoots();
		for (Kahoot kahoot : listaKahoots) {
			System.out.println(kahoot.getNom());
		}
		
		
		Preguntes pregunta1 = new Preguntes("Las Ballenas", kahoot1);
		Preguntes pregunta2 = new Preguntes("Los buitres son más grandes que las palomas", kahoot1);
		Preguntes pregunta3 = new Preguntes("Las ardillas comen hormigas", kahoot1);
		Preguntes pregunta4 = new Preguntes("Los pavos tienen visión de", kahoot1);
		Preguntes pregunta5 = new Preguntes("... de peces", kahoot1);
		Preguntes pregunta6 = new Preguntes("¿que animal sobrevive a un desastre nuclear", kahoot1);
		Preguntes pregunta7 = new Preguntes("Los camaleones tienen la lengua corta", kahoot1);
		Preguntes pregunta8 = new Preguntes("¿hay que sacar a pasear a los gatos?", kahoot1);
		
		Preguntes pregunta9 = new Preguntes("El Bitcoin es...", kahoot2);
		Preguntes pregunta10 = new Preguntes("los bloques son mutables", kahoot2);
		Preguntes pregunta11 = new Preguntes("Un smart contract es", kahoot2);
		Preguntes pregunta12 = new Preguntes("No se puede comprar Etherium", kahoot2);
		
		Preguntes pregunta13 = new Preguntes("Fem crides POLL cada 2\"?", kahoot4);
		Preguntes pregunta14 = new Preguntes("Al inici del concurs es mostren botons amb respostes i un compte enrera. Quan s'acaba, es bloquegen els botons de respostes", kahoot4);
		Preguntes pregunta15 = new Preguntes("L'usuari tria resposta, que s'il·lumina i s'envia el nickname i la resposta a servidor per guardar a la BD", kahoot4);
		Preguntes pregunta16 = new Preguntes("L'usuari pot corregir la resposta?", kahoot4);
		Preguntes pregunta17 = new Preguntes("L'algorisme per determinar la puntuació está documentat a la wiki", kahoot4);
		Preguntes pregunta18 = new Preguntes("Al finalitzar el temps per pregunta, es mostra la resposta correcta i un rànking", kahoot4);
		Preguntes pregunta19 = new Preguntes("Al final del Concurs, es mostra el Nick del guanyadors?", kahoot4);
		Preguntes pregunta20 = new Preguntes("quan s'acaba el concurs es torna a la pantalla de CONNEXIÓ?", kahoot4);
		
		Respostes resposta29 = new Respostes("Si", true,  pregunta13);
		Respostes resposta30 = new Respostes("No", false,  pregunta13);
		
		Respostes resposta31 = new Respostes("Fals", false,  pregunta14);
		Respostes resposta32 = new Respostes("Cert", true,  pregunta14);
		Respostes resposta33 = new Respostes("Si, pero els botons no es bloquegen", false,  pregunta14);
		
		Respostes resposta34 = new Respostes("Els botons no s'iluminen", false,  pregunta15);
		Respostes resposta35 = new Respostes("Els botons s'iluminen pero no s'envia cap dada", false,  pregunta15);
		Respostes resposta36 = new Respostes("Si, i es guarda cada resposta per pregunta per jugador per partida", true,  pregunta15);
		Respostes resposta37 = new Respostes("El servidor rep les dades pero aquestes no es guarden a BD", false,  pregunta15);
		
		Respostes resposta38 = new Respostes("No", false,  pregunta16);
		Respostes resposta39 = new Respostes("Si", true,  pregunta16);
		
		Respostes resposta40 = new Respostes("Si, esta molt ben explicat", true,  pregunta17);
		Respostes resposta41 = new Respostes("No tenim wiki", false,  pregunta17);
		Respostes resposta42 = new Respostes("No", false,  pregunta17);
		
		Respostes resposta43 = new Respostes("Fals", false,  pregunta18);
		Respostes resposta44 = new Respostes("Cert", true,  pregunta18);
		
		Respostes resposta45 = new Respostes("Si", true,  pregunta19);
		Respostes resposta46 = new Respostes("No ha donat temps de fer una classificació", false,  pregunta19);
		Respostes resposta47 = new Respostes("No", false,  pregunta19);
		
		Respostes resposta48 = new Respostes("No es demanava aquesta especificació", false,  pregunta20);
		Respostes resposta49 = new Respostes("No", false,  pregunta20);
		Respostes resposta50 = new Respostes("Si, ho comprovarem ara en finalitzar", true,  pregunta20);
		
		
		
		
		
		
		
		
		pd.savePregunta(pregunta1);
		pd.savePregunta(pregunta2);
		pd.savePregunta(pregunta3);
		pd.savePregunta(pregunta4);
		pd.savePregunta(pregunta5);
		pd.savePregunta(pregunta6);
		pd.savePregunta(pregunta7);
		pd.savePregunta(pregunta8);
		
		pd.savePregunta(pregunta9);
		pd.savePregunta(pregunta10);
		pd.savePregunta(pregunta11);
		pd.savePregunta(pregunta12);
		
		pd.savePregunta(pregunta13);
		pd.savePregunta(pregunta14);
		pd.savePregunta(pregunta15);
		pd.savePregunta(pregunta16);
		pd.savePregunta(pregunta17);
		pd.savePregunta(pregunta18);
		pd.savePregunta(pregunta19);
		pd.savePregunta(pregunta20);
		
		
		
		
		Kahoot kahootRecuperat = kd.getKahoot(1);
		ArrayList<Preguntes>listaPreguntes = (ArrayList<Preguntes>) pd.getAllPreguntesByKahoot(kahootRecuperat.getIdKahoot());
		for (Preguntes pregunta : listaPreguntes) {
			System.out.println(pregunta.getDescripcio());
		}
		
		Respostes resposta1 = new Respostes("Son mamíferos", true,  pregunta1);
		Respostes resposta2 = new Respostes("Son peces", false,  pregunta1);
		Respostes resposta3 = new Respostes("Falso", false,  pregunta2);
		Respostes resposta4 = new Respostes("Verdadero", true,  pregunta2);
		Respostes resposta5 = new Respostes("Verdadero", false,  pregunta3);
		Respostes resposta6 = new Respostes("Falso", true,  pregunta3);
		Respostes resposta7 = new Respostes("180 grados", false,  pregunta4);
		Respostes resposta8 = new Respostes("270 grados", true,  pregunta4);
		Respostes resposta9 = new Respostes("Bancos", true,  pregunta5);
		Respostes resposta10 = new Respostes("Manadas", false,  pregunta5);
		Respostes resposta11= new Respostes("Los hamsters", false,  pregunta6);
		Respostes resposta12= new Respostes("Las cucarachas", true,  pregunta6);
		Respostes resposta13= new Respostes("verdadero", false,  pregunta7);
		Respostes resposta14= new Respostes("falso", true,  pregunta7);
		Respostes resposta15 = new Respostes("No", true,  pregunta8);
		Respostes resposta16= new Respostes("Si", false,  pregunta8);
		
		rd.saveResposta(resposta1);
		rd.saveResposta(resposta2);
		rd.saveResposta(resposta3);
		rd.saveResposta(resposta4);
		rd.saveResposta(resposta5);
		rd.saveResposta(resposta6);
		rd.saveResposta(resposta7);
		rd.saveResposta(resposta8);
		rd.saveResposta(resposta9);
		rd.saveResposta(resposta10);
		rd.saveResposta(resposta11);
		rd.saveResposta(resposta12);
		rd.saveResposta(resposta13);
		rd.saveResposta(resposta14);
		rd.saveResposta(resposta15);
		rd.saveResposta(resposta16);
		
		Respostes resposta17 = new Respostes("Un vale de bits", false,  pregunta9);
		Respostes resposta18 = new Respostes("Una criptomoneda", true,  pregunta9);
		Respostes resposta19 = new Respostes("Verdadero", false,  pregunta10);
		Respostes resposta20 = new Respostes("Falso", true,  pregunta10);
		Respostes resposta21 = new Respostes("Un contrato de un coche", false,  pregunta11);
		Respostes resposta22 = new Respostes("Un contrato inteligente", true,  pregunta11);
		Respostes resposta23 = new Respostes("Un contrato listo", false,  pregunta11);
		Respostes resposta24 = new Respostes("Contacto Inteligente", false,  pregunta11);
		Respostes resposta25 = new Respostes("No", false,  pregunta12);
		Respostes resposta26 = new Respostes("Si", true,  pregunta12);
		Respostes resposta27 = new Respostes("Si, pero solo gastando etherium", false,  pregunta12);
//		Respostes resposta28 = new Respostes("El etherium no existe", false,  pregunta12);
		
		rd.saveResposta(resposta17);
		rd.saveResposta(resposta18);
		rd.saveResposta(resposta19);
		rd.saveResposta(resposta20);
		rd.saveResposta(resposta21);
		rd.saveResposta(resposta22);
		rd.saveResposta(resposta23);
		rd.saveResposta(resposta24);
		rd.saveResposta(resposta25);
		rd.saveResposta(resposta26);
		rd.saveResposta(resposta27);
//		rd.saveResposta(resposta28);
		
		
		
		rd.saveResposta(resposta29);
		rd.saveResposta(resposta30);
		rd.saveResposta(resposta31);
		rd.saveResposta(resposta32);
		rd.saveResposta(resposta33);
		rd.saveResposta(resposta34);
		rd.saveResposta(resposta35);
		rd.saveResposta(resposta36);
		rd.saveResposta(resposta37);
		rd.saveResposta(resposta38);
		rd.saveResposta(resposta39);
		rd.saveResposta(resposta40);
		rd.saveResposta(resposta41);
		rd.saveResposta(resposta42);
		rd.saveResposta(resposta43);
		rd.saveResposta(resposta44);
		rd.saveResposta(resposta45);
		rd.saveResposta(resposta46);
		rd.saveResposta(resposta47);
		rd.saveResposta(resposta48);
		rd.saveResposta(resposta49);
		rd.saveResposta(resposta50);
		
		
		ArrayList<Respostes>listaRespostes = (ArrayList<Respostes>) rd.getRespostesByPreguntaId(pd.getPreguntaById(11).getIdPreguntes());
		for (Respostes resposta : listaRespostes) {
			System.out.println(resposta.getDescripcio());
		}
		
//		Concursant concursant1 = new Concursant("Pepe", "pass1");
//		Concursant concursant2 = new Concursant("Paco", "pass2");
//		Concurs concurs1 = new Concurs(kahoot1.getIdKahoot());
//		
//		ctd.saveConcursant(concursant1);
//		ctd.saveConcursant(concursant2);
//		Concursant concursantRecuperat = ctd.getConcursantById(1);
//		ArrayList<Concursant> concursants = new ArrayList<Concursant>();
//		concursants.add(concursant1);
//		concursants.add(concursant2);
		
//		concurs1.addConcursant(concursant1);
//		concurs1.addConcursant(concursant2);
//		System.out.println(concurs1.getConcursants());
//		concurs1.setConcursants(concurs1.getConcursants());
//		cd.addConcurs(concurs1);
//		TornId tornId = new TornId(concurs1.getIdConcurs(),pregunta1.getIdPreguntes(), concursant1.getIdConcursant());
//		Torn torn = new Torn(new TornId(), concurs1, pregunta1,concursant1, resposta1.getIdResposta());
//		Torn torn2 = new Torn(new TornId(), concurs1, pregunta1, concursant2, resposta8.getIdResposta());
//		torn.setResposta(resposta1.getIdResposta());
//		td.saveTorn(torn);
//		td.saveTorn(torn2);
		
		
		
		
		
		
		
		
		
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


