package tn.esprit.rh.achat.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Operateur;



@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OperServiceImplTest {
	@Autowired
	IOperateurService operateurService;
	
	@Test
	public void testAddOperateur() throws ParseException {
		Operateur op = new Operateur();
		op.setNom("Yassine");
		op.setPrenom("Makhlouf");
		op.setPassword("123456");
		assertNotNull(op.getNom());
		assertNotNull(op.getPrenom());
		operateurService.addOperateur(op);
		log.info("operateur ajouter avec success");
	}
	
	@Test
	public void testModifierOperateur() throws ParseException {
		Operateur op = new Operateur();
		op.setNom("yassine");
		op.setPrenom("makh");
		op.setPassword("123456");
		assertNotNull(op.getNom());
		assertNotNull(op.getPrenom());
		operateurService.addOperateur(op);
		operateurService.addOperateur(op);
		log.info("operateur ajouter avec success");
		
		op.setNom("yass");
		op.setPrenom("makh");
		op.setPassword("123456789");
		assertNotNull(op.getNom());
		assertNotNull(op.getPrenom());
		operateurService.addOperateur(op);
		operateurService.updateOperateur(op);
		log.info("operateur modifier avec success");
	}
	
	
	@Test
	public void testDeleteOperateur() throws ParseException {
		Operateur op = new Operateur();
		op.setNom("yassin");
		op.setPrenom("makhlouff");
		op.setPassword("1234");
		
		operateurService.addOperateur(op);
		log.info("operateur ajouter avec success");
		operateurService.deleteOperateur(op.getIdOperateur());

		assertNull(operateurService.retrieveOperateur(op.getIdOperateur()));
		log.info("operateur supprimer avec success");
	}
	
	
	@Test
	public void testRetrieveAllOperateur() throws ParseException {
		List<Operateur> listOperateurs = operateurService.retrieveAllOperateurs();
		log.info("Nombre operateurs: " + listOperateurs.size()+" \n");
		for(int i=0;i<listOperateurs.size();i++){
			log.info(""+listOperateurs.get(i).getNom());
		}
	}
}
