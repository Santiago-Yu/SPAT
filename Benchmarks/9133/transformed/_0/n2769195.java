class n2769195 {
	public int procesar() {
		int G6f1aErJ = 0;
		String Z8dU5Ail = "", fG1So9zs = "", Si6JDQzC = "";
		String QfMwXLjB = "", M6o2GrFP = "";
		String YmoDjIIZ = "";
		md5 mkHBEZTQ = null;
		StringTokenV2 b5Mt1qpZ = null, bKYw4aE2 = null, BIRg0Ocy = null;
		FileInputStream rCH4MDUR = null;
		BufferedInputStream eAqh6Jah = null;
		DataInputStream WYjGcdrc = null;
		FileWriter XDDDoxbG = null;
		BufferedWriter DAMhyTNG = null;
		PrintWriter awuxd12a = null;
		String JAnjOlk8 = "", lxWcPVdX = "", KbspEjht = "", cASG6Jnz = "", kN4dC9vG = "";
		StringTokenV2 UVJkYPPA;
		boolean tKHGwWDV = false;
		OntClass CHkNP4mq = null;
		OntClass jGI76ygS = null;
		String e3BKNeRU = "";
		String QHmZu8Xr = "", TuUBQGAP = "", gpu9eGjY = "";
		int RY0zuLOb = 0, n9N8WZ2N = 0;
		String Z07Lpt2e = "";
		String[] kpfppeit = new String[5];
		kpfppeit[0] = "http://www.criado.info/owl/vertebrados_es.owl#";
		kpfppeit[1] = "http://www.w3.org/2001/sw/WebOnt/guide-src/wine#";
		kpfppeit[2] = "http://www.co-ode.org/ontologies/pizza/2005/10/18/pizza.owl#";
		kpfppeit[3] = "http://www.w3.org/2001/sw/WebOnt/guide-src/food#";
		kpfppeit[4] = "http://www.daml.org/2001/01/gedcom/gedcom#";
		String[] eLVsEfbE = new String[5];
		eLVsEfbE[0] = this.directorioMapeo + "\\" + "mapeo_vertebrados_es.xml";
		eLVsEfbE[1] = this.directorioMapeo + "\\" + "mapeo_wine_es.xml";
		eLVsEfbE[2] = this.directorioMapeo + "\\" + "mapeo_pizza_es.xml";
		eLVsEfbE[3] = this.directorioMapeo + "\\" + "mapeo_food_es.xml";
		eLVsEfbE[4] = this.directorioMapeo + "\\" + "mapeo_parentesco_es.xml";
		mapeoIdiomas yZRFCB0D;
		try {
			if ((entrada = entradaFichero.readLine()) != null) {
				if (entrada.trim().length() > 10) {
					entrada2 = new StringTokenV2(entrada.trim(), "\"");
					if (entrada2.isIncluidaSubcadena("<fichero ontologia=")) {
						ontologiaOrigen = entrada2.getToken(2);
						QfMwXLjB = entrada2.getToken(4);
						M6o2GrFP = entrada2.getToken(6);
						if (ontologiaOrigen.equals("VERTEBRADOS")) {
							fG1So9zs = eLVsEfbE[0];
							Z8dU5Ail = kpfppeit[0];
						}
						if (ontologiaOrigen.equals("WINE")) {
							fG1So9zs = eLVsEfbE[1];
							Z8dU5Ail = kpfppeit[1];
						}
						if (ontologiaOrigen.equals("PIZZA")) {
							fG1So9zs = eLVsEfbE[2];
							Z8dU5Ail = kpfppeit[2];
						}
						if (ontologiaOrigen.equals("FOOD")) {
							fG1So9zs = eLVsEfbE[3];
							Z8dU5Ail = kpfppeit[3];
						}
						if (ontologiaOrigen.equals("PARENTESCOS")) {
							fG1So9zs = eLVsEfbE[4];
							Z8dU5Ail = kpfppeit[4];
						}
						mkHBEZTQ = new md5(Z8dU5Ail, false);
						yZRFCB0D = new mapeoIdiomas(fG1So9zs);
						Si6JDQzC = "";
						YmoDjIIZ = "";
						bKYw4aE2 = new StringTokenV2(QfMwXLjB, "\\");
						int LvGQtoc7 = bKYw4aE2.getNumeroTokenTotales();
						b5Mt1qpZ = new StringTokenV2(QfMwXLjB, " ");
						if (b5Mt1qpZ.isIncluidaSubcadena(directorioLocal)) {
							b5Mt1qpZ = new StringTokenV2(b5Mt1qpZ.getQuitar(directorioLocal) + "", " ");
							Si6JDQzC = b5Mt1qpZ.getCambiar("\\", "/");
							Si6JDQzC = b5Mt1qpZ.getQuitar(bKYw4aE2.getToken(LvGQtoc7)) + "";
							BIRg0Ocy = new StringTokenV2(bKYw4aE2.getToken(LvGQtoc7), ".");
							YmoDjIIZ = BIRg0Ocy.getToken(1) + "_" + mkHBEZTQ.toString() + ".owl";
							Si6JDQzC = urlPatron + Si6JDQzC + YmoDjIIZ;
						}
						BIRg0Ocy = new StringTokenV2(QfMwXLjB, ".");
						YmoDjIIZ = BIRg0Ocy.getToken(1) + "_" + mkHBEZTQ.toString() + ".owl";
						Z07Lpt2e = "<vistasemantica origen=\"" + M6o2GrFP + "\" destino=\"" + Si6JDQzC + "\" />";
						rCH4MDUR = new FileInputStream(M6o2GrFP);
						eAqh6Jah = new BufferedInputStream(rCH4MDUR);
						WYjGcdrc = new DataInputStream(eAqh6Jah);
						XDDDoxbG = new FileWriter(YmoDjIIZ);
						DAMhyTNG = new BufferedWriter(XDDDoxbG);
						awuxd12a = new PrintWriter(DAMhyTNG);
						while ((entradaInstancias = WYjGcdrc.readLine()) != null) {
							JAnjOlk8 = "";
							lxWcPVdX = "";
							KbspEjht = "";
							cASG6Jnz = "";
							kN4dC9vG = "";
							if (entradaInstancias.trim().length() > 10) {
								entrada2 = new StringTokenV2(entradaInstancias.trim(), "\"");
								if (entrada2.isIncluidaSubcadena("<oracion sujeto=")) {
									JAnjOlk8 = entrada2.getToken(2).trim();
									lxWcPVdX = entrada2.getToken(4).trim();
									KbspEjht = entrada2.getToken(6).trim();
									cASG6Jnz = entrada2.getToken(8).trim();
									kN4dC9vG = entrada2.getToken(10).trim();
									if (JAnjOlk8.length() > 0 & lxWcPVdX.length() > 0 & KbspEjht.length() > 0) {
										tKHGwWDV = false;
										CHkNP4mq = null;
										jGI76ygS = null;
										QHmZu8Xr = yZRFCB0D.getClaseInstancia(KbspEjht);
										if (QHmZu8Xr.length() > 0) {
											tKHGwWDV = true;
										}
										if (tKHGwWDV) {
											if (RY0zuLOb == 0) {
												awuxd12a.write(" <rdf:RDF        " + "\n");
												awuxd12a.write("     xmlns:j.0=\"" + Z8dU5Ail + "\"" + "\n");
												awuxd12a.write(
														"     xmlns:protege=\"http://protege.stanford.edu/plugins/owl/protege#\""
																+ "\n");
												awuxd12a.write(
														"     xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\""
																+ "\n");
												awuxd12a.write(
														"     xmlns:xsd=\"http://www.w3.org/2001/XMLSchema#\"" + "\n");
												awuxd12a.write(
														"     xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\""
																+ "\n");
												awuxd12a.write(
														"     xmlns:owl=\"http://www.w3.org/2002/07/owl#\"    " + "\n");
												awuxd12a.write("     xmlns=\"" + Si6JDQzC + "#\"" + "\n");
												awuxd12a.write("   xml:base=\"" + Si6JDQzC + "\">" + "\n");
												awuxd12a.write("   <owl:Ontology rdf:about=\"\">" + "\n");
												awuxd12a.write(
														"     <owl:imports rdf:resource=\"" + Z8dU5Ail + "\"/>" + "\n");
												awuxd12a.write("   </owl:Ontology>" + "\n");
												awuxd12a.flush();
												salida.write(Z07Lpt2e + "\n");
												salida.flush();
												RY0zuLOb = 1;
											}
											awuxd12a.write("    <j.0:" + QHmZu8Xr + " rdf:ID=\""
													+ JAnjOlk8.toUpperCase() + "\"/>" + "\n");
											awuxd12a.write("    <owl:AllDifferent>" + "\n");
											awuxd12a.write(
													"      <owl:distinctMembers rdf:parseType=\"Collection\">" + "\n");
											awuxd12a.write("        <" + QHmZu8Xr + " rdf:about=\"#"
													+ JAnjOlk8.toUpperCase() + "\"/>" + "\n");
											awuxd12a.write("      </owl:distinctMembers>" + "\n");
											awuxd12a.write("    </owl:AllDifferent>" + "\n");
											awuxd12a.flush();
											tKHGwWDV = false;
										}
									}
								}
							}
						}
						awuxd12a.write(" </rdf:RDF>" + "\n" + "\n");
						awuxd12a.write("<!-- Creado por [html2ws]  http://www.luis.criado.org -->" + "\n");
						awuxd12a.flush();
					}
				}
				G6f1aErJ = 1;
			} else {
				salida.write("</listaVistasSemanticas>\n");
				salida.flush();
				salida.close();
				bw2.close();
				fw2.close();
				awuxd12a.close();
				entradaFichero.close();
				ent2.close();
				ent1.close();
				G6f1aErJ = -1;
			}
		} catch (Exception jiRTp2oP) {
			G6f1aErJ = -2;
			salida.write("No se encuentra: " + fichOrigen + "\n");
			salida.flush();
		}
		return G6f1aErJ;
	}

}