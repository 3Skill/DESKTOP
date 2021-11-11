package ParteSwing;

import kadamm.hibernate.dao.UsuariDao;
import kadamm.hibernate.model.Usuari;

public class TestHibernate {

	public static void main(String[] args) {
		UsuariDao usuariDao = new UsuariDao();
		
		Usuari usuari = new Usuari("Arzzet", "pepe1234");
		Usuari usuari1 = new Usuari("VMV", "VMerchanHitler");
		Usuari usuari2 = new Usuari("JoseMRN", "Coleta69");
		
		usuariDao.guardarUsuari(usuari);
		usuariDao.guardarUsuari(usuari1);
		usuariDao.guardarUsuari(usuari2);

	}

}
