class n4494367 {
	@Override
	public ActionForward execute(ActionMapping BtcjGuxA, ActionForm X00qtAUM, HttpServletRequest Ldp2uVQ8,
			HttpServletResponse m1QG8shr) throws Exception {
		String KwZc8Y99 = Ldp2uVQ8.getParameter("Id");
		String fbMCUHaB = Ldp2uVQ8.getParameter("LibId");
		System.out.println("********************************printing starts here***************************");
		Enumeration pnhPy6VX = Ldp2uVQ8.getAttributeNames();
		while (pnhPy6VX.hasMoreElements()) {
			String A5D2tzRA = pnhPy6VX.nextElement().toString();
			System.out.println("REQ ATTR" + A5D2tzRA + "------" + Ldp2uVQ8.getAttribute(A5D2tzRA));
		}
		pnhPy6VX = Ldp2uVQ8.getSession().getAttributeNames();
		while (pnhPy6VX.hasMoreElements()) {
			String Q292VFQU = pnhPy6VX.nextElement().toString();
			System.out.println("SESS ATTR" + Q292VFQU + "------" + Ldp2uVQ8.getSession().getAttribute(Q292VFQU));
		}
		pnhPy6VX = Ldp2uVQ8.getParameterNames();
		while (pnhPy6VX.hasMoreElements()) {
			String ZUgsazIl = pnhPy6VX.nextElement().toString();
			System.out.println("REQ PARAM" + ZUgsazIl + "------" + Ldp2uVQ8.getParameter(ZUgsazIl));
		}
		System.out.println("********************************printing ends here***************************");
		String DZyLvMy1 = "";
		try {
			if (Ldp2uVQ8.getSession().getAttribute("searchLimits") != null) {
				System.out.println("searchLimits set");
				DZyLvMy1 = "SET";
				java.util.Hashtable IvSobkvF = new java.util.Hashtable();
				IvSobkvF = (java.util.Hashtable) Ldp2uVQ8.getSession().getAttribute("searchLimits");
			} else {
				DZyLvMy1 = "UNSET";
				System.out.println("searchLimits not set");
			}
			java.util.Properties SvO5vFjh = System.getProperties();
			SvO5vFjh.load(new FileInputStream(ejb.bprocess.util.NewGenLibRoot.getRoot() + java.io.File.separator
					+ "SystemFiles" + java.io.File.separator + "ENV_VAR.txt"));
			System.out
					.println("SEARCH MODE IS " + searchmode + " FILE PATH " + ejb.bprocess.util.NewGenLibRoot.getRoot()
							+ java.io.File.separator + "SystemFiles" + java.io.File.separator + "ENV_VAR.txt");
		} catch (Exception mXYzryv5) {
		}
		javax.servlet.http.HttpSession uNBKEySq = Ldp2uVQ8.getSession();
		uNBKEySq.setAttribute("totalPages", "1");
		uNBKEySq.setAttribute("formOfRec", "");
		String guUw1dKi = "singleRecordView";
		int imCzanWt = 0, fYsrrf8F = 0;
		java.util.Vector Nm1dTFIY = new java.util.Vector();
		aportal.form.cataloguing.SingleRecordForm y2DiuDpz = (aportal.form.cataloguing.SingleRecordForm) X00qtAUM;
		opacHm = (ejb.bprocess.opac.xcql.OPACUtilitiesHome) ejb.bprocess.util.HomeFactory.getInstance()
				.getRemoteHome("OPACUtilities");
		ejb.bprocess.opac.xcql.OPACUtilities CAU9PyM9 = opacHm.create();
		System.out.println("CLASS NO " + Ldp2uVQ8.getParameter("ClassNo") + " ClassNoForwarded "
				+ uNBKEySq.getAttribute("ClassNoForwarded"));
		if (y2DiuDpz.getExportRec() == null || !(y2DiuDpz.getExportRec().equals("export"))) {
			System.out.println("*************************************************************************** 1");
			if (KwZc8Y99 != null && fbMCUHaB != null && Ldp2uVQ8.getParameter("relation") != null
					&& !(uNBKEySq.getAttribute("HostItemDisplay") != null
							&& uNBKEySq.getAttribute("HostItemDisplay").toString().equals("false"))) {
				System.out.println("*************************************************************************** 2");
				home = (ejb.bprocess.opac.xcql.SearchSRUWCatalogueHome) ejb.bprocess.util.HomeFactory.getInstance()
						.getRemoteHome("SearchSRUWCatalogue");
				ejb.bprocess.opac.xcql.SearchSRUWCatalogue lYhxXuxt = home.create();
				String Ju6od8k5 = KwZc8Y99;
				String HZMfD0q4 = fbMCUHaB;
				System.out.println("*********************CatId1: " + Ju6od8k5);
				y2DiuDpz.setCatalogueRecordId(Ju6od8k5);
				y2DiuDpz.setOwnerLibraryId(HZMfD0q4);
				String dr6lLMiV = Ldp2uVQ8.getParameter("relation");
				java.util.Vector qCtarEk9 = lYhxXuxt.getRelatedCatalogueRecords(null, Ju6od8k5, HZMfD0q4, dr6lLMiV);
				Ldp2uVQ8.setAttribute("LuceneVector", qCtarEk9);
				uNBKEySq.setAttribute("searchVec", qCtarEk9);
				fYsrrf8F = 1;
				uNBKEySq.setAttribute("HostItemDisplay", "false");
				imCzanWt = 1;
				guUw1dKi = "searchRes";
				Nm1dTFIY.addElement(Ju6od8k5);
				Nm1dTFIY.addElement(HZMfD0q4);
			} else if (imCzanWt == 0 || fYsrrf8F == 1) {
				System.out.println("*************************************************************************** 3");
				System.out.println("LINK AND SINGLE LINK " + imCzanWt + " single " + fYsrrf8F);
				if ((Ldp2uVQ8.getParameter("ClassNo") != null) && uNBKEySq.getAttribute("ClassNoForwarded") == null) {
					System.out.println("*************************************************************************** 4");
					System.out.println("action called for class no.");
					String k0KYtH6l = Ldp2uVQ8.getParameter("ClassNo");
					System.out.println("TITLE WORDS ");
					home = (ejb.bprocess.opac.xcql.SearchSRUWCatalogueHome) ejb.bprocess.util.HomeFactory.getInstance()
							.getRemoteHome("SearchSRUWCatalogue");
					ejb.bprocess.opac.xcql.SearchSRUWCatalogue x7vKxfef = home.create();
					String z4fvwnZF = (new beans.miscellaneous.RequestStringProcessor())
							.processString("*" + k0KYtH6l + "*");
					System.out.println("raw search Text" + z4fvwnZF);
					String XhA3zZOi = "classificationNumber=" + z4fvwnZF;
					System.out.println("search text is " + XhA3zZOi);
					String hghC9GqE = (new org.z3950.zing.cql.CQLParser()).parse(XhA3zZOi).toXCQL(0);
					java.util.Hashtable lmSBXUAW = new java.util.Hashtable();
					java.util.Vector MutsDWEX = new java.util.Vector();
					if (uNBKEySq.getAttribute("searchLimits") != null) {
						System.out.println(
								"*************************************************************************** 5");
						lmSBXUAW = (java.util.Hashtable) uNBKEySq.getAttribute("searchLimits");
					}
					Vector qKkl2NJO = new Vector();
					String P7PI5yRS = Utility.getInstance().simplifiedSolrQuery(k0KYtH6l, "classificationNumber");
					if (DZyLvMy1.equalsIgnoreCase("SET")) {
						System.out.println(
								"*************************************************************************** 6");
						String EGKPUbaH = limitsSolrQuery(lmSBXUAW);
						P7PI5yRS += EGKPUbaH;
					}
					P7PI5yRS += " & ";
					Vector O9REEKJF = x7vKxfef.processSolrQuery(1, 25, P7PI5yRS, "245_Tag", "asc");
					Hashtable mhGJYqPO = (Hashtable) O9REEKJF.get(0);
					String O8qrFMSr = (String) mhGJYqPO.get("HITS");
					uNBKEySq.setAttribute("TOTALREC", Integer.parseInt(O8qrFMSr));
					MutsDWEX = (Vector) mhGJYqPO.get("RESULTS");
					lmSBXUAW.put("Query", P7PI5yRS);
					if (MutsDWEX.size() > 0) {
						System.out.println(
								"*************************************************************************** 7");
						lmSBXUAW.put("searchText", z4fvwnZF);
						lmSBXUAW.put("noOfRecords", 25);
						lmSBXUAW.put("browseType", "Classification Number");
						uNBKEySq.setAttribute("searchEntry", lmSBXUAW);
						uNBKEySq.setAttribute("searchVec", MutsDWEX);
						guUw1dKi = "searchRes";
					} else {
						System.out.println(
								"*************************************************************************** 8");
						guUw1dKi = "home";
					}
				} else {
					System.out.println("*************************************************************************** 9");
					System.out.println("ELSE CALLED ");
					String F8YXsmH8 = Ldp2uVQ8.getParameter("record");
					String vxC55kU9 = Ldp2uVQ8.getParameter("recNo");
					int ASa03P8F = 0, Xe5yWEtr = 0;
					String Kyd7A0XM = "";
					if (KwZc8Y99 != null && fbMCUHaB != null) {
						System.out.println(
								"*************************************************************************** 10");
						ASa03P8F = new Integer(KwZc8Y99).intValue();
						Xe5yWEtr = new Integer(fbMCUHaB).intValue();
						Kyd7A0XM = "title";
						y2DiuDpz.setCatalogueRecordId(KwZc8Y99);
						y2DiuDpz.setOwnerLibraryId(fbMCUHaB);
					}
					uNBKEySq.setAttribute("SingleViewExport", Nm1dTFIY);
					if (uNBKEySq.getAttribute("OnlySingleRec") != null
							&& uNBKEySq.getAttribute("OnlySingleRec").toString().equals("true")) {
						System.out.println(
								"*************************************************************************** 11");
						java.util.Vector HD8APOrz = new java.util.Vector();
						System.out.println("SEARCH MODE " + searchmode);
						if (searchmode.equalsIgnoreCase("a")) {
							System.out.println(
									"*************************************************************************** 12");
							System.out.println("SEARCHMODE IN SEARCH VIEW ACTION (IF) " + searchmode);
							HD8APOrz = (java.util.Vector) Ldp2uVQ8.getAttribute("LuceneVector");
							System.out.println("VECTOR V1 " + HD8APOrz);
						} else {
							System.out.println(
									"*************************************************************************** 13");
							System.out.println("SEARCHMODE IN SEARCH VIEW ACTION (ELSE)" + searchmode);
							HD8APOrz = (java.util.Vector) uNBKEySq.getAttribute("searchVec");
						}
						Object[] wYyW2VNE = (Object[]) HD8APOrz.elementAt(0);
						String fBK0Sk93[] = (String[]) wYyW2VNE[0];
						java.util.Hashtable JeFSc3Yj = new java.util.Hashtable();
						String Ves8hq03 = "";
						JeFSc3Yj = (java.util.Hashtable) wYyW2VNE[1];
						System.out.println("HASH TABLE in view action " + JeFSc3Yj);
						ASa03P8F = new Integer(fBK0Sk93[0]).intValue();
						Xe5yWEtr = new Integer(fBK0Sk93[1]).intValue();
						Kyd7A0XM = JeFSc3Yj.get("TITLE").toString();
						y2DiuDpz.setAttachmentsAndUrl("");
						if ((JeFSc3Yj.get("URL").toString() != null
								&& JeFSc3Yj.get("URL").toString().equals("AVAILABLE"))
								|| (JeFSc3Yj.get("ATTACHMENTS") != null
										&& JeFSc3Yj.get("ATTACHMENTS").equals("AVAILABLE"))) {
							System.out.println(
									"*************************************************************************** 14");
							y2DiuDpz.setAttachmentsAndUrl("available");
						}
						F8YXsmH8 = "full";
						vxC55kU9 = "1";
						uNBKEySq.removeAttribute("OnlySingleRec");
					}
					if (uNBKEySq.getAttribute("HostItemDisplay") != null
							&& uNBKEySq.getAttribute("HostItemDisplay").equals("false")) {
						System.out.println(
								"*************************************************************************** 15");
						uNBKEySq.removeAttribute("HostItemDisplay");
					}
					uNBKEySq.setAttribute("Title", Kyd7A0XM);
					System.out.println("Title..........................................." + Kyd7A0XM);
					java.util.Hashtable hCQYEhJM = CAU9PyM9.getDetailsForSingleCatalogueRecord(ASa03P8F, Xe5yWEtr);
					System.out.println("hash1 ................................" + hCQYEhJM);
					Nm1dTFIY.addElement(String.valueOf(ASa03P8F));
					Nm1dTFIY.addElement(String.valueOf(Xe5yWEtr));
					y2DiuDpz.setAttachmentsAndUrl("");
					if (hCQYEhJM.get("URL") != null && hCQYEhJM.get("ATTACHMENTS") != null
							&& (hCQYEhJM.get("URL").toString().equals("AVAILABLE")
									|| hCQYEhJM.get("ATTACHMENTS").toString().equals("AVAILABLE"))) {
						System.out.println(
								"*************************************************************************** 16");
						y2DiuDpz.setAttachmentsAndUrl("available");
					}
					y2DiuDpz.setRecordNo(vxC55kU9);
					uNBKEySq.setAttribute("record", F8YXsmH8);
					java.util.Vector KNM1pNRH = (java.util.Vector) uNBKEySq.getAttribute("CatAndOwner");
					y2DiuDpz.setCatCur(ASa03P8F);
					y2DiuDpz.setOwnerCur(Xe5yWEtr);
					y2DiuDpz.setPrevExists("no");
					y2DiuDpz.setNextExists("no");
					if (KNM1pNRH != null) {
						System.out.println(
								"*************************************************************************** 17");
						for (int om3tRy3E = 0; om3tRy3E < KNM1pNRH.size(); om3tRy3E = om3tRy3E + 4) {
							int Cu2HdeVV = new Integer(KNM1pNRH.elementAt(om3tRy3E).toString()).intValue();
							int uMlNaxOK = new Integer(KNM1pNRH.elementAt(om3tRy3E + 1).toString()).intValue();
							if (Cu2HdeVV == ASa03P8F && uMlNaxOK == Xe5yWEtr) {
								System.out.println(
										"*************************************************************************** 18");
								if (om3tRy3E != 0) {
									System.out.println(
											"*************************************************************************** 19");
									int rADjIgsu = new Integer(KNM1pNRH.elementAt(om3tRy3E - 4).toString()).intValue();
									int KzqdKvR9 = new Integer(KNM1pNRH.elementAt(om3tRy3E - 3).toString()).intValue();
									y2DiuDpz.setCatPrev(rADjIgsu);
									y2DiuDpz.setOwnerPrev(KzqdKvR9);
									y2DiuDpz.setTitlePrev(KNM1pNRH.elementAt(om3tRy3E - 2).toString());
									y2DiuDpz.setRecPrev(KNM1pNRH.elementAt(om3tRy3E - 1).toString());
									y2DiuDpz.setPrevExists("yes");
								}
								if (om3tRy3E < KNM1pNRH.size() - 4) {
									System.out.println(
											"*************************************************************************** 20");
									int bfpsYqlZ = new Integer(KNM1pNRH.elementAt(om3tRy3E + 4).toString()).intValue();
									int J77AfS3c = new Integer(KNM1pNRH.elementAt(om3tRy3E + 5).toString()).intValue();
									y2DiuDpz.setCatNext(bfpsYqlZ);
									y2DiuDpz.setOwnerNext(J77AfS3c);
									y2DiuDpz.setTitleNext(KNM1pNRH.elementAt(om3tRy3E + 6).toString());
									y2DiuDpz.setRecNext(KNM1pNRH.elementAt(om3tRy3E + 7).toString());
									y2DiuDpz.setNextExists("yes");
								}
							}
						}
					}
					String xaeusL8s[] = (String[]) hCQYEhJM.get("Biblo_Mat");
					int UKqQKkO9 = new Integer(xaeusL8s[0]).intValue();
					int ZUdSyUwo = new Integer(xaeusL8s[1]).intValue();
					aportal.view.RecordView Xah2bip3 = new aportal.view.DesignFactory().getCorView(UKqQKkO9, ZUdSyUwo,
							"full");
					String sIWuXzEO = "";
					if (UKqQKkO9 == 3 && ZUdSyUwo == 1) {
						sIWuXzEO = "Book";
					} else if (UKqQKkO9 == 4 && ZUdSyUwo == 1) {
						sIWuXzEO = "Serial";
					} else if (UKqQKkO9 == 1 && ZUdSyUwo == 1) {
						sIWuXzEO = "Book Chapter";
					} else if (UKqQKkO9 == 2 && ZUdSyUwo == 1) {
						sIWuXzEO = "Serial Article";
					} else {
						sIWuXzEO = ejb.bprocess.util.TypeDefinition.getInstance()
								.getTypeDefinition(String.valueOf(UKqQKkO9), String.valueOf(ZUdSyUwo));
					}
					java.util.Hashtable bpijUrja = (java.util.Hashtable) hCQYEhJM.get("MonoGraphRecords");
					java.util.Hashtable kZLu4wNl = Xah2bip3.getView(hCQYEhJM);
					kZLu4wNl.put("Type", sIWuXzEO);
					try {
						String FnwcKcXV = Ldp2uVQ8.getSession().getId();
						ejb.bprocess.holdings.HoldingsStatement SsjE75c8 = ((ejb.bprocess.holdings.HoldingsStatementHome) ejb.bprocess.util.HomeFactory
								.getInstance().getRemoteHome("HoldingsStatement")).create();
						java.util.Vector i0rL0MUM = new java.util.Vector();
						i0rL0MUM.addElement("1");
						if (uNBKEySq.getAttribute("Libraries") != null) {
							System.out.println(
									"*************************************************************************** 21");
							i0rL0MUM = (java.util.Vector) uNBKEySq.getAttribute("Libraries");
						}
						String wKeY7uEe = fbMCUHaB;
						Ldp2uVQ8.setAttribute("catRecId", String.valueOf(ASa03P8F));
						Ldp2uVQ8.setAttribute("ownLibId", String.valueOf(Xe5yWEtr));
						Ldp2uVQ8.setAttribute("libIds", String.valueOf(wKeY7uEe));
						y2DiuDpz.setHashSing(kZLu4wNl);
					} catch (Exception zs81w13H) {
						zs81w13H.printStackTrace();
					}
				}
			}
		} else if (y2DiuDpz.getExportRec() != null && y2DiuDpz.getExportRec().equals("export")) {
			System.out.println("*************************************************************************** 22");
			y2DiuDpz.setExportRec(null);
			Nm1dTFIY = (java.util.Vector) uNBKEySq.getAttribute("SingleViewExport");
			String wAluacrJ = y2DiuDpz.getSf();
			if (wAluacrJ.equals("marc")) {
				String TY9b1YJl = CAU9PyM9.getDetailsForMultiRecordViewMARC(Nm1dTFIY);
				y2DiuDpz.setDisplayFormat(TY9b1YJl);
				uNBKEySq.setAttribute("RecordDisplay", TY9b1YJl);
				guUw1dKi = "RecordFormat";
			} else if (wAluacrJ.equals("marcXml")) {
				String qoYJU55I = CAU9PyM9.getDetailsForMultiRecordViewMARCXML(Nm1dTFIY);
				y2DiuDpz.setDisplayFormat(qoYJU55I);
				m1QG8shr.setContentType("text/xml");
				uNBKEySq.setAttribute("RecordDisplay", qoYJU55I);
				guUw1dKi = "RecordFormat";
			} else if (wAluacrJ.equals("mods")) {
				String up1W4Bta = CAU9PyM9.getDetailsForMultiRecordViewMODS(Nm1dTFIY);
				y2DiuDpz.setDisplayFormat(up1W4Bta);
				uNBKEySq.setAttribute("RecordDisplay", up1W4Bta);
				guUw1dKi = "RecordFormat";
			} else if (wAluacrJ.equals("dc")) {
				String XDPXR50V = CAU9PyM9.getDetailsForMultiRecordViewDublinCore(Nm1dTFIY);
				y2DiuDpz.setDisplayFormat(XDPXR50V);
				uNBKEySq.setAttribute("RecordDisplay", XDPXR50V);
				guUw1dKi = "RecordFormat";
			} else if (wAluacrJ.equals("agris")) {
				String qsVmkh7P = CAU9PyM9.getDetailsForMultiRecordViewAgris(Nm1dTFIY);
				y2DiuDpz.setDisplayFormat(qsVmkh7P);
				uNBKEySq.setAttribute("RecordDisplay", qsVmkh7P);
				guUw1dKi = "RecordFormat";
			} else if (wAluacrJ.equals("text")) {
				java.util.Vector UN3kZG3S = new java.util.Vector();
				for (int NB0HQuOy = 0; NB0HQuOy < Nm1dTFIY.size(); NB0HQuOy = NB0HQuOy + 2) {
					java.util.Hashtable n8XVGEBA = CAU9PyM9.getDetailsForSingleCatalogueRecord(
							new Integer(Nm1dTFIY.elementAt(NB0HQuOy).toString()).intValue(),
							new Integer(Nm1dTFIY.elementAt(NB0HQuOy + 1).toString()).intValue());
					aportal.view.ISBDView uPPomNj0 = new aportal.view.ISBDView();
					java.util.Hashtable DiDTSUff = uPPomNj0.getView(n8XVGEBA);
					UN3kZG3S.addElement(DiDTSUff);
					guUw1dKi = "RecordFormatText";
				}
				uNBKEySq.setAttribute("RecordTextDisplay", UN3kZG3S);
				if (y2DiuDpz.getPs() != null && y2DiuDpz.getPs().equals("email")) {
					boolean DPzQsyzc = false;
					if (y2DiuDpz.getEmail() != null && !(y2DiuDpz.getEmail().equals(""))) {
						String mDgETi1N = y2DiuDpz.getEmail();
						try {
							String NqvMl3o4 = Ldp2uVQ8.getSession().getId();
							java.net.URL gmuluDVf = new java.net.URL("http://localhost:" + Ldp2uVQ8.getServerPort()
									+ "/newgenlibctxt/jsp/aportal/cataloguing/RecordDisplayText.jsp;jsessionid="
									+ NqvMl3o4);
							java.net.URLConnection tgHviVnn = gmuluDVf.openConnection();
							java.io.InputStream XSem6hSH = tgHviVnn.getInputStream();
							String nUicZcup = "";
							java.io.BufferedReader AWE51SXE = new java.io.BufferedReader(
									new java.io.InputStreamReader(XSem6hSH));
							String nOjBF1Wo = "";
							while ((nOjBF1Wo = AWE51SXE.readLine()) != null) {
								nUicZcup = nUicZcup + nOjBF1Wo;
							}
							DPzQsyzc = ((ejb.bprocess.util.DispatchEmailHome) ejb.bprocess.util.HomeFactory
									.getInstance().getRemoteHome("DispatchEmail")).create().dispatchEmail(null,
											mDgETi1N, "OPAC results", nUicZcup);
						} catch (Exception ywpZDSrK) {
							ywpZDSrK.printStackTrace();
						}
					}
					String pEMW2mai = "The selected records have been successfully mailed to " + y2DiuDpz.getEmail();
					if (DPzQsyzc == false) {
						pEMW2mai = "<h4><p>The selected records could not be mailed to " + y2DiuDpz.getEmail()
								+ "&nbsp; These might be the possible reasons.</p></h4>"
								+ "<h5><ol> <li>The email id entered is not a valid one</font></li>"
								+ "<li>The email id domain might not be in the list of allowed  recipient&nbsp; hosts</li>"
								+ "<li>There might a error in connectivity to the mail server</li></ol></h5>"
								+ "<h4><p>Please contact the  Network Administrator </p></h4>";
					}
					uNBKEySq.setAttribute("MailStatus", pEMW2mai);
					guUw1dKi = "SendEmail";
				}
			}
		}
		String aN4ODgo8 = ejb.bprocess.util.StaticValues.getInstance().getVersion();
		if (aN4ODgo8 != null && !aN4ODgo8.equals("")) {
			y2DiuDpz.setVersion(aN4ODgo8);
		}
		if (uNBKEySq.getAttribute("ClassNoForwarded") != null) {
			uNBKEySq.removeAttribute("ClassNoForwarded");
		}
		System.out.println("final forward is ......................... " + guUw1dKi);
		return BtcjGuxA.findForward(guUw1dKi);
	}

}