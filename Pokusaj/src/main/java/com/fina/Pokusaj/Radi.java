package com.fina.Pokusaj;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.fina.Pokusaj.controller.ProtocolController;
import com.fina.Pokusaj.dao.ProtocolDao;
import com.fina.Pokusaj.model.Osoba;
import com.fina.Pokusaj.model.Protocol;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Button.ClickEvent;

@StyleSheet("/Uredivanje.css")
@SpringUI

public class Radi extends UI {

	public Radi() {
		
	}

	@Autowired
	ProtocolDao iProtocolDao;

	private static Logger logger = LoggerFactory.getLogger(ProtocolController.class);

	private static final long serialVersionUID = 4947130739766651376L;
	TextField ime = new TextField();
	TextField prezime = new TextField();

	private VerticalLayout root;
	List<Osoba> osobe = new ArrayList<Osoba>();
	Grid<Protocol> grid = new Grid<Protocol>();
	
	
	Grid<Protocol> grid1 = new Grid<Protocol>();
	
	Grid<Protocol> grid2 = new Grid<Protocol>();
	Grid<Protocol> grid3 = new Grid<Protocol>();
	
	Grid<Protocol> grid4 = new Grid<Protocol>();
	
	Grid<Protocol> grid5 = new Grid<Protocol>();
	Grid<Protocol> grid6 = new Grid<Protocol>();
	Grid<Protocol> grid7 = new Grid<Protocol>();
	
	Grid<Protocol> grid8 = new Grid<Protocol>();
	Grid<Protocol> grid9 = new Grid<Protocol>();

	@Autowired
	TodoLayout layout;

	@Override
	protected void init(VaadinRequest pRequest) {
		setupLayout();
		addTodoList();
		dodavanjeOsoba();
		brisanjeOsobe();
		azuriranjeOsobe();
		

	}

	private void azuriranjeOsobe() {
		/*
		 * Button azuriraj = new Button("Ažuriraj"); azuriraj.addClickListener(new
		 * Button.ClickListener() {
		 * 
		 * @Override public void buttonClick(ClickEvent pEvent) { Osoba osoba = (Osoba)
		 * grid.getSelectionModel().getFirstSelectedItem().get(); osobe.remove(osoba);
		 * Osoba osoba2 = new Osoba(); osoba2.setIme(ime.getValue());
		 * osoba2.setPrezime(prezime.getValue());
		 * 
		 * } });
		 */

	}

	private void brisanjeOsobe() {
		/*
		 * Button brisi = new Button("Izbriši"); root.addComponent(brisi);
		 * brisi.addClickListener(new Button.ClickListener() {
		 * 
		 * @Override public void buttonClick(ClickEvent pEvent) { Osoba a = (Osoba)
		 * grid.getSelectionModel().getFirstSelectedItem().get(); osobe.remove(a);
		 * grid.getDataProvider().refreshAll();
		 * 
		 * } });
		 */

	}

	private void dodavanjeOsoba() {
		List<Protocol> lista = iProtocolDao.dohvatiProtokole();
		/*
		 * HttpHeaders headers = new HttpHeaders();
		 * headers.setContentType(MediaType.APPLICATION_JSON); String url =
		 * "http://localhost:8080/protokol"; RestTemplate restTemplate = new
		 * RestTemplate(); HttpEntity<String> requestEntity = new
		 * HttpEntity<String>(headers); ResponseEntity<Protocol[]> responseEntity =
		 * restTemplate.exchange(url, HttpMethod.GET, requestEntity, Protocol[].class);
		 */

		/*
		 * Protocol[] e=responseEntity.getBody(); for(int i=0; i<e.length;i++) {
		 * lista.add(e[i]); }
		 */

		HorizontalLayout proba = new HorizontalLayout();
		TextField ime = new TextField();
		ime.setPlaceholder("Iva");
		TextField prezime = new TextField();
		prezime.setPlaceholder("Ivic");
		Button dodaj = new Button("Dodaj");
		dodaj.addStyleName("button");
	
		grid.addStyleName("grid");
		grid.setItems(lista);
		// grid.addColumn(Protocol::getId).setCaption("ID");
		grid.addColumn(Protocol::getServis).setCaption("Servis");
		grid.addColumn(Protocol::getProtokol).setCaption("Protocol");
		grid.addColumn(Protocol::getUrl).setCaption("Url");
		grid.addColumn(Protocol::getCertAlias).setCaption("CertAlias");
		// grid.addColumn(Protocol::getIdCertIn).setCaption("CertId");

		grid.setWidth("1300px");

		root.addComponent(grid);
		proba.addComponents(ime, prezime);
		root.addComponent(proba);
		root.addComponent(dodaj);
		dodaj.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent pEvent) {

				Osoba o1 = new Osoba();
				o1.setIme(ime.getValue());

				o1.setPrezime(prezime.getValue());
				osobe.add(o1);
				grid.getDataProvider().refreshAll();
			}
		});

	}

	private void addTodoList() {
		
		root.addComponent(layout);

	}

	private void setupLayout() {

		root = new VerticalLayout();
		root.addStyleName("main");

		root.setCaption("Dodavanje osoba u tablicu");
		root.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		setContent(root);
	}

}
