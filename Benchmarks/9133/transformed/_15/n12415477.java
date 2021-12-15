class n12415477 {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String limitsSet = "";
		String synstatus = SystemFilesLoader.getInstance().getNewgenlibProperties().getProperty("SYNDETICS", "OFF");
		String synncode = SystemFilesLoader.getInstance().getNewgenlibProperties().getProperty("SYNDETICS_CLIENT_CODE",
				"");
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
		String forward = "searchView";
		int link = 0, singleLink = 0;
		java.util.Vector vecThisPage = new java.util.Vector();
		aportal.form.cataloguing.SearchViewForm svF = (aportal.form.cataloguing.SearchViewForm) form;
		svF.setSyndeticsStatus(synstatus);
		svF.setSyndeticsClientCode(synncode);
		opacHm = (ejb.bprocess.opac.xcql.OPACUtilitiesHome) ejb.bprocess.util.HomeFactory.getInstance()
				.getRemoteHome("OPACUtilities");
		ejb.bprocess.opac.xcql.OPACUtilities opacUt = opacHm.create();
		System.out.println("CLASS NO " + request.getParameter("ClassNo") + " ClassNoForwarded "
				+ session.getAttribute("ClassNoForwarded"));
		if (svF.getExportRec() == null || !(svF.getExportRec().equals("export"))) {
			if (request.getParameter("CatId") != null && request.getParameter("OwnerId") != null
					&& request.getParameter("relation") != null && !(session.getAttribute("HostItemDisplay") != null
							&& session.getAttribute("HostItemDisplay").toString().equals("false"))) {
				home = (ejb.bprocess.opac.xcql.SearchSRUWCatalogueHome) ejb.bprocess.util.HomeFactory.getInstance()
						.getRemoteHome("SearchSRUWCatalogue");
				ejb.bprocess.opac.xcql.SearchSRUWCatalogue searchCat = home.create();
				String catId1 = request.getParameter("CatId");
				String ownId1 = request.getParameter("OwnerId");
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
			} else if (link == 0 || singleLink == 1) {
				System.out.println("LINK AND SINGLE LINK " + link + " single " + singleLink);
				if ((request.getParameter("ClassNo") != null) && session.getAttribute("ClassNoForwarded") == null) {
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
						hs = (java.util.Hashtable) session.getAttribute("searchLimits");
					}
					Vector vec = new Vector();
					String solrQuery = Utility.getInstance().simplifiedSolrQuery(classificNo, "classificationNumber");
					if (limitsSet.equalsIgnoreCase("SET")) {
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
						hs.put("searchText", rawSearchText);
						hs.put("noOfRecords", 25);
						hs.put("browseType", "Classification Number");
						session.setAttribute("searchEntry", hs);
						session.setAttribute("searchVec", v1);
						forward = "searchRes";
					} else {
						forward = "home";
					}
				} else {
					System.out.println("ELSE CALLED ");
					String record = request.getParameter("record");
					String recNo = request.getParameter("recNo");
					Integer catId = 0, ownerId = 0;
					String title = "";
					if (request.getParameter("CatId") != null && request.getParameter("OwnerId") != null) {
						catId = new Integer(request.getParameter("CatId")).intValue();
						ownerId = new Integer(request.getParameter("OwnerId")).intValue();
						System.out.println("catId is +++=" + catId);
						System.out.println("OwnerId is +++=" + ownerId);
						title = request.getParameter("title");
						svF.setCatalogueRecordId(request.getParameter("CatId"));
						svF.setOwnerLibraryId(request.getParameter("OwnerId"));
					}
					System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%VVVVVVVVVVVVVVVVVVVVVV");
					ArrayList alOtherBooks = ((ejb.bprocess.opac.SearchCatalogue) ejb.bprocess.util.HomeFactory
							.getInstance().getHome("SearchCatalogue")).getOtherBooksInTheRack(null, catId.toString(),
									ownerId.toString(), ownerId.toString());
					System.out.println("alOtherBooks size is  " + alOtherBooks.size());
					Vector vOtherBooks = new Vector();
					Session catrecsession = DBConnector.getInstance().getSession();
					utility = ejb.bprocess.util.Utility.getInstance(catrecsession);
					for (int i = 0; i < alOtherBooks.size(); i++) {
						String[] scData = (String[]) (alOtherBooks.get(i));
						String catalogueId = scData[0];
						String ownerLibId = scData[1];
						System.out.println("catId is +++=" + catalogueId);
						System.out.println("OwnerId is +++=" + ownerLibId);
						String xmlWholeRecord = "";
						String titleD = "";
						String titleV = "";
						String authorV = "";
						String isbnNumber = "";
						if (catalogueId != null && ownerLibId != null) {
							try {
								System.out.println("***************************** 0");
								Hashtable htDetails = utility.getCatalogueRecord(new Integer(catalogueId),
										new Integer(ownerLibId));
								System.out.println("***************************** 1");
								if (htDetails != null && !htDetails.isEmpty()) {
									System.out.println("htDetails" + htDetails.toString());
									titleV = utility.getTestedString(htDetails.get("Title"));
									authorV = utility.getTestedString(htDetails.get("Author"));
									isbnNumber = utility.getTestedString(htDetails.get("ISBN"));
									String[] str1 = titleV.split("/");
									if (str1.length > 0) {
										titleD = str1[0];
										if (titleD.length() > 45) {
											titleD = titleD.substring(0, 45) + "...";
										}
									}
									String[] str = new String[5];
									str[0] = titleD;
									str[1] = authorV;
									str[2] = isbnNumber;
									str[3] = catalogueId;
									str[4] = ownerLibId;
									vOtherBooks.add(str);
									System.out.println("Other Books size is " + vOtherBooks.size());
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
					System.out.println("Other Books vector is *************************** \n ");
					for (int i = 0; i < vOtherBooks.size(); i++) {
						String[] str = (String[]) vOtherBooks.get(i);
						System.out.println("title   :" + str[0].toString());
						System.out.println("author  :" + str[1].toString());
						System.out.println("isbn  :" + str[2].toString());
						System.out.println("catID  :" + str[3].toString());
						System.out.println("ownerLibId  :" + str[4].toString());
					}
					System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
					request.setAttribute("fisheyedata", vOtherBooks);
					catrecsession.close();
					session.setAttribute("SingleViewExport", vecThisPage);
					if (session.getAttribute("OnlySingleRec") != null
							&& session.getAttribute("OnlySingleRec").toString().equals("true")) {
						java.util.Vector v1 = new java.util.Vector();
						System.out.println("SEARCH MODE " + searchmode);
						if (searchmode.equalsIgnoreCase("a")) {
							System.out.println("SEARCHMODE IN SEARCH VIEW ACTION (IF) " + searchmode);
							v1 = (java.util.Vector) request.getAttribute("LuceneVector");
							System.out.println("VECTOR V1 " + v1);
						} else {
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
						if ((h.get("ATTACHMENTS") != null && h.get("ATTACHMENTS").equals("AVAILABLE"))) {
							svF.setAttachmentsAndUrl("available");
						}
						record = "full";
						recNo = "1";
						session.removeAttribute("OnlySingleRec");
					}
					if (session.getAttribute("HostItemDisplay") != null
							&& session.getAttribute("HostItemDisplay").equals("false")) {
						session.removeAttribute("HostItemDisplay");
					}
					session.setAttribute("Title", title);
					java.util.Hashtable hash1 = opacUt.getDetailsForSingleCatalogueRecord(catId, ownerId);
					vecThisPage.addElement(String.valueOf(catId));
					vecThisPage.addElement(String.valueOf(ownerId));
					svF.setAttachmentsAndUrl("");
					if (hash1.get("ATTACHMENTS") != null && "AVAILABLE".equals(hash1.get("ATTACHMENTS").toString())) {
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
						for (int j = 0; j < vecCO.size(); j = j + 4) {
							int c = new Integer(vecCO.elementAt(j).toString()).intValue();
							int o = new Integer(vecCO.elementAt(j + 1).toString()).intValue();
							if (c == catId && o == ownerId) {
								if (j != 0) {
									int catPrev = new Integer(vecCO.elementAt(j - 4).toString()).intValue();
									int ownerPrev = new Integer(vecCO.elementAt(j - 3).toString()).intValue();
									svF.setCatPrev(catPrev);
									svF.setOwnerPrev(ownerPrev);
									svF.setTitlePrev(vecCO.elementAt(j - 2).toString());
									svF.setRecPrev(vecCO.elementAt(j - 1).toString());
									svF.setPrevExists("yes");
								}
								if (j < vecCO.size() - 4) {
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
					aportal.view.RecordView rv = new aportal.view.DesignFactory().getCorView(bib_id, mat_id, record);
					String type = "";
					if (bib_id == 3 && mat_id == 1) {
						type = "Book";
					} else if (bib_id == 4 && mat_id == 1) {
						type = "Serial";
					} else if (bib_id == 1 && mat_id == 1) {
						type = "Book Chapter";
					} else if (bib_id == 2 && mat_id == 1) {
						type = "Serial Article";
					} else {
						type = ejb.bprocess.util.TypeDefinition.getInstance().getTypeDefinition(String.valueOf(bib_id),
								String.valueOf(mat_id));
					}
					java.util.Hashtable hMono = (java.util.Hashtable) hash1.get("MonoGraphRecords");
					java.util.Hashtable h4 = rv.getView(hash1);
					h4.put("Type", type);
					Hashtable ht = (Hashtable) h4.get("NoLink");
					if (ht != null && ht.get("URLS_856") != null) {
						Vector urls856 = (Vector) ht.get("URLS_856");
						if (urls856.size() > 0) {
							Hashtable linksAndText = new Hashtable();
							Hashtable url856 = new Hashtable();
							for (int i = 0; i < urls856.size(); i += 2) {
								url856.put(urls856.elementAt(i), urls856.elementAt(i + 1));
							}
							linksAndText.put("URL", url856);
							h4.put("URLS_856", linksAndText);
						}
					}
					try {
						String sessionid = request.getSession().getId();
						ejb.bprocess.holdings.HoldingsStatement holdingsStatement = ((ejb.bprocess.holdings.HoldingsStatementHome) ejb.bprocess.util.HomeFactory
								.getInstance().getRemoteHome("HoldingsStatement")).create();
						java.util.Vector vecLib = new java.util.Vector();
						vecLib.addElement("1");
						if (session.getAttribute("Libraries") != null) {
							vecLib = (java.util.Vector) session.getAttribute("Libraries");
						}
						String libIds = "";
						for (int p = 0; p < vecLib.size(); p++) {
							if (p != 0) {
								libIds += ",";
							}
							String libName = vecLib.elementAt(p).toString();
							Session session1 = DBConnector.getInstance().getSession();
							libIds += ejb.bprocess.util.Utility.getInstance(session1).getLibraryId(libName);
							session1.close();
						}
						request.setAttribute("catRecId", String.valueOf(catId));
						request.setAttribute("ownLibId", String.valueOf(ownerId));
						request.setAttribute("libIds", String.valueOf(libIds));
						Hashtable onerecordattach = new Hashtable();
						JSONObject jsonCatOwnId = new JSONObject().put("Id", catId).put("LibId", ownerId);
						ejb.bprocess.opac.SearchCatalogue searchCatAttach = ((ejb.bprocess.opac.SearchCatalogueHome) ejb.bprocess.util.HomeFactory
								.getInstance().getRemoteHome("SearchCatalogue")).create();
						String strAttach = searchCatAttach.getAttachmentDetails(jsonCatOwnId.toString());
						if (!"".equals(strAttach)) {
							JSONObject jsonAttach = new JSONObject(strAttach);
							if (jsonAttach != null) {
								if (!jsonAttach.isNull("BookCover")) {
									ArrayList albookcover = new ArrayList();
									JSONArray jsonarr = (JSONArray) jsonAttach.get("BookCover");
									if (jsonarr != null) {
										for (int j = 0; j < jsonarr.length(); j++) {
											albookcover.add(jsonarr.getString(j));
										}
										onerecordattach.put("BookCover", albookcover);
									}
								}
								if (!jsonAttach.isNull("TOC")) {
									ArrayList alTOC = new ArrayList();
									JSONArray jsonarr = (JSONArray) jsonAttach.get("TOC");
									if (jsonarr != null) {
										for (int j = 0; j < jsonarr.length(); j++) {
											alTOC.add(jsonarr.getString(j));
										}
										onerecordattach.put("TOC", alTOC);
									}
								}
								if (!jsonAttach.isNull("Preview")) {
									ArrayList alPreview = new ArrayList();
									JSONArray jsonarr = (JSONArray) jsonAttach.get("Preview");
									if (jsonarr != null) {
										for (int j = 0; j < jsonarr.length(); j++) {
											alPreview.add(jsonarr.getString(j));
										}
										onerecordattach.put("Preview", alPreview);
									}
								}
								if (!jsonAttach.isNull("FullView")) {
									ArrayList alFullView = new ArrayList();
									JSONArray jsonarr = (JSONArray) jsonAttach.get("FullView");
									if (jsonarr != null) {
										for (int j = 0; j < jsonarr.length(); j++) {
											alFullView.add(jsonarr.getString(j));
										}
										onerecordattach.put("FullView", alFullView);
									}
								}
								if (!jsonAttach.isNull("Attachment")) {
									ArrayList alAttachment = new ArrayList();
									JSONArray jsonarr = (JSONArray) jsonAttach.get("Attachment");
									if (jsonarr != null) {
										for (int j = 0; j < jsonarr.length(); j++) {
											alAttachment.add(jsonarr.getString(j));
										}
										onerecordattach.put("Attachment", alAttachment);
									}
								}
								if (onerecordattach != null && !onerecordattach.isEmpty()) {
									h4.put("dAttachment", onerecordattach);
								}
							}
						}
						svF.setHashSing(h4);
						System.out.println("hash tabel values*************************");
						Enumeration enumx = h4.keys();
						while (enumx.hasMoreElements()) {
							String key = enumx.nextElement().toString();
							System.out.println("Key: " + key + "-----value: " + h4.get(key));
						}
						System.out.println("********************************************");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else if (svF.getExportRec() != null && svF.getExportRec().equals("export")) {
			svF.setExportRec(null);
			vecThisPage = (java.util.Vector) session.getAttribute("SingleViewExport");
			String format = svF.getSf();
			if ("marc".equals(format)) {
				String marc = opacUt.getDetailsForMultiRecordViewMARC(vecThisPage);
				svF.setDisplayFormat(marc);
				session.setAttribute("RecordDisplay", marc);
				forward = "RecordFormat";
			} else if ("marcXml".equals(format)) {
				String marcXML = opacUt.getDetailsForMultiRecordViewMARCXML(vecThisPage);
				svF.setDisplayFormat(marcXML);
				response.setContentType("text/xml");
				session.setAttribute("RecordDisplay", marcXML);
				forward = "RecordFormat";
			} else if ("mods".equals(format)) {
				String mods = opacUt.getDetailsForMultiRecordViewMODS(vecThisPage);
				svF.setDisplayFormat(mods);
				session.setAttribute("RecordDisplay", mods);
				forward = "RecordFormat";
			} else if ("dc".equals(format)) {
				String dc = opacUt.getDetailsForMultiRecordViewDublinCore(vecThisPage);
				svF.setDisplayFormat(dc);
				session.setAttribute("RecordDisplay", dc);
				forward = "RecordFormat";
			} else if ("agris".equals(format)) {
				String agr = opacUt.getDetailsForMultiRecordViewAgris(vecThisPage);
				svF.setDisplayFormat(agr);
				session.setAttribute("RecordDisplay", agr);
				forward = "RecordFormat";
			} else if ("text".equals(format)) {
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
							String[] emailids = { emailId };
							int status = SendEmail.getInstance().sendMail(emailids, "OPAC results", htmlContent,
									"html");
							if (status == 0)
								flag = true;
							else
								flag = false;
						} catch (Exception exp) {
							exp.printStackTrace();
						}
					}
					String mailMessage = "The selected records have been successfully mailed to " + svF.getEmail();
					if (flag == false) {
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
		if (version != null && !"".equals(version)) {
			svF.setVersion(version);
		}
		if (session.getAttribute("ClassNoForwarded") != null) {
			session.removeAttribute("ClassNoForwarded");
		}
		return mapping.findForward(forward);
	}

}