package pl.wat.mgr.lekarz.fascade;

import java.util.List;

import pl.wat.mgr.lekarz.assembler.ReceptaAssembler;
import pl.wat.mgr.lekarz.dao.ReceptaDao;
import pl.wat.mgr.lekarz.model.Recepta;
import pl.wat.mgr.lekarz.view.bean.DodajRecepteBean;

public class ReceptaFascade {

	ReceptaDao receptaDao = new ReceptaDao();
	
	public boolean zapiszRecepte(DodajRecepteBean drb) {
		
		receptaDao.beginTransaction();
		Recepta r = ReceptaAssembler.prepareRecepta(drb);
		receptaDao.save(r);
		receptaDao.commitAndCloseTransaction();
		
		return true;
	}
	
	public List<Recepta> pobierzRecepty() {
		
		receptaDao.beginTransaction();
		List<Recepta> recepty = receptaDao.findAll();
		receptaDao.commitAndCloseTransaction();
		
		return recepty;
	}
	
	public boolean wyslijRecepteDoNfz(DodajRecepteBean drb) {
		
		String receptaXml = ReceptaAssembler.prepareXmlDocument(drb);
		NfzFascade.wyslijRecepteDoNfz(receptaXml);
		
		return true;
	}
	
}
