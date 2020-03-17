package com.fina.Pokusaj.model;

public class Protocol {
	private int iId;
	private String iServis;
	private String iUrl;
	private String iProtokol;
	private String iCertAlias;
	private String iIdCertIn;

	public String getServis() {
		return iServis;
	}

	public void setServis(String servis) {
		iServis = servis;
	}

	public String getUrl() {
		return iUrl;
	}

	public void setUrl(String url) {
		iUrl = url;
	}

	public String getProtokol() {
		return iProtokol;
	}

	public void setProtokol(String protokol) {
		iProtokol = protokol;
	}

	public String getCertAlias() {
		return iCertAlias;
	}

	public void setCertAlias(String certAlias) {
		iCertAlias = certAlias;
	}

	public String getIdCertIn() {
		return iIdCertIn;
	}

	public void setIdCertIn(String idCertIn) {
		iIdCertIn = idCertIn;
	}

	public int getId() {
		return iId;
	}

	public void setId(int id) {
		iId = id;
	}

	@Override
	public String toString() {
		return " id= " + iId + " servis= " + iServis + " url= " + iUrl + " protokol= " + iProtokol + " Cert_Alias= "
				+ iCertAlias + " idCertIn= " + iIdCertIn + "\n" + "\n";

	}

}
