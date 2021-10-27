class n21642215 {
	private int addIDs(PeakListRow Z5SMHfZq, String yH1ckITj) {
		{
			BufferedReader ikLMJ7zu = null;
			try {
				String VjSl4uOD = "http://gmd.mpimp-golm.mpg.de/search.aspx?query=" + yH1ckITj;
				URL t8FLsvzr = new URL(VjSl4uOD);
				ikLMJ7zu = new BufferedReader(new InputStreamReader(t8FLsvzr.openStream()));
				String I0Ys2h3G, POwNhnfO = "0";
				while ((I0Ys2h3G = ikLMJ7zu.readLine()) != null) {
					String LBMvEgn9 = "";
					if (I0Ys2h3G.contains("href=\"Metabolites/")) {
						String[] cbkTz3wr = I0Ys2h3G.split("</td><td>");
						POwNhnfO = cbkTz3wr[0].substring(cbkTz3wr[0].indexOf("<td>") + 4);
						LBMvEgn9 = I0Ys2h3G.substring(I0Ys2h3G.indexOf("href=\"Metabolites/") + 18,
								I0Ys2h3G.indexOf("aspx\">") + 4);
						VjSl4uOD = "http://gmd.mpimp-golm.mpg.de/Metabolites/" + LBMvEgn9;
						I0Ys2h3G = ikLMJ7zu.readLine();
						I0Ys2h3G = ikLMJ7zu.readLine();
						String[] yZpwUUvA = I0Ys2h3G.split("</td><td>");
						String d0ROh4aK = yZpwUUvA[yZpwUUvA.length - 1].replaceAll("&nbsp;", "");
						Z5SMHfZq.setVar(GCGCColumnName.MOLWEIGHT.getSetFunctionName(), d0ROh4aK);
						break;
					} else if (I0Ys2h3G.contains("href=\"Analytes/")) {
						String[] pUAq3cua = I0Ys2h3G.split("</td><td>");
						POwNhnfO = pUAq3cua[0].substring(pUAq3cua[0].indexOf("<td>") + 4);
						LBMvEgn9 = I0Ys2h3G.substring(I0Ys2h3G.indexOf("href=\"Analytes/") + 15,
								I0Ys2h3G.indexOf("aspx\">") + 4);
						VjSl4uOD = "http://gmd.mpimp-golm.mpg.de/Analytes/" + LBMvEgn9;
						I0Ys2h3G = ikLMJ7zu.readLine();
						I0Ys2h3G = ikLMJ7zu.readLine();
						String[] WZcVjG3L = I0Ys2h3G.split("</td><td>");
						String oelP1EL9 = WZcVjG3L[WZcVjG3L.length - 1].replaceAll("&nbsp;", "");
						Z5SMHfZq.setVar(GCGCColumnName.MOLWEIGHT.getSetFunctionName(), oelP1EL9);
						break;
					} else if (I0Ys2h3G.contains("href=\"ReferenceSubstances/")) {
						String[] NtDQAy0X = I0Ys2h3G.split("</td><td>");
						POwNhnfO = NtDQAy0X[0].substring(NtDQAy0X[0].indexOf("<td>") + 4);
						LBMvEgn9 = I0Ys2h3G.substring(I0Ys2h3G.indexOf("href=\"ReferenceSubstances/") + 26,
								I0Ys2h3G.indexOf("aspx\">") + 4);
						VjSl4uOD = "http://gmd.mpimp-golm.mpg.de/ReferenceSubstances/" + LBMvEgn9;
						I0Ys2h3G = ikLMJ7zu.readLine();
						I0Ys2h3G = ikLMJ7zu.readLine();
						String[] pni9hHiP = I0Ys2h3G.split("</td><td>");
						String TdrUbjYh = pni9hHiP[pni9hHiP.length - 1].replaceAll("&nbsp;", "");
						Z5SMHfZq.setVar(GCGCColumnName.MOLWEIGHT.getSetFunctionName(), TdrUbjYh);
						break;
					}
				}
				ikLMJ7zu.close();
				VjSl4uOD = searchMetabolite(VjSl4uOD);
				if (VjSl4uOD != null && VjSl4uOD.contains(".aspx")) {
					t8FLsvzr = new URL(VjSl4uOD);
					ikLMJ7zu = new BufferedReader(new InputStreamReader(t8FLsvzr.openStream()));
					while ((I0Ys2h3G = ikLMJ7zu.readLine()) != null) {
						if (I0Ys2h3G.contains("<meta http-equiv=\"keywords\" content=")) {
							String OqSGzfzz = I0Ys2h3G.substring(
									I0Ys2h3G.indexOf("<meta http-equiv=\"keywords\" content=") + 37,
									I0Ys2h3G.indexOf("\" /></head>"));
							String[] lWlQErnR = OqSGzfzz.split(", ");
							for (String xgEeIVQL : lWlQErnR) {
								if (xgEeIVQL.contains("PubChem")) {
									xgEeIVQL = xgEeIVQL.substring(xgEeIVQL.indexOf("PubChem") + 8);
									String ZCaG7KpM = (String) Z5SMHfZq
											.getVar(GCGCColumnName.PUBCHEM.getGetFunctionName());
									if (ZCaG7KpM.length() == 0) {
										ZCaG7KpM += xgEeIVQL;
									} else {
										ZCaG7KpM += ", " + xgEeIVQL;
									}
									Z5SMHfZq.setVar(GCGCColumnName.PUBCHEM.getSetFunctionName(), ZCaG7KpM);
								} else if (xgEeIVQL.contains("ChEBI")) {
									xgEeIVQL = xgEeIVQL.substring(xgEeIVQL.indexOf("ChEBI:") + 6);
									Z5SMHfZq.setVar(GCGCColumnName.ChEBI.getSetFunctionName(), xgEeIVQL);
								} else if (xgEeIVQL.contains("KEGG")) {
									xgEeIVQL = xgEeIVQL.substring(xgEeIVQL.indexOf("KEGG:") + 6);
									Z5SMHfZq.setVar(GCGCColumnName.KEGG.getSetFunctionName(), xgEeIVQL);
								} else if (xgEeIVQL.contains("CAS")) {
									xgEeIVQL = xgEeIVQL.substring(xgEeIVQL.indexOf("CAS:") + 5);
									Z5SMHfZq.setVar(GCGCColumnName.CAS2.getSetFunctionName(), xgEeIVQL);
								} else if (xgEeIVQL.contains("ChemSpider") || xgEeIVQL.contains("MAPMAN")
										|| xgEeIVQL.contains("Beilstein:")) {
								} else {
									String W6gFUY9m = (String) Z5SMHfZq
											.getVar(GCGCColumnName.SYNONYM.getGetFunctionName());
									if (W6gFUY9m.length() == 0) {
										W6gFUY9m += xgEeIVQL;
									} else {
										W6gFUY9m += " // " + xgEeIVQL;
									}
									W6gFUY9m = W6gFUY9m.replaceAll("&amp;#39;", "'");
									Z5SMHfZq.setVar(GCGCColumnName.SYNONYM.getSetFunctionName(), W6gFUY9m);
								}
							}
							break;
						}
					}
					ikLMJ7zu.close();
				}
				return Integer.parseInt(POwNhnfO);
			} catch (IOException wOyxmZb0) {
				Logger.getLogger(GetGolmIDsTask.class.getName()).log(Level.SEVERE, null, wOyxmZb0);
				return 0;
			}
		}
	}

}