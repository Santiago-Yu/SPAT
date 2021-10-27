class n4494367 {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("Id");
		String libid = request.getParameter("LibId");
		System.out.println("********************************printing starts here***************************");
		Enumeration enumx = request.getAttributeNames();
		while (enumx.hasMoreElements()) {
			String namex = enumx.nextElement().toString();
			System.out.println("REQ ATTR" + namex + "------" + request.getAttribute(namex));
		}
		enumx = request.getSession().getAttributeNames();
		while (enumx.hasMoreElements()) {
			String namex = enumx.nextElement().toString();
			System.out.println("SESS ATTR" + namex + "------" + request.getSession().getAttribute(namex));
		}
		enumx = request.getParameterNames();
		while (enumx.hasMoreElements()) {
			String namex = enumx.nextElement().toString();
			System.out.println("REQ PARAM" + namex + "------" + request.getParameter(namex));
		}
		System.out.println("********************************printing ends here***************************");
		String limitsSet = "";
		try {
			if (request.getSession().getAttribute("searchLimits") != null) {
				System.out.println("searchLimits set");
				limitsSet = "SET";
				java.util.Hashtable htLimits = new java.util.Hashtable();
				htLimits = (java.util.Hashtable) request.getSession().getAttribute("searchLimits");
			} else {
				limitsSet = "UNSET";
				System.out.println("searchLimits not set");
			}
			java.util.Properties prop = System.getProperties();
			prop.load(new FileInputStream(ejb.bprocess.util.NewGenLibRoot.getRoot() + java.io.File.separator
					+ "SystemFiles" + java.io.File.separator + "ENV_VAR.txt"));
			System.out
					.println("SEARCH MODE IS " + searchmode + " FILE PATH " + ejb.bprocess.util.NewGenLibRoot.getRoot()
							+ java.io.File.separator + "SystemFiles" + java.io.File.separator + "ENV_VAR.txt");
		} catch (Exception e) {
		}
		javax.servlet.http.HttpSession session = request.getSession();
		session.setAttribute("totalPages", "1");
		session.setAttribute("formOfRec", "");
		String forward = "singleRecordView";
		int link = 0, singleLink = 0;
		java.util.Vector vecThisPage = new java.util.Vector();
		aportal.form.cataloguing.SingleRecordForm svF = (aportal.form.cataloguing.SingleRecordForm) form;
		opacHm = (ejb.bprocess.opac.xcql.OPACUtilitiesHome) ejb.bprocess.util.HomeFactory.getInstance()
				.getRemoteHome("OPACUtilities");
		ejb.bprocess.opac.xcql.OPACUtilities opacUt = opacHm.create();
		System.out.println("CLASS NO " + request.getParameter("ClassNo") + " ClassNoForwarded "
				+ session.getAttribute("ClassNoForwarded"));
		if (null == svF.getExportRec() || !(svF.getExportRec().equals("export"))) {
			System.out.println("*************************************************************************** 1");
			if (id != null && libid != null && request.getParameter("relation") != null
					&& !(session.getAttribute("HostItemDisplay") != null
							&& session.getAttribute("HostItemDisplay").toString().equals("false"))) {
				System.out.println("*************************************************************************** 2");
				home = (ejb.bprocess.opac.xcql.SearchSRUWCatalogueHome) ejb.bprocess.util.HomeFactory.getInstance()
						.getRemoteHome("SearchSRUWCatalogue");
				ejb.bprocess.opac.xcql.SearchSRUWCatalogue searchCat = home.create();
				String catId1 = id;
				String ownId1 = libid;
				System.out.println("*********************CatId1: " + catId1);
				svF.setCatalogueRecordId(catId1);
				svF.setOwnerLibraryId(ownId1);
				String rel = request.getParameter("relation");
				java.util.Vector vecL = searchCat.getRelatedCatalogueRecords(null, catId1, ownId1, rel);
				request.setAttribute("LuceneVector", vecL);
				session.setAttribute("searchVec", vecL);
				singleLink = 1;
				session.setAttribute("HostItemDisplay", "false");
				link = 1;
				forward = "searchRes";
				vecThisPage.addElement(catId1);
				vecThisPage.addElement(ownId1);
			} else if (0 == link || 1 == singleLink) {
				System.out.println("*************************************************************************** 3");
				System.out.println("LINK AND SINGLE LINK " + link + " single " + singleLink);
				if ((request.getParameter("ClassNo") != null) && null == session.getAttribute("ClassNoForwarded")) {
					System.out.println("*************************************************************************** 4");
					System.out.println("action called for class no.");
					String classificNo = request.getParameter("ClassNo");
					System.out.println("TITLE WORDS ");
					home = (ejb.bprocess.opac.xcql.SearchSRUWCatalogueHome) ejb.bprocess.util.HomeFactory.getInstance()
							.getRemoteHome("SearchSRUWCatalogue");
					ejb.bprocess.opac.xcql.SearchSRUWCatalogue searchCat = home.create();
					String rawSearchText = (new beans.miscellaneous.RequestStringProcessor())
							.processString("*" + classificNo + "*");
					System.out.println("raw search Text" + rawSearchText);
					String searchText = "classificationNumber=" + rawSearchText;
					System.out.println("search text is " + searchText);
					String xmlRes = (new org.z3950.zing.cql.CQLParser()).parse(searchText).toXCQL(0);
					java.util.Hashtable hs = new java.util.Hashtable();
					java.util.Vector v1 = new java.util.Vector();
					if (session.getAttribute("searchLimits") != null) {
						System.out.println(
								"*************************************************************************** 5");
						hs = (java.util.Hashtable) session.getAttribute("searchLimits");
					}
					Vector vec = new Vector();
					String solrQuery = Utility.getInstance().simplifiedSolrQuery(classificNo, "classificationNumber");
					if (limitsSet.equalsIgnoreCase("SET")) {
						System.out.println(
								"*************************************************************************** 6");
						String limitsQuery = limitsSolrQuery(hs);
						solrQuery += limitsQuery;
					}
					solrQuery += " & ";
					Vector newRetvec = searchCat.processSolrQuery(1, 25, solrQuery, "245_Tag", "asc");
					Hashtable ht = (Hashtable) newRetvec.get(0);
					String totrec = (String) ht.get("HITS");
					session.setAttribute("TOTALREC", Integer.parseInt(totrec));
					v1 = (Vector) ht.get("RESULTS");
					hs.put("Query", solrQuery);
					if (v1.size() > 0) {
						System.out.println(
								"*************************************************************************** 7");
						hs.put("searchText", rawSearchText);
						hs.put("noOfRecords", 25);
						hs.put("browseType", "Classification Number");
						session.setAttribute("searchEntry", hs);
						session.setAttribute("searchVec", v1);
						forward = "searchRes";
					} else {
						System.out.println(
								"*************************************************************************** 8");
						forward = "home";
					}
				} else {
					System.out.println("*************************************************************************** 9");
					System.out.println("ELSE CALLED ");
					String record = request.getParameter("record");
					String recNo = request.getParameter("recNo");
					int catId = 0, ownerId = 0;
					String title = "";
					if (id != null && libid != null) {
						System.out.println(
								"*************************************************************************** 10");
						catId = new Integer(id).intValue();
						ownerId = new Integer(libid).intValue();
						title = "title";
						svF.setCatalogueRecordId(id);
						svF.setOwnerLibraryId(libid);
					}
					session.setAttribute("SingleViewExport", vecThisPage);
					if (session.getAttribute("OnlySingleRec") != null
							&& session.getAttribute("OnlySingleRec").toString().equals("true")) {
						System.out.println(
								"*************************************************************************** 11");
						java.util.Vector v1 = new java.util.Vector();
						System.out.println("SEARCH MODE " + searchmode);
						if (searchmode.equalsIgnoreCase("a")) {
							System.out.println(
									"*************************************************************************** 12");
							System.out.println("SEARCHMODE IN SEARCH VIEW ACTION (IF) " + searchmode);
							v1 = (java.util.Vector) request.getAttribute("LuceneVector");
							System.out.println("VECTOR V1 " + v1);
						} else {
							System.out.println(
									"*************************************************************************** 13");
							System.out.println("SEARCHMODE IN SEARCH VIEW ACTION (ELSE)" + searchmode);
							v1 = (java.util.Vector) session.getAttribute("searchVec");
						}
						Object[] obj = (Object[]) v1.elementAt(0);
						String str[] = (String[]) obj[0];
						java.util.Hashtable h = new java.util.Hashtable();
						String tit = "";
						h = (java.util.Hashtable) obj[1];
						System.out.println("HASH TABLE in view action " + h);
						catId = new Integer(str[0]).intValue();
						ownerId = new Integer(str[1]).intValue();
						title = h.get("TITLE").toString();
						svF.setAttachmentsAndUrl("");
						if ((h.get("URL").toString() != null && h.get("URL").toString().equals("AVAILABLE"))
								|| (h.get("ATTACHMENTS") != null && h.get("ATTACHMENTS").equals("AVAILABLE"))) {
							System.out.println(
									"*************************************************************************** 14");
							svF.setAttachmentsAndUrl("available");
						}
						record = "full";
						recNo = "1";
						session.removeAttribute("OnlySingleRec");
					}
					if (session.getAttribute("HostItemDisplay") != null
							&& session.getAttribute("HostItemDisplay").equals("false")) {
						System.out.println(
								"*************************************************************************** 15");
						session.removeAttribute("HostItemDisplay");
					}
					session.setAttribute("Title", title);
					System.out.println("Title..........................................." + title);
					java.util.Hashtable hash1 = opacUt.getDetailsForSingleCatalogueRecord(catId, ownerId);
					System.out.println("hash1 ................................" + hash1);
					vecThisPage.addElement(String.valueOf(catId));
					vecThisPage.addElement(String.valueOf(ownerId));
					svF.setAttachmentsAndUrl("");
					if (hash1.get("URL") != null && hash1.get("ATTACHMENTS") != null
							&& (hash1.get("URL").toString().equals("AVAILABLE")
									|| hash1.get("ATTACHMENTS").toString().equals("AVAILABLE"))) {
						System.out.println(
								"*************************************************************************** 16");
						svF.setAttachmentsAndUrl("available");
					}
					svF.setRecordNo(recNo);
					session.setAttribute("record", record);
					java.util.Vector vecCO = (java.util.Vector) session.getAttribute("CatAndOwner");
					svF.setCatCur(catId);
					svF.setOwnerCur(ownerId);
					svF.setPrevExists("no");
					svF.setNextExists("no");
					if (vecCO != null) {
						System.out.println(
								"*************************************************************************** 17");
						for (int j = 0; j < vecCO.size(); j = j + 4) {
							int c = new Integer(vecCO.elementAt(j).toString()).intValue();
							int o = new Integer(vecCO.elementAt(j + 1).toString()).intValue();
							if (catId == c && ownerId == o) {
								System.out.println(
										"*************************************************************************** 18");
								if (j != 0) {
									System.out.println(
											"*************************************************************************** 19");
									int catPrev = new Integer(vecCO.elementAt(j - 4).toString()).intValue();
									int ownerPrev = new Integer(vecCO.elementAt(j - 3).toString()).intValue();
									svF.setCatPrev(catPrev);
									svF.setOwnerPrev(ownerPrev);
									svF.setTitlePrev(vecCO.elementAt(j - 2).toString());
									svF.setRecPrev(vecCO.elementAt(j - 1).toString());
									svF.setPrevExists("yes");
								}
								if (j < vecCO.size() - 4) {
									System.out.println(
											"*************************************************************************** 20");
									int catNext = new Integer(vecCO.elementAt(j + 4).toString()).intValue();
									int ownerNext = new Integer(vecCO.elementAt(j + 5).toString()).intValue();
									svF.setCatNext(catNext);
									svF.setOwnerNext(ownerNext);
									svF.setTitleNext(vecCO.elementAt(j + 6).toString());
									svF.setRecNext(vecCO.elementAt(j + 7).toString());
									svF.setNextExists("yes");
								}
							}
						}
					}
					String str[] = (String[]) hash1.get("Biblo_Mat");
					int bib_id = new Integer(str[0]).intValue();
					int mat_id = new Integer(str[1]).intValue();
					aportal.view.RecordView rv = new aportal.view.DesignFactory().getCorView(bib_id, mat_id, "full");
					String type = "";
					if (3 == bib_id && 1 == mat_id) {
						type = "Book";
					} else if (4 == bib_id && 1 == mat_id) {
						type = "Serial";
					} else if (1 == bib_id && 1 == mat_id) {
						type = "Book Chapter";
					} else if (2 == bib_id && 1 == mat_id) {
						type = "Serial Article";
					} else {
						type = ejb.bprocess.util.TypeDefinition.getInstance().getTypeDefinition(String.valueOf(bib_id),
								String.valueOf(mat_id));
					}
					java.util.Hashtable hMono = (java.util.Hashtable) hash1.get("MonoGraphRecords");
					java.util.Hashtable h4 = rv.getView(hash1);
					h4.put("Type", type);
					try {
						String sessionid = request.getSession().getId();
						ejb.bprocess.holdings.HoldingsStatement holdingsStatement = ((ejb.bprocess.holdings.HoldingsStatementHome) ejb.bprocess.util.HomeFactory
								.getInstance().getRemoteHome("HoldingsStatement")).create();
						java.util.Vector vecLib = new java.util.Vector();
						vecLib.addElement("1");
						if (session.getAttribute("Libraries") != null) {
							System.out.println(
									"*************************************************************************** 21");
							vecLib = (java.util.Vector) session.getAttribute("Libraries");
						}
						String libIds = libid;
						request.setAttribute("catRecId", String.valueOf(catId));
						request.setAttribute("ownLibId", String.valueOf(ownerId));
						request.setAttribute("libIds", String.valueOf(libIds));
						svF.setHashSing(h4);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else if (svF.getExportRec() != null && svF.getExportRec().equals("export")) {
			System.out.println("*************************************************************************** 22");
			svF.setExportRec(null);
			vecThisPage = (java.util.Vector) session.getAttribute("SingleViewExport");
			String format = svF.getSf();
			if (format.equals("marc")) {
				String marc = opacUt.getDetailsForMultiRecordViewMARC(vecThisPage);
				svF.setDisplayFormat(marc);
				session.setAttribute("RecordDisplay", marc);
				forward = "RecordFormat";
			} else if (format.equals("marcXml")) {
				String marcXML = opacUt.getDetailsForMultiRecordViewMARCXML(vecThisPage);
				svF.setDisplayFormat(marcXML);
				response.setContentType("text/xml");
				session.setAttribute("RecordDisplay", marcXML);
				forward = "RecordFormat";
			} else if (format.equals("mods")) {
				String mods = opacUt.getDetailsForMultiRecordViewMODS(vecThisPage);
				svF.setDisplayFormat(mods);
				session.setAttribute("RecordDisplay", mods);
				forward = "RecordFormat";
			} else if (format.equals("dc")) {
				String dc = opacUt.getDetailsForMultiRecordViewDublinCore(vecThisPage);
				svF.setDisplayFormat(dc);
				session.setAttribute("RecordDisplay", dc);
				forward = "RecordFormat";
			} else if (format.equals("agris")) {
				String agr = opacUt.getDetailsForMultiRecordViewAgris(vecThisPage);
				svF.setDisplayFormat(agr);
				session.setAttribute("RecordDisplay", agr);
				forward = "RecordFormat";
			} else if (format.equals("text")) {
				java.util.Vector vecTextDis = new java.util.Vector();
				for (int i2 = 0; i2 < vecThisPage.size(); i2 = i2 + 2) {
					java.util.Hashtable hash1 = opacUt.getDetailsForSingleCatalogueRecord(
							new Integer(vecThisPage.elementAt(i2).toString()).intValue(),
							new Integer(vecThisPage.elementAt(i2 + 1).toString()).intValue());
					aportal.view.ISBDView fullView = new aportal.view.ISBDView();
					java.util.Hashtable hashCit = fullView.getView(hash1);
					vecTextDis.addElement(hashCit);
					forward = "RecordFormatText";
				}
				session.setAttribute("RecordTextDisplay", vecTextDis);
				if (svF.getPs() != null && svF.getPs().equals("email")) {
					boolean flag = false;
					if (svF.getEmail() != null && !(svF.getEmail().equals(""))) {
						String emailId = svF.getEmail();
						try {
							String sessionid = request.getSession().getId();
							java.net.URL url = new java.net.URL("http://localhost:" + request.getServerPort()
									+ "/newgenlibctxt/jsp/aportal/cataloguing/RecordDisplayText.jsp;jsessionid="
									+ sessionid);
							java.net.URLConnection urlCon = url.openConnection();
							java.io.InputStream is = urlCon.getInputStream();
							String htmlContent = "";
							java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(is));
							String line = "";
							while ((line = br.readLine()) != null) {
								htmlContent = htmlContent + line;
							}
							flag = ((ejb.bprocess.util.DispatchEmailHome) ejb.bprocess.util.HomeFactory.getInstance()
									.getRemoteHome("DispatchEmail")).create().dispatchEmail(null, emailId,
											"OPAC results", htmlContent);
						} catch (Exception exp) {
							exp.printStackTrace();
						}
					}
					String mailMessage = "The selected records have been successfully mailed to " + svF.getEmail();
					if (false == flag) {
						mailMessage = "<h4><p>The selected records could not be mailed to " + svF.getEmail()
								+ "&nbsp; These might be the possible reasons.</p></h4>"
								+ "<h5><ol> <li>The email id entered is not a valid one</font></li>"
								+ "<li>The email id domain might not be in the list of allowed  recipient&nbsp; hosts</li>"
								+ "<li>There might a error in connectivity to the mail server</li></ol></h5>"
								+ "<h4><p>Please contact the  Network Administrator </p></h4>";
					}
					session.setAttribute("MailStatus", mailMessage);
					forward = "SendEmail";
				}
			}
		}
		String version = ejb.bprocess.util.StaticValues.getInstance().getVersion();
		if (version != null && !version.equals("")) {
			svF.setVersion(version);
		}
		if (session.getAttribute("ClassNoForwarded") != null) {
			session.removeAttribute("ClassNoForwarded");
		}
		System.out.println("final forward is ......................... " + forward);
		return mapping.findForward(forward);
	}

}