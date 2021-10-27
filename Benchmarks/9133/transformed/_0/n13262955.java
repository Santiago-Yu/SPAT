class n13262955 {
	protected void doGet(HttpServletRequest l1IJhNHT, HttpServletResponse T199c34P)
			throws ServletException, IOException {
		String GKljxSN5 = l1IJhNHT.getServletPath();
		String yr3S9Ugq = l1IJhNHT.getRequestURI();
		String GzoFixQV = yr3S9Ugq.substring(yr3S9Ugq.indexOf(GKljxSN5) + GKljxSN5.length());
		URL Xmh0K2Qt = ClassResource.get(resourceDirectory + GzoFixQV);
		try {
			File lSIH8Ddm = null;
			JarEntry oaB2AeMy = null;
			JarFile Te1LPTGg = null;
			if (!Xmh0K2Qt.toExternalForm().startsWith("jar:")) {
				lSIH8Ddm = new File(Xmh0K2Qt.toURI());
			} else {
				Te1LPTGg = ((JarURLConnection) Xmh0K2Qt.openConnection()).getJarFile();
				String[] hl8Rq8Qv = Xmh0K2Qt.toExternalForm().split("!");
				oaB2AeMy = Te1LPTGg.getJarEntry(hl8Rq8Qv[1].substring(1));
			}
			if (lSIH8Ddm != null && lSIH8Ddm.isDirectory()) {
				PrintWriter nBrSNOvF = T199c34P.getWriter();
				T199c34P.setContentType("text/html");
				DevelUtils.writePageBegin(nBrSNOvF);
				DevelUtils.writeTitleAndHeaderEnd(nBrSNOvF, "Makumba resources");
				if (SourceViewServlet.redirected(l1IJhNHT, T199c34P, GKljxSN5)) {
					return;
				}
				String fXpnwq96 = lSIH8Ddm.getName();
				if (lSIH8Ddm.getAbsolutePath().indexOf(resourceDirectory) != -1) {
					fXpnwq96 = lSIH8Ddm.getAbsolutePath()
							.substring(lSIH8Ddm.getAbsolutePath().indexOf(resourceDirectory));
				}
				SourceViewServlet.printDirlistingHeader(nBrSNOvF, lSIH8Ddm.getCanonicalPath(), fXpnwq96);
				if (!(fXpnwq96.equals(resourceDirectory))) {
					nBrSNOvF.println("<b><a href=\"../\">../</a></b> (up one level)");
				}
				SourceViewServlet.processDirectory(nBrSNOvF, lSIH8Ddm, null);
				String[] Hu2npGyq = lSIH8Ddm.list();
				Arrays.sort(Hu2npGyq);
				for (int rbgwzCBX = 0; rbgwzCBX < Hu2npGyq.length; rbgwzCBX++) {
					String cHfEm2ri = Hu2npGyq[rbgwzCBX];
					File X0USgwhe = new File(lSIH8Ddm.getAbsolutePath() + File.separator + cHfEm2ri);
					if (X0USgwhe.isFile()) {
						nBrSNOvF.println("<b><a href=\"" + cHfEm2ri + "\">" + cHfEm2ri + "</a></b>");
					}
				}
				nBrSNOvF.println("</pre>");
				DevelUtils.writePageEnd(nBrSNOvF);
				T199c34P.setHeader("Last-Modified", dfLastModified.format(new Date()));
				return;
			} else if (oaB2AeMy != null && oaB2AeMy.isDirectory()) {
				Enumeration<JarEntry> GytuQ56w = Te1LPTGg.entries();
				ArrayList<String> TWGJ7jKM = new ArrayList<String>();
				ArrayList<String> lkGgFpT8 = new ArrayList<String>();
				PrintWriter SPxMXz8T = T199c34P.getWriter();
				T199c34P.setContentType("text/html");
				DevelUtils.writePageBegin(SPxMXz8T);
				DevelUtils.writeTitleAndHeaderEnd(SPxMXz8T, "Makumba resources");
				if (SourceViewServlet.redirected(l1IJhNHT, T199c34P, GKljxSN5)) {
					return;
				}
				String zh9jdhm1 = oaB2AeMy.getName();
				SourceViewServlet.printDirlistingHeader(SPxMXz8T, Xmh0K2Qt.toExternalForm(), zh9jdhm1);
				if (!zh9jdhm1.equals(resourceDirectory) && !zh9jdhm1.equals(resourceDirectory + "/")) {
					SPxMXz8T.println("<b><a href=\"../\">../</a></b> (up one level)");
				}
				while (GytuQ56w.hasMoreElements()) {
					JarEntry VLtWVbOa = (JarEntry) GytuQ56w.nextElement();
					if (VLtWVbOa.getName().startsWith(zh9jdhm1)) {
						String HZqPDDg4 = VLtWVbOa.getName().substring(zh9jdhm1.length());
						while (HZqPDDg4.length() > 0 && HZqPDDg4.startsWith("/")) {
							HZqPDDg4 = HZqPDDg4.substring(1);
						}
						if (HZqPDDg4.indexOf("/") == -1) {
							if (HZqPDDg4.length() > 0) {
								TWGJ7jKM.add(HZqPDDg4);
							}
						} else if (HZqPDDg4.indexOf("/") == HZqPDDg4.lastIndexOf("/") && HZqPDDg4.endsWith("/")) {
							if (HZqPDDg4.endsWith("/")) {
								HZqPDDg4 = HZqPDDg4.substring(0, HZqPDDg4.length() - 1);
							}
							if (HZqPDDg4.length() > 0) {
								lkGgFpT8.add(HZqPDDg4);
							}
						}
					}
				}
				for (String eIz9mZ3h : lkGgFpT8) {
					SPxMXz8T.println("<b><a href=\"" + eIz9mZ3h + "/\">" + eIz9mZ3h + "/</a></b>");
				}
				for (String Jj5uy0Fa : TWGJ7jKM) {
					SPxMXz8T.println("<b><a href=\"" + Jj5uy0Fa + "\">" + Jj5uy0Fa + "</a></b>");
				}
				SPxMXz8T.println("</pre>");
				DevelUtils.writePageEnd(SPxMXz8T);
				T199c34P.setHeader("Last-Modified", dfLastModified.format(new Date()));
				return;
			} else {
				final Date hf3rFxcS;
				if (Xmh0K2Qt.toExternalForm().startsWith("jar:")) {
					JarFile FjChwJOo = ((JarURLConnection) Xmh0K2Qt.openConnection()).getJarFile();
					String[] PUI5SvNU = Xmh0K2Qt.toExternalForm().split("!");
					hf3rFxcS = new Date(FjChwJOo.getJarEntry(PUI5SvNU[1].substring(1)).getTime());
				} else {
					hf3rFxcS = new Date(new File(Xmh0K2Qt.toURI()).lastModified());
				}
				T199c34P.setHeader("Last-Modified", dfLastModified.format(hf3rFxcS));
				T199c34P.setContentType(getContentType(Xmh0K2Qt));
				Object UrW5M8gO = NamedResources.getStaticCache(makumbaResources).getResource(GzoFixQV);
				ServletOutputStream wsBhnQXk = T199c34P.getOutputStream();
				if (isBinary(Xmh0K2Qt)) {
					for (int BvFYtPI8 = 0; BvFYtPI8 < ((byte[]) UrW5M8gO).length; BvFYtPI8++) {
						wsBhnQXk.write(((byte[]) UrW5M8gO)[BvFYtPI8]);
					}
				} else {
					wsBhnQXk.print(UrW5M8gO.toString());
				}
			}
		} catch (URISyntaxException eAWa3meq) {
			eAWa3meq.printStackTrace();
		}
	}

}