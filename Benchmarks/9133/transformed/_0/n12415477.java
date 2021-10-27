class n12415477 {
	public ActionForward execute(ActionMapping d0Sa4CJw, ActionForm GcJkv2nh, HttpServletRequest q2jR2GE2,
			HttpServletResponse VbfW49zK) throws Exception {
		String JrtLsmlz = "";
		String sWaTcmjJ = SystemFilesLoader.getInstance().getNewgenlibProperties().getProperty("SYNDETICS", "OFF");
		String MpCN1pu4 = SystemFilesLoader.getInstance().getNewgenlibProperties().getProperty("SYNDETICS_CLIENT_CODE",
				"");
		try {
			if (q2jR2GE2.getSession().getAttribute("searchLimits") != null) {
				System.out.println("searchLimits set");
				JrtLsmlz = "SET";
				java.util.Hashtable WpYlrnR4 = new java.util.Hashtable();
				WpYlrnR4 = (java.util.Hashtable) q2jR2GE2.getSession().getAttribute("searchLimits");
			} else {
				JrtLsmlz = "UNSET";
				System.out.println("searchLimits not set");
			}
			java.util.Properties EVYX2L6t = System.getProperties();
			EVYX2L6t.load(new FileInputStream(ejb.bprocess.util.NewGenLibRoot.getRoot() + java.io.File.separator
					+ "SystemFiles" + java.io.File.separator + "ENV_VAR.txt"));
			System.out
					.println("SEARCH MODE IS " + searchmode + " FILE PATH " + ejb.bprocess.util.NewGenLibRoot.getRoot()
							+ java.io.File.separator + "SystemFiles" + java.io.File.separator + "ENV_VAR.txt");
		} catch (Exception NwRF4PSc) {
		}
		javax.servlet.http.HttpSession NM3oHeOC = q2jR2GE2.getSession();
		String FrgyKEww = "searchView";
		int jmixmMbA = 0, RGOj7zGU = 0;
		java.util.Vector SSCqKOmc = new java.util.Vector();
		aportal.form.cataloguing.SearchViewForm A1TfCoZI = (aportal.form.cataloguing.SearchViewForm) GcJkv2nh;
		A1TfCoZI.setSyndeticsStatus(sWaTcmjJ);
		A1TfCoZI.setSyndeticsClientCode(MpCN1pu4);
		opacHm = (ejb.bprocess.opac.xcql.OPACUtilitiesHome) ejb.bprocess.util.HomeFactory.getInstance()
				.getRemoteHome("OPACUtilities");
		ejb.bprocess.opac.xcql.OPACUtilities d0EebbQr = opacHm.create();
		System.out.println("CLASS NO " + q2jR2GE2.getParameter("ClassNo") + " ClassNoForwarded "
				+ NM3oHeOC.getAttribute("ClassNoForwarded"));
		if (A1TfCoZI.getExportRec() == null || !(A1TfCoZI.getExportRec().equals("export"))) {
			if (q2jR2GE2.getParameter("CatId") != null && q2jR2GE2.getParameter("OwnerId") != null
					&& q2jR2GE2.getParameter("relation") != null && !(NM3oHeOC.getAttribute("HostItemDisplay") != null
							&& NM3oHeOC.getAttribute("HostItemDisplay").toString().equals("false"))) {
				home = (ejb.bprocess.opac.xcql.SearchSRUWCatalogueHome) ejb.bprocess.util.HomeFactory.getInstance()
						.getRemoteHome("SearchSRUWCatalogue");
				ejb.bprocess.opac.xcql.SearchSRUWCatalogue kGdfY2By = home.create();
				String yfpTwIcl = q2jR2GE2.getParameter("CatId");
				String Olu6XdeD = q2jR2GE2.getParameter("OwnerId");
				System.out.println("*********************CatId1: " + yfpTwIcl);
				A1TfCoZI.setCatalogueRecordId(yfpTwIcl);
				A1TfCoZI.setOwnerLibraryId(Olu6XdeD);
				String ARQR6PCS = q2jR2GE2.getParameter("relation");
				java.util.Vector NMYj2Ryd = kGdfY2By.getRelatedCatalogueRecords(null, yfpTwIcl, Olu6XdeD, ARQR6PCS);
				q2jR2GE2.setAttribute("LuceneVector", NMYj2Ryd);
				NM3oHeOC.setAttribute("searchVec", NMYj2Ryd);
				RGOj7zGU = 1;
				NM3oHeOC.setAttribute("HostItemDisplay", "false");
				jmixmMbA = 1;
				FrgyKEww = "searchRes";
				SSCqKOmc.addElement(yfpTwIcl);
				SSCqKOmc.addElement(Olu6XdeD);
			} else if (jmixmMbA == 0 || RGOj7zGU == 1) {
				System.out.println("LINK AND SINGLE LINK " + jmixmMbA + " single " + RGOj7zGU);
				if ((q2jR2GE2.getParameter("ClassNo") != null) && NM3oHeOC.getAttribute("ClassNoForwarded") == null) {
					System.out.println("action called for class no.");
					String F9npcR8P = q2jR2GE2.getParameter("ClassNo");
					System.out.println("TITLE WORDS ");
					home = (ejb.bprocess.opac.xcql.SearchSRUWCatalogueHome) ejb.bprocess.util.HomeFactory.getInstance()
							.getRemoteHome("SearchSRUWCatalogue");
					ejb.bprocess.opac.xcql.SearchSRUWCatalogue X9W84bLj = home.create();
					String rucNkTRi = (new beans.miscellaneous.RequestStringProcessor())
							.processString("*" + F9npcR8P + "*");
					System.out.println("raw search Text" + rucNkTRi);
					String IGuJCw2Z = "classificationNumber=" + rucNkTRi;
					System.out.println("search text is " + IGuJCw2Z);
					String L2hK2zMA = (new org.z3950.zing.cql.CQLParser()).parse(IGuJCw2Z).toXCQL(0);
					java.util.Hashtable wDcBo6Kg = new java.util.Hashtable();
					java.util.Vector dG0RYypU = new java.util.Vector();
					if (NM3oHeOC.getAttribute("searchLimits") != null) {
						wDcBo6Kg = (java.util.Hashtable) NM3oHeOC.getAttribute("searchLimits");
					}
					Vector roNSQoTM = new Vector();
					String S60stKLW = Utility.getInstance().simplifiedSolrQuery(F9npcR8P, "classificationNumber");
					if (JrtLsmlz.equalsIgnoreCase("SET")) {
						String y7UvYEy0 = limitsSolrQuery(wDcBo6Kg);
						S60stKLW += y7UvYEy0;
					}
					S60stKLW += " & ";
					Vector f6AMJbBy = X9W84bLj.processSolrQuery(1, 25, S60stKLW, "245_Tag", "asc");
					Hashtable bf5ICPSb = (Hashtable) f6AMJbBy.get(0);
					String QSKZX8lP = (String) bf5ICPSb.get("HITS");
					NM3oHeOC.setAttribute("TOTALREC", Integer.parseInt(QSKZX8lP));
					dG0RYypU = (Vector) bf5ICPSb.get("RESULTS");
					wDcBo6Kg.put("Query", S60stKLW);
					if (dG0RYypU.size() > 0) {
						wDcBo6Kg.put("searchText", rucNkTRi);
						wDcBo6Kg.put("noOfRecords", 25);
						wDcBo6Kg.put("browseType", "Classification Number");
						NM3oHeOC.setAttribute("searchEntry", wDcBo6Kg);
						NM3oHeOC.setAttribute("searchVec", dG0RYypU);
						FrgyKEww = "searchRes";
					} else {
						FrgyKEww = "home";
					}
				} else {
					System.out.println("ELSE CALLED ");
					String BZT5dvuR = q2jR2GE2.getParameter("record");
					String fxScS4Ho = q2jR2GE2.getParameter("recNo");
					Integer AOunmDOF = 0, mv4x6aFP = 0;
					String CRaKzuv3 = "";
					if (q2jR2GE2.getParameter("CatId") != null && q2jR2GE2.getParameter("OwnerId") != null) {
						AOunmDOF = new Integer(q2jR2GE2.getParameter("CatId")).intValue();
						mv4x6aFP = new Integer(q2jR2GE2.getParameter("OwnerId")).intValue();
						System.out.println("catId is +++=" + AOunmDOF);
						System.out.println("OwnerId is +++=" + mv4x6aFP);
						CRaKzuv3 = q2jR2GE2.getParameter("title");
						A1TfCoZI.setCatalogueRecordId(q2jR2GE2.getParameter("CatId"));
						A1TfCoZI.setOwnerLibraryId(q2jR2GE2.getParameter("OwnerId"));
					}
					System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%VVVVVVVVVVVVVVVVVVVVVV");
					ArrayList vISK8fAc = ((ejb.bprocess.opac.SearchCatalogue) ejb.bprocess.util.HomeFactory
							.getInstance().getHome("SearchCatalogue")).getOtherBooksInTheRack(null, AOunmDOF.toString(),
									mv4x6aFP.toString(), mv4x6aFP.toString());
					System.out.println("alOtherBooks size is  " + vISK8fAc.size());
					Vector fv0pDlVe = new Vector();
					Session QgY30K98 = DBConnector.getInstance().getSession();
					utility = ejb.bprocess.util.Utility.getInstance(QgY30K98);
					for (int rWck5kUG = 0; rWck5kUG < vISK8fAc.size(); rWck5kUG++) {
						String[] qeO6rIRK = (String[]) (vISK8fAc.get(rWck5kUG));
						String JA38dHW2 = qeO6rIRK[0];
						String YEXzJdqD = qeO6rIRK[1];
						System.out.println("catId is +++=" + JA38dHW2);
						System.out.println("OwnerId is +++=" + YEXzJdqD);
						String bTpgcbHr = "";
						String ebyYMZvQ = "";
						String zsIHLk0q = "";
						String KyjZELyi = "";
						String K7BHDlr4 = "";
						if (JA38dHW2 != null && YEXzJdqD != null) {
							try {
								System.out.println("***************************** 0");
								Hashtable c9cY7Vz7 = utility.getCatalogueRecord(new Integer(JA38dHW2),
										new Integer(YEXzJdqD));
								System.out.println("***************************** 1");
								if (c9cY7Vz7 != null && !c9cY7Vz7.isEmpty()) {
									System.out.println("htDetails" + c9cY7Vz7.toString());
									zsIHLk0q = utility.getTestedString(c9cY7Vz7.get("Title"));
									KyjZELyi = utility.getTestedString(c9cY7Vz7.get("Author"));
									K7BHDlr4 = utility.getTestedString(c9cY7Vz7.get("ISBN"));
									String[] SqpGcnuZ = zsIHLk0q.split("/");
									if (SqpGcnuZ.length > 0) {
										ebyYMZvQ = SqpGcnuZ[0];
										if (ebyYMZvQ.length() > 45) {
											ebyYMZvQ = ebyYMZvQ.substring(0, 45) + "...";
										}
									}
									String[] ID849KBW = new String[5];
									ID849KBW[0] = ebyYMZvQ;
									ID849KBW[1] = KyjZELyi;
									ID849KBW[2] = K7BHDlr4;
									ID849KBW[3] = JA38dHW2;
									ID849KBW[4] = YEXzJdqD;
									fv0pDlVe.add(ID849KBW);
									System.out.println("Other Books size is " + fv0pDlVe.size());
								}
							} catch (Exception Zsc0Xsaw) {
								Zsc0Xsaw.printStackTrace();
							}
						}
					}
					System.out.println("Other Books vector is *************************** \n ");
					for (int joQExGlp = 0; joQExGlp < fv0pDlVe.size(); joQExGlp++) {
						String[] orRtrqyf = (String[]) fv0pDlVe.get(joQExGlp);
						System.out.println("title   :" + orRtrqyf[0].toString());
						System.out.println("author  :" + orRtrqyf[1].toString());
						System.out.println("isbn  :" + orRtrqyf[2].toString());
						System.out.println("catID  :" + orRtrqyf[3].toString());
						System.out.println("ownerLibId  :" + orRtrqyf[4].toString());
					}
					System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
					q2jR2GE2.setAttribute("fisheyedata", fv0pDlVe);
					QgY30K98.close();
					NM3oHeOC.setAttribute("SingleViewExport", SSCqKOmc);
					if (NM3oHeOC.getAttribute("OnlySingleRec") != null
							&& NM3oHeOC.getAttribute("OnlySingleRec").toString().equals("true")) {
						java.util.Vector VHAaUf0P = new java.util.Vector();
						System.out.println("SEARCH MODE " + searchmode);
						if (searchmode.equalsIgnoreCase("a")) {
							System.out.println("SEARCHMODE IN SEARCH VIEW ACTION (IF) " + searchmode);
							VHAaUf0P = (java.util.Vector) q2jR2GE2.getAttribute("LuceneVector");
							System.out.println("VECTOR V1 " + VHAaUf0P);
						} else {
							System.out.println("SEARCHMODE IN SEARCH VIEW ACTION (ELSE)" + searchmode);
							VHAaUf0P = (java.util.Vector) NM3oHeOC.getAttribute("searchVec");
						}
						Object[] mI7xtyMF = (Object[]) VHAaUf0P.elementAt(0);
						String edYWGcpP[] = (String[]) mI7xtyMF[0];
						java.util.Hashtable iiFcqP7u = new java.util.Hashtable();
						String l6J93SFh = "";
						iiFcqP7u = (java.util.Hashtable) mI7xtyMF[1];
						System.out.println("HASH TABLE in view action " + iiFcqP7u);
						AOunmDOF = new Integer(edYWGcpP[0]).intValue();
						mv4x6aFP = new Integer(edYWGcpP[1]).intValue();
						CRaKzuv3 = iiFcqP7u.get("TITLE").toString();
						A1TfCoZI.setAttachmentsAndUrl("");
						if ((iiFcqP7u.get("ATTACHMENTS") != null && iiFcqP7u.get("ATTACHMENTS").equals("AVAILABLE"))) {
							A1TfCoZI.setAttachmentsAndUrl("available");
						}
						BZT5dvuR = "full";
						fxScS4Ho = "1";
						NM3oHeOC.removeAttribute("OnlySingleRec");
					}
					if (NM3oHeOC.getAttribute("HostItemDisplay") != null
							&& NM3oHeOC.getAttribute("HostItemDisplay").equals("false")) {
						NM3oHeOC.removeAttribute("HostItemDisplay");
					}
					NM3oHeOC.setAttribute("Title", CRaKzuv3);
					java.util.Hashtable ZvE4VesG = d0EebbQr.getDetailsForSingleCatalogueRecord(AOunmDOF, mv4x6aFP);
					SSCqKOmc.addElement(String.valueOf(AOunmDOF));
					SSCqKOmc.addElement(String.valueOf(mv4x6aFP));
					A1TfCoZI.setAttachmentsAndUrl("");
					if (ZvE4VesG.get("ATTACHMENTS") != null
							&& ZvE4VesG.get("ATTACHMENTS").toString().equals("AVAILABLE")) {
						A1TfCoZI.setAttachmentsAndUrl("available");
					}
					A1TfCoZI.setRecordNo(fxScS4Ho);
					NM3oHeOC.setAttribute("record", BZT5dvuR);
					java.util.Vector nNM7GutQ = (java.util.Vector) NM3oHeOC.getAttribute("CatAndOwner");
					A1TfCoZI.setCatCur(AOunmDOF);
					A1TfCoZI.setOwnerCur(mv4x6aFP);
					A1TfCoZI.setPrevExists("no");
					A1TfCoZI.setNextExists("no");
					if (nNM7GutQ != null) {
						for (int pGHUqXWE = 0; pGHUqXWE < nNM7GutQ.size(); pGHUqXWE = pGHUqXWE + 4) {
							int eqXWGSZi = new Integer(nNM7GutQ.elementAt(pGHUqXWE).toString()).intValue();
							int ZcP7pevY = new Integer(nNM7GutQ.elementAt(pGHUqXWE + 1).toString()).intValue();
							if (eqXWGSZi == AOunmDOF && ZcP7pevY == mv4x6aFP) {
								if (pGHUqXWE != 0) {
									int PhJDEcmj = new Integer(nNM7GutQ.elementAt(pGHUqXWE - 4).toString()).intValue();
									int L65Sm3xq = new Integer(nNM7GutQ.elementAt(pGHUqXWE - 3).toString()).intValue();
									A1TfCoZI.setCatPrev(PhJDEcmj);
									A1TfCoZI.setOwnerPrev(L65Sm3xq);
									A1TfCoZI.setTitlePrev(nNM7GutQ.elementAt(pGHUqXWE - 2).toString());
									A1TfCoZI.setRecPrev(nNM7GutQ.elementAt(pGHUqXWE - 1).toString());
									A1TfCoZI.setPrevExists("yes");
								}
								if (pGHUqXWE < nNM7GutQ.size() - 4) {
									int MmT7YbLv = new Integer(nNM7GutQ.elementAt(pGHUqXWE + 4).toString()).intValue();
									int HKrnIhgL = new Integer(nNM7GutQ.elementAt(pGHUqXWE + 5).toString()).intValue();
									A1TfCoZI.setCatNext(MmT7YbLv);
									A1TfCoZI.setOwnerNext(HKrnIhgL);
									A1TfCoZI.setTitleNext(nNM7GutQ.elementAt(pGHUqXWE + 6).toString());
									A1TfCoZI.setRecNext(nNM7GutQ.elementAt(pGHUqXWE + 7).toString());
									A1TfCoZI.setNextExists("yes");
								}
							}
						}
					}
					String EbeCeUs9[] = (String[]) ZvE4VesG.get("Biblo_Mat");
					int O7p6khBf = new Integer(EbeCeUs9[0]).intValue();
					int DD6EyDoX = new Integer(EbeCeUs9[1]).intValue();
					aportal.view.RecordView U5bfuBoV = new aportal.view.DesignFactory().getCorView(O7p6khBf, DD6EyDoX,
							BZT5dvuR);
					String C5ZtFqnF = "";
					if (O7p6khBf == 3 && DD6EyDoX == 1) {
						C5ZtFqnF = "Book";
					} else if (O7p6khBf == 4 && DD6EyDoX == 1) {
						C5ZtFqnF = "Serial";
					} else if (O7p6khBf == 1 && DD6EyDoX == 1) {
						C5ZtFqnF = "Book Chapter";
					} else if (O7p6khBf == 2 && DD6EyDoX == 1) {
						C5ZtFqnF = "Serial Article";
					} else {
						C5ZtFqnF = ejb.bprocess.util.TypeDefinition.getInstance()
								.getTypeDefinition(String.valueOf(O7p6khBf), String.valueOf(DD6EyDoX));
					}
					java.util.Hashtable kL9VH62J = (java.util.Hashtable) ZvE4VesG.get("MonoGraphRecords");
					java.util.Hashtable Y5trrCrI = U5bfuBoV.getView(ZvE4VesG);
					Y5trrCrI.put("Type", C5ZtFqnF);
					Hashtable sbyNNU3i = (Hashtable) Y5trrCrI.get("NoLink");
					if (sbyNNU3i != null && sbyNNU3i.get("URLS_856") != null) {
						Vector oN768Ljy = (Vector) sbyNNU3i.get("URLS_856");
						if (oN768Ljy.size() > 0) {
							Hashtable OAfqSyFj = new Hashtable();
							Hashtable WxpDTMBi = new Hashtable();
							for (int fUKCPpiI = 0; fUKCPpiI < oN768Ljy.size(); fUKCPpiI += 2) {
								WxpDTMBi.put(oN768Ljy.elementAt(fUKCPpiI), oN768Ljy.elementAt(fUKCPpiI + 1));
							}
							OAfqSyFj.put("URL", WxpDTMBi);
							Y5trrCrI.put("URLS_856", OAfqSyFj);
						}
					}
					try {
						String CNhp2OqY = q2jR2GE2.getSession().getId();
						ejb.bprocess.holdings.HoldingsStatement uZMOqgqi = ((ejb.bprocess.holdings.HoldingsStatementHome) ejb.bprocess.util.HomeFactory
								.getInstance().getRemoteHome("HoldingsStatement")).create();
						java.util.Vector NYn4yk8Z = new java.util.Vector();
						NYn4yk8Z.addElement("1");
						if (NM3oHeOC.getAttribute("Libraries") != null) {
							NYn4yk8Z = (java.util.Vector) NM3oHeOC.getAttribute("Libraries");
						}
						String mRhDnTw9 = "";
						for (int r4SK5lj2 = 0; r4SK5lj2 < NYn4yk8Z.size(); r4SK5lj2++) {
							if (r4SK5lj2 != 0) {
								mRhDnTw9 += ",";
							}
							String whwqNBPL = NYn4yk8Z.elementAt(r4SK5lj2).toString();
							Session qTjrjaqA = DBConnector.getInstance().getSession();
							mRhDnTw9 += ejb.bprocess.util.Utility.getInstance(qTjrjaqA).getLibraryId(whwqNBPL);
							qTjrjaqA.close();
						}
						q2jR2GE2.setAttribute("catRecId", String.valueOf(AOunmDOF));
						q2jR2GE2.setAttribute("ownLibId", String.valueOf(mv4x6aFP));
						q2jR2GE2.setAttribute("libIds", String.valueOf(mRhDnTw9));
						Hashtable lBoo3WTO = new Hashtable();
						JSONObject DRfXdhiC = new JSONObject().put("Id", AOunmDOF).put("LibId", mv4x6aFP);
						ejb.bprocess.opac.SearchCatalogue DeXKibb1 = ((ejb.bprocess.opac.SearchCatalogueHome) ejb.bprocess.util.HomeFactory
								.getInstance().getRemoteHome("SearchCatalogue")).create();
						String jFelAzH6 = DeXKibb1.getAttachmentDetails(DRfXdhiC.toString());
						if (!jFelAzH6.equals("")) {
							JSONObject IJuvthyI = new JSONObject(jFelAzH6);
							if (IJuvthyI != null) {
								if (!IJuvthyI.isNull("BookCover")) {
									ArrayList bKRwXW7K = new ArrayList();
									JSONArray MekOymg2 = (JSONArray) IJuvthyI.get("BookCover");
									if (MekOymg2 != null) {
										for (int hp8rabsu = 0; hp8rabsu < MekOymg2.length(); hp8rabsu++) {
											bKRwXW7K.add(MekOymg2.getString(hp8rabsu));
										}
										lBoo3WTO.put("BookCover", bKRwXW7K);
									}
								}
								if (!IJuvthyI.isNull("TOC")) {
									ArrayList ag3FCfjr = new ArrayList();
									JSONArray WT9PNxgu = (JSONArray) IJuvthyI.get("TOC");
									if (WT9PNxgu != null) {
										for (int HitFLMTk = 0; HitFLMTk < WT9PNxgu.length(); HitFLMTk++) {
											ag3FCfjr.add(WT9PNxgu.getString(HitFLMTk));
										}
										lBoo3WTO.put("TOC", ag3FCfjr);
									}
								}
								if (!IJuvthyI.isNull("Preview")) {
									ArrayList pRMNUChK = new ArrayList();
									JSONArray y8jAQskQ = (JSONArray) IJuvthyI.get("Preview");
									if (y8jAQskQ != null) {
										for (int ki4eBZRu = 0; ki4eBZRu < y8jAQskQ.length(); ki4eBZRu++) {
											pRMNUChK.add(y8jAQskQ.getString(ki4eBZRu));
										}
										lBoo3WTO.put("Preview", pRMNUChK);
									}
								}
								if (!IJuvthyI.isNull("FullView")) {
									ArrayList grWzvns4 = new ArrayList();
									JSONArray FjdH2lDY = (JSONArray) IJuvthyI.get("FullView");
									if (FjdH2lDY != null) {
										for (int FFx8EP1o = 0; FFx8EP1o < FjdH2lDY.length(); FFx8EP1o++) {
											grWzvns4.add(FjdH2lDY.getString(FFx8EP1o));
										}
										lBoo3WTO.put("FullView", grWzvns4);
									}
								}
								if (!IJuvthyI.isNull("Attachment")) {
									ArrayList gzRXhpEH = new ArrayList();
									JSONArray xugm8Rr4 = (JSONArray) IJuvthyI.get("Attachment");
									if (xugm8Rr4 != null) {
										for (int UFpXrsUL = 0; UFpXrsUL < xugm8Rr4.length(); UFpXrsUL++) {
											gzRXhpEH.add(xugm8Rr4.getString(UFpXrsUL));
										}
										lBoo3WTO.put("Attachment", gzRXhpEH);
									}
								}
								if (lBoo3WTO != null && !lBoo3WTO.isEmpty()) {
									Y5trrCrI.put("dAttachment", lBoo3WTO);
								}
							}
						}
						A1TfCoZI.setHashSing(Y5trrCrI);
						System.out.println("hash tabel values*************************");
						Enumeration qj2R9LfW = Y5trrCrI.keys();
						while (qj2R9LfW.hasMoreElements()) {
							String ULQRmkiY = qj2R9LfW.nextElement().toString();
							System.out.println("Key: " + ULQRmkiY + "-----value: " + Y5trrCrI.get(ULQRmkiY));
						}
						System.out.println("********************************************");
					} catch (Exception I4RfJLHL) {
						I4RfJLHL.printStackTrace();
					}
				}
			}
		} else if (A1TfCoZI.getExportRec() != null && A1TfCoZI.getExportRec().equals("export")) {
			A1TfCoZI.setExportRec(null);
			SSCqKOmc = (java.util.Vector) NM3oHeOC.getAttribute("SingleViewExport");
			String eu284xH7 = A1TfCoZI.getSf();
			if (eu284xH7.equals("marc")) {
				String vBtnwJLW = d0EebbQr.getDetailsForMultiRecordViewMARC(SSCqKOmc);
				A1TfCoZI.setDisplayFormat(vBtnwJLW);
				NM3oHeOC.setAttribute("RecordDisplay", vBtnwJLW);
				FrgyKEww = "RecordFormat";
			} else if (eu284xH7.equals("marcXml")) {
				String Xw9OTwjt = d0EebbQr.getDetailsForMultiRecordViewMARCXML(SSCqKOmc);
				A1TfCoZI.setDisplayFormat(Xw9OTwjt);
				VbfW49zK.setContentType("text/xml");
				NM3oHeOC.setAttribute("RecordDisplay", Xw9OTwjt);
				FrgyKEww = "RecordFormat";
			} else if (eu284xH7.equals("mods")) {
				String wYCxbrhD = d0EebbQr.getDetailsForMultiRecordViewMODS(SSCqKOmc);
				A1TfCoZI.setDisplayFormat(wYCxbrhD);
				NM3oHeOC.setAttribute("RecordDisplay", wYCxbrhD);
				FrgyKEww = "RecordFormat";
			} else if (eu284xH7.equals("dc")) {
				String rQKBJ37B = d0EebbQr.getDetailsForMultiRecordViewDublinCore(SSCqKOmc);
				A1TfCoZI.setDisplayFormat(rQKBJ37B);
				NM3oHeOC.setAttribute("RecordDisplay", rQKBJ37B);
				FrgyKEww = "RecordFormat";
			} else if (eu284xH7.equals("agris")) {
				String CcwviDNZ = d0EebbQr.getDetailsForMultiRecordViewAgris(SSCqKOmc);
				A1TfCoZI.setDisplayFormat(CcwviDNZ);
				NM3oHeOC.setAttribute("RecordDisplay", CcwviDNZ);
				FrgyKEww = "RecordFormat";
			} else if (eu284xH7.equals("text")) {
				java.util.Vector oYsbm45T = new java.util.Vector();
				for (int LkVUjtXZ = 0; LkVUjtXZ < SSCqKOmc.size(); LkVUjtXZ = LkVUjtXZ + 2) {
					java.util.Hashtable rtBXW4y7 = d0EebbQr.getDetailsForSingleCatalogueRecord(
							new Integer(SSCqKOmc.elementAt(LkVUjtXZ).toString()).intValue(),
							new Integer(SSCqKOmc.elementAt(LkVUjtXZ + 1).toString()).intValue());
					aportal.view.ISBDView hxUjsb3W = new aportal.view.ISBDView();
					java.util.Hashtable WKADlg1T = hxUjsb3W.getView(rtBXW4y7);
					oYsbm45T.addElement(WKADlg1T);
					FrgyKEww = "RecordFormatText";
				}
				NM3oHeOC.setAttribute("RecordTextDisplay", oYsbm45T);
				if (A1TfCoZI.getPs() != null && A1TfCoZI.getPs().equals("email")) {
					boolean h3YG2Lfa = false;
					if (A1TfCoZI.getEmail() != null && !(A1TfCoZI.getEmail().equals(""))) {
						String pc7rnM1X = A1TfCoZI.getEmail();
						try {
							String GjW9ZUX1 = q2jR2GE2.getSession().getId();
							java.net.URL MXxjVT1A = new java.net.URL("http://localhost:" + q2jR2GE2.getServerPort()
									+ "/newgenlibctxt/jsp/aportal/cataloguing/RecordDisplayText.jsp;jsessionid="
									+ GjW9ZUX1);
							java.net.URLConnection L9YeiLfg = MXxjVT1A.openConnection();
							java.io.InputStream Gu1kwI7L = L9YeiLfg.getInputStream();
							String LSfOo3Ai = "";
							java.io.BufferedReader RjhygHG1 = new java.io.BufferedReader(
									new java.io.InputStreamReader(Gu1kwI7L));
							String ybOuVF1X = "";
							while ((ybOuVF1X = RjhygHG1.readLine()) != null) {
								LSfOo3Ai = LSfOo3Ai + ybOuVF1X;
							}
							String[] ckvp3xYL = { pc7rnM1X };
							int jg1VX3Vs = SendEmail.getInstance().sendMail(ckvp3xYL, "OPAC results", LSfOo3Ai, "html");
							if (jg1VX3Vs == 0)
								h3YG2Lfa = true;
							else
								h3YG2Lfa = false;
						} catch (Exception Zvhu8UB3) {
							Zvhu8UB3.printStackTrace();
						}
					}
					String i3Iz9xNh = "The selected records have been successfully mailed to " + A1TfCoZI.getEmail();
					if (h3YG2Lfa == false) {
						i3Iz9xNh = "<h4><p>The selected records could not be mailed to " + A1TfCoZI.getEmail()
								+ "&nbsp; These might be the possible reasons.</p></h4>"
								+ "<h5><ol> <li>The email id entered is not a valid one</font></li>"
								+ "<li>The email id domain might not be in the list of allowed  recipient&nbsp; hosts</li>"
								+ "<li>There might a error in connectivity to the mail server</li></ol></h5>"
								+ "<h4><p>Please contact the  Network Administrator </p></h4>";
					}
					NM3oHeOC.setAttribute("MailStatus", i3Iz9xNh);
					FrgyKEww = "SendEmail";
				}
			}
		}
		String eJnwnl36 = ejb.bprocess.util.StaticValues.getInstance().getVersion();
		if (eJnwnl36 != null && !eJnwnl36.equals("")) {
			A1TfCoZI.setVersion(eJnwnl36);
		}
		if (NM3oHeOC.getAttribute("ClassNoForwarded") != null) {
			NM3oHeOC.removeAttribute("ClassNoForwarded");
		}
		return d0Sa4CJw.findForward(FrgyKEww);
	}

}