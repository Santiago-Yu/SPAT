class n7005223 {
	public void checkFilesAndCopyValid(String psf95ygn) {
		downloadResults();
		loadResults();
		File CLRZMsWP = new File(tmpFolder);
		deleteFileFromTMPFolder(CLRZMsWP);
		ZipReader K6AWoszy = new ZipReader();
		K6AWoszy.UnzipFile(psf95ygn);
		try {
			LogManager.getInstance().log("Ov??uji odevzdan? soubory a kop?ruji validovan?:");
			LogManager.getInstance().log("");
			JAXBElement<?> quSiNJuk = ElementJAXB.getJAXBElement();
			Ppa1VysledkyCviceniType kTIRRnp3 = (Ppa1VysledkyCviceniType) quSiNJuk.getValue();
			File GHbBU5bM = new File(tmpFolder).listFiles()[0].listFiles()[0].listFiles()[0];
			File[] WQ8WvCa6 = GHbBU5bM.listFiles();
			for (File qJvn06WZ : WQ8WvCa6) {
				if (qJvn06WZ.isDirectory()) {
					String bDl4FGMg = qJvn06WZ.getName().split("-")[0];
					LogManager.getInstance().changeLog("Prov??ov?n? soubor? studenta s ??slem: " + bDl4FGMg);
					List<StudentType> L4DOnH1h = (List<StudentType>) kTIRRnp3.getStudent();
					for (StudentType u6zM4Q55 : L4DOnH1h) {
						if (u6zM4Q55.getOsobniCislo().equals(bDl4FGMg)) {
							int ysXlKvJG = u6zM4Q55.getDomaciUlohy().getPosledniZpracovanyPokus().getCislo().intValue();
							DomaciUlohyType JEIJ5h7i = u6zM4Q55.getDomaciUlohy();
							ChybneOdevzdaneType d5JcAdoR = JEIJ5h7i.getChybneOdevzdane();
							ObjectFactory l4EyoJmU = new ObjectFactory();
							File[] HjXZOQrk = qJvn06WZ.listFiles();
							NodeList BeF6XzZg = result.getElementsByTagName("soubor");
							int se75vPjz = BeF6XzZg.getLength() - 1;
							boolean gQoitdus = false;
							for (int S5zvKnLj = (HjXZOQrk.length - 1); S5zvKnLj >= 0; S5zvKnLj--) {
								if ((HjXZOQrk[S5zvKnLj].isDirectory()) && (ysXlKvJG < Integer
										.parseInt(HjXZOQrk[S5zvKnLj].getName().split("_")[1].trim()))) {
									File hbcVUOcE = HjXZOQrk[S5zvKnLj].listFiles()[0];
									if ((hbcVUOcE.exists()) && (hbcVUOcE.isFile())) {
										String[] pS9AYnmL = hbcVUOcE.getName().split("_");
										String HCaT6mVL = "", UZSYnhtO = "";
										String[] rfFFguev = null;
										if (pS9AYnmL.length == 4) {
											rfFFguev = pS9AYnmL[3].split("[.]");
											HCaT6mVL = rfFFguev[0];
											if (rfFFguev.length <= 1)
												UZSYnhtO = "";
											else
												UZSYnhtO = rfFFguev[1];
										}
										String GGH0PcTU = Konfigurace.getInstance().getSamostatnaPraceNazev();
										List<SouborType> KtU8WVGX = d5JcAdoR.getSoubor();
										if (hbcVUOcE.getName().startsWith(GGH0PcTU)) {
											gQoitdus = true;
										} else {
											gQoitdus = false;
											if (pS9AYnmL.length != 4) {
												SouborType wuC8viBF = new SouborType();
												wuC8viBF.setJmeno(hbcVUOcE.getName());
												wuC8viBF.setDuvod("?patn? struktura jm?na souboru.");
												KtU8WVGX.add(wuC8viBF);
												continue;
											} else if (!hbcVUOcE.getName().startsWith("Ppa1_cv")) {
												SouborType SBcjfFEQ = new SouborType();
												SBcjfFEQ.setJmeno(hbcVUOcE.getName());
												SBcjfFEQ.setDuvod("?patn? za??tek jm?na souboru.");
												KtU8WVGX.add(SBcjfFEQ);
												continue;
											} else if (!UZSYnhtO.equals("java")) {
												SouborType JHLWMQxm = new SouborType();
												JHLWMQxm.setJmeno(hbcVUOcE.getName());
												JHLWMQxm.setDuvod("?patn? p??pona souboru.");
												KtU8WVGX.add(JHLWMQxm);
												continue;
											} else if (!HCaT6mVL.equals(bDl4FGMg)) {
												SouborType kejEM2Ik = new SouborType();
												kejEM2Ik.setJmeno(hbcVUOcE.getName());
												kejEM2Ik.setDuvod("Nesouhlas? osobn? ??sla.");
												KtU8WVGX.add(kejEM2Ik);
												continue;
											} else if (pS9AYnmL[3].split("[.]").length > 2) {
												SouborType S0B6EytP = new SouborType();
												S0B6EytP.setJmeno(hbcVUOcE.getName());
												S0B6EytP.setDuvod("V?ce p??pon souboru.");
												KtU8WVGX.add(S0B6EytP);
												continue;
											} else {
												long hFobDWEj, y4yZHix4;
												try {
													if (pS9AYnmL[1].length() == 4) {
														String DCrDu9qQ = pS9AYnmL[1].substring(2);
														long HT9HARVT = Long.parseLong(DCrDu9qQ);
														hFobDWEj = HT9HARVT;
													} else {
														throw new NumberFormatException();
													}
												} catch (NumberFormatException AQ422jB2) {
													SouborType t0BxC2vM = new SouborType();
													t0BxC2vM.setJmeno(hbcVUOcE.getName());
													t0BxC2vM.setDuvod("Chyb? (nebo je chybn?) ??slo cvi?en?");
													KtU8WVGX.add(t0BxC2vM);
													continue;
												}
												try {
													if (pS9AYnmL[2].length() > 0) {
														String jIqJUXKP = pS9AYnmL[2];
														long DwaKTqi1 = Long.parseLong(jIqJUXKP);
														y4yZHix4 = DwaKTqi1;
													} else {
														throw new NumberFormatException();
													}
												} catch (NumberFormatException wxsYZcAq) {
													SouborType pKJ6CqdZ = new SouborType();
													pKJ6CqdZ.setJmeno(hbcVUOcE.getName());
													pKJ6CqdZ.setDuvod("Chyb? (nebo je chybn?) ??slo ?lohy");
													KtU8WVGX.add(pKJ6CqdZ);
													continue;
												}
												CislaUloh Lgut9InB = new CislaUloh();
												List<long[]> uSjw6UDZ = Lgut9InB.getSeznamCviceni();
												boolean dfkHK7mj = false, tvIrzlxl = false;
												for (long[] UkWYl8sA : uSjw6UDZ) {
													if (UkWYl8sA[0] == hFobDWEj) {
														for (int TCCuByLE = 1; TCCuByLE < UkWYl8sA.length; TCCuByLE++) {
															if (UkWYl8sA[TCCuByLE] == y4yZHix4) {
																tvIrzlxl = true;
																break;
															}
														}
														dfkHK7mj = true;
														break;
													}
												}
												if (!dfkHK7mj) {
													SouborType d48uVySI = new SouborType();
													d48uVySI.setJmeno(hbcVUOcE.getName());
													d48uVySI.setDuvod("Neplatn? ??slo cvi?en?");
													KtU8WVGX.add(d48uVySI);
													continue;
												}
												if (!tvIrzlxl) {
													SouborType cYVSlyPv = new SouborType();
													cYVSlyPv.setJmeno(hbcVUOcE.getName());
													cYVSlyPv.setDuvod("Neplatn? ??slo ?lohy");
													KtU8WVGX.add(cYVSlyPv);
													continue;
												}
											}
										}
									}
									Calendar BdzLlVRu = null;
									File wmnbbEqM = new File(psf95ygn);
									if (wmnbbEqM.exists()) {
										String[] QLVqLFFN = wmnbbEqM.getName().split("_");
										if (QLVqLFFN.length >= 3) {
											String[] oYbweEIP = QLVqLFFN[1].split("-"),
													SWxrC8cj = QLVqLFFN[2].split("-");
											BdzLlVRu = new GregorianCalendar();
											BdzLlVRu.set(Integer.parseInt(oYbweEIP[0]),
													Integer.parseInt(oYbweEIP[1]) - 1, Integer.parseInt(oYbweEIP[2]),
													Integer.parseInt(SWxrC8cj[0]), Integer.parseInt(SWxrC8cj[1]), 0);
										}
									}
									boolean sDrpJzu4 = false;
									String eOxHXpen = "";
									for (int pPsnNlqE = se75vPjz; pPsnNlqE >= 0; pPsnNlqE--) {
										NodeList IpaEIxFK = BeF6XzZg.item(pPsnNlqE).getChildNodes();
										for (int YTglH2tP = 0; YTglH2tP < IpaEIxFK.getLength(); YTglH2tP++) {
											if (IpaEIxFK.item(YTglH2tP).getNodeName().equals("cas")) {
												String[] NNV7kImH = IpaEIxFK.item(YTglH2tP).getTextContent().split(" ");
												String[] pyTZe5rV = NNV7kImH[0].split("-"),
														Oueliy77 = NNV7kImH[1].split("-");
												Calendar SAvWNUGq = new GregorianCalendar();
												SAvWNUGq.set(Integer.parseInt(pyTZe5rV[0]),
														Integer.parseInt(pyTZe5rV[1]) - 1,
														Integer.parseInt(pyTZe5rV[2]), Integer.parseInt(Oueliy77[0]),
														Integer.parseInt(Oueliy77[1]), Integer.parseInt(Oueliy77[2]));
												if ((BdzLlVRu != null) && (SAvWNUGq.compareTo(BdzLlVRu) > 0)) {
													sDrpJzu4 = false;
													break;
												}
											}
											if (IpaEIxFK.item(YTglH2tP).getNodeName().equals("nazev")) {
												sDrpJzu4 = IpaEIxFK.item(YTglH2tP).getTextContent()
														.equals(hbcVUOcE.getName());
											}
											if (IpaEIxFK.item(YTglH2tP).getNodeName().equals("vysledek")) {
												eOxHXpen = IpaEIxFK.item(YTglH2tP).getTextContent();
											}
										}
										if (sDrpJzu4) {
											se75vPjz = --pPsnNlqE;
											break;
										}
									}
									if (sDrpJzu4 && !gQoitdus) {
										boolean xAbnSbpH = false;
										String dvoKzUQn = hbcVUOcE.getName().split("_")[1].substring(2);
										int PcrjuiFR = Integer.parseInt(dvoKzUQn);
										String DtoyuPex = hbcVUOcE.getName().split("_")[2];
										int NWo33eT0 = Integer.parseInt(DtoyuPex);
										List<CviceniType> WxZkbgUL = u6zM4Q55.getDomaciUlohy().getCviceni();
										for (CviceniType vA1HuBAr : WxZkbgUL) {
											if (vA1HuBAr.getCislo().intValue() == PcrjuiFR) {
												MezniTerminOdevzdaniVcasType c0gvk4Of = vA1HuBAr
														.getMezniTerminOdevzdaniVcas();
												Calendar RiwkBDgL = new GregorianCalendar();
												RiwkBDgL.set(c0gvk4Of.getDatum().getYear(),
														c0gvk4Of.getDatum().getMonth() - 1,
														c0gvk4Of.getDatum().getDay(), 23, 59, 59);
												Calendar APhwCn6F = new GregorianCalendar();
												APhwCn6F.setTimeInMillis(hbcVUOcE.lastModified());
												String[] GjfS5I6R = String.format("%tF", APhwCn6F).split("-");
												String[] EfvxGcQV = String.format("%tT", APhwCn6F).split(":");
												XMLGregorianCalendar yPJX6zFe = DatatypeFactory.newInstance()
														.newXMLGregorianCalendarDate(Integer.parseInt(GjfS5I6R[0]),
																Integer.parseInt(GjfS5I6R[1]),
																Integer.parseInt(GjfS5I6R[2]),
																DatatypeConstants.FIELD_UNDEFINED);
												XMLGregorianCalendar hy47XscY = DatatypeFactory.newInstance()
														.newXMLGregorianCalendarTime(Integer.parseInt(EfvxGcQV[0]),
																Integer.parseInt(EfvxGcQV[1]),
																Integer.parseInt(EfvxGcQV[2]),
																DatatypeConstants.FIELD_UNDEFINED);
												if (APhwCn6F.compareTo(RiwkBDgL) <= 0)
													xAbnSbpH = true;
												else
													xAbnSbpH = false;
												List<UlohaType> T6hbKMSq = vA1HuBAr.getUloha();
												for (UlohaType swkEtxxR : T6hbKMSq) {
													if (swkEtxxR.getCislo().intValue() == NWo33eT0) {
														List<OdevzdanoType> jgGjXoOB = swkEtxxR.getOdevzdano();
														OdevzdanoType sqy7LvKo = l4EyoJmU.createOdevzdanoType();
														sqy7LvKo.setDatum(yPJX6zFe);
														sqy7LvKo.setCas(hy47XscY);
														OdevzdanoVcasType H7AzVLUT = l4EyoJmU.createOdevzdanoVcasType();
														H7AzVLUT.setVysledek(xAbnSbpH);
														ValidatorType SezhUQYj = l4EyoJmU.createValidatorType();
														SezhUQYj.setVysledek(eOxHXpen.equals("true"));
														sqy7LvKo.setOdevzdanoVcas(H7AzVLUT);
														sqy7LvKo.setValidator(SezhUQYj);
														jgGjXoOB.add(sqy7LvKo);
														if (SezhUQYj.isVysledek()) {
															String iByBsOWx = String.format("%s%s%02d", validovane,
																	File.separator, vA1HuBAr.getCislo().intValue());
															if (!(new File(iByBsOWx).exists())) {
																LogManager.getInstance().log(
																		"Nebyla provedena p??prava soubor?. Chyb? slo?ka "
																				+ iByBsOWx.substring(
																						Ppa1Cviceni.USER_DIR.length())
																				+ ".");
																return;
															} else {
																copyValidFile(hbcVUOcE, vA1HuBAr.getCislo().intValue());
															}
														}
														break;
													}
												}
												break;
											}
										}
									} else if (sDrpJzu4 && gQoitdus) {
										String[] divzb3C8 = hbcVUOcE.getName().split("_");
										String[] odfRSbbD = divzb3C8[divzb3C8.length - 1].split("[.]");
										String Jq3p4Kft = odfRSbbD[0];
										String HkKWF03n = odfRSbbD[odfRSbbD.length - 1];
										if ((odfRSbbD.length == 2) && (HkKWF03n.equals("java"))) {
											if (u6zM4Q55.getOsobniCislo().equals(Jq3p4Kft)) {
												Calendar t2rwY3gI = new GregorianCalendar();
												t2rwY3gI.setTimeInMillis(hbcVUOcE.lastModified());
												String[] a4Dkp6KC = String.format("%tF", t2rwY3gI).split("-");
												String[] tHOB4Dmo = String.format("%tT", t2rwY3gI).split(":");
												XMLGregorianCalendar G6kkfsqy = DatatypeFactory.newInstance()
														.newXMLGregorianCalendarDate(Integer.parseInt(a4Dkp6KC[0]),
																Integer.parseInt(a4Dkp6KC[1]),
																Integer.parseInt(a4Dkp6KC[2]),
																DatatypeConstants.FIELD_UNDEFINED);
												XMLGregorianCalendar Rb35ZFa2 = DatatypeFactory.newInstance()
														.newXMLGregorianCalendarTime(Integer.parseInt(tHOB4Dmo[0]),
																Integer.parseInt(tHOB4Dmo[1]),
																Integer.parseInt(tHOB4Dmo[2]),
																DatatypeConstants.FIELD_UNDEFINED);
												List<UlozenoType> f3InoTGW = u6zM4Q55.getSamostatnaPrace().getUlozeno();
												if (f3InoTGW.isEmpty()) {
													File LPhMK6it = new File(sp + File.separator + hbcVUOcE.getName());
													if (LPhMK6it.exists()) {
														LPhMK6it.delete();
														LPhMK6it.createNewFile();
													}
													String T9MrFgrg = "" + (char) 0x0D + (char) 0x0A;
													FileReader cFFuQQD3 = new FileReader(hbcVUOcE);
													BufferedReader mTEdwYlF = new BufferedReader(cFFuQQD3);
													FileWriter ndl0B3tx = new FileWriter(LPhMK6it);
													String VxHZoJPX;
													while ((VxHZoJPX = mTEdwYlF.readLine()) != null)
														ndl0B3tx.write(VxHZoJPX + T9MrFgrg);
													mTEdwYlF.close();
													ndl0B3tx.close();
													LPhMK6it.setLastModified(hbcVUOcE.lastModified());
												}
												UlozenoType AWCGu7gz = l4EyoJmU.createUlozenoType();
												AWCGu7gz.setDatum(G6kkfsqy);
												AWCGu7gz.setCas(Rb35ZFa2);
												f3InoTGW.add(0, AWCGu7gz);
											}
										}
									}
								}
							}
							PosledniZpracovanyPokusType jgaA5SAg = new PosledniZpracovanyPokusType();
							String[] Bdxwxvz4 = HjXZOQrk[HjXZOQrk.length - 1].getName().split("_");
							int QfGuQKIz = Integer.parseInt(Bdxwxvz4[Bdxwxvz4.length - 1].trim());
							jgaA5SAg.setCislo(new BigInteger(String.valueOf(QfGuQKIz)));
							u6zM4Q55.getDomaciUlohy().setPosledniZpracovanyPokus(jgaA5SAg);
							break;
						}
					}
				}
			}
			ElementJAXB.setJAXBElement(quSiNJuk);
			LogManager.getInstance().log("Ov??ov?n? a kop?rov?n? odevzdan?ch soubor? dokon?eno.");
		} catch (FileNotFoundException wWY7szh2) {
			wWY7szh2.printStackTrace();
			LogManager.getInstance().log("Nastala chyba p?i ov??ov?n? a kop?rov?n?.");
		} catch (DatatypeConfigurationException SxxrWZTW) {
			SxxrWZTW.printStackTrace();
			LogManager.getInstance().log("Nastala chyba p?i ov??ov?n? a kop?rov?n?.");
		} catch (IOException UsVzm0ay) {
			UsVzm0ay.printStackTrace();
			LogManager.getInstance().log("Nastala chyba p?i ov??ov?n? a kop?rov?n?.");
		}
		LogManager.getInstance().log("Maz?n? rozbalen?ch soubor? ...");
		deleteFileFromTMPFolder(CLRZMsWP);
		LogManager.getInstance().changeLog("Maz?n? rozbalen?ch soubor? ... OK");
	}

}