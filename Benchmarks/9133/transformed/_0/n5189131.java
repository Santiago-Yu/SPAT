class n5189131 {
	public void service(Request NwZwtOEU, Response hW4sDlEp) {
		PrintStream vqUmmrss = null;
		try {
			vqUmmrss = hW4sDlEp.getPrintStream(8192);
			String sMCjZ5ne = NwZwtOEU.getParameter("env");
			String EInflDkb = NwZwtOEU.getParameter("regex");
			String Yx17JGuY = NwZwtOEU.getParameter("deep");
			String CNtKUdax = NwZwtOEU.getParameter("term");
			String ftybm0wG = NwZwtOEU.getParameter("index");
			String moYoKLT4 = NwZwtOEU.getParameter("refresh");
			String npJPZhaW = NwZwtOEU.getParameter("searcher");
			String AtbBXXHh = NwZwtOEU.getParameter("grep");
			String u9DBhuR0 = NwZwtOEU.getParameter("fi_server_details");
			String eb3qO8Se = NwZwtOEU.getParameter("server_details");
			String pfCYfJOy = NwZwtOEU.getParameter("host_details");
			String Z4swW6FI = NwZwtOEU.getParameter("name");
			String tLbfdSts = NwZwtOEU.getParameter("show");
			String Tm95nmeO = NwZwtOEU.getPath().getPath();
			int s6yHm4l8 = NwZwtOEU.getForm().getInteger("page");
			if (Tm95nmeO.startsWith("/fs")) {
				String Bk1EimTj = Tm95nmeO.replaceAll("^/fs", "");
				File VhceJG5V = new File("C:\\", Bk1EimTj.replace('/', File.separatorChar));
				if (VhceJG5V.isDirectory()) {
					vqUmmrss.write(FileSystemDirectory.getContents(new File("c:\\"), Bk1EimTj, "/fs"));
				} else {
					hW4sDlEp.set("Cache", "no-cache");
					FileInputStream uq9cntRo = new FileInputStream(VhceJG5V);
					FileChannel fX3xwFZF = uq9cntRo.getChannel();
					WritableByteChannel duKIJ2by = hW4sDlEp.getByteChannel();
					fX3xwFZF.transferTo(0, VhceJG5V.length(), duKIJ2by);
					fX3xwFZF.close();
					uq9cntRo.close();
					System.err.println("Serving " + Tm95nmeO + " as " + VhceJG5V.getCanonicalPath());
				}
			} else if (Tm95nmeO.startsWith("/files/")) {
				String[] S4J7hXWw = NwZwtOEU.getPath().getSegments();
				boolean O3YP5Q0C = false;
				if (S4J7hXWw.length > 1) {
					String bANCNiQx = NwZwtOEU.getPath().getPath(1);
					File t6w9plva = context.getFile(bANCNiQx);
					if (t6w9plva.isFile()) {
						hW4sDlEp.set("Content-Type", context.getContentType(bANCNiQx));
						FileInputStream Lpyo7NZO = new FileInputStream(t6w9plva);
						FileChannel YN7EmPrs = Lpyo7NZO.getChannel();
						WritableByteChannel TWSimSSl = hW4sDlEp.getByteChannel();
						long ESHtJ1Sq = System.currentTimeMillis();
						YN7EmPrs.transferTo(0, bANCNiQx.length(), TWSimSSl);
						YN7EmPrs.close();
						Lpyo7NZO.close();
						System.err.println("Time take to write [" + bANCNiQx + "] was ["
								+ (System.currentTimeMillis() - ESHtJ1Sq) + "] of size [" + t6w9plva.length() + "]");
						O3YP5Q0C = true;
					}
				}
				if (!O3YP5Q0C) {
					hW4sDlEp.set("Content-Type", "text/plain");
					vqUmmrss.println("Can not serve directory: path");
				}
			} else if (Tm95nmeO.startsWith("/upload")) {
				FileItemFactory BbnOcpGg = new DiskFileItemFactory();
				FileUpload at02pYR2 = new FileUpload(BbnOcpGg);
				RequestAdapter YiHEIa7S = new RequestAdapter(NwZwtOEU);
				List<FileItem> m2mGZhpH = at02pYR2.parseRequest(YiHEIa7S);
				Map<String, FileItem> TYMLUJ5J = new HashMap<String, FileItem>();
				for (FileItem FdhzZevU : m2mGZhpH) {
					String GEB5lp7s = FdhzZevU.getFieldName();
					TYMLUJ5J.put(GEB5lp7s, FdhzZevU);
				}
				hW4sDlEp.set("Content-Type", "text/html");
				vqUmmrss.println("<html>");
				vqUmmrss.println("<body>");
				for (int fVtu4RLm = 0; fVtu4RLm < 10; fVtu4RLm++) {
					Part yUYqCGap = NwZwtOEU.getPart("datafile" + (fVtu4RLm + 1));
					if (yUYqCGap != null && yUYqCGap.isFile()) {
						String NKnSUNAB = yUYqCGap.getName();
						String nADgSNxz = yUYqCGap.getFileName();
						File Q6kY8ldq = new File(nADgSNxz);
						FileItem yWhcmzQa = TYMLUJ5J.get(NKnSUNAB);
						InputStream vStO7WFe = yUYqCGap.getInputStream();
						String Rn4DG06b = yUYqCGap.getFileName().replaceAll("\\\\", "_").replaceAll(":", "_");
						File i7AtAVA3 = new File(Rn4DG06b);
						OutputStream vWsXSWPE = new FileOutputStream(i7AtAVA3);
						byte[] OMwRMPEC = new byte[8192];
						int G7Ol93PK = 0;
						while ((G7Ol93PK = vStO7WFe.read(OMwRMPEC)) != -1) {
							vWsXSWPE.write(OMwRMPEC, 0, G7Ol93PK);
						}
						vWsXSWPE.close();
						vStO7WFe.close();
						vqUmmrss.println("<table border='1'>");
						vqUmmrss.println("<tr><td><b>File</b></td><td>");
						vqUmmrss.println(i7AtAVA3.getCanonicalPath());
						vqUmmrss.println("</tr></td>");
						vqUmmrss.println("<tr><td><b>Size</b></td><td>");
						vqUmmrss.println(i7AtAVA3.length());
						vqUmmrss.println("</tr></td>");
						vqUmmrss.println("<tr><td><b>MD5</b></td><td>");
						vqUmmrss.println(Digest.getSignature(Digest.Algorithm.MD5, yUYqCGap.getInputStream()));
						vqUmmrss.println("<br>");
						vqUmmrss.println(Digest.getSignature(Digest.Algorithm.MD5, yWhcmzQa.getInputStream()));
						if (Q6kY8ldq.exists()) {
							vqUmmrss.println("<br>");
							vqUmmrss.println(Digest.getSignature(Digest.Algorithm.MD5, new FileInputStream(Q6kY8ldq)));
						}
						vqUmmrss.println("</tr></td>");
						vqUmmrss.println("<tr><td><b>SHA1</b></td><td>");
						vqUmmrss.println(Digest.getSignature(Digest.Algorithm.SHA1, yUYqCGap.getInputStream()));
						vqUmmrss.println("<br>");
						vqUmmrss.println(Digest.getSignature(Digest.Algorithm.SHA1, yWhcmzQa.getInputStream()));
						if (Q6kY8ldq.exists()) {
							vqUmmrss.println("<br>");
							vqUmmrss.println(Digest.getSignature(Digest.Algorithm.SHA1, new FileInputStream(Q6kY8ldq)));
						}
						vqUmmrss.println("</tr></td>");
						vqUmmrss.println("<tr><td><b>Header</b></td><td><pre>");
						vqUmmrss.println(yUYqCGap.toString().trim());
						vqUmmrss.println("</pre></tr></td>");
						if (nADgSNxz.toLowerCase().endsWith(".xml")) {
							String Y5nJx4Ma = yUYqCGap.getContent();
							String A1QHWWyl = format(Y5nJx4Ma);
							String gK6APZe9 = Rn4DG06b + ".formatted";
							File KlAJ4QIP = new File(gK6APZe9);
							FileOutputStream daV4a4o3 = new FileOutputStream(KlAJ4QIP);
							daV4a4o3.write(A1QHWWyl.getBytes("UTF-8"));
							vqUmmrss.println("<tr><td><b>Formatted XML</b></td><td><pre>");
							vqUmmrss.println("<a href='/" + (gK6APZe9) + "'>" + nADgSNxz + "</a>");
							vqUmmrss.println("</pre></tr></td>");
							daV4a4o3.close();
						}
						vqUmmrss.println("<table>");
					}
				}
				vqUmmrss.println("</body>");
				vqUmmrss.println("</html>");
			} else if (Tm95nmeO.startsWith("/sql/") && ftybm0wG != null && npJPZhaW != null) {
				String Cv1XeugT = NwZwtOEU.getPath().getPath(1);
				File eAOh6JH5 = searchEngine.index(npJPZhaW).getRoot();
				SearchEngine gEW363jH = searchEngine.index(npJPZhaW);
				File pWx4cOyV = getStoredProcIndexFile(gEW363jH.getRoot(), ftybm0wG);
				File h5ZtXWMs = new File(eAOh6JH5, "cpsql");
				File R6mHz7vf = new File(eAOh6JH5, Cv1XeugT.replace('/', File.separatorChar));
				FindStoredProcs.StoredProcProject flMgur4A = FindStoredProcs.getStoredProcProject(h5ZtXWMs, pWx4cOyV);
				FindStoredProcs.StoredProc NkylilmX = flMgur4A.getStoredProc(R6mHz7vf.getName());
				hW4sDlEp.set("Content-Type", "text/html");
				vqUmmrss.println("<html>");
				vqUmmrss.println("<body><pre>");
				for (String OJ4Fu0sQ : NkylilmX.getReferences()) {
					FindStoredProcs.StoredProc BPoKk23L = flMgur4A.getStoredProc(OJ4Fu0sQ);
					if (BPoKk23L != null) {
						String AonV6hhP = getRelativeURL(eAOh6JH5, BPoKk23L.getFile());
						vqUmmrss.println("<a href='/?show=" + AonV6hhP + "&index=" + ftybm0wG + "&searcher=" + npJPZhaW
								+ "'><b>" + BPoKk23L.getName() + "</b>");
					}
				}
				vqUmmrss.println("</pre></body>");
				vqUmmrss.println("</html>");
			} else if (tLbfdSts != null && ftybm0wG != null && npJPZhaW != null) {
				String It15bcEV = NwZwtOEU.getValue("Authorization");
				if (It15bcEV == null) {
					hW4sDlEp.setCode(401);
					hW4sDlEp.setText("Authorization Required");
					hW4sDlEp.set("Content-Type", "text/html");
					hW4sDlEp.set("WWW-Authenticate", "Basic realm=\"DTS Subversion Repository\"");
					vqUmmrss.println("<html>");
					vqUmmrss.println("<head>");
					vqUmmrss.println("401 Authorization Required");
					vqUmmrss.println("</head>");
					vqUmmrss.println("<body>");
					vqUmmrss.println("<h1>401 Authorization Required</h1>");
					vqUmmrss.println("</body>");
					vqUmmrss.println("</html>");
				} else {
					hW4sDlEp.set("Content-Type", "text/html");
					Principal oDe0qNMb = new PrincipalParser(It15bcEV);
					String wr59F7cj = tLbfdSts;
					SearchEngine hNk90gSr = searchEngine.index(npJPZhaW);
					File K6IsVCu5 = hNk90gSr.getRoot();
					File WffcZoac = getJavaIndexFile(K6IsVCu5, ftybm0wG);
					File yKjRu97L = getStoredProcIndexFile(K6IsVCu5, ftybm0wG);
					File Bv3XL90o = new File(K6IsVCu5, "cpsql");
					File tH1YqILg = new File(K6IsVCu5, wr59F7cj.replace('/', File.separatorChar));
					File sJDeCWtV = new File(K6IsVCu5, wr59F7cj.replace('/', File.separatorChar));
					File j6UQJvFP = tH1YqILg.getCanonicalFile();
					Repository rIjD0Yd2 = Subversion.login(Scheme.HTTP, oDe0qNMb.getName(), oDe0qNMb.getPassword());
					Info QBmQmfM9 = null;
					try {
						QBmQmfM9 = rIjD0Yd2.info(j6UQJvFP);
					} catch (Exception pfpxAbWC) {
						pfpxAbWC.printStackTrace();
					}
					List<Change> vpHGpsAo = new ArrayList<Change>();
					try {
						vpHGpsAo = rIjD0Yd2.log(j6UQJvFP);
					} catch (Exception Yqi6JZ9E) {
						Yqi6JZ9E.printStackTrace();
					}
					FileInputStream nDTVuCIh = new FileInputStream(j6UQJvFP);
					List<String> jfcrseow = LineStripper.stripLines(nDTVuCIh);
					vqUmmrss.println("<html>");
					vqUmmrss.println("<head>");
					vqUmmrss.println(
							"<!-- username='" + oDe0qNMb.getName() + "' password='" + oDe0qNMb.getPassword() + "' -->");
					vqUmmrss.println("<link rel='stylesheet' type='text/css' href='style.css'>");
					vqUmmrss.println("<script src='highlight.js'></script>");
					vqUmmrss.println("</head>");
					vqUmmrss.println("<body onload=\"sh_highlightDocument('lang/', '.js')\">");
					if (QBmQmfM9 != null) {
						vqUmmrss.println("<table border='1'>");
						vqUmmrss.printf("<tr><td bgcolor=\"#C4C4C4\"><tt>Author</tt></td><td><tt>" + QBmQmfM9.author
								+ "</tt></td></tr>");
						vqUmmrss.printf("<tr><td bgcolor=\"#C4C4C4\"><tt>Version</tt></td><td><tt>" + QBmQmfM9.version
								+ "</tt></td></tr>");
						vqUmmrss.printf("<tr><td bgcolor=\"#C4C4C4\"><tt>URL</tt></td><td><tt>" + QBmQmfM9.location
								+ "</tt></td></tr>");
						vqUmmrss.printf("<tr><td bgcolor=\"#C4C4C4\"><tt>Path</tt></td><td><tt>" + j6UQJvFP
								+ "</tt></td></tr>");
						vqUmmrss.println("</table>");
					}
					vqUmmrss.println("<table border='1''>");
					vqUmmrss.println("<tr>");
					vqUmmrss.println("<td valign='top' bgcolor=\"#C4C4C4\"><pre>");
					FindStoredProcs.StoredProcProject EyI6bL5O = FindStoredProcs.getStoredProcProject(Bv3XL90o,
							yKjRu97L);
					FindStoredProcs.StoredProc X8ganF6R = null;
					FindJavaSources.JavaProject mGib17vX = null;
					FindJavaSources.JavaClass KXhBScny = null;
					List<FindJavaSources.JavaClass> DiUQYOQ7 = null;
					if (wr59F7cj.endsWith(".sql")) {
						X8ganF6R = EyI6bL5O.getStoredProc(j6UQJvFP.getName());
					} else if (wr59F7cj.endsWith(".java")) {
						mGib17vX = FindJavaSources.getProject(K6IsVCu5, WffcZoac);
						KXhBScny = mGib17vX.getClass(tH1YqILg);
						DiUQYOQ7 = mGib17vX.getImports(sJDeCWtV);
					}
					for (int XuHkgfRZ = 0; XuHkgfRZ < jfcrseow.size(); XuHkgfRZ++) {
						vqUmmrss.println(XuHkgfRZ);
					}
					vqUmmrss.println("</pre></td>");
					vqUmmrss.print("<td valign='top'><pre");
					vqUmmrss.print(getJavaScript(wr59F7cj));
					vqUmmrss.println(">");
					for (int RifPfnHq = 0; RifPfnHq < jfcrseow.size(); RifPfnHq++) {
						String yoIg7cGC = jfcrseow.get(RifPfnHq);
						String PoydKVml = escapeHtml(yoIg7cGC);
						if (mGib17vX != null) {
							for (FindJavaSources.JavaClass RYX89Zdh : DiUQYOQ7) {
								String JZq3BTqu = RYX89Zdh.getClassName();
								String PD0qWVBM = RYX89Zdh.getFullyQualifiedName();
								if (yoIg7cGC.startsWith("import") && yoIg7cGC.indexOf(PD0qWVBM) > -1) {
									File r6xghgsV = RYX89Zdh.getSourceFile();
									String lKTdeUw4 = getRelativeURL(K6IsVCu5, r6xghgsV);
									PoydKVml = PoydKVml.replaceAll(PD0qWVBM + ";",
											"<a href='/?show=" + lKTdeUw4 + "&index=" + ftybm0wG + "&searcher="
													+ npJPZhaW + "'>" + PD0qWVBM + "</a>;");
								} else if (yoIg7cGC.indexOf(JZq3BTqu) > -1) {
									File Mpygvcxu = RYX89Zdh.getSourceFile();
									String fsNW8QG9 = getRelativeURL(K6IsVCu5, Mpygvcxu);
									PoydKVml = PoydKVml.replaceAll("\\s" + JZq3BTqu + ",",
											" <a href='/?show=" + fsNW8QG9 + "&index=" + ftybm0wG + "&searcher="
													+ npJPZhaW + "'>" + JZq3BTqu + "</a>,");
									PoydKVml = PoydKVml.replaceAll("\\s" + JZq3BTqu + "\\{",
											" <a href='/?show=" + fsNW8QG9 + "&index=" + ftybm0wG + "&searcher="
													+ npJPZhaW + "'>" + JZq3BTqu + "</a>{");
									PoydKVml = PoydKVml.replaceAll("," + JZq3BTqu + ",",
											",<a href='/?show=" + fsNW8QG9 + "&index=" + ftybm0wG + "&searcher="
													+ npJPZhaW + "'>" + JZq3BTqu + "</a>,");
									PoydKVml = PoydKVml.replaceAll("," + JZq3BTqu + "\\{",
											",<a href='/?show=" + fsNW8QG9 + "&index=" + ftybm0wG + "&searcher="
													+ npJPZhaW + "'>" + JZq3BTqu + "</a>{");
									PoydKVml = PoydKVml.replaceAll("\\s" + JZq3BTqu + "\\s",
											" <a href='/?show=" + fsNW8QG9 + "&index=" + ftybm0wG + "&searcher="
													+ npJPZhaW + "'>" + JZq3BTqu + "</a> ");
									PoydKVml = PoydKVml.replaceAll("\\(" + JZq3BTqu + "\\s",
											"(<a href='/?show=" + fsNW8QG9 + "&index=" + ftybm0wG + "&searcher="
													+ npJPZhaW + "'>" + JZq3BTqu + "</a> ");
									PoydKVml = PoydKVml.replaceAll("\\s" + JZq3BTqu + "\\.",
											" <a href='/?show=" + fsNW8QG9 + "&index=" + ftybm0wG + "&searcher="
													+ npJPZhaW + "'>" + JZq3BTqu + "</a>.");
									PoydKVml = PoydKVml.replaceAll("\\(" + JZq3BTqu + "\\.",
											"(<a href='/?show=" + fsNW8QG9 + "&index=" + ftybm0wG + "&searcher="
													+ npJPZhaW + "'>" + JZq3BTqu + "</a>.");
									PoydKVml = PoydKVml.replaceAll("\\s" + JZq3BTqu + "\\(",
											" <a href='/?show=" + fsNW8QG9 + "&index=" + ftybm0wG + "&searcher="
													+ npJPZhaW + "'>" + JZq3BTqu + "</a>(");
									PoydKVml = PoydKVml.replaceAll("\\(" + JZq3BTqu + "\\(",
											"(<a href='/?show=" + fsNW8QG9 + "&index=" + ftybm0wG + "&searcher="
													+ npJPZhaW + "'>" + JZq3BTqu + "</a>(");
									PoydKVml = PoydKVml.replaceAll("&gt;" + JZq3BTqu + ",",
											"&gt;<a href='/?show=" + fsNW8QG9 + "&index=" + ftybm0wG + "&searcher="
													+ npJPZhaW + "'>" + JZq3BTqu + "</a>,");
									PoydKVml = PoydKVml.replaceAll("&gt;" + JZq3BTqu + "\\s",
											"&gt;<a href='/?show=" + fsNW8QG9 + "&index=" + ftybm0wG + "&searcher="
													+ npJPZhaW + "'>" + JZq3BTqu + "</a> ");
									PoydKVml = PoydKVml.replaceAll("&gt;" + JZq3BTqu + "&lt;",
											"&gt;<a href='/?show=" + fsNW8QG9 + "&index=" + ftybm0wG + "&searcher="
													+ npJPZhaW + "'>" + JZq3BTqu + "</a>&lt;");
									PoydKVml = PoydKVml.replaceAll("\\(" + JZq3BTqu + "\\);",
											"(<a href='/?show=" + fsNW8QG9 + "&index=" + ftybm0wG + "&searcher="
													+ npJPZhaW + "'>" + JZq3BTqu + "</a>)");
								}
							}
						} else if (X8ganF6R != null) {
							Set<String> mJcBddPf = X8ganF6R.getTopReferences();
							List<String> txDs0uHn = new ArrayList(mJcBddPf);
							Collections.sort(txDs0uHn, LONGEST_FIRST);
							for (String NlDhhWp7 : txDs0uHn) {
								if (PoydKVml.indexOf(NlDhhWp7) != -1) {
									File pQTXuVB2 = EyI6bL5O.getLocation(NlDhhWp7);
									if (pQTXuVB2 != null) {
										String X4wMoqx9 = getRelativeURL(K6IsVCu5, pQTXuVB2);
										PoydKVml = PoydKVml.replaceAll("\\s" + NlDhhWp7 + "\\s",
												" <a href='/?show=" + X4wMoqx9 + "&index=" + ftybm0wG + "&searcher="
														+ npJPZhaW + "'>" + NlDhhWp7 + "</a> ");
										PoydKVml = PoydKVml.replaceAll("\\s" + NlDhhWp7 + ",",
												" <a href='/?show=" + X4wMoqx9 + "&index=" + ftybm0wG + "&searcher="
														+ npJPZhaW + "'>" + NlDhhWp7 + "</a>,");
										PoydKVml = PoydKVml.replaceAll("\\s" + NlDhhWp7 + ";",
												" <a href='/?show=" + X4wMoqx9 + "&index=" + ftybm0wG + "&searcher="
														+ npJPZhaW + "'>" + NlDhhWp7 + "</a>;");
										PoydKVml = PoydKVml.replaceAll("," + NlDhhWp7 + "\\s",
												",<a href='/?show=" + X4wMoqx9 + "&index=" + ftybm0wG + "&searcher="
														+ npJPZhaW + "'>" + NlDhhWp7 + "</a> ");
										PoydKVml = PoydKVml.replaceAll("," + NlDhhWp7 + ",",
												",<a href='/?show=" + X4wMoqx9 + "&index=" + ftybm0wG + "&searcher="
														+ npJPZhaW + "'>" + NlDhhWp7 + "</a>,");
										PoydKVml = PoydKVml.replaceAll("," + NlDhhWp7 + ";",
												",<a href='/?show=" + X4wMoqx9 + "&index=" + ftybm0wG + "&searcher="
														+ npJPZhaW + "'>" + NlDhhWp7 + "</a>;");
										PoydKVml = PoydKVml.replaceAll("=" + NlDhhWp7 + "\\s",
												"=<a href='/?show=" + X4wMoqx9 + "&index=" + ftybm0wG + "&searcher="
														+ npJPZhaW + "'>" + NlDhhWp7 + "</a> ");
										PoydKVml = PoydKVml.replaceAll("=" + NlDhhWp7 + ",",
												"=<a href='/?show=" + X4wMoqx9 + "&index=" + ftybm0wG + "&searcher="
														+ npJPZhaW + "'>" + NlDhhWp7 + "</a>,");
										PoydKVml = PoydKVml.replaceAll("=" + NlDhhWp7 + ";",
												"=<a href='/?show=" + X4wMoqx9 + "&index=" + ftybm0wG + "&searcher="
														+ npJPZhaW + "'>" + NlDhhWp7 + "</a>;");
										PoydKVml = PoydKVml.replaceAll("." + NlDhhWp7 + "\\s",
												".<a href='/?show=" + X4wMoqx9 + "&index=" + ftybm0wG + "&searcher="
														+ npJPZhaW + "'>" + NlDhhWp7 + "</a> ");
										PoydKVml = PoydKVml.replaceAll("." + NlDhhWp7 + ",",
												".<a href='/?show=" + X4wMoqx9 + "&index=" + ftybm0wG + "&searcher="
														+ npJPZhaW + "'>" + NlDhhWp7 + "</a>,");
										PoydKVml = PoydKVml.replaceAll("." + NlDhhWp7 + ";",
												".<a href='/?show=" + X4wMoqx9 + "&index=" + ftybm0wG + "&searcher="
														+ npJPZhaW + "'>" + NlDhhWp7 + "</a>;");
									} else {
										System.err.println("NOT FOUND: " + NlDhhWp7);
									}
								}
							}
						}
						vqUmmrss.println(PoydKVml);
					}
					vqUmmrss.println("</pre></td>");
					vqUmmrss.println("</tr>");
					vqUmmrss.println("</table>");
					vqUmmrss.println("<table border='1'>");
					vqUmmrss.printf(
							"<tr><td bgcolor=\"#C4C4C4\"><tt>Revision</tt></td><td bgcolor=\"#C4C4C4\"><tt>Date</tt></td><td bgcolor=\"#C4C4C4\"><tt>Author</tt></td><td bgcolor=\"#C4C4C4\"><tt>Comment</tt></td></tr>");
					DateFormat nKYGifkB = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					for (Change F5VDKeRV : vpHGpsAo) {
						vqUmmrss.printf(
								"<tr><td><tt>%s</tt></td><td><tt>%s</tt></td><td><tt>%s</tt></td><td><tt>%s</tt></td></tr>%n",
								F5VDKeRV.version, nKYGifkB.format(F5VDKeRV.date).replaceAll("\\s", "&nbsp;"),
								F5VDKeRV.author, F5VDKeRV.message);
					}
					vqUmmrss.println("</table>");
					if (mGib17vX != null) {
						vqUmmrss.println("<pre>");
						for (FindJavaSources.JavaClass O3Mfc6ET : DiUQYOQ7) {
							String akuWjCSf = getRelativeURL(K6IsVCu5, O3Mfc6ET.getSourceFile());
							vqUmmrss.println("import <a href='/?show=" + akuWjCSf + "&index=" + ftybm0wG + "&searcher="
									+ npJPZhaW + "'>" + O3Mfc6ET.getFullyQualifiedName() + "</a> as "
									+ O3Mfc6ET.getClassName());
						}
						vqUmmrss.println("</pre>");
					}
					if (X8ganF6R != null) {
						vqUmmrss.println("<pre>");
						for (String TpHW0t5r : X8ganF6R.getReferences()) {
							FindStoredProcs.StoredProc e2yHgfiD = EyI6bL5O.getStoredProc(TpHW0t5r);
							if (e2yHgfiD != null) {
								String gK1qvB3q = getRelativeURL(K6IsVCu5, e2yHgfiD.getFile());
								vqUmmrss.println("using <a href='/?show=" + gK1qvB3q + "&index=" + ftybm0wG
										+ "&searcher=" + npJPZhaW + "'>" + e2yHgfiD.getName() + "</a>");
							}
						}
						vqUmmrss.println("</pre>");
					}
					vqUmmrss.println("</form>");
					vqUmmrss.println("</body>");
					vqUmmrss.println("</html>");
				}
			} else if (Tm95nmeO.endsWith(".js") || Tm95nmeO.endsWith(".css") || Tm95nmeO.endsWith(".formatted")) {
				Tm95nmeO = Tm95nmeO.replace('/', File.separatorChar);
				if (Tm95nmeO.endsWith(".formatted")) {
					hW4sDlEp.set("Content-Type", "text/plain");
				} else if (Tm95nmeO.endsWith(".js")) {
					hW4sDlEp.set("Content-Type", "application/javascript");
				} else {
					hW4sDlEp.set("Content-Type", "text/css");
				}
				hW4sDlEp.set("Cache", "no-cache");
				WritableByteChannel ciswUoxo = hW4sDlEp.getByteChannel();
				File eDW7Sp3y = new File(".", Tm95nmeO).getCanonicalFile();
				System.err.println("Serving " + Tm95nmeO + " as " + eDW7Sp3y.getCanonicalPath());
				FileChannel uthAyhwd = new FileInputStream(eDW7Sp3y).getChannel();
				uthAyhwd.transferTo(0, eDW7Sp3y.length(), ciswUoxo);
				uthAyhwd.close();
				ciswUoxo.close();
			} else if (sMCjZ5ne != null && EInflDkb != null) {
				ServerDetails vP0faw4g = config.getEnvironment(sMCjZ5ne).load(persister, eb3qO8Se != null,
						u9DBhuR0 != null, pfCYfJOy != null);
				List<String> zKlQg3Fy = new ArrayList<String>();
				List<Searchable> Hyt8l9Cv = vP0faw4g.search(EInflDkb, Yx17JGuY != null, zKlQg3Fy);
				Collections.sort(zKlQg3Fy, LONGEST_FIRST);
				for (String IxgAeDe2 : zKlQg3Fy) {
					System.out.println("TOKEN: " + IxgAeDe2);
				}
				hW4sDlEp.set("Content-Type", "text/html");
				vqUmmrss.println("<html>");
				vqUmmrss.println("<head>");
				vqUmmrss.println("<link rel='stylesheet' type='text/css' href='style.css'>");
				vqUmmrss.println("<script src='highlight.js'></script>");
				vqUmmrss.println("</head>");
				vqUmmrss.println("<body onload=\"sh_highlightDocument('lang/', '.js')\">");
				writeSearchBox(vqUmmrss, npJPZhaW, null, null, EInflDkb);
				vqUmmrss.println("<br>Found " + Hyt8l9Cv.size() + " hits for <b>" + EInflDkb + "</b>");
				vqUmmrss.println("<table border='1''>");
				int fBpPvkjY = 1;
				for (Searchable ZUUeWiBa : Hyt8l9Cv) {
					vqUmmrss.println("    <tr><td>" + fBpPvkjY++ + "&nbsp;<a href='" + ZUUeWiBa.getSource() + "'><b>"
							+ ZUUeWiBa.getSource() + "</b></a></td></tr>");
					vqUmmrss.println("    <tr><td><pre class='sh_xml'>");
					StringWriter tEtrVzCd = new StringWriter();
					persister.write(ZUUeWiBa, tEtrVzCd);
					String H6EqcapF = tEtrVzCd.toString();
					H6EqcapF = escapeHtml(H6EqcapF);
					for (String xSICcKa7 : zKlQg3Fy) {
						H6EqcapF = H6EqcapF.replaceAll(xSICcKa7,
								"<font style='BACKGROUND-COLOR: yellow'>" + xSICcKa7 + "</font>");
					}
					vqUmmrss.println(H6EqcapF);
					vqUmmrss.println("    </pre></td></tr>");
				}
				vqUmmrss.println("</table>");
				vqUmmrss.println("</form>");
				vqUmmrss.println("</body>");
				vqUmmrss.println("</html>");
			} else if (ftybm0wG != null && CNtKUdax != null && CNtKUdax.length() > 0) {
				vqUmmrss.println("<html>");
				vqUmmrss.println("<head>");
				vqUmmrss.println("<link rel='stylesheet' type='text/css' href='style.css'>");
				vqUmmrss.println("<script src='highlight.js'></script>");
				vqUmmrss.println("</head>");
				vqUmmrss.println("<body onload=\"sh_highlightDocument('lang/', '.js')\">");
				writeSearchBox(vqUmmrss, npJPZhaW, CNtKUdax, ftybm0wG, null);
				if (npJPZhaW == null) {
					npJPZhaW = searchEngine.getDefaultSearcher();
				}
				if (moYoKLT4 != null) {
					SearchEngine hW44g4om = searchEngine.index(npJPZhaW);
					File TXO4hEnr = hW44g4om.getRoot();
					File LmVmD9Ho = getJavaIndexFile(TXO4hEnr, ftybm0wG);
					FindJavaSources.deleteProject(TXO4hEnr, LmVmD9Ho);
				}
				boolean wQ58YOz4 = moYoKLT4 != null;
				boolean dxOr9eLF = AtbBXXHh != null;
				boolean ruB4XciX = Z4swW6FI != null;
				SearchQuery Te6zyXQ7 = new SearchQuery(ftybm0wG, CNtKUdax, s6yHm4l8, wQ58YOz4, dxOr9eLF, ruB4XciX);
				List<SearchResult> lZMXk9Gq = searchEngine.index(npJPZhaW).search(Te6zyXQ7);
				writeSearchResults(Te6zyXQ7, npJPZhaW, lZMXk9Gq, vqUmmrss);
				vqUmmrss.println("</body>");
				vqUmmrss.println("</html>");
			} else {
				vqUmmrss.println("<html>");
				vqUmmrss.println("<body>");
				writeSearchBox(vqUmmrss, npJPZhaW, null, null, null);
				vqUmmrss.println("</body>");
				vqUmmrss.println("</html>");
			}
			vqUmmrss.close();
		} catch (Exception sInL9yNi) {
			try {
				sInL9yNi.printStackTrace();
				hW4sDlEp.reset();
				hW4sDlEp.setCode(500);
				hW4sDlEp.setText("Internal Server Error");
				hW4sDlEp.set("Content-Type", "text/html");
				vqUmmrss.println("<html>");
				vqUmmrss.println("<body><h1>Internal Server Error</h1><pre>");
				sInL9yNi.printStackTrace(vqUmmrss);
				vqUmmrss.println("</pre></body>");
				vqUmmrss.println("</html>");
				vqUmmrss.close();
			} catch (Exception g8NggF2X) {
				g8NggF2X.printStackTrace();
			}
		}
	}

}