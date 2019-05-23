package pl.wat.mgr.lekarz.assembler;

import java.util.ArrayList;
import java.util.List;

import pl.wat.mgr.lekarz.model.PozycjaRecepty;
import pl.wat.mgr.lekarz.model.Recepta;
import pl.wat.mgr.lekarz.view.bean.DodajRecepteBean;
import pl.wat.mgr.lekarz.view.bo.Specyfikacja;

public class ReceptaAssembler {

	public static Recepta prepareRecepta(DodajRecepteBean drb) {
		Recepta r = new Recepta();
		
		r.setChorobyPrzewlekle(drb.getChorobyPrzewlekle());
		r.setData(drb.getData());
		r.setDataRealizacajiOd(drb.getDataRealizacajiOd());
		r.setlImie(drb.getlImie());
		r.setlNazwisko(drb.getlNazwisko());
		r.setlNrPrawa(drb.getlNrPrawa());
		r.setNumer(drb.getNumer());
		r.setOddzialNfz(drb.getOddzialNfz());
		r.setpImie(drb.getpImie());
		r.setpKodPocztowy(drb.getpKodPocztowy());
		r.setpMiejscowosc(drb.getpMiejscowosc());
		r.setpNazwisko(drb.getpNazwisko());
		r.setpNrDomu(drb.getpNrDomu());
		r.setpNrLokalu(drb.getpNrLokalu());
		r.setpPesel(drb.getpPesel());
		r.setpPoczta(drb.getpPoczta());
		r.setpPoswiadczenie(drb.getpPoswiadczenie());
		r.setpUlica(drb.getpUlica());
		r.setsIdent(drb.getsIdent());
		r.setsKodPocztowy(drb.getsKodPocztowy());
		r.setsMiejscowosc(drb.getsMiejscowosc());
		r.setsNazwa(drb.getsNazwa());
		r.setsNrDomu(drb.getsNrDomu());
		r.setsNrLokalu(drb.getsNrLokalu());
		r.setsPoczta(drb.getsPoczta());
		r.setsTelefon(drb.getsTelefon());
		r.setsUlica(drb.getsUlica());
		r.setUprawnienia(drb.getUprawnienia());
		r.setSpecyfikacja(preaprePozycjeRecepty(drb.getSpecyfikacja(), r));
		
		return r;
	}
	
	public static String prepareXmlDocument(DodajRecepteBean drb) {
		String receptyXml = "<?xml version=\"1.0\" ?>\n";
		receptyXml += "<recepty>\n";
		receptyXml += buildXmlString(drb);
	    receptyXml += "</recepty>";
	    return receptyXml;
	}

