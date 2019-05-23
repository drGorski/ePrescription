package pl.wat.mgr.lekarz.view.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import pl.wat.mgr.lekarz.fascade.ReceptaFascade;
import pl.wat.mgr.lekarz.model.Recepta;

@ManagedBean
@RequestScoped
public class SpisReceptBean implements Serializable {
	private static final long serialVersionUID = -8396074768654585998L;
	
	private List<Recepta> recepty;

	public SpisReceptBean() {
		ReceptaFascade rf = new ReceptaFascade();
		recepty = rf.pobierzRecepty();
	}
	
	public List<Recepta> getRecepty() {
		return recepty;
	}

	public void setRecepty(List<Recepta> recepty) {
		this.recepty = recepty;
	}
	
}
