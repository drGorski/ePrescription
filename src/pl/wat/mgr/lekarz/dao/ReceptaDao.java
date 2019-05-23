package pl.wat.mgr.lekarz.dao;

import pl.wat.mgr.lekarz.model.Recepta;

public class ReceptaDao extends GenericDao<Recepta>{
	private static final long serialVersionUID = 2266892614964044705L;

	public ReceptaDao() {
		super(Recepta.class);
	}
}