	private static String buildXmlString(DodajRecepteBean drb) {
        String recepta = "";
        recepta += "<recepta>\n";
            recepta += "\t<nr>" + drb.getNumer() + "</nr>\n";
            recepta += "\t<odplatnosc></odplatnosc>\n";
            recepta += "\t<swiadczeniodawca>\n"; 
                recepta += "\t\t<nazwa>" + drb.getsNazwa() + "</nazwa>\n";
                recepta += "\t\t<adres>\n";
                    recepta += "\t\t\t<ulica>" + drb.getsUlica() + "</ulica>\n";
                    recepta += "\t\t\t<nrDomu>" + drb.getsNrDomu() + "</nrDomu>\n";
                    recepta += "\t\t\t<nrLokalu>" + drb.getsNrLokalu() + "</nrLokalu>\n";
                    recepta += "\t\t\t<kodPocztowy>" + drb.getsKodPocztowy() + "</kodPocztowy>\n";
                    recepta += "\t\t\t<miejscowosc>" + drb.getsMiejscowosc() + "</miejscowosc>\n";
                    recepta += "\t\t\t<poczta>" + drb.getsPoczta() + "</poczta>\n";
                recepta += "\t\t</adres>\n";
                recepta += "\t\t<telefon>" + drb.getsTelefon() + "</telefon>\n";
                recepta += "\t\t<identyfikator>" + drb.getsIdent() + "</identyfikator>\n";
            recepta += "\t</swiadczeniodawca>\n";
            recepta += "\t<oddzialNfz>" + drb.getOddzialNfz() + "</oddzialNfz>\n";
            recepta += "\t<uprawnienia>" + drb.getUprawnienia() + "</uprawnienia>\n";
            recepta += "\t<chorobyPrzewlekle>";
                if(drb.getChorobyPrzewlekle()) 
                    recepta += "X";
            recepta += "</chorobyPrzewlekle>\n";
            recepta += "\t<pacjent>\n";
                recepta += "\t\t<imie>" + drb.getpImie() + "</imie>\n";
                recepta += "\t\t<nazwisko>" + drb.getpNazwisko() + "</nazwisko>\n";
                recepta += "\t\t<adres>\n";
                    recepta += "\t\t\t<ulica>" + drb.getpUlica() + "</ulica>\n";
                    recepta += "\t\t\t<nrDomu>" + drb.getpNrDomu() + "</nrDomu>\n";
                    recepta += "\t\t\t<nrLokalu>" + drb.getpNrLokalu() + "</nrLokalu>\n";
                    recepta += "\t\t\t<kodPocztowy>" + drb.getpKodPocztowy() + "</kodPocztowy>\n";
                    recepta += "\t\t\t<miejscowosc>" + drb.getpMiejscowosc() + "</miejscowosc>\n";
                    recepta += "\t\t\t<poczta>" + drb.getpPoczta() + "</poczta>\n";
                recepta += "\t\t</adres>\n";
                recepta += "\t\t<pesel>" + drb.getpPesel() + "</pesel>\n";
                recepta += "\t\t<nrPoswiadczenia>" + drb.getpPoswiadczenie() + "</nrPoswiadczenia>\n";
            recepta += "\t</pacjent>\n";
            recepta += "\t<dataWystawienia>" + drb.getData().getTime() + "</dataWystawienia>\n";
            recepta += "\t<dataRealizacjiOd>" + drb.getDataRealizacajiOd().getTime() + "</dataRealizacjiOd>\n";
            recepta += "\t<specyfikacja>\n";
                for(Specyfikacja s : drb.getSpecyfikacja()) {
                    recepta += "\t\t<pozycja>\n";
                        recepta += "\t\t\t<nazwa>" + s.getLek_nazwa() + "</nazwa>\n";
                        recepta += "\t\t\t<dawka>" + s.getLek_dawka() + "</dawka>\n";
                        recepta += "\t\t\t<jednostka>" + s.getLek_dJednostka() + "</jednostka>\n";
                        recepta += "\t\t\t<dawkowanie>\n";
                            recepta += "\t\t\t\t<czestosc>" + s.getLek_czestosc() + "</czestosc>\n";
                            recepta += "\t\t\t\t<ilosc>" + s.getLek_ilosc() + "</ilosc>\n";
                            recepta += "\t\t\t\t<jednostka>" + s.getLek_iJednostka() + "</jednostka>\n";
                        recepta += "\t\t\t</dawkowanie>\n";
                        recepta += "\t\t\t<dataRealizacji></dataRealizacji>\n";
                        recepta += "\t\t\t<ktoRealizowal>\n";
                            recepta += "\t\t\t\t<imie></imie>\n";
                            recepta += "\t\t\t\t<nazwisko></nazwisko>\n";
                            recepta += "\t\t\t\t<ident></ident>\n";
                        recepta += "\t\t\t</ktoRealizowal>\n";
                    recepta += "\t\t</pozycja>\n";
                }
            recepta += "\t</specyfikacja>\n";
            recepta += "\t<lekarz>\n";
                recepta += "\t\t<imie>" + drb.getlImie() + "</imie>\n";
                recepta += "\t\t<nazwisko>" + drb.getlNazwisko() + "</nazwisko>\n";
                recepta += "\t\t<nrPrawa>" + drb.getlNrPrawa() + "</nrPrawa>\n";
            recepta += "\t</lekarz>\n";
        recepta += "</recepta>\n";
        return recepta;
    }

	private static List<PozycjaRecepty> preaprePozycjeRecepty(List<Specyfikacja> spec, Recepta r) {
		List<PozycjaRecepty> poz = new ArrayList<PozycjaRecepty>();
		
		PozycjaRecepty pr = null;
		for(Specyfikacja s : spec) {
			pr = new PozycjaRecepty();
			pr.setCzestosc(s.getLek_czestosc());
			pr.setDawka(s.getLek_dawka());
			pr.setDawka_jednostka(s.getLek_dJednostka());
			pr.setIlosc(s.getLek_ilosc());
			pr.setIlosc_jednostka(s.getLek_iJednostka());
			pr.setNazwa(s.getLek_nazwa());
			pr.setRecepta(r);
			
			poz.add(pr);
		}
		
		return poz;
	}
}
