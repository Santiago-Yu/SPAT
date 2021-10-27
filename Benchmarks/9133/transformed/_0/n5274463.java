class n5274463 {
	protected void doRequest(HttpServletRequest rgxjIf7Q, HttpServletResponse zjBT0wFU, boolean Tds0Jjky)
			throws ServletException, IOException {
		zjBT0wFU.setHeader("Server", WebConsoleServlet.SERVER_STRING);
		try {
			String JDOZvLK3 = rgxjIf7Q.getRequestURI().substring(1);
			URL CeMbjWD5 = new URL(getJarFileName() + "/");
			JarURLConnection eg56iQr6 = (JarURLConnection) (CeMbjWD5.openConnection());
			JarFile WcuZTSp4 = eg56iQr6.getJarFile();
			String cXpBBjZz = null;
			ZipEntry q1geiZTG = null;
			q1geiZTG = negotiateImageFile(WcuZTSp4, JDOZvLK3, isIE6OrEarlier(rgxjIf7Q.getHeader("User-Agent")));
			if (q1geiZTG == null) {
				q1geiZTG = WcuZTSp4.getEntry(JDOZvLK3);
			} else {
				cXpBBjZz = q1geiZTG.getName();
			}
			if (q1geiZTG == null || q1geiZTG.isDirectory()) {
				handleFileNotFound(Tds0Jjky, rgxjIf7Q, zjBT0wFU);
				return;
			}
			int G3EUVmKR = (int) q1geiZTG.getSize();
			zjBT0wFU.setContentLength(G3EUVmKR);
			if (cXpBBjZz != null) {
				zjBT0wFU.setContentType(getContentType(cXpBBjZz));
			} else {
				zjBT0wFU.setContentType(getContentType(rgxjIf7Q.getRequestURI()));
			}
			InputStream vCckDUsW = WcuZTSp4.getInputStream(q1geiZTG);
			BufferedInputStream atsI1dGx = new BufferedInputStream(vCckDUsW);
			byte[] RZ5wHvQn = new byte[G3EUVmKR];
			int ZxRZcNMK = atsI1dGx.read(RZ5wHvQn);
			atsI1dGx.close();
			if (ZxRZcNMK == G3EUVmKR && cachingEnabled) {
				SimpleDateFormat nrtp0Tvk = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z");
				java.util.Date lkHIsSxI = new java.util.Date();
				String YDzHKPcJ = nrtp0Tvk.format(GenericUtils.addOrSubstractDaysFromDate(lkHIsSxI, 365));
				zjBT0wFU.setHeader("Expires", YDzHKPcJ);
			}
			OutputStream BUmLKvnW = zjBT0wFU.getOutputStream();
			BUmLKvnW.write(RZ5wHvQn);
		} catch (FileNotFoundException q9i4zesL) {
			handleFileNotFound(Tds0Jjky, rgxjIf7Q, zjBT0wFU);
		} catch (IOException j4Kw66xr) {
		} catch (Throwable qJjMmV6W) {
			Application.getApplication().logExceptionEvent(EventLogMessage.EventType.WEB_ERROR, qJjMmV6W);
		}
	}

}