package pl.wat.mgr.lekarz.view.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import pl.wat.mgr.lekarz.assembler.ReceptaAssembler;
import pl.wat.mgr.lekarz.fascade.NfzFascade;
import pl.wat.mgr.lekarz.fascade.ReceptaFascade;
import pl.wat.mgr.lekarz.view.bo.Specyfikacja;

@ManagedBean
@SessionScoped
public class DodajRecepteBean implements Serializable {
	private static final long serialVersionUID = -3253942189820420896L;
	
	private String numer;
    private String sNazwa;
    private String sUlica;
    private String sNrDomu;
    private String sNrLokalu;
    private String sKodPocztowy;
    private String sPoczta;
    private String sMiejscowosc;
    private String sTelefon;
    private String sIdent;
    private String oddzialNfz;
    private String uprawnienia;
    private boolean chorobyPrzewlekle;
    private String pImie;
    private String pNazwisko;
    private String pUlica;
    private String pNrDomu;
    private String pNrLokalu;
    private String pKodPocztowy;
    private String pPoczta;
    private String pMiejscowosc;
    private String pPesel;
    private String pPoswiadczenie;
    private Date data;
    private Date dataRealizacajiOd;
    private String lImie;
    private String lNazwisko;
    private String lNrPrawa;
    
    private String lek_nazwa;
    private String lek_dawka;
    private String lek_dJednostka;
    private String lek_czestosc;
    private String lek_ilosc;
    private String lek_iJednostka;
    
    private List<Specyfikacja> specyfikacja;
    private Specyfikacja wybranaPoz;
    
    private boolean weryfikacja = true;

	public String getNumer() {
		return numer;
	}
	
	public void setNumer(String numer) {
		this.numer = numer;
	}
	
	public String getsNazwa() {
		return sNazwa;
	}
	
	public void setsNazwa(String sNazwa) {
		this.sNazwa = sNazwa;
	}
	
	public String getsUlica() {
		return sUlica;
	}
	
	public void setsUlica(String sUlica) {
		this.sUlica = sUlica;
	}
	
	public String getsNrDomu() {
		return sNrDomu;
	}
	
	public void setsNrDomu(String sNrDomu) {
		this.sNrDomu = sNrDomu;
	}
	
	public String getsNrLokalu() {
		return sNrLokalu;
	}
	
	public void setsNrLokalu(String sNrLokalu) {
		this.sNrLokalu = sNrLokalu;
	}
	
	public String getsKodPocztowy() {
		return sKodPocztowy;
	}
	
	public void setsKodPocztowy(String sKodPocztowy) {
		this.sKodPocztowy = sKodPocztowy;
	}
	
	public String getsPoczta() {
		return sPoczta;
	}
	
	public void setsPoczta(String sPoczta) {
		this.sPoczta = sPoczta;
	}
	
	public String getsMiejscowosc() {
		return sMiejscowosc;
	}
	
	public void setsMiejscowosc(String sMiejscowosc) {
		this.sMiejscowosc = sMiejscowosc;
	}
	
	public String getsTelefon() {
		return sTelefon;
	}
	
	public void setsTelefon(String sTelefon) {
		this.sTelefon = sTelefon;
	}
	
	public String getsIdent() {
		return sIdent;
	}
	
	public void setsIdent(String sIdent) {
		this.sIdent = sIdent;
	}
	
	public String getOddzialNfz() {
		return oddzialNfz;
	}
	
	public void setOddzialNfz(String oddzialNfz) {
		this.oddzialNfz = oddzialNfz;
	}
	
	public String getUprawnienia() {
		return uprawnienia;
	}
	
	public void setUprawnienia(String uprawnienia) {
		this.uprawnienia = uprawnienia;
	}
	
	public boolean getChorobyPrzewlekle() {
		return chorobyPrzewlekle;
	}
	
	public void setChorobyPrzewlekle(boolean chorobyPrzewlekle) {
		this.chorobyPrzewlekle = chorobyPrzewlekle;
	}
	
	public String getpImie() {
		return pImie;
	}
	
	public void setpImie(String pImie) {
		this.pImie = pImie;
	}
	
	public String getpNazwisko() {
		return pNazwisko;
	}
	
	public void setpNazwisko(String pNazwisko) {
		this.pNazwisko = pNazwisko;
	}
	
	public String getpUlica() {
		return pUlica;
	}
	
	public void setpUlica(String pUlica) {
		this.pUlica = pUlica;
	}
	
	public String getpNrDomu() {
		return pNrDomu;
	}
	
	public void setpNrDomu(String pNrDomu) {
		this.pNrDomu = pNrDomu;
	}
	
	public String getpNrLokalu() {
		return pNrLokalu;
	}
	
	public void setpNrLokalu(String pNrLokalu) {
		this.pNrLokalu = pNrLokalu;
	}
	
	public String getpKodPocztowy() {
		return pKodPocztowy;
	}
	
