class n325062 {
	public void readMESHDescriptorFileIntoFiles(String kgU0sRiF) {
		String XDdGxqFS, FfcRJ5R9;
		String rkHagQ8c = getMESHdescriptorfilename();
		String M6z053rA = "";
		String SA6FJCxH = "";
		String mnXxWbK3 = "";
		String TRu87xUD = "";
		Vector J9Oqa7bC = new Vector();
		Vector NiBpV3Lp = new Vector();
		Vector QPYddxSs = new Vector();
		Vector TZKgzWpA = new Vector();
		Vector vwak3k10 = new Vector();
		Vector BNHWDp7o = new Vector();
		Set ArBB3tf9 = new TreeSet();
		Map afKvHjOG = new TreeMap();
		Map PpjwpP9G = new TreeMap();
		String X8tJ09kt, Al0Se4Vd;
		try {
			BufferedReader ETdxbVq1 = new BufferedReader(new FileReader(rkHagQ8c));
			String QtFYLUHH = kgU0sRiF + "\\mesh";
			BufferedWriter oQ3ME5M0 = new BufferedWriter(new FileWriter(QtFYLUHH + "_concept.txt"));
			BufferedWriter Sm254lIY = new BufferedWriter(new FileWriter(QtFYLUHH + "_concept_name.txt"));
			BufferedWriter WXXh9cju = new BufferedWriter(new FileWriter(QtFYLUHH + "_relation.txt"));
			BufferedWriter F8sW5lzF = new BufferedWriter(new FileWriter(QtFYLUHH + "to_cas_mapping.txt"));
			BufferedWriter jmSCGtmj = new BufferedWriter(new FileWriter(QtFYLUHH + "to_ec_mapping.txt"));
			Connection dnXp22Pd = tools.openDB("kb");
			String JVspGXXo = "SELECT hierarchy_complete,uid FROM mesh_tree, mesh_graph_uid_name WHERE term=name";
			ResultSet koAgpBkf = tools.executeQuery(dnXp22Pd, JVspGXXo);
			while (koAgpBkf.next()) {
				String C8ryt2xG = koAgpBkf.getString("hierarchy_complete");
				String AwFElSHg = koAgpBkf.getString("uid");
				afKvHjOG.put(C8ryt2xG, AwFElSHg);
			}
			dnXp22Pd.close();
			System.out.println("Reading in the DUIDs ...");
			BufferedReader oyeB8Vv2 = new BufferedReader(new FileReader(rkHagQ8c));
			XDdGxqFS = getNextLine(oyeB8Vv2);
			boolean e0nbkSrF = false;
			while ((oyeB8Vv2 != null) && (XDdGxqFS != null)) {
				if (XDdGxqFS.startsWith("<DescriptorRecord DescriptorClass")) {
					XDdGxqFS = getNextLine(oyeB8Vv2);
					X8tJ09kt = "<DescriptorUI>";
					Al0Se4Vd = "</DescriptorUI>";
					String Yivhb7Pb = XDdGxqFS.substring(X8tJ09kt.length(), XDdGxqFS.indexOf(Al0Se4Vd));
					if (Yivhb7Pb.compareTo("D041441") == 0)
						e0nbkSrF = true;
					XDdGxqFS = getNextLine(oyeB8Vv2);
					XDdGxqFS = getNextLine(oyeB8Vv2);
					X8tJ09kt = "<String>";
					Al0Se4Vd = "</String>";
					String iyhZn78r = XDdGxqFS.substring(X8tJ09kt.length(), XDdGxqFS.indexOf(Al0Se4Vd));
					PpjwpP9G.put(Yivhb7Pb, iyhZn78r);
				}
				XDdGxqFS = getNextLine(oyeB8Vv2);
			}
			oyeB8Vv2.close();
			BufferedReader r0QCpqh2 = new BufferedReader(new FileReader("e:\\projects\\ondex\\ec_concept_acc.txt"));
			Set eG5sy7mM = new TreeSet();
			String fo2ANlww = r0QCpqh2.readLine();
			while (r0QCpqh2.ready()) {
				StringTokenizer WLX2Xfwu = new StringTokenizer(fo2ANlww);
				WLX2Xfwu.nextToken();
				eG5sy7mM.add(WLX2Xfwu.nextToken());
				fo2ANlww = r0QCpqh2.readLine();
			}
			r0QCpqh2.close();
			tools.printDate();
			XDdGxqFS = getNextLine(ETdxbVq1);
			while (XDdGxqFS != null) {
				if (XDdGxqFS.startsWith("<DescriptorRecord DescriptorClass")) {
					J9Oqa7bC.clear();
					NiBpV3Lp.clear();
					QPYddxSs.clear();
					TZKgzWpA.clear();
					vwak3k10.clear();
					boolean IuQrkFfL = false;
					boolean dZPCSS4j = false;
					while ((XDdGxqFS != null) && (!XDdGxqFS.startsWith("</DescriptorRecord>"))) {
						dZPCSS4j = false;
						if ((XDdGxqFS.startsWith("<DescriptorUI>")) && (!IuQrkFfL)) {
							X8tJ09kt = "<DescriptorUI>";
							Al0Se4Vd = "</DescriptorUI>";
							M6z053rA = XDdGxqFS.substring(X8tJ09kt.length(), XDdGxqFS.indexOf(Al0Se4Vd));
							XDdGxqFS = getNextLine(ETdxbVq1);
							XDdGxqFS = getNextLine(ETdxbVq1);
							X8tJ09kt = "<String>";
							Al0Se4Vd = "</String>";
							SA6FJCxH = XDdGxqFS.substring(X8tJ09kt.length(), XDdGxqFS.indexOf(Al0Se4Vd));
							IuQrkFfL = true;
						}
						if (XDdGxqFS.compareTo("<SeeRelatedList>") == 0) {
							while ((XDdGxqFS != null) && (XDdGxqFS.indexOf("</SeeRelatedList>") == -1)) {
								if (XDdGxqFS.startsWith("<DescriptorUI>")) {
									X8tJ09kt = "<DescriptorUI>";
									Al0Se4Vd = "</DescriptorUI>";
									String iSiBHGtE = XDdGxqFS.substring(X8tJ09kt.length(), XDdGxqFS.indexOf(Al0Se4Vd));
									NiBpV3Lp.add(iSiBHGtE);
								}
								XDdGxqFS = getNextLine(ETdxbVq1);
								dZPCSS4j = true;
							}
						}
						if (XDdGxqFS.compareTo("<TreeNumberList>") == 0) {
							while ((XDdGxqFS != null) && (XDdGxqFS.indexOf("</TreeNumberList>") == -1)) {
								if (XDdGxqFS.startsWith("<TreeNumber>")) {
									X8tJ09kt = "<TreeNumber>";
									Al0Se4Vd = "</TreeNumber>";
									String vwzw53PB = XDdGxqFS.substring(X8tJ09kt.length(), XDdGxqFS.indexOf(Al0Se4Vd));
									J9Oqa7bC.add(vwzw53PB);
								}
								XDdGxqFS = getNextLine(ETdxbVq1);
								dZPCSS4j = true;
							}
						}
						if (XDdGxqFS.startsWith("<Concept PreferredConceptYN")) {
							boolean WNS6nuyQ = false;
							if (XDdGxqFS.compareTo("<Concept PreferredConceptYN=\"Y\">") == 0)
								WNS6nuyQ = true;
							while ((XDdGxqFS != null) && (XDdGxqFS.indexOf("</Concept>") == -1)) {
								if (XDdGxqFS.startsWith("<CASN1Name>") && WNS6nuyQ) {
									X8tJ09kt = "<CASN1Name>";
									Al0Se4Vd = "</CASN1Name>";
									String d8NL7foQ = XDdGxqFS.substring(X8tJ09kt.length(), XDdGxqFS.indexOf(Al0Se4Vd));
									String Z5NJFfff = d8NL7foQ;
									String Wjto5I9K = "";
									if (d8NL7foQ.length() > Z5NJFfff.length() + 2)
										Wjto5I9K = d8NL7foQ.substring(Z5NJFfff.length() + 2, d8NL7foQ.length());
									String fCVgW4gM = "";
									XDdGxqFS = getNextLine(ETdxbVq1);
									if (XDdGxqFS.startsWith("<RegistryNumber>")) {
										X8tJ09kt = "<RegistryNumber>";
										Al0Se4Vd = "</RegistryNumber>";
										fCVgW4gM = XDdGxqFS.substring(X8tJ09kt.length(), XDdGxqFS.indexOf(Al0Se4Vd));
									}
									Vector GjOzpefH = new Vector();
									String SWXT8Nph = "";
									if (fCVgW4gM.startsWith("EC")) {
										SWXT8Nph = "EC";
										fCVgW4gM = fCVgW4gM.substring(3, fCVgW4gM.length());
									} else {
										SWXT8Nph = "CAS";
									}
									GjOzpefH.add(SWXT8Nph);
									GjOzpefH.add(fCVgW4gM);
									GjOzpefH.add(Z5NJFfff);
									GjOzpefH.add(Wjto5I9K);
									vwak3k10.add(GjOzpefH);
									if (SWXT8Nph.compareTo("CAS") == 0) {
										if (!ArBB3tf9.contains(fCVgW4gM)) {
											ArBB3tf9.add(fCVgW4gM);
											BNHWDp7o.add(GjOzpefH);
										}
									}
								}
								if (XDdGxqFS.startsWith("<ScopeNote>") && WNS6nuyQ) {
									X8tJ09kt = "<ScopeNote>";
									mnXxWbK3 = XDdGxqFS.substring(X8tJ09kt.length(), XDdGxqFS.length());
								}
								if (XDdGxqFS.startsWith("<TermUI>")) {
									XDdGxqFS = getNextLine(ETdxbVq1);
									X8tJ09kt = "<String>";
									Al0Se4Vd = "</String>";
									String N3w2K3Hj = XDdGxqFS.substring(X8tJ09kt.length(), XDdGxqFS.indexOf(Al0Se4Vd));
									if (N3w2K3Hj.indexOf("&amp;") != -1) {
										String zmVUxYen = N3w2K3Hj.substring(0, N3w2K3Hj.indexOf("&amp;"));
										String Dcy4c0Nn = N3w2K3Hj.substring(N3w2K3Hj.indexOf("amp;") + 4,
												N3w2K3Hj.length());
										N3w2K3Hj = zmVUxYen + " & " + Dcy4c0Nn;
									}
									if (SA6FJCxH.compareTo(N3w2K3Hj) != 0)
										QPYddxSs.add(N3w2K3Hj);
								}
								if (XDdGxqFS.startsWith("<PharmacologicalAction>")) {
									XDdGxqFS = getNextLine(ETdxbVq1);
									XDdGxqFS = getNextLine(ETdxbVq1);
									X8tJ09kt = "<DescriptorUI>";
									Al0Se4Vd = "</DescriptorUI>";
									String ygbQK1hL = XDdGxqFS.substring(X8tJ09kt.length(), XDdGxqFS.indexOf(Al0Se4Vd));
									TZKgzWpA.add(ygbQK1hL);
								}
								XDdGxqFS = getNextLine(ETdxbVq1);
								dZPCSS4j = true;
							}
						}
						if (!dZPCSS4j)
							XDdGxqFS = getNextLine(ETdxbVq1);
					}
					String Z1K5ohLV = "";
					TRu87xUD = "MESHD";
					String EAhPUDQd = "0";
					oQ3ME5M0.write(M6z053rA + "\t" + Z1K5ohLV + "\t" + mnXxWbK3 + "\t" + TRu87xUD + "\t");
					oQ3ME5M0.write(EAhPUDQd + "\n");
					String J5Vfn5KL = "";
					String erxedcuD = "";
					TRu87xUD = "MESHD";
					String Cl96AIDt = "0";
					int GmjqRS0I = 1;
					String d0LO64Ti = SA6FJCxH;
					String RX9yfcZH = "0";
					Sm254lIY.write(M6z053rA + "\t" + SA6FJCxH + "\t" + J5Vfn5KL + "\t");
					Sm254lIY.write(erxedcuD + "\t" + TRu87xUD + "\t");
					Sm254lIY.write(Cl96AIDt + "\t" + GmjqRS0I + "\t");
					Sm254lIY.write(d0LO64Ti + "\t" + RX9yfcZH + "\n");
					GmjqRS0I = 0;
					for (int cdkESGSN = 0; cdkESGSN < QPYddxSs.size(); cdkESGSN++) {
						SA6FJCxH = (String) QPYddxSs.get(cdkESGSN);
						d0LO64Ti = SA6FJCxH;
						Sm254lIY.write(M6z053rA + "\t" + SA6FJCxH + "\t" + J5Vfn5KL + "\t");
						Sm254lIY.write(erxedcuD + "\t" + TRu87xUD + "\t");
						Sm254lIY.write(Cl96AIDt + "\t" + GmjqRS0I + "\t");
						Sm254lIY.write(d0LO64Ti + "\t" + RX9yfcZH + "\n");
					}
					String SaVQeDkk = "is_r";
					TRu87xUD = "MESHD";
					String y2pbO9nG = SA6FJCxH;
					for (int sWTfCDuz = 0; sWTfCDuz < NiBpV3Lp.size(); sWTfCDuz++) {
						String SlsL9QxU = (String) NiBpV3Lp.get(sWTfCDuz);
						String SRynr2r3 = (String) PpjwpP9G.get(SlsL9QxU);
						WXXh9cju.write(M6z053rA + "\t" + SlsL9QxU + "\t");
						WXXh9cju.write(SaVQeDkk + "\t" + TRu87xUD + "\t");
						WXXh9cju.write(y2pbO9nG + "\t" + SRynr2r3 + "\n");
					}
					SaVQeDkk = "is_a";
					TRu87xUD = "MESHD";
					NiBpV3Lp.clear();
					for (int PptR0rdr = 0; PptR0rdr < J9Oqa7bC.size(); PptR0rdr++) {
						String AICUn0ch = (String) J9Oqa7bC.get(PptR0rdr);
						if (AICUn0ch.length() > 3)
							AICUn0ch = AICUn0ch.substring(0, AICUn0ch.lastIndexOf("."));
						String YqRrxefb = (String) afKvHjOG.get(AICUn0ch);
						if (YqRrxefb != null)
							NiBpV3Lp.add(YqRrxefb);
						else
							System.out.println(M6z053rA + ": No DUI found for " + AICUn0ch);
					}
					for (int chyRCJVR = 0; chyRCJVR < NiBpV3Lp.size(); chyRCJVR++) {
						String WdtKKPVZ = (String) NiBpV3Lp.get(chyRCJVR);
						String oZA5xrfk = (String) PpjwpP9G.get(WdtKKPVZ);
						WXXh9cju.write(M6z053rA + "\t" + WdtKKPVZ + "\t");
						WXXh9cju.write(SaVQeDkk + "\t" + TRu87xUD + "\t");
						WXXh9cju.write(y2pbO9nG + "\t" + oZA5xrfk + "\n");
					}
					if (NiBpV3Lp.size() == 0)
						System.out.println(M6z053rA + ": No is_a relations");
					SaVQeDkk = "act";
					TRu87xUD = "MESHD";
					for (int g5Zk4IIB = 0; g5Zk4IIB < TZKgzWpA.size(); g5Zk4IIB++) {
						String yTTpYrtk = (String) TZKgzWpA.get(g5Zk4IIB);
						String FO8wEAug = (String) PpjwpP9G.get(yTTpYrtk);
						WXXh9cju.write(M6z053rA + "\t" + yTTpYrtk + "\t");
						WXXh9cju.write(SaVQeDkk + "\t" + TRu87xUD + "\t");
						WXXh9cju.write(y2pbO9nG + "\t" + FO8wEAug + "\n");
					}
					String utznPUTt = "IMPM";
					String yWd792Ce = "1.0";
					for (int coHhgIAI = 0; coHhgIAI < vwak3k10.size(); coHhgIAI++) {
						Vector BnYvOGMb = (Vector) vwak3k10.get(coHhgIAI);
						String ha6Vt8nG = (String) BnYvOGMb.get(0);
						String XlxxBGqT = (String) BnYvOGMb.get(1);
						if (!eG5sy7mM.contains(XlxxBGqT) && (ha6Vt8nG.compareTo("EC") == 0)) {
							if (XlxxBGqT.compareTo("1.14.-") == 0)
								XlxxBGqT = "1.14.-.-";
							else
								System.out.println("MISSING EC: " + XlxxBGqT);
						}
						String s1BB8Mb1 = ha6Vt8nG + ":" + XlxxBGqT;
						String W0P12o0E = M6z053rA + "\t" + s1BB8Mb1 + "\t" + utznPUTt + "\t" + yWd792Ce + "\n";
						if (ha6Vt8nG.compareTo("CAS") == 0)
							F8sW5lzF.write(W0P12o0E);
						else
							jmSCGtmj.write(W0P12o0E);
					}
				} else
					XDdGxqFS = getNextLine(ETdxbVq1);
			}
			System.out.println("End import descriptors");
			tools.printDate();
			ETdxbVq1.close();
			oQ3ME5M0.close();
			Sm254lIY.close();
			WXXh9cju.close();
			F8sW5lzF.close();
			jmSCGtmj.close();
			QtFYLUHH = kgU0sRiF + "\\cas";
			oQ3ME5M0 = new BufferedWriter(new FileWriter(QtFYLUHH + "_concept.txt"));
			Sm254lIY = new BufferedWriter(new FileWriter(QtFYLUHH + "_concept_name.txt"));
			BufferedWriter qPpaC3nU = new BufferedWriter(new FileWriter(QtFYLUHH + "_concept_acc.txt"));
			for (int dTe1c1SR = 0; dTe1c1SR < BNHWDp7o.size(); dTe1c1SR++) {
				Vector rpT086T1 = (Vector) BNHWDp7o.get(dTe1c1SR);
				String CawnSGwe = "CAS:" + (String) rpT086T1.get(1);
				String BVtkRsaw = (String) rpT086T1.get(2);
				String GeWSiXR2 = "";
				String XFpHc0Mi = (String) rpT086T1.get(3);
				String qKO6906k = "CAS";
				String UOLfq3Kh = "0";
				oQ3ME5M0.write(CawnSGwe + "\t" + GeWSiXR2 + "\t" + XFpHc0Mi + "\t");
				oQ3ME5M0.write(qKO6906k + "\t" + UOLfq3Kh + "\n");
				String BPVRPtoF = "";
				String isFFIt9t = "";
				String Bn7MmEwP = "0";
				String Lf8ZeHNW = "0";
				String g4kAp3X2 = BVtkRsaw;
				String YVRVub8m = "0";
				Sm254lIY.write(CawnSGwe + "\t" + BVtkRsaw + "\t" + BPVRPtoF + "\t");
				Sm254lIY.write(isFFIt9t + "\t" + qKO6906k + "\t");
				Sm254lIY.write(Bn7MmEwP + "\t" + Lf8ZeHNW + "\t");
				Sm254lIY.write(g4kAp3X2 + "\t" + YVRVub8m + "\n");
				qPpaC3nU.write(CawnSGwe + "\t" + (String) rpT086T1.get(1) + "\t");
				qPpaC3nU.write(qKO6906k + "\n");
			}
			oQ3ME5M0.close();
			Sm254lIY.close();
			qPpaC3nU.close();
		} catch (Exception oJpqZLQy) {
			settings.writeLog("Error while reading MESH descriptor file: " + oJpqZLQy.getMessage());
		}
	}

}