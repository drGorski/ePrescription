package pl.wat.mgr.lekarz.fascade;

import java.rmi.RemoteException;

import pl.wat.mgr.nfz.services.WSProviderImplProxy;

public class NfzFascade {

	private static final String ESB = "http://bednarski-hp:9080/SOAPHTTPChannel1/soaphttpengine/SCA.APPLICATION.qcell.Bus/httpservicesnfzmgrwatplWSProviderImplServiceWSProviderImplInboundService/qnode_server1_SOAPHTTPChannel1_InboundPort?wsdl";
	
	public static String pobierzKolejnyNumerRecepty(String npwz, String swiadczeniodawca) {
		
		WSProviderImplProxy wspip = new WSProviderImplProxy();
		try {
			return wspip.pobierzKolejnyNumerRecepty(npwz, swiadczeniodawca);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static String wyslijRecepteDoNfz(String receptaXml) {
		
		WSProviderImplProxy wspip = new WSProviderImplProxy();
		try {
			return wspip.zapiszRecepte(receptaXml);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Boolean sprawdzRealizacjePozycji(String numer, String lek) {
		
		WSProviderImplProxy wspip = new WSProviderImplProxy();
		try {
			return wspip.getStatusPozycjiRecepty(numer, lek);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Boolean weryfikujRecepte(String receptaXml) {
		
		WSProviderImplProxy wspip = new WSProviderImplProxy();
		try {
			return wspip.walidujRecepte(receptaXml);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
}