	public void setpKodPocztowy(String pKodPocztowy) {
		this.pKodPocztowy = pKodPocztowy;
	}
	
	public String getpPoczta() {
		return pPoczta;
	}
	
	public void setpPoczta(String pPoczta) {
		this.pPoczta = pPoczta;
	}
	
	public String getpMiejscowosc() {
		return pMiejscowosc;
	}
	
	public void setpMiejscowosc(String pMiejscowosc) {
		this.pMiejscowosc = pMiejscowosc;
	}
	
	public String getpPesel() {
		return pPesel;
	}
	
	public void setpPesel(String pPesel) {
		this.pPesel = pPesel;
	}
	
	public String getpPoswiadczenie() {
		return pPoswiadczenie;
	}
	
	public void setpPoswiadczenie(String pPoswiadczenie) {
		this.pPoswiadczenie = pPoswiadczenie;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public Date getDataRealizacajiOd() {
		return dataRealizacajiOd;
	}
	
	public void setDataRealizacajiOd(Date dataRealizacajiOd) {
		this.dataRealizacajiOd = dataRealizacajiOd;
	}
	
	public String getlImie() {
		return lImie;
	}
	
	public void setlImie(String lImie) {
		this.lImie = lImie;
	}
	
	public String getlNazwisko() {
		return lNazwisko;
	}
	
	public void setlNazwisko(String lNazwisko) {
		this.lNazwisko = lNazwisko;
	}
	
	public String getlNrPrawa() {
		return lNrPrawa;
	}
	
	public void setlNrPrawa(String lNrPrawa) {
		this.lNrPrawa = lNrPrawa;
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
	
	public List<Specyfikacja> getSpecyfikacja() {
		if(specyfikacja == null)
			specyfikacja = new ArrayList<Specyfikacja>();
		
		return specyfikacja;
	}

	public void setSpecyfikacja(List<Specyfikacja> specyfikacja) {
		this.specyfikacja = specyfikacja;
	}
	
	public Specyfikacja getWybranaPoz() {
		return wybranaPoz;
	}

	public void setWybranaPoz(Specyfikacja wybranaPoz) {
		this.wybranaPoz = wybranaPoz;
	}
	
	public boolean isWeryfikacja() {
		return weryfikacja;
	}

	public void setWeryfikacja(boolean weryfikacja) {
		this.weryfikacja = weryfikacja;
	}

	public void dodajSpecAction(ActionEvent ae) {
		specyfikacja.add(new Specyfikacja(lek_nazwa, lek_dawka, lek_dJednostka, lek_czestosc, lek_ilosc, lek_iJednostka));
	}
	
	public void dodajSpec(AjaxBehaviorEvent abe) {
		if(specyfikacja.size() < 5)
			specyfikacja.add(new Specyfikacja(lek_nazwa, lek_dawka, lek_dJednostka, lek_czestosc, lek_ilosc, lek_iJednostka));
	}
	
	public void setValue(AjaxBehaviorEvent abe) {
		
	}
	
	public void wyczysc(ActionEvent e) {
		cleanAll();
	}
	
	private void cleanAll() {
		cleanSpec();
		specyfikacja.clear();
		numer = null;
	    sNazwa = null;
	    sUlica = null;
	    sNrDomu = null;
	    sNrLokalu = null;
	    sKodPocztowy = null;
	    sPoczta = null;
	    sMiejscowosc = null;
	    sTelefon = null;
	    sIdent = null;
	    oddzialNfz = null;
	    uprawnienia = null;
	    chorobyPrzewlekle = false;
	    pImie = null;
	    pNazwisko = null;
	    pUlica = null;
	    pNrDomu = null;
	    pNrLokalu = null;
	    pKodPocztowy = null;
	    pPoczta = null;
	    pMiejscowosc = null;
	    pPesel = null;
	    pPoswiadczenie = null;
	    data = null;
	    dataRealizacajiOd = null;
	    lImie = null;
	    lNazwisko = null;
	    lNrPrawa = null;
	    weryfikacja = true;
	}
	
	private void cleanSpec() {
		lek_nazwa = null;
		lek_dawka = null;
		lek_dJednostka = null;
		lek_czestosc = null;
		lek_ilosc = null;
		lek_iJednostka = null;
	}
	
	public void weryfikujRecepte(ActionEvent ae) {
		
		String receptaXml = ReceptaAssembler.prepareXmlDocument(this);
		if(NfzFascade.weryfikujRecepte(receptaXml)) {
			numer = NfzFascade.pobierzKolejnyNumerRecepty(lNrPrawa, sIdent);
			weryfikacja = false;
		}
	}
	
	public String zapisz() {
		ReceptaFascade rf = new ReceptaFascade();
		rf.zapiszRecepte(this);
		
		NfzFascade.wyslijRecepteDoNfz(ReceptaAssembler.prepareXmlDocument(this));
		
		cleanAll();
		return "index";
	}
	
	public void usunPoz(ActionEvent ae) {
		specyfikacja.remove(wybranaPoz);
	}
}
