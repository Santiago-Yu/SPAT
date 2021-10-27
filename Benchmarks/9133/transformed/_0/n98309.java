class n98309 {
	public void readMESHDescriptorFileIntoFiles(String sCsuYXJr) {
		String YLtU9xvE, QgBSXNoY;
		String E1T9dN0X = getMESHdescriptorfilename();
		String plGvyekj = "";
		String MNLqN4jU = "";
		String SoWmOcxN = "";
		String QMoMdMeG = "";
		Vector TsAKzX0a = new Vector();
		Vector yGTpy0m2 = new Vector();
		Vector oEUUrDxt = new Vector();
		Vector Znl9F5Ff = new Vector();
		Vector v4nrxOPy = new Vector();
		Vector HsGlRZUK = new Vector();
		Set CvzKcEGY = new TreeSet();
		Map iGk5opXb = new TreeMap();
		Map twwURXMV = new TreeMap();
		String CK0JLw9R, dPPgFWWU;
		try {
			BufferedReader jS7ZJYHq = new BufferedReader(new FileReader(E1T9dN0X));
			String cMrxsy2O = sCsuYXJr + "\\mesh";
			BufferedWriter xr17uXMt = new BufferedWriter(new FileWriter(cMrxsy2O + "_concept.txt"));
			BufferedWriter dKfXTrLO = new BufferedWriter(new FileWriter(cMrxsy2O + "_concept_name.txt"));
			BufferedWriter WhONIEWt = new BufferedWriter(new FileWriter(cMrxsy2O + "_relation.txt"));
			BufferedWriter hGt8GhYp = new BufferedWriter(new FileWriter(cMrxsy2O + "to_cas_mapping.txt"));
			BufferedWriter s8XlHsA1 = new BufferedWriter(new FileWriter(cMrxsy2O + "to_ec_mapping.txt"));
			Connection t6VGrqHi = tools.openDB("kb");
			String nwdMZwVP = "SELECT hierarchy_complete,uid FROM mesh_tree, mesh_graph_uid_name WHERE term=name";
			ResultSet f1CNJwvC = tools.executeQuery(t6VGrqHi, nwdMZwVP);
			while (f1CNJwvC.next()) {
				String BVXzeIt7 = f1CNJwvC.getString("hierarchy_complete");
				String eeSQvHp9 = f1CNJwvC.getString("uid");
				iGk5opXb.put(BVXzeIt7, eeSQvHp9);
			}
			t6VGrqHi.close();
			System.out.println("Reading in the DUIDs ...");
			BufferedReader RBsIgSq6 = new BufferedReader(new FileReader(E1T9dN0X));
			YLtU9xvE = getNextLine(RBsIgSq6);
			boolean CYiaphCW = false;
			while ((RBsIgSq6 != null) && (YLtU9xvE != null)) {
				if (YLtU9xvE.startsWith("<DescriptorRecord DescriptorClass")) {
					YLtU9xvE = getNextLine(RBsIgSq6);
					CK0JLw9R = "<DescriptorUI>";
					dPPgFWWU = "</DescriptorUI>";
					String XN8nJi2M = YLtU9xvE.substring(CK0JLw9R.length(), YLtU9xvE.indexOf(dPPgFWWU));
					if (XN8nJi2M.compareTo("D041441") == 0)
						CYiaphCW = true;
					YLtU9xvE = getNextLine(RBsIgSq6);
					YLtU9xvE = getNextLine(RBsIgSq6);
					CK0JLw9R = "<String>";
					dPPgFWWU = "</String>";
					String QNNL1F5V = YLtU9xvE.substring(CK0JLw9R.length(), YLtU9xvE.indexOf(dPPgFWWU));
					twwURXMV.put(XN8nJi2M, QNNL1F5V);
				}
				YLtU9xvE = getNextLine(RBsIgSq6);
			}
			RBsIgSq6.close();
			BufferedReader eaFjQxuX = new BufferedReader(new FileReader("e:\\projects\\ondex\\ec_concept_acc.txt"));
			Set DhuC6959 = new TreeSet();
			String upQQL3Hh = eaFjQxuX.readLine();
			while (eaFjQxuX.ready()) {
				StringTokenizer kxLVhdrv = new StringTokenizer(upQQL3Hh);
				kxLVhdrv.nextToken();
				DhuC6959.add(kxLVhdrv.nextToken());
				upQQL3Hh = eaFjQxuX.readLine();
			}
			eaFjQxuX.close();
			tools.printDate();
			YLtU9xvE = getNextLine(jS7ZJYHq);
			while (YLtU9xvE != null) {
				if (YLtU9xvE.startsWith("<DescriptorRecord DescriptorClass")) {
					TsAKzX0a.clear();
					yGTpy0m2.clear();
					oEUUrDxt.clear();
					Znl9F5Ff.clear();
					v4nrxOPy.clear();
					boolean XUcSPDqs = false;
					boolean HR9db4Lz = false;
					while ((YLtU9xvE != null) && (!YLtU9xvE.startsWith("</DescriptorRecord>"))) {
						HR9db4Lz = false;
						if ((YLtU9xvE.startsWith("<DescriptorUI>")) && (!XUcSPDqs)) {
							CK0JLw9R = "<DescriptorUI>";
							dPPgFWWU = "</DescriptorUI>";
							plGvyekj = YLtU9xvE.substring(CK0JLw9R.length(), YLtU9xvE.indexOf(dPPgFWWU));
							YLtU9xvE = getNextLine(jS7ZJYHq);
							YLtU9xvE = getNextLine(jS7ZJYHq);
							CK0JLw9R = "<String>";
							dPPgFWWU = "</String>";
							MNLqN4jU = YLtU9xvE.substring(CK0JLw9R.length(), YLtU9xvE.indexOf(dPPgFWWU));
							XUcSPDqs = true;
						}
						if (YLtU9xvE.compareTo("<SeeRelatedList>") == 0) {
							while ((YLtU9xvE != null) && (YLtU9xvE.indexOf("</SeeRelatedList>") == -1)) {
								if (YLtU9xvE.startsWith("<DescriptorUI>")) {
									CK0JLw9R = "<DescriptorUI>";
									dPPgFWWU = "</DescriptorUI>";
									String zJuGCVGE = YLtU9xvE.substring(CK0JLw9R.length(), YLtU9xvE.indexOf(dPPgFWWU));
									yGTpy0m2.add(zJuGCVGE);
								}
								YLtU9xvE = getNextLine(jS7ZJYHq);
								HR9db4Lz = true;
							}
						}
						if (YLtU9xvE.compareTo("<TreeNumberList>") == 0) {
							while ((YLtU9xvE != null) && (YLtU9xvE.indexOf("</TreeNumberList>") == -1)) {
								if (YLtU9xvE.startsWith("<TreeNumber>")) {
									CK0JLw9R = "<TreeNumber>";
									dPPgFWWU = "</TreeNumber>";
									String KUzOqkms = YLtU9xvE.substring(CK0JLw9R.length(), YLtU9xvE.indexOf(dPPgFWWU));
									TsAKzX0a.add(KUzOqkms);
								}
								YLtU9xvE = getNextLine(jS7ZJYHq);
								HR9db4Lz = true;
							}
						}
						if (YLtU9xvE.startsWith("<Concept PreferredConceptYN")) {
							boolean SekjJhTR = false;
							if (YLtU9xvE.compareTo("<Concept PreferredConceptYN=\"Y\">") == 0)
								SekjJhTR = true;
							while ((YLtU9xvE != null) && (YLtU9xvE.indexOf("</Concept>") == -1)) {
								if (YLtU9xvE.startsWith("<CASN1Name>") && SekjJhTR) {
									CK0JLw9R = "<CASN1Name>";
									dPPgFWWU = "</CASN1Name>";
									String Bh5k3tSx = YLtU9xvE.substring(CK0JLw9R.length(), YLtU9xvE.indexOf(dPPgFWWU));
									String pL2PEUgO = Bh5k3tSx;
									String j7ZTqxZs = "";
									if (Bh5k3tSx.length() > pL2PEUgO.length() + 2)
										j7ZTqxZs = Bh5k3tSx.substring(pL2PEUgO.length() + 2, Bh5k3tSx.length());
									String A5NCvYYu = "";
									YLtU9xvE = getNextLine(jS7ZJYHq);
									if (YLtU9xvE.startsWith("<RegistryNumber>")) {
										CK0JLw9R = "<RegistryNumber>";
										dPPgFWWU = "</RegistryNumber>";
										A5NCvYYu = YLtU9xvE.substring(CK0JLw9R.length(), YLtU9xvE.indexOf(dPPgFWWU));
									}
									Vector LRRfG44w = new Vector();
									String ARkjHbxL = "";
									if (A5NCvYYu.startsWith("EC")) {
										ARkjHbxL = "EC";
										A5NCvYYu = A5NCvYYu.substring(3, A5NCvYYu.length());
									} else {
										ARkjHbxL = "CAS";
									}
									LRRfG44w.add(ARkjHbxL);
									LRRfG44w.add(A5NCvYYu);
									LRRfG44w.add(pL2PEUgO);
									LRRfG44w.add(j7ZTqxZs);
									v4nrxOPy.add(LRRfG44w);
									if (ARkjHbxL.compareTo("CAS") == 0) {
										if (!CvzKcEGY.contains(A5NCvYYu)) {
											CvzKcEGY.add(A5NCvYYu);
											HsGlRZUK.add(LRRfG44w);
										}
									}
								}
								if (YLtU9xvE.startsWith("<ScopeNote>") && SekjJhTR) {
									CK0JLw9R = "<ScopeNote>";
									SoWmOcxN = YLtU9xvE.substring(CK0JLw9R.length(), YLtU9xvE.length());
								}
								if (YLtU9xvE.startsWith("<TermUI>")) {
									YLtU9xvE = getNextLine(jS7ZJYHq);
									CK0JLw9R = "<String>";
									dPPgFWWU = "</String>";
									String Q4wLfLzU = YLtU9xvE.substring(CK0JLw9R.length(), YLtU9xvE.indexOf(dPPgFWWU));
									if (Q4wLfLzU.indexOf("&amp;") != -1) {
										String Y4xQB7Gd = Q4wLfLzU.substring(0, Q4wLfLzU.indexOf("&amp;"));
										String aprP8WAe = Q4wLfLzU.substring(Q4wLfLzU.indexOf("amp;") + 4,
												Q4wLfLzU.length());
										Q4wLfLzU = Y4xQB7Gd + " & " + aprP8WAe;
									}
									if (MNLqN4jU.compareTo(Q4wLfLzU) != 0)
										oEUUrDxt.add(Q4wLfLzU);
								}
								if (YLtU9xvE.startsWith("<PharmacologicalAction>")) {
									YLtU9xvE = getNextLine(jS7ZJYHq);
									YLtU9xvE = getNextLine(jS7ZJYHq);
									CK0JLw9R = "<DescriptorUI>";
									dPPgFWWU = "</DescriptorUI>";
									String xSS4khrY = YLtU9xvE.substring(CK0JLw9R.length(), YLtU9xvE.indexOf(dPPgFWWU));
									Znl9F5Ff.add(xSS4khrY);
								}
								YLtU9xvE = getNextLine(jS7ZJYHq);
								HR9db4Lz = true;
							}
						}
						if (!HR9db4Lz)
							YLtU9xvE = getNextLine(jS7ZJYHq);
					}
					String EulfQ86Y = "";
					QMoMdMeG = "MESHD";
					String nrWECl62 = "0";
					xr17uXMt.write(plGvyekj + "\t" + EulfQ86Y + "\t" + SoWmOcxN + "\t" + QMoMdMeG + "\t");
					xr17uXMt.write(nrWECl62 + "\n");
					String pJ4WfrRS = "";
					String SZXAs5wG = "";
					QMoMdMeG = "MESHD";
					String cDRB4cHu = "0";
					int WvfBu4Ig = 1;
					String JQAxYFOl = MNLqN4jU;
					String TpDsGKPc = "0";
					dKfXTrLO.write(plGvyekj + "\t" + MNLqN4jU + "\t" + pJ4WfrRS + "\t");
					dKfXTrLO.write(SZXAs5wG + "\t" + QMoMdMeG + "\t");
					dKfXTrLO.write(cDRB4cHu + "\t" + WvfBu4Ig + "\t");
					dKfXTrLO.write(JQAxYFOl + "\t" + TpDsGKPc + "\n");
					WvfBu4Ig = 0;
					for (int ZJRMz0xu = 0; ZJRMz0xu < oEUUrDxt.size(); ZJRMz0xu++) {
						MNLqN4jU = (String) oEUUrDxt.get(ZJRMz0xu);
						JQAxYFOl = MNLqN4jU;
						dKfXTrLO.write(plGvyekj + "\t" + MNLqN4jU + "\t" + pJ4WfrRS + "\t");
						dKfXTrLO.write(SZXAs5wG + "\t" + QMoMdMeG + "\t");
						dKfXTrLO.write(cDRB4cHu + "\t" + WvfBu4Ig + "\t");
						dKfXTrLO.write(JQAxYFOl + "\t" + TpDsGKPc + "\n");
					}
					String Y2kf8rfI = "is_r";
					QMoMdMeG = "MESHD";
					String uRtBZSEe = MNLqN4jU;
					for (int Kzmrr7u9 = 0; Kzmrr7u9 < yGTpy0m2.size(); Kzmrr7u9++) {
						String R70xRCMy = (String) yGTpy0m2.get(Kzmrr7u9);
						String W2n3EpGo = (String) twwURXMV.get(R70xRCMy);
						WhONIEWt.write(plGvyekj + "\t" + R70xRCMy + "\t");
						WhONIEWt.write(Y2kf8rfI + "\t" + QMoMdMeG + "\t");
						WhONIEWt.write(uRtBZSEe + "\t" + W2n3EpGo + "\n");
					}
					Y2kf8rfI = "is_a";
					QMoMdMeG = "MESHD";
					yGTpy0m2.clear();
					for (int IGkJW4IA = 0; IGkJW4IA < TsAKzX0a.size(); IGkJW4IA++) {
						String NZaqsHRT = (String) TsAKzX0a.get(IGkJW4IA);
						if (NZaqsHRT.length() > 3)
							NZaqsHRT = NZaqsHRT.substring(0, NZaqsHRT.lastIndexOf("."));
						String IxcgmVcB = (String) iGk5opXb.get(NZaqsHRT);
						if (IxcgmVcB != null)
							yGTpy0m2.add(IxcgmVcB);
						else
							System.out.println(plGvyekj + ": No DUI found for " + NZaqsHRT);
					}
					for (int kCF3toBH = 0; kCF3toBH < yGTpy0m2.size(); kCF3toBH++) {
						String gfw8ryp3 = (String) yGTpy0m2.get(kCF3toBH);
						String TT1xwS1X = (String) twwURXMV.get(gfw8ryp3);
						WhONIEWt.write(plGvyekj + "\t" + gfw8ryp3 + "\t");
						WhONIEWt.write(Y2kf8rfI + "\t" + QMoMdMeG + "\t");
						WhONIEWt.write(uRtBZSEe + "\t" + TT1xwS1X + "\n");
					}
					if (yGTpy0m2.size() == 0)
						System.out.println(plGvyekj + ": No is_a relations");
					Y2kf8rfI = "act";
					QMoMdMeG = "MESHD";
					for (int U4dS5eZn = 0; U4dS5eZn < Znl9F5Ff.size(); U4dS5eZn++) {
						String MEeSc5AH = (String) Znl9F5Ff.get(U4dS5eZn);
						String Ze2URxwT = (String) twwURXMV.get(MEeSc5AH);
						WhONIEWt.write(plGvyekj + "\t" + MEeSc5AH + "\t");
						WhONIEWt.write(Y2kf8rfI + "\t" + QMoMdMeG + "\t");
						WhONIEWt.write(uRtBZSEe + "\t" + Ze2URxwT + "\n");
					}
					String OnsHQl7e = "IMPM";
					String QHL89sq2 = "1.0";
					for (int YkrJoxiA = 0; YkrJoxiA < v4nrxOPy.size(); YkrJoxiA++) {
						Vector NgZxidUk = (Vector) v4nrxOPy.get(YkrJoxiA);
						String Y6YuOdqe = (String) NgZxidUk.get(0);
						String CL8PRao6 = (String) NgZxidUk.get(1);
						if (!DhuC6959.contains(CL8PRao6) && (Y6YuOdqe.compareTo("EC") == 0)) {
							if (CL8PRao6.compareTo("1.14.-") == 0)
								CL8PRao6 = "1.14.-.-";
							else
								System.out.println("MISSING EC: " + CL8PRao6);
						}
						String NRBqEAZl = Y6YuOdqe + ":" + CL8PRao6;
						String KkbyAODQ = plGvyekj + "\t" + NRBqEAZl + "\t" + OnsHQl7e + "\t" + QHL89sq2 + "\n";
						if (Y6YuOdqe.compareTo("CAS") == 0)
							hGt8GhYp.write(KkbyAODQ);
						else
							s8XlHsA1.write(KkbyAODQ);
					}
				} else
					YLtU9xvE = getNextLine(jS7ZJYHq);
			}
			System.out.println("End import descriptors");
			tools.printDate();
			jS7ZJYHq.close();
			xr17uXMt.close();
			dKfXTrLO.close();
			WhONIEWt.close();
			hGt8GhYp.close();
			s8XlHsA1.close();
			cMrxsy2O = sCsuYXJr + "\\cas";
			xr17uXMt = new BufferedWriter(new FileWriter(cMrxsy2O + "_concept.txt"));
			dKfXTrLO = new BufferedWriter(new FileWriter(cMrxsy2O + "_concept_name.txt"));
			BufferedWriter HoewDzhr = new BufferedWriter(new FileWriter(cMrxsy2O + "_concept_acc.txt"));
			for (int DgSNiEqW = 0; DgSNiEqW < HsGlRZUK.size(); DgSNiEqW++) {
				Vector KmpZVcCp = (Vector) HsGlRZUK.get(DgSNiEqW);
				String khPX9yVt = "CAS:" + (String) KmpZVcCp.get(1);
				String tBTTFBiF = (String) KmpZVcCp.get(2);
				String Hle21tKW = "";
				String tuZf0Xsw = (String) KmpZVcCp.get(3);
				String fB0fnZCu = "CAS";
				String lo1vdSOq = "0";
				xr17uXMt.write(khPX9yVt + "\t" + Hle21tKW + "\t" + tuZf0Xsw + "\t");
				xr17uXMt.write(fB0fnZCu + "\t" + lo1vdSOq + "\n");
				String qF6mKU8F = "";
				String XNGgOu3K = "";
				String qTOFvegM = "0";
				String FZciKSU1 = "0";
				String yOnqD5ia = tBTTFBiF;
				String QoAMoezg = "0";
				dKfXTrLO.write(khPX9yVt + "\t" + tBTTFBiF + "\t" + qF6mKU8F + "\t");
				dKfXTrLO.write(XNGgOu3K + "\t" + fB0fnZCu + "\t");
				dKfXTrLO.write(qTOFvegM + "\t" + FZciKSU1 + "\t");
				dKfXTrLO.write(yOnqD5ia + "\t" + QoAMoezg + "\n");
				HoewDzhr.write(khPX9yVt + "\t" + (String) KmpZVcCp.get(1) + "\t");
				HoewDzhr.write(fB0fnZCu + "\n");
			}
			xr17uXMt.close();
			dKfXTrLO.close();
			HoewDzhr.close();
		} catch (Exception E3t1HHu0) {
			settings.writeLog("Error while reading MESH descriptor file: " + E3t1HHu0.getMessage());
		}
	}

}