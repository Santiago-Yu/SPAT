class n12914531 {
	public int procesar() {
		int WBSD9Lzf = 0;
		String k9OanWGw = "", w8veOrhX = "", iYVJ25X2 = "";
		String caKgnwNb = "", LjJePXZB = "";
		String kYKH33gB = "";
		md5 Qumea7uu = null;
		StringTokenV2 J9M6g6lv = null, EwRk9G35 = null, jlbgRbu0 = null;
		FileInputStream ChJipl02 = null;
		BufferedInputStream UPnwJ8Y5 = null;
		DataInputStream pV8wHvOX = null;
		FileWriter LivGS1SZ = null;
		BufferedWriter IAFUkdT2 = null;
		PrintWriter xqVPMEc7 = null;
		String FCfa9ul2 = "", yLBTtSmQ = "", tRU1vEgu = "", tWSjXq9M = "", FrevXYqY = "";
		StringTokenV2 aZj0R9Q8;
		boolean PiKibGV0 = false;
		OntClass dTuHg3yy = null;
		OntClass vyQQgAdL = null;
		String xw29EX9B = "";
		String nUsKOUSV = "", WxgjqzCB = "", GHYkVmd0 = "";
		int X7tt7Tbb = 0, XRuLQ0tG = 0;
		String BRlcJQWa = "";
		String[] NVI5iND0 = new String[5];
		NVI5iND0[0] = "http://www.criado.info/owl/vertebrados_es.owl#";
		NVI5iND0[1] = "http://www.w3.org/2001/sw/WebOnt/guide-src/wine#";
		NVI5iND0[2] = "http://www.co-ode.org/ontologies/pizza/2005/10/18/pizza.owl#";
		NVI5iND0[3] = "http://www.w3.org/2001/sw/WebOnt/guide-src/food#";
		NVI5iND0[4] = "http://www.daml.org/2001/01/gedcom/gedcom#";
		String[] HIwi9sjD = new String[5];
		HIwi9sjD[0] = this.directorioMapeo + "\\" + "mapeo_vertebrados_es.xml";
		HIwi9sjD[1] = this.directorioMapeo + "\\" + "mapeo_wine_es.xml";
		HIwi9sjD[2] = this.directorioMapeo + "\\" + "mapeo_pizza_es.xml";
		HIwi9sjD[3] = this.directorioMapeo + "\\" + "mapeo_food_es.xml";
		HIwi9sjD[4] = this.directorioMapeo + "\\" + "mapeo_parentesco_es.xml";
		mapeoIdiomas YkPGrReW;
		try {
			if ((entrada = entradaFichero.readLine()) != null) {
				if (entrada.trim().length() > 10) {
					entrada2 = new StringTokenV2(entrada.trim(), "\"");
					if (entrada2.isIncluidaSubcadena("<fichero ontologia=")) {
						ontologiaOrigen = entrada2.getToken(2);
						caKgnwNb = entrada2.getToken(4);
						LjJePXZB = entrada2.getToken(6);
						if (ontologiaOrigen.equals("VERTEBRADOS")) {
							w8veOrhX = HIwi9sjD[0];
							k9OanWGw = NVI5iND0[0];
						}
						if (ontologiaOrigen.equals("WINE")) {
							w8veOrhX = HIwi9sjD[1];
							k9OanWGw = NVI5iND0[1];
						}
						if (ontologiaOrigen.equals("PIZZA")) {
							w8veOrhX = HIwi9sjD[2];
							k9OanWGw = NVI5iND0[2];
						}
						if (ontologiaOrigen.equals("FOOD")) {
							w8veOrhX = HIwi9sjD[3];
							k9OanWGw = NVI5iND0[3];
						}
						if (ontologiaOrigen.equals("PARENTESCOS")) {
							w8veOrhX = HIwi9sjD[4];
							k9OanWGw = NVI5iND0[4];
						}
						Qumea7uu = new md5(k9OanWGw, false);
						YkPGrReW = new mapeoIdiomas(w8veOrhX);
						iYVJ25X2 = "";
						kYKH33gB = "";
						EwRk9G35 = new StringTokenV2(caKgnwNb, "\\");
						int LjjcDZmX = EwRk9G35.getNumeroTokenTotales();
						J9M6g6lv = new StringTokenV2(caKgnwNb, " ");
						if (J9M6g6lv.isIncluidaSubcadena(directorioLocal)) {
							J9M6g6lv = new StringTokenV2(J9M6g6lv.getQuitar(directorioLocal) + "", " ");
							iYVJ25X2 = J9M6g6lv.getCambiar("\\", "/");
							iYVJ25X2 = J9M6g6lv.getQuitar(EwRk9G35.getToken(LjjcDZmX)) + "";
							jlbgRbu0 = new StringTokenV2(EwRk9G35.getToken(LjjcDZmX), ".");
							kYKH33gB = jlbgRbu0.getToken(1) + "_" + Qumea7uu.toString() + ".owl";
							iYVJ25X2 = urlPatron + iYVJ25X2 + kYKH33gB;
						}
						jlbgRbu0 = new StringTokenV2(caKgnwNb, ".");
						kYKH33gB = jlbgRbu0.getToken(1) + "_" + Qumea7uu.toString() + ".owl";
						BRlcJQWa = "<vistasemantica origen=\"" + LjJePXZB + "\" destino=\"" + iYVJ25X2 + "\" />";
						ChJipl02 = new FileInputStream(LjJePXZB);
						UPnwJ8Y5 = new BufferedInputStream(ChJipl02);
						pV8wHvOX = new DataInputStream(UPnwJ8Y5);
						LivGS1SZ = new FileWriter(kYKH33gB);
						IAFUkdT2 = new BufferedWriter(LivGS1SZ);
						xqVPMEc7 = new PrintWriter(IAFUkdT2);
						while ((entradaInstancias = pV8wHvOX.readLine()) != null) {
							FCfa9ul2 = "";
							yLBTtSmQ = "";
							tRU1vEgu = "";
							tWSjXq9M = "";
							FrevXYqY = "";
							if (entradaInstancias.trim().length() > 10) {
								entrada2 = new StringTokenV2(entradaInstancias.trim(), "\"");
								if (entrada2.isIncluidaSubcadena("<oracion sujeto=")) {
									FCfa9ul2 = entrada2.getToken(2).trim();
									yLBTtSmQ = entrada2.getToken(4).trim();
									tRU1vEgu = entrada2.getToken(6).trim();
									tWSjXq9M = entrada2.getToken(8).trim();
									FrevXYqY = entrada2.getToken(10).trim();
									if (FCfa9ul2.length() > 0 & yLBTtSmQ.length() > 0 & tRU1vEgu.length() > 0) {
										PiKibGV0 = false;
										dTuHg3yy = null;
										vyQQgAdL = null;
										nUsKOUSV = YkPGrReW.getClaseInstancia(tRU1vEgu);
										if (nUsKOUSV.length() > 0) {
											PiKibGV0 = true;
										}
										if (PiKibGV0) {
											if (X7tt7Tbb == 0) {
												xqVPMEc7.write(" <rdf:RDF        " + "\n");
												xqVPMEc7.write("     xmlns:j.0=\"" + k9OanWGw + "\"" + "\n");
												xqVPMEc7.write(
														"     xmlns:protege=\"http://protege.stanford.edu/plugins/owl/protege#\""
																+ "\n");
												xqVPMEc7.write(
														"     xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\""
																+ "\n");
												xqVPMEc7.write(
														"     xmlns:xsd=\"http://www.w3.org/2001/XMLSchema#\"" + "\n");
												xqVPMEc7.write(
														"     xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\""
																+ "\n");
												xqVPMEc7.write(
														"     xmlns:owl=\"http://www.w3.org/2002/07/owl#\"    " + "\n");
												xqVPMEc7.write("     xmlns=\"" + iYVJ25X2 + "#\"" + "\n");
												xqVPMEc7.write("   xml:base=\"" + iYVJ25X2 + "\">" + "\n");
												xqVPMEc7.write("   <owl:Ontology rdf:about=\"\">" + "\n");
												xqVPMEc7.write(
														"     <owl:imports rdf:resource=\"" + k9OanWGw + "\"/>" + "\n");
												xqVPMEc7.write("   </owl:Ontology>" + "\n");
												xqVPMEc7.flush();
												salida.write(BRlcJQWa + "\n");
												salida.flush();
												X7tt7Tbb = 1;
											}
											xqVPMEc7.write("    <j.0:" + nUsKOUSV + " rdf:ID=\""
													+ FCfa9ul2.toUpperCase() + "\"/>" + "\n");
											xqVPMEc7.write("    <owl:AllDifferent>" + "\n");
											xqVPMEc7.write(
													"      <owl:distinctMembers rdf:parseType=\"Collection\">" + "\n");
											xqVPMEc7.write("        <" + nUsKOUSV + " rdf:about=\"#"
													+ FCfa9ul2.toUpperCase() + "\"/>" + "\n");
											xqVPMEc7.write("      </owl:distinctMembers>" + "\n");
											xqVPMEc7.write("    </owl:AllDifferent>" + "\n");
											xqVPMEc7.flush();
											PiKibGV0 = false;
										}
									}
								}
							}
						}
						xqVPMEc7.write(" </rdf:RDF>" + "\n" + "\n");
						xqVPMEc7.write("<!-- Creado por [html2ws]  http://www.luis.criado.org -->" + "\n");
						xqVPMEc7.flush();
					}
				}
				WBSD9Lzf = 1;
			} else {
				salida.write("</listaVistasSemanticas>\n");
				salida.flush();
				salida.close();
				bw2.close();
				fw2.close();
				xqVPMEc7.close();
				entradaFichero.close();
				ent2.close();
				ent1.close();
				WBSD9Lzf = -1;
			}
		} catch (Exception zCHTOSrC) {
			WBSD9Lzf = -2;
			salida.write("No se encuentra: " + fichOrigen + "\n");
			salida.flush();
		}
		return WBSD9Lzf;
	}

}