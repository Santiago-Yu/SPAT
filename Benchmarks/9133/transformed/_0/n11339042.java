class n11339042 {
	public void doPost(HttpServletRequest kF9c7BPn, HttpServletResponse ZPGsYsqR) throws ServletException, IOException {
		PrintWriter OduYG0Gn = null;
		ServletOutputStream PC4X4Qen = null;
		try {
			String GK6qZXSv = kF9c7BPn.getParameter("nmrshiftdbaction");
			String k3ttFxOj = ServletUtils.expandRelative(this.getServletConfig(), "/WEB-INF");
			TurbineConfig RuxeE65P = new TurbineConfig(k3ttFxOj + "..",
					k3ttFxOj + getServletConfig().getInitParameter("properties"));
			RuxeE65P.init();
			int z1pVMEx8 = -1;
			DBSpectrum cnQ8TQp6 = null;
			Export PRw2frFM = null;
			String zDInAddn = kF9c7BPn.getParameter("format");
			if (GK6qZXSv.equals("test")) {
				try {
					ZPGsYsqR.setContentType("text/plain");
					OduYG0Gn = ZPGsYsqR.getWriter();
					List FrUMfJLt = DBSpectrumPeer.executeQuery("select SPECTRUM_ID from SPECTRUM limit 1");
					if (FrUMfJLt.size() > 0)
						z1pVMEx8 = ((Record) FrUMfJLt.get(0)).getValue(1).asInt();
					OduYG0Gn.write("success");
				} catch (Exception uBGvKUwk) {
					OduYG0Gn.write("failure");
				}
			} else if (GK6qZXSv.equals("rss")) {
				int DsHnguhE = 10;
				OduYG0Gn = ZPGsYsqR.getWriter();
				if (kF9c7BPn.getParameter("numbertoexport") != null) {
					try {
						DsHnguhE = Integer.parseInt(kF9c7BPn.getParameter("numbertoexport"));
						if (DsHnguhE < 1 || DsHnguhE > 20)
							throw new NumberFormatException("Number to small/large");
					} catch (NumberFormatException VB3EeCcy) {
						OduYG0Gn.println("The parameter <code>numbertoexport</code>must be an integer from 1 to 20");
					}
				}
				ZPGsYsqR.setContentType("text/xml");
				RssWriter mMV3xrQT = new RssWriter();
				mMV3xrQT.setWriter(ZPGsYsqR.getWriter());
				AtomContainerSet sZbC5K0C = new AtomContainerSet();
				String WxTCjICq = "select distinct MOLECULE.MOLECULE_ID from MOLECULE, SPECTRUM where SPECTRUM.MOLECULE_ID = MOLECULE.MOLECULE_ID and SPECTRUM.REVIEW_FLAG =\"true\" order by MOLECULE.DATE desc;";
				List gk1v0b7R = NmrshiftdbUserPeer.executeQuery(WxTCjICq);
				for (int X7JAkwXS = 0; X7JAkwXS < DsHnguhE; X7JAkwXS++) {
					if (X7JAkwXS == gk1v0b7R.size())
						break;
					DBMolecule svrIcswg = DBMoleculePeer
							.retrieveByPK(new NumberKey(((Record) gk1v0b7R.get(X7JAkwXS)).getValue(1).asInt()));
					IMolecule HFMbKmu0 = svrIcswg.getAsCDKMoleculeAsEntered(1);
					sZbC5K0C.addAtomContainer(HFMbKmu0);
					mMV3xrQT.getLinkmap().put(HFMbKmu0, svrIcswg.getEasylink(kF9c7BPn));
					mMV3xrQT.getDatemap().put(HFMbKmu0, svrIcswg.getDate());
					mMV3xrQT.getTitlemap().put(HFMbKmu0, svrIcswg.getChemicalNamesAsOneStringWithFallback());
					mMV3xrQT.getCreatormap().put(HFMbKmu0, svrIcswg.getNmrshiftdbUser().getUserName());
					mMV3xrQT.setCreator(GeneralUtils.getAdminEmail(getServletConfig()));
					Vector BWknOahh = svrIcswg.getDBCanonicalNames();
					for (int ho5sWD3L = 0; ho5sWD3L < BWknOahh.size(); ho5sWD3L++) {
						DBCanonicalName cLwiMABc = (DBCanonicalName) BWknOahh.get(ho5sWD3L);
						if (cLwiMABc.getDBCanonicalNameType().getCanonicalNameType() == "INChI") {
							mMV3xrQT.getInchimap().put(HFMbKmu0, cLwiMABc.getName());
							break;
						}
					}
					mMV3xrQT.setTitle("NMRShiftDB");
					mMV3xrQT.setLink("http://www.nmrshiftdb.org");
					mMV3xrQT.setDescription(
							"NMRShiftDB is an open-source, open-access, open-submission, open-content web database for chemical structures and their nuclear magnetic resonance data");
					mMV3xrQT.setPublisher("NMRShiftDB.org");
					mMV3xrQT.setImagelink("http://www.nmrshiftdb.org/images/nmrshift-logo.gif");
					mMV3xrQT.setAbout("http://www.nmrshiftdb.org/NmrshiftdbServlet?nmrshiftdbaction=rss");
					Collection fz8ldCTL = new ArrayList();
					Vector r6Oqhksb = svrIcswg.selectSpectra(null);
					for (int O26HasIh = 0; O26HasIh < r6Oqhksb.size(); O26HasIh++) {
						Element joNbFKyE = ((DBSpectrum) r6Oqhksb.get(O26HasIh)).getCmlSpect();
						Element jUpvwirr = joNbFKyE.getChildElements().get(0);
						joNbFKyE.removeChild(jUpvwirr);
						fz8ldCTL.add(jUpvwirr);
					}
					mMV3xrQT.getMultiMap().put(HFMbKmu0, fz8ldCTL);
				}
				mMV3xrQT.write(sZbC5K0C);
			} else if (GK6qZXSv.equals("getattachment")) {
				ZPGsYsqR.setContentType("application/zip");
				PC4X4Qen = ZPGsYsqR.getOutputStream();
				DBSample ZuHvBZPx = DBSamplePeer.retrieveByPK(new NumberKey(kF9c7BPn.getParameter("sampleid")));
				PC4X4Qen.write(ZuHvBZPx.getAttachment());
			} else if (GK6qZXSv.equals("createreport")) {
				ZPGsYsqR.setContentType("application/pdf");
				PC4X4Qen = ZPGsYsqR.getOutputStream();
				boolean zfycPH5k = kF9c7BPn.getParameter("style").equals("yearly");
				int S7ROf8E5 = Integer.parseInt(kF9c7BPn.getParameter("yearstart"));
				int tYQOIv6H = Integer.parseInt(kF9c7BPn.getParameter("yearend"));
				int AoS9dpxO = 0;
				int gcRQ0xHh = 0;
				if (!zfycPH5k) {
					AoS9dpxO = Integer.parseInt(kF9c7BPn.getParameter("monthstart"));
					gcRQ0xHh = Integer.parseInt(kF9c7BPn.getParameter("monthend"));
				}
				int pZMCZqAX = Integer.parseInt(kF9c7BPn.getParameter("type"));
				JasperReport Tr4oZLtk = (JasperReport) JRLoader.loadObject(
						k3ttFxOj + "/reports/" + (zfycPH5k ? "yearly" : "monthly") + "_report_" + pZMCZqAX + ".jasper");
				Map CnRIewEY = new HashMap();
				if (zfycPH5k)
					CnRIewEY.put("HEADER", "Report for years " + S7ROf8E5 + " - " + tYQOIv6H);
				else
					CnRIewEY.put("HEADER",
							"Report for " + AoS9dpxO + "/" + S7ROf8E5 + " - " + gcRQ0xHh + "/" + tYQOIv6H);
				DBConnection E5OJVjgN = TurbineDB.getConnection();
				Connection Wz5ebgyJ = E5OJVjgN.getConnection();
				Statement oBDPecls = Wz5ebgyJ.createStatement();
				ResultSet q5LUAcGB = null;
				if (pZMCZqAX == 1) {
					q5LUAcGB = oBDPecls.executeQuery("select YEAR(DATE) as YEAR, "
							+ (zfycPH5k ? "" : " MONTH(DATE) as MONTH, ")
							+ "AFFILIATION_1, AFFILIATION_2, MACHINE.NAME as NAME, count(*) as C, sum(WISHED_SPECTRUM like '%13C%' or WISHED_SPECTRUM like '%variable temperature%' or WISHED_SPECTRUM like '%ID sel. NOE%' or WISHED_SPECTRUM like '%solvent suppression%' or WISHED_SPECTRUM like '%standard spectrum%') as 1_D, sum(WISHED_SPECTRUM like '%H,H-COSY%' or WISHED_SPECTRUM like '%NOESY%' or WISHED_SPECTRUM like '%HMQC%' or WISHED_SPECTRUM like '%HMBC%') as 2_D, sum(OTHER_WISHED_SPECTRUM!='') as SPECIAL, sum(OTHER_NUCLEI!='') as HETERO, sum(PROCESS='self') as SELF, sum(PROCESS='robot') as ROBOT, sum(PROCESS='worker') as OPERATOR from (SAMPLE join TURBINE_USER using (USER_ID)) join MACHINE on MACHINE.MACHINE_ID=SAMPLE.MACHINE where YEAR(DATE)>="
							+ S7ROf8E5 + " and YEAR(DATE)<=" + tYQOIv6H + " and LOGIN_NAME<>'testuser' group by YEAR, "
							+ (zfycPH5k ? "" : "MONTH, ") + "AFFILIATION_1, AFFILIATION_2, MACHINE.NAME");
				} else if (pZMCZqAX == 2) {
					q5LUAcGB = oBDPecls.executeQuery("select YEAR(DATE) as YEAR, "
							+ (zfycPH5k ? "" : " MONTH(DATE) as MONTH, ")
							+ "MACHINE.NAME as NAME, count(*) as C, sum(WISHED_SPECTRUM like '%13C%' or WISHED_SPECTRUM like '%variable temperature%' or WISHED_SPECTRUM like '%ID sel. NOE%' or WISHED_SPECTRUM like '%solvent suppression%' or WISHED_SPECTRUM like '%standard spectrum%') as 1_D, sum(WISHED_SPECTRUM like '%H,H-COSY%' or WISHED_SPECTRUM like '%NOESY%' or WISHED_SPECTRUM like '%HMQC%' or WISHED_SPECTRUM like '%HMBC%') as 2_D, sum(OTHER_WISHED_SPECTRUM!='') as SPECIAL, sum(OTHER_NUCLEI!='') as HETERO, sum(PROCESS='self') as SELF, sum(PROCESS='robot') as ROBOT, sum(PROCESS='worker') as OPERATOR from (SAMPLE join TURBINE_USER using (USER_ID)) join MACHINE on MACHINE.MACHINE_ID=SAMPLE.MACHINE group by YEAR, "
							+ (zfycPH5k ? "" : "MONTH, ") + "MACHINE.NAME");
				}
				JasperPrint XbptCUPC = JasperFillManager.fillReport(Tr4oZLtk, CnRIewEY,
						new JRResultSetDataSource(q5LUAcGB));
				JasperExportManager.exportReportToPdfStream(XbptCUPC, PC4X4Qen);
				E5OJVjgN.close();
			} else if (GK6qZXSv.equals("exportcmlbyinchi")) {
				ZPGsYsqR.setContentType("text/xml");
				OduYG0Gn = ZPGsYsqR.getWriter();
				String HiJkZHiN = kF9c7BPn.getParameter("inchi");
				String dYyQ9Lh4 = kF9c7BPn.getParameter("spectrumtype");
				Criteria X0w0tqcR = new Criteria();
				X0w0tqcR.add(DBCanonicalNamePeer.NAME, HiJkZHiN);
				X0w0tqcR.addJoin(DBCanonicalNamePeer.MOLECULE_ID, DBSpectrumPeer.MOLECULE_ID);
				X0w0tqcR.addJoin(DBSpectrumPeer.SPECTRUM_TYPE_ID, DBSpectrumTypePeer.SPECTRUM_TYPE_ID);
				X0w0tqcR.add(DBSpectrumTypePeer.NAME, dYyQ9Lh4);
				try {
					GeneralUtils.logToSql(X0w0tqcR.toString(), null);
				} catch (Exception evrCETZa) {
				}
				Vector TvfFpGPg = DBSpectrumPeer.doSelect(X0w0tqcR);
				if (TvfFpGPg.size() == 0) {
					OduYG0Gn.write("No such molecule or spectrum");
				} else {
					Element bxdNJ1eR = new Element("cml");
					bxdNJ1eR.addAttribute(new Attribute("convention", "nmrshiftdb-convention"));
					bxdNJ1eR.setNamespaceURI("http://www.xml-cml.org/schema");
					Element NrRFpq1S = ((DBSpectrum) TvfFpGPg.get(0)).getDBMolecule().getCML(1);
					nu.xom.Node Idoui89b = NrRFpq1S.getChild(0);
					((Element) Idoui89b).setNamespaceURI("http://www.xml-cml.org/schema");
					NrRFpq1S.removeChildren();
					bxdNJ1eR.appendChild(Idoui89b);
					for (int l7rXTEEG = 0; l7rXTEEG < TvfFpGPg.size(); l7rXTEEG++) {
						Element XPXzV0Tf = ((DBSpectrum) TvfFpGPg.get(l7rXTEEG)).getCmlSpect();
						Node UWYZJRY7 = XPXzV0Tf.getChild(0);
						XPXzV0Tf.removeChildren();
						bxdNJ1eR.appendChild(UWYZJRY7);
						((Element) UWYZJRY7).setNamespaceURI("http://www.xml-cml.org/schema");
					}
					OduYG0Gn.write(bxdNJ1eR.toXML());
				}
			} else if (GK6qZXSv.equals("namelist")) {
				ZPGsYsqR.setContentType("application/zip");
				PC4X4Qen = ZPGsYsqR.getOutputStream();
				ByteArrayOutputStream iuxfs9TL = new ByteArrayOutputStream();
				ZipOutputStream I8Rf331b = new ZipOutputStream(iuxfs9TL);
				Criteria j6cfKPH9 = new Criteria();
				j6cfKPH9.addJoin(DBMoleculePeer.MOLECULE_ID, DBSpectrumPeer.MOLECULE_ID);
				j6cfKPH9.add(DBSpectrumPeer.REVIEW_FLAG, "true");
				Vector zi33FKmD = DBMoleculePeer.doSelect(j6cfKPH9);
				for (int E8Dtnf2C = 0; E8Dtnf2C < zi33FKmD.size(); E8Dtnf2C++) {
					if (E8Dtnf2C % 500 == 0) {
						if (E8Dtnf2C != 0) {
							I8Rf331b.write(new String("<p>The list is continued <a href=\"nmrshiftdb.names." + E8Dtnf2C
									+ ".html\">here</a></p></body></html>").getBytes());
							I8Rf331b.closeEntry();
						}
						I8Rf331b.putNextEntry(new ZipEntry("nmrshiftdb.names." + E8Dtnf2C + ".html"));
						I8Rf331b.write(new String(
								"<html><body><h1>This is a list of strcutures in <a href=\"http://www.nmrshiftdb.org\">NMRShiftDB</a>, starting at "
										+ E8Dtnf2C + ", Its main purpose is to be found by search engines</h1>")
												.getBytes());
					}
					DBMolecule z9moPPVH = (DBMolecule) zi33FKmD.get(E8Dtnf2C);
					I8Rf331b.write(new String("<p><a href=\"" + z9moPPVH.getEasylink(kF9c7BPn) + "\">").getBytes());
					Vector qvIC34jb = z9moPPVH.getDBCanonicalNames();
					for (int W6BfEQwh = 0; W6BfEQwh < qvIC34jb.size(); W6BfEQwh++) {
						I8Rf331b.write(
								new String(((DBCanonicalName) qvIC34jb.get(W6BfEQwh)).getName() + " ").getBytes());
					}
					Vector g1VOFtKf = z9moPPVH.getDBChemicalNames();
					for (int axNJmpD1 = 0; axNJmpD1 < g1VOFtKf.size(); axNJmpD1++) {
						I8Rf331b.write(
								new String(((DBChemicalName) g1VOFtKf.get(axNJmpD1)).getName() + " ").getBytes());
					}
					I8Rf331b.write(new String("</a>. Information we have got: NMR spectra").getBytes());
					Vector UaRLULZc = z9moPPVH.selectSpectra();
					for (int g9yjJmV1 = 0; g9yjJmV1 < UaRLULZc.size(); g9yjJmV1++) {
						I8Rf331b.write(
								new String(((DBSpectrum) UaRLULZc.get(g9yjJmV1)).getDBSpectrumType().getName() + ", ")
										.getBytes());
					}
					if (z9moPPVH.hasAny3d())
						I8Rf331b.write(new String("3D coordinates, ").getBytes());
					I8Rf331b.write(new String("File formats: CML, mol, png, jpeg").getBytes());
					I8Rf331b.write(new String("</p>").getBytes());
				}
				I8Rf331b.write(new String("</body></html>").getBytes());
				I8Rf331b.closeEntry();
				I8Rf331b.close();
				InputStream cCsnt09X = new ByteArrayInputStream(iuxfs9TL.toByteArray());
				byte[] VlLv0u25 = new byte[32 * 1024];
				int hhAimXmZ = 0;
				while ((hhAimXmZ = cCsnt09X.read(VlLv0u25)) != -1) {
					PC4X4Qen.write(VlLv0u25, 0, hhAimXmZ);
				}
			} else if (GK6qZXSv.equals("predictor")) {
				if (kF9c7BPn.getParameter("symbol") == null) {
					ZPGsYsqR.setContentType("text/plain");
					OduYG0Gn = ZPGsYsqR.getWriter();
					OduYG0Gn.write(
							"please give the symbol to create the predictor for in the request with symbol=X (e. g. symbol=C");
				}
				ZPGsYsqR.setContentType("application/zip");
				PC4X4Qen = ZPGsYsqR.getOutputStream();
				ByteArrayOutputStream c9wU9Y6v = new ByteArrayOutputStream();
				ZipOutputStream mFrPRonq = new ZipOutputStream(c9wU9Y6v);
				String UJWr7kJG = "org/openscience/nmrshiftdb/PredictionTool.class";
				mFrPRonq.putNextEntry(new ZipEntry(UJWr7kJG));
				JarInputStream yl4Mjg4O = new JarInputStream(new FileInputStream(
						ServletUtils.expandRelative(getServletConfig(), "/WEB-INF/lib/nmrshiftdb-lib.jar")));
				JarEntry xL2AwsXA = yl4Mjg4O.getNextJarEntry();
				while (xL2AwsXA.getName().indexOf("PredictionTool.class") == -1) {
					xL2AwsXA = yl4Mjg4O.getNextJarEntry();
				}
				for (int XBiAHfCk = 0; XBiAHfCk < xL2AwsXA.getSize(); XBiAHfCk++) {
					mFrPRonq.write(yl4Mjg4O.read());
				}
				mFrPRonq.closeEntry();
				mFrPRonq.putNextEntry(new ZipEntry("nmrshiftdb.csv"));
				int a9VhneYT = 0;
				org.apache.turbine.util.db.pool.DBConnection lHKWq4GM = TurbineDB.getConnection();
				HashMap RAfwznzd = new HashMap();
				while (true) {
					Statement d3HGCDLQ = lHKWq4GM.createStatement();
					ResultSet mdW5PFmX = d3HGCDLQ.executeQuery(
							"select HOSE_CODE, VALUE, SYMBOL from HOSE_CODES where CONDITION_TYPE='m' and WITH_RINGS=0 and SYMBOL='"
									+ kF9c7BPn.getParameter("symbol") + "' limit " + (a9VhneYT * 1000) + ", 1000");
					int E8mD8kYu = 0;
					while (mdW5PFmX.next()) {
						String dbbEi0xu = mdW5PFmX.getString(1);
						Double ix67jJTk = new Double(mdW5PFmX.getString(2));
						String um8paPgA = mdW5PFmX.getString(3);
						if (RAfwznzd.get(um8paPgA) == null) {
							RAfwznzd.put(um8paPgA, new HashMap());
						}
						for (int yeeiDLbU = 6; yeeiDLbU > 0; yeeiDLbU--) {
							StringBuffer JfQ4LCx9 = new StringBuffer();
							StringTokenizer Bmq2zr5b = new StringTokenizer(dbbEi0xu, "()/");
							for (int lj2weBZC = 0; lj2weBZC < yeeiDLbU; lj2weBZC++) {
								if (Bmq2zr5b.hasMoreTokens()) {
									String wPxlqWDr = Bmq2zr5b.nextToken();
									JfQ4LCx9.append(wPxlqWDr);
								}
								if (lj2weBZC == 0) {
									JfQ4LCx9.append("(");
								} else if (lj2weBZC == 3) {
									JfQ4LCx9.append(")");
								} else {
									JfQ4LCx9.append("/");
								}
							}
							String VHw7pIgj = JfQ4LCx9.toString();
							if (((HashMap) RAfwznzd.get(um8paPgA)).get(VHw7pIgj) == null) {
								((HashMap) RAfwznzd.get(um8paPgA)).put(VHw7pIgj, new ArrayList());
							}
							((ArrayList) ((HashMap) RAfwznzd.get(um8paPgA)).get(VHw7pIgj)).add(ix67jJTk);
						}
						E8mD8kYu++;
					}
					a9VhneYT++;
					d3HGCDLQ.close();
					if (E8mD8kYu == 0)
						break;
				}
				Set g1sOO8qT = RAfwznzd.keySet();
				Iterator wZJxXFO8 = g1sOO8qT.iterator();
				while (wZJxXFO8.hasNext()) {
					String qTJ9KxjE = (String) wZJxXFO8.next();
					HashMap QNSKYKF4 = ((HashMap) RAfwznzd.get(qTJ9KxjE));
					Set r7651mux = QNSKYKF4.keySet();
					Iterator Pg8enjaL = r7651mux.iterator();
					while (Pg8enjaL.hasNext()) {
						String EAyDfKDw = (String) Pg8enjaL.next();
						ArrayList QbtNWE9S = ((ArrayList) QNSKYKF4.get(EAyDfKDw));
						double[] IaQyAphH = new double[QbtNWE9S.size()];
						for (int Um4iLYnR = 0; Um4iLYnR < QbtNWE9S.size(); Um4iLYnR++) {
							IaQyAphH[Um4iLYnR] = ((Double) QbtNWE9S.get(Um4iLYnR)).doubleValue();
						}
						mFrPRonq.write(new String(qTJ9KxjE + "|" + EAyDfKDw + "|" + Statistics.minimum(IaQyAphH) + "|"
								+ Statistics.average(IaQyAphH) + "|" + Statistics.maximum(IaQyAphH) + "\r\n")
										.getBytes());
					}
				}
				mFrPRonq.closeEntry();
				mFrPRonq.close();
				InputStream TdDodICA = new ByteArrayInputStream(c9wU9Y6v.toByteArray());
				byte[] hteIJDeO = new byte[32 * 1024];
				int NRWkL0ik = 0;
				a9VhneYT = 0;
				while ((NRWkL0ik = TdDodICA.read(hteIJDeO)) != -1) {
					PC4X4Qen.write(hteIJDeO, 0, NRWkL0ik);
				}
			} else if (GK6qZXSv.equals("exportspec") || GK6qZXSv.equals("exportmol")) {
				if (z1pVMEx8 > -1)
					cnQ8TQp6 = DBSpectrumPeer.retrieveByPK(new NumberKey(z1pVMEx8));
				else
					cnQ8TQp6 = DBSpectrumPeer.retrieveByPK(new NumberKey(kF9c7BPn.getParameter("spectrumid")));
				PRw2frFM = new Export(cnQ8TQp6);
			} else if (GK6qZXSv.equals("exportmdl")) {
				ZPGsYsqR.setContentType("text/plain");
				PC4X4Qen = ZPGsYsqR.getOutputStream();
				DBMolecule gKJIjuak = DBMoleculePeer.retrieveByPK(new NumberKey(kF9c7BPn.getParameter("moleculeid")));
				PC4X4Qen.write(gKJIjuak.getStructureFile(Integer.parseInt(kF9c7BPn.getParameter("coordsetid")), false)
						.getBytes());
			} else if (GK6qZXSv.equals("exportlastinputs")) {
				zDInAddn = GK6qZXSv;
			} else if (GK6qZXSv.equals("printpredict")) {
				ZPGsYsqR.setContentType("text/html");
				OduYG0Gn = ZPGsYsqR.getWriter();
				HttpSession hpb9USQJ = kF9c7BPn.getSession();
				VelocityContext FRpRWTBO = PredictPortlet.getContext(hpb9USQJ, true, true, new StringBuffer(),
						getServletConfig(), kF9c7BPn, true);
				StringWriter ZFZAk8W4 = new StringWriter();
				Velocity.mergeTemplate("predictprint.vm", "ISO-8859-1", FRpRWTBO, ZFZAk8W4);
				OduYG0Gn.println(ZFZAk8W4.toString());
			} else {
				ZPGsYsqR.setContentType("text/html");
				OduYG0Gn = ZPGsYsqR.getWriter();
				OduYG0Gn.println("No valid action");
			}
			if (zDInAddn == null)
				zDInAddn = "";
			if (zDInAddn.equals("pdf") || zDInAddn.equals("rtf")) {
				ZPGsYsqR.setContentType("application/" + zDInAddn);
				OduYG0Gn = ZPGsYsqR.getWriter();
			}
			if (zDInAddn.equals("docbook")) {
				ZPGsYsqR.setContentType("application/zip");
				PC4X4Qen = ZPGsYsqR.getOutputStream();
			}
			if (zDInAddn.equals("svg")) {
				ZPGsYsqR.setContentType("image/x-svg");
				OduYG0Gn = ZPGsYsqR.getWriter();
			}
			if (zDInAddn.equals("tiff")) {
				ZPGsYsqR.setContentType("image/tiff");
				PC4X4Qen = ZPGsYsqR.getOutputStream();
			}
			if (zDInAddn.equals("jpeg")) {
				ZPGsYsqR.setContentType("image/jpeg");
				PC4X4Qen = ZPGsYsqR.getOutputStream();
			}
			if (zDInAddn.equals("png")) {
				ZPGsYsqR.setContentType("image/png");
				PC4X4Qen = ZPGsYsqR.getOutputStream();
			}
			if (zDInAddn.equals("mdl") || zDInAddn.equals("txt") || zDInAddn.equals("cml") || zDInAddn.equals("cmlboth")
					|| zDInAddn.indexOf("exsection") == 0) {
				ZPGsYsqR.setContentType("text/plain");
				OduYG0Gn = ZPGsYsqR.getWriter();
			}
			if (zDInAddn.equals("simplehtml") || zDInAddn.equals("exportlastinputs")) {
				ZPGsYsqR.setContentType("text/html");
				OduYG0Gn = ZPGsYsqR.getWriter();
			}
			if (GK6qZXSv.equals("exportlastinputs")) {
				int FZO1TZUi = 4;
				if (kF9c7BPn.getParameter("numbertoexport") != null) {
					try {
						FZO1TZUi = Integer.parseInt(kF9c7BPn.getParameter("numbertoexport"));
						if (FZO1TZUi < 1 || FZO1TZUi > 20)
							throw new NumberFormatException("Number to small/large");
					} catch (NumberFormatException DhDCjHAo) {
						OduYG0Gn.println("The parameter <code>numbertoexport</code>must be an integer from 1 to 20");
					}
				}
				NmrshiftdbUser eQNfGP7r = null;
				try {
					eQNfGP7r = NmrshiftdbUserPeer.getByName(kF9c7BPn.getParameter("username"));
				} catch (NmrshiftdbException TxWNiI7B) {
					OduYG0Gn.println("Seems <code>username</code> is not OK: " + TxWNiI7B.getMessage());
				}
				if (eQNfGP7r != null) {
					List P7grvoUS = NmrshiftdbUserPeer
							.executeQuery("SELECT LAST_DOWNLOAD_DATE FROM TURBINE_USER  where LOGIN_NAME=\""
									+ eQNfGP7r.getUserName() + "\";");
					Date IGvdVVFB = ((Record) P7grvoUS.get(0)).getValue(1).asDate();
					if (((new Date().getTime() - IGvdVVFB.getTime()) / 3600000) < 24) {
						OduYG0Gn.println("Your last download was at " + IGvdVVFB
								+ ". You may download your last inputs only once a day. Sorry for this, but we need to be carefull with resources. If you want to put your last inputs on your homepage best use some sort of cache (e. g. use wget for downlaod with crond and link to this static resource))!");
					} else {
						NmrshiftdbUserPeer
								.executeStatement("UPDATE TURBINE_USER SET LAST_DOWNLOAD_DATE=NOW() where LOGIN_NAME=\""
										+ eQNfGP7r.getUserName() + "\";");
						Vector<String> gwYu0XYx = new Vector<String>();
						String IGpamIFd = "select distinct MOLECULE.MOLECULE_ID from MOLECULE, SPECTRUM where SPECTRUM.MOLECULE_ID = MOLECULE.MOLECULE_ID and SPECTRUM.REVIEW_FLAG =\"true\" and SPECTRUM.USER_ID="
								+ eQNfGP7r.getUserId() + " order by MOLECULE.DATE desc;";
						P7grvoUS = NmrshiftdbUserPeer.executeQuery(IGpamIFd);
						String Eh55OcCq = javax.servlet.http.HttpUtils.getRequestURL(kF9c7BPn).toString();
						Eh55OcCq = Eh55OcCq.substring(0, Eh55OcCq.length() - 17);
						for (int PBdOjx45 = 0; PBdOjx45 < FZO1TZUi; PBdOjx45++) {
							if (PBdOjx45 == P7grvoUS.size())
								break;
							DBMolecule rTo6B2ox = DBMoleculePeer
									.retrieveByPK(new NumberKey(((Record) P7grvoUS.get(PBdOjx45)).getValue(1).asInt()));
							gwYu0XYx.add(new String("<a href=\"" + Eh55OcCq
									+ "/portal/pane0/Results?nmrshiftdbaction=showDetailsFromHome&molNumber="
									+ rTo6B2ox.getMoleculeId() + "\"><img src=\""
									+ javax.servlet.http.HttpUtils.getRequestURL(kF9c7BPn).toString()
									+ "?nmrshiftdbaction=exportmol&spectrumid="
									+ ((DBSpectrum) rTo6B2ox.getDBSpectrums().get(0)).getSpectrumId()
									+ "&format=jpeg&size=150x150&backcolor=12632256\"></a>"));
						}
						VelocityContext fU5OEMLp = new VelocityContext();
						fU5OEMLp.put("results", gwYu0XYx);
						StringWriter nlfb3JGt = new StringWriter();
						Velocity.mergeTemplate("lateststructures.vm", "ISO-8859-1", fU5OEMLp, nlfb3JGt);
						OduYG0Gn.println(nlfb3JGt.toString());
					}
				}
			}
			if (GK6qZXSv.equals("exportspec")) {
				if (zDInAddn.equals("txt")) {
					String baTQU58N = kF9c7BPn.getParameter("lastsearchtype");
					if (baTQU58N.equals(NmrshiftdbConstants.TOTALSPECTRUM)
							|| baTQU58N.equals(NmrshiftdbConstants.SUBSPECTRUM)) {
						List IFDgxTF9 = ParseUtils.parseSpectrumFromSpecFile(kF9c7BPn.getParameter("lastsearchvalues"));
						cnQ8TQp6.initSimilarity(IFDgxTF9, baTQU58N.equals(NmrshiftdbConstants.SUBSPECTRUM));
					}
					Vector dvFGmKKA = cnQ8TQp6.getOptions();
					DBMolecule HmwdfKWv = cnQ8TQp6.getDBMolecule();
					OduYG0Gn.print(HmwdfKWv.getChemicalNamesAsOneString(false) + HmwdfKWv.getMolecularFormula(false)
							+ "; " + HmwdfKWv.getMolecularWeight() + " Dalton\n\r");
					OduYG0Gn.print("\n\rAtom\t");
					if (cnQ8TQp6.getDBSpectrumType().getElementSymbol() == ("H"))
						OduYG0Gn.print("Mult.\t");
					OduYG0Gn.print("Meas.");
					if (baTQU58N.equals(NmrshiftdbConstants.TOTALSPECTRUM)
							|| baTQU58N.equals(NmrshiftdbConstants.SUBSPECTRUM)) {
						OduYG0Gn.print("\tInput\tDiff");
					}
					OduYG0Gn.print("\n\r");
					OduYG0Gn.print("No.\t");
					if (cnQ8TQp6.getDBSpectrumType().getElementSymbol() == ("H"))
						OduYG0Gn.print("\t");
					OduYG0Gn.print("Shift");
					if (baTQU58N.equals(NmrshiftdbConstants.TOTALSPECTRUM)
							|| baTQU58N.equals(NmrshiftdbConstants.SUBSPECTRUM)) {
						OduYG0Gn.print("\tShift\tM-I");
					}
					OduYG0Gn.print("\n\r");
					for (int QnxcIdNn = 0; QnxcIdNn < dvFGmKKA.size(); QnxcIdNn++) {
						OduYG0Gn.print(((ValuesForVelocityBean) dvFGmKKA.get(QnxcIdNn)).getDisplayText() + "\t"
								+ ((ValuesForVelocityBean) dvFGmKKA.get(QnxcIdNn)).getRange());
						if (baTQU58N.equals(NmrshiftdbConstants.TOTALSPECTRUM)
								|| baTQU58N.equals(NmrshiftdbConstants.SUBSPECTRUM)) {
							OduYG0Gn.print("\t" + ((ValuesForVelocityBean) dvFGmKKA.get(QnxcIdNn)).getNameForElements()
									+ "\t" + ((ValuesForVelocityBean) dvFGmKKA.get(QnxcIdNn)).getDelta());
						}
						OduYG0Gn.print("\n\r");
					}
				}
				if (zDInAddn.equals("simplehtml")) {
					String V2T0E28j = PRw2frFM.getImage(false, "jpeg",
							ServletUtils.expandRelative(this.getServletConfig(), "/nmrshiftdbhtml") + "/tmp/"
									+ System.currentTimeMillis(),
							true);
					PRw2frFM.pictures[0] = new File(V2T0E28j).getName();
					String KHJsyjtc = PRw2frFM.getImage(true, "jpeg",
							ServletUtils.expandRelative(this.getServletConfig(), "/nmrshiftdbhtml") + "/tmp/"
									+ System.currentTimeMillis(),
							true);
					PRw2frFM.pictures[1] = new File(KHJsyjtc).getName();
					String ALn9tVLX = PRw2frFM.getHtml();
					OduYG0Gn.print(ALn9tVLX);
				}
				if (zDInAddn.equals("pdf") || zDInAddn.equals("rtf")) {
					String aEPPstZ4 = PRw2frFM.getSpecSvg(400, 200);
					String UKAqmeZI = k3ttFxOj + "/tmp/" + System.currentTimeMillis() + "s.svg";
					new FileOutputStream(UKAqmeZI).write(aEPPstZ4.getBytes());
					PRw2frFM.pictures[1] = UKAqmeZI;
					String NClH3x7C = PRw2frFM.getMolSvg(true);
					String fPtxq43P = k3ttFxOj + "/tmp/" + System.currentTimeMillis() + "m.svg";
					new FileOutputStream(fPtxq43P).write(NClH3x7C.getBytes());
					PRw2frFM.pictures[0] = fPtxq43P;
					String QWTAeXZN = PRw2frFM.getDocbook("pdf", "SVG");
					TransformerFactory prbpliX9 = TransformerFactory.newInstance();
					Transformer bmCf4Ch6 = prbpliX9.newTransformer(new StreamSource(
							"file:" + GeneralUtils.getNmrshiftdbProperty("docbookxslpath", getServletConfig())
									+ "/fo/docbook.xsl"));
					ByteArrayOutputStream qRdpuhPY = new ByteArrayOutputStream();
					bmCf4Ch6.transform(new StreamSource(new StringReader(QWTAeXZN)), new StreamResult(qRdpuhPY));
					FopFactory F2XYKZ1A = FopFactory.newInstance();
					FOUserAgent gLx5srIB = F2XYKZ1A.newFOUserAgent();
					OutputStream cYPuTks1 = new ByteArrayOutputStream();
					Fop vBjEWQbR = F2XYKZ1A.newFop(
							zDInAddn.equals("rtf") ? MimeConstants.MIME_RTF : MimeConstants.MIME_PDF, gLx5srIB,
							cYPuTks1);
					TransformerFactory l331AVJk = TransformerFactory.newInstance();
					bmCf4Ch6 = l331AVJk.newTransformer();
					Source PzKcm5AM = new StreamSource(new StringReader(qRdpuhPY.toString()));
					Result acJsJ6pc = new SAXResult(vBjEWQbR.getDefaultHandler());
					bmCf4Ch6.transform(PzKcm5AM, acJsJ6pc);
					OduYG0Gn.print(cYPuTks1.toString());
				}
				if (zDInAddn.equals("docbook")) {
					String mgXKRazY = k3ttFxOj + "/tmp/" + System.currentTimeMillis() + ".svg";
					new FileOutputStream(mgXKRazY).write(PRw2frFM.getSpecSvg(300, 200).getBytes());
					PRw2frFM.pictures[0] = new File(mgXKRazY).getName();
					String MFwPsnSu = k3ttFxOj + "/tmp/" + System.currentTimeMillis() + ".svg";
					new FileOutputStream(MFwPsnSu).write(PRw2frFM.getMolSvg(true).getBytes());
					PRw2frFM.pictures[1] = new File(MFwPsnSu).getName();
					String Zurxqb9b = PRw2frFM.getDocbook("pdf", "SVG");
					String HrxWryH6 = k3ttFxOj + "/tmp/" + System.currentTimeMillis() + ".xml";
					new FileOutputStream(HrxWryH6).write(Zurxqb9b.getBytes());
					ByteArrayOutputStream ReNGxX7H = PRw2frFM.makeZip(new String[] { HrxWryH6, mgXKRazY, MFwPsnSu });
					PC4X4Qen.write(ReNGxX7H.toByteArray());
				}
				if (zDInAddn.equals("svg")) {
					OduYG0Gn.print(PRw2frFM.getSpecSvg(400, 200));
				}
				if (zDInAddn.equals("tiff") || zDInAddn.equals("jpeg") || zDInAddn.equals("png")) {
					InputStream et5t4LWK = new FileInputStream(
							PRw2frFM.getImage(false, zDInAddn, k3ttFxOj + "/tmp/" + System.currentTimeMillis(), true));
					byte[] BoxikDUs = new byte[32 * 1024];
					int RNeDQAb1 = 0;
					while ((RNeDQAb1 = et5t4LWK.read(BoxikDUs)) != -1) {
						PC4X4Qen.write(BoxikDUs, 0, RNeDQAb1);
					}
				}
				if (zDInAddn.equals("cml")) {
					OduYG0Gn.print(cnQ8TQp6.getCmlSpect().toXML());
				}
				if (zDInAddn.equals("cmlboth")) {
					Element JD6BzRPT = new Element("cml");
					JD6BzRPT.addAttribute(new Attribute("convention", "nmrshiftdb-convention"));
					JD6BzRPT.setNamespaceURI("http://www.xml-cml.org/schema");
					Element zYFnmUnb = cnQ8TQp6.getDBMolecule().getCML(1,
							cnQ8TQp6.getDBSpectrumType().getName().equals("1H"));
					nu.xom.Node toMUA7nW = zYFnmUnb.getChild(0);
					((Element) toMUA7nW).setNamespaceURI("http://www.xml-cml.org/schema");
					zYFnmUnb.removeChildren();
					JD6BzRPT.appendChild(toMUA7nW);
					Element NFI1ExxR = cnQ8TQp6.getCmlSpect();
					Node MCLSyn0B = NFI1ExxR.getChild(0);
					NFI1ExxR.removeChildren();
					JD6BzRPT.appendChild(MCLSyn0B);
					((Element) MCLSyn0B).setNamespaceURI("http://www.xml-cml.org/schema");
					OduYG0Gn.write(JD6BzRPT.toXML());
				}
				if (zDInAddn.indexOf("exsection") == 0) {
					StringTokenizer Tra6R2rv = new StringTokenizer(zDInAddn, "-");
					Tra6R2rv.nextToken();
					String RpF0xbO7 = Tra6R2rv.nextToken();
					Criteria gWJ9D5zV = new Criteria();
					gWJ9D5zV.add(DBSpectrumPeer.USER_ID, cnQ8TQp6.getUserId());
					Vector DdhcVlMz = cnQ8TQp6.getDBMolecule().getDBSpectrums(gWJ9D5zV);
					VelocityContext aj2N87cT = new VelocityContext();
					aj2N87cT.put("spectra", DdhcVlMz);
					aj2N87cT.put("molecule", cnQ8TQp6.getDBMolecule());
					StringWriter A6xUFfsP = new StringWriter();
					Velocity.mergeTemplate("exporttemplates/" + RpF0xbO7, "ISO-8859-1", aj2N87cT, A6xUFfsP);
					OduYG0Gn.write(A6xUFfsP.toString());
				}
			}
			if (GK6qZXSv.equals("exportmol")) {
				int SJr4MoB7 = -1;
				int P94A1g98 = -1;
				if (kF9c7BPn.getParameter("size") != null) {
					StringTokenizer R7FeiTob = new StringTokenizer(kF9c7BPn.getParameter("size"), "x");
					SJr4MoB7 = Integer.parseInt(R7FeiTob.nextToken());
					P94A1g98 = Integer.parseInt(R7FeiTob.nextToken());
				}
				boolean WB8OJLiS = true;
				if (kF9c7BPn.getParameter("shownumbers") != null
						&& kF9c7BPn.getParameter("shownumbers").equals("false")) {
					WB8OJLiS = false;
				}
				if (kF9c7BPn.getParameter("backcolor") != null) {
					PRw2frFM.backColor = new Color(Integer.parseInt(kF9c7BPn.getParameter("backcolor")));
				}
				if (kF9c7BPn.getParameter("markatom") != null) {
					PRw2frFM.selected = Integer.parseInt(kF9c7BPn.getParameter("markatom")) - 1;
				}
				if (zDInAddn.equals("svg")) {
					OduYG0Gn.print(PRw2frFM.getMolSvg(true));
				}
				if (zDInAddn.equals("tiff") || zDInAddn.equals("jpeg") || zDInAddn.equals("png")) {
					InputStream TvNJioKj = new FileInputStream(PRw2frFM.getImage(true, zDInAddn,
							k3ttFxOj + "/tmp/" + System.currentTimeMillis(), SJr4MoB7, P94A1g98, WB8OJLiS, null));
					byte[] LFO95ga7 = new byte[32 * 1024];
					int WgoouH4a = 0;
					while ((WgoouH4a = TvNJioKj.read(LFO95ga7)) != -1) {
						PC4X4Qen.write(LFO95ga7, 0, WgoouH4a);
					}
				}
				if (zDInAddn.equals("mdl")) {
					OduYG0Gn.println(cnQ8TQp6.getDBMolecule().getStructureFile(1, false));
				}
				if (zDInAddn.equals("cml")) {
					OduYG0Gn.println(cnQ8TQp6.getDBMolecule().getCMLString(1));
				}
			}
			if (OduYG0Gn != null)
				OduYG0Gn.flush();
			else
				PC4X4Qen.flush();
		} catch (Exception j38oj8QS) {
			j38oj8QS.printStackTrace();
			OduYG0Gn.print(GeneralUtils.logError(j38oj8QS, "NmrshiftdbServlet", null, true));
			OduYG0Gn.flush();
		}
	}

}