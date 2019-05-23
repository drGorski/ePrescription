package pl.wat.mgr.lekarz.view.bo;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Specyfikacja implements Serializable {
	private static final long serialVersionUID = 6334977603727456737L;
	
	private String lek_nazwa;
    private String lek_dawka;
    private String lek_dJednostka;
    private String lek_czestosc;
    private String lek_ilosc;
    private String lek_iJednostka;
    
	public Specyfikacja(String lek_nazwa, String lek_dawka,
			String lek_dJednostka, String lek_czestosc, String lek_ilosc,
			String lek_iJednostka) {
		super();
		this.lek_nazwa = lek_nazwa;
		this.lek_dawka = lek_dawka;
		this.lek_dJednostka = lek_dJednostka;
		this.lek_czestosc = lek_czestosc;
		this.lek_ilosc = lek_ilosc;
		this.lek_iJednostka = lek_iJednostka;
	}

	public String getLek_nazwa() {
		return lek_nazwa;
	}
	
	public void setLek_nazwa(String lek_nazwa) {
		this.lek_nazwa = lek_nazwa;
	}
	
	public String getLek_dawka() {
		return lek_dawka;
	}
	
	public void setLek_dawka(String lek_dawka) {
		this.lek_dawka = lek_dawka;
	}
	
	public String getLek_dJednostka() {
		return lek_dJednostka;
	}
	
	public void setLek_dJednostka(String lek_dJednostka) {
		this.lek_dJednostka = lek_dJednostka;
	}
	
	public String getLek_czestosc() {
		return lek_czestosc;
	}
	
	public void setLek_czestosc(String lek_czestosc) {
		this.lek_czestosc = lek_czestosc;
	}
	
	public String getLek_ilosc() {
		return lek_ilosc;
	}
	
	public void setLek_ilosc(String lek_ilosc) {
		this.lek_ilosc = lek_ilosc;
	}
	
	public String getLek_iJednostka() {
		return lek_iJednostka;
	}
	
	public void setLek_iJednostka(String lek_iJednostka) {
		this.lek_iJednostka = lek_iJednostka;
	}

}
