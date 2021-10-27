class n19382420 {
	protected void processRequest(HttpServletRequest IWEOB6cv, HttpServletResponse UDgLt80V)
			throws ServletException, IOException {
		try {
			ejb.bprocess.OAIPMH.AutoHarvesterSession ZaINzrsN = home.create();
			java.util.Vector fSSlTWEn = new java.util.Vector(1, 1);
			Integer YuYhDLj5 = new Integer(1);
			String k2lrxKJs = "";
			String CeU0RBtN = "";
			String PEvPjp2v[] = new String[2];
			String[] xq1danHG = new String[4];
			String Gk37k0JM = "", qAZTnKuO = "";
			String QSkkfhwH = "", AeEfj6Xv = "";
			String thFfN3P4 = "", NkospFID = "";
			String dYvDVrck = "", U98NaEof = "";
			String tEs0HV5i = IWEOB6cv.getParameter("verb");
			String XE8E8Lkq = IWEOB6cv.getQueryString();
			String heGwMdz7 = "";
			heGwMdz7 = "http://" + IWEOB6cv.getServerName() + ":" + IWEOB6cv.getServerPort()
					+ "/newgenlibctxt/HarvestServlet";
			String oLgc6vVA = XE8E8Lkq;
			String a4t19BiY = oLgc6vVA.substring(oLgc6vVA.indexOf("?") + 1);
			StringTokenizer VERxWilQ = new StringTokenizer(a4t19BiY, "&");
			int je9bOe23 = 0;
			int DInqusi5 = 0;
			int djrQjoKV = 0;
			int xTQy6lGN = 0;
			String v8oYVE6a = "";
			while (VERxWilQ.hasMoreTokens()) {
				PEvPjp2v[je9bOe23] = VERxWilQ.nextToken();
				StringTokenizer zPCDsOsY = new StringTokenizer(PEvPjp2v[je9bOe23], "=");
				while (zPCDsOsY.hasMoreTokens()) {
					xq1danHG[DInqusi5] = zPCDsOsY.nextToken();
					DInqusi5++;
				}
				je9bOe23++;
				xTQy6lGN++;
			}
			int FdcTvp77 = 0, ZQH08Vmp = 0, lyrhtOcd = 0, HSb9G4Wo = 0;
			ListRecords pH2TWzIX = new ListRecords();
			for (int cnkZSAZy = 0; cnkZSAZy < DInqusi5; cnkZSAZy += 2) {
				if (xq1danHG[cnkZSAZy].equals("from")) {
					QSkkfhwH = "from";
					ZQH08Vmp++;
					AeEfj6Xv = xq1danHG[cnkZSAZy + 1];
					AeEfj6Xv = pH2TWzIX.validateDate(AeEfj6Xv);
				} else if (xq1danHG[cnkZSAZy].equals("until")) {
					thFfN3P4 = "until";
					lyrhtOcd++;
					NkospFID = xq1danHG[cnkZSAZy + 1];
					NkospFID = pH2TWzIX.validateDate(NkospFID);
				}
			}
			if (AeEfj6Xv.equals("") && lyrhtOcd == 1) {
				AeEfj6Xv = pH2TWzIX.validateDate("0001-01-01");
			} else if (NkospFID.equals("") && ZQH08Vmp == 1) {
				String Ikuv9WFK = (new Resdate()).getDate();
				NkospFID = Ikuv9WFK.substring(0, Ikuv9WFK.indexOf("T"));
			}
			System.out.println("This is fromValue:" + AeEfj6Xv);
			System.out.println("This is untilValue:" + NkospFID);
			fSSlTWEn = ZaINzrsN.getHarvestLibrary(null, YuYhDLj5);
			String BscrEuPM = "";
			if (fSSlTWEn.size() > 0) {
				for (int RdQ8pwOy = 0; RdQ8pwOy < fSSlTWEn.size(); RdQ8pwOy = RdQ8pwOy + 3) {
					BscrEuPM = fSSlTWEn.elementAt(RdQ8pwOy).toString();
					String NDeYdby2 = fSSlTWEn.elementAt(RdQ8pwOy + 1).toString();
					String lv4X9baS = fSSlTWEn.elementAt(RdQ8pwOy + 2).toString();
					if (lv4X9baS.equals("A")) {
						String Ao6Om06b = IWEOB6cv.getParameter("verb");
						String eBHsitFA = IWEOB6cv.getQueryString();
						heGwMdz7 = "http://" + NDeYdby2
								+ ":8080/newgenlibctxt/oai2.0?verb=ListRecords&metadataPrefix=marc21&from=" + AeEfj6Xv
								+ "&until=" + NkospFID + "";
						boolean c7Lo1JBN = true;
						for (int Oovrnb0h = 0; c7Lo1JBN == true; Oovrnb0h++) {
							java.net.URL hifkDZie = new java.net.URL(heGwMdz7);
							java.net.URLConnection lDh0Yww4 = hifkDZie.openConnection();
							lDh0Yww4.setDoInput(true);
							lDh0Yww4.connect();
							InputStream Z3Ihs0bn = lDh0Yww4.getInputStream();
							System.out.println("input" + Z3Ihs0bn.available());
							org.jdom.input.SAXBuilder o25VsTSI = new org.jdom.input.SAXBuilder();
							org.jdom.Document eBzJ8MaL = o25VsTSI.build(Z3Ihs0bn);
							k2lrxKJs = (new org.jdom.output.XMLOutputter()).outputString(eBzJ8MaL);
							System.out.println("xmlStr:" + k2lrxKJs);
							eBzJ8MaL = null;
							o25VsTSI = null;
							java.util.Vector YCSkBYMZ = new java.util.Vector();
							YCSkBYMZ = ZaINzrsN.autoInitialHarvest(null, k2lrxKJs, BscrEuPM);
							String VrTMonJK = eBzJ8MaL.getRootElement().getChildText("resumptionToken",
									eBzJ8MaL.getRootElement().getNamespace());
							if (!(VrTMonJK == null)) {
								heGwMdz7 = "http://" + NDeYdby2
										+ ":8080/newgenlibctxt/oai2.0?verb=ListRecords&resumptionToken=" + VrTMonJK;
							} else {
								c7Lo1JBN = false;
							}
						}
					} else if (lv4X9baS.equals("B")) {
						java.io.File v0kJwXFm = new java.io.File(NDeYdby2);
						java.io.File[] ThZdufcs = v0kJwXFm.listFiles();
						for (int HvF46zFA = 0; HvF46zFA < ThZdufcs.length; HvF46zFA++) {
							File hgK0DLdw = (File) ThZdufcs[HvF46zFA];
							System.out.println("File2:" + hgK0DLdw);
							long Hbf831wH = hgK0DLdw.lastModified();
							StringTokenizer fWjVDPfT = new StringTokenizer(AeEfj6Xv, "-");
							String IY3NXZmq[] = new String[3];
							java.util.Calendar seLgY3l3 = java.util.Calendar.getInstance();
							int GH9J0jbY = 0;
							while (fWjVDPfT.hasMoreElements()) {
								IY3NXZmq[GH9J0jbY] = fWjVDPfT.nextToken();
								GH9J0jbY++;
							}
							seLgY3l3.set(Integer.parseInt(IY3NXZmq[0]), Integer.parseInt(IY3NXZmq[1]),
									Integer.parseInt(IY3NXZmq[2]));
							StringTokenizer cMyL1QsH = new StringTokenizer(NkospFID, "-");
							String SmQmuBcF[] = new String[3];
							java.util.Calendar Dmj32Pfy = java.util.Calendar.getInstance();
							int BPOwiskY = 0;
							while (cMyL1QsH.hasMoreElements()) {
								SmQmuBcF[BPOwiskY] = cMyL1QsH.nextToken();
								BPOwiskY++;
							}
							Dmj32Pfy.set(Integer.parseInt(SmQmuBcF[0]), Integer.parseInt(SmQmuBcF[1]),
									Integer.parseInt(SmQmuBcF[2]));
							java.util.Calendar xExJuTdM = java.util.Calendar.getInstance();
							xExJuTdM.setTimeInMillis(Hbf831wH);
							xExJuTdM.set(java.util.Calendar.HOUR, 0);
							xExJuTdM.set(java.util.Calendar.AM_PM, java.util.Calendar.AM);
							xExJuTdM.set(java.util.Calendar.MINUTE, 0);
							xExJuTdM.set(java.util.Calendar.SECOND, 0);
							xExJuTdM.set(java.util.Calendar.MILLISECOND, 0);
							java.util.Date CSdCWeIB = seLgY3l3.getTime();
							java.util.Date q9ebS1aJ = Dmj32Pfy.getTime();
							java.util.Date ihnabZGY = xExJuTdM.getTime();
							System.out.println("This is d1:" + CSdCWeIB);
							System.out.println("This is d2:" + q9ebS1aJ);
							System.out.println("This is d3:" + ihnabZGY);
							if (ihnabZGY.after(CSdCWeIB) && ihnabZGY.before(q9ebS1aJ)) {
								org.jdom.input.SAXBuilder Xli3EBVj = new org.jdom.input.SAXBuilder();
								org.jdom.Document NKlAd65Q = Xli3EBVj.build(new java.io.FileInputStream(hgK0DLdw));
								k2lrxKJs = (new org.jdom.output.XMLOutputter()).outputString(NKlAd65Q);
								java.util.Vector namfQLkA = new java.util.Vector();
								namfQLkA = ZaINzrsN.autoInitialHarvest(null, k2lrxKJs, BscrEuPM);
							}
						}
					}
				}
			}
		} catch (Exception hdRzVX9x) {
			hdRzVX9x.printStackTrace();
		}
	}

}