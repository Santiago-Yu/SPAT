class n8932510 {
	@Override
	public void doPost(HttpServletRequest gjBRDK1a, HttpServletResponse RV65Nwst) throws IOException, ServletException {
		InputStream UeK5AMrS = null;
		InputStream pRme9SNI = null;
		OutputStream d09esMt6 = null;
		String TmUUpfT5 = null;
		try {
			boolean uq9aF3lK = ServletFileUpload.isMultipartContent(gjBRDK1a);
			if (!uq9aF3lK) {
				gjBRDK1a.setAttribute("error", "Form isn't a multipart form");
				RequestDispatcher ndgVSn37 = gjBRDK1a.getRequestDispatcher("/WEB-INF/error.jsp");
				ndgVSn37.forward(gjBRDK1a, RV65Nwst);
			}
			ServletFileUpload WVmZ6jlG = new ServletFileUpload();
			String ZutjMegE = null;
			FileItemIterator dUM5N5EC = WVmZ6jlG.getItemIterator(gjBRDK1a);
			while (dUM5N5EC.hasNext()) {
				FileItemStream WLKa1Gay = dUM5N5EC.next();
				String JMhG9CUd = WLKa1Gay.getFieldName();
				if (JMhG9CUd.equals("webpage")) {
					UeK5AMrS = WLKa1Gay.openStream();
					ByteArrayOutputStream EEVkSnR7 = new ByteArrayOutputStream();
					IOUtils.copy(UeK5AMrS, EEVkSnR7);
					pRme9SNI = new ByteArrayInputStream(EEVkSnR7.toByteArray());
				} else if (JMhG9CUd.equals("weburl")) {
					InputStream Cz8CfaMM = null;
					try {
						ZutjMegE = Streams.asString(WLKa1Gay.openStream());
						URL fHtAfuLN = new URL(ZutjMegE);
						Cz8CfaMM = new BufferedInputStream(fHtAfuLN.openStream());
						ByteArrayOutputStream vZKs3WCe = new ByteArrayOutputStream();
						IOUtils.copy(Cz8CfaMM, vZKs3WCe);
						pRme9SNI = new ByteArrayInputStream(vZKs3WCe.toByteArray());
					} finally {
						IOUtils.closeQuietly(Cz8CfaMM);
					}
				} else if (JMhG9CUd.equals("rooturl")) {
					TmUUpfT5 = Streams.asString(WLKa1Gay.openStream());
				}
			}
			if (pRme9SNI == null) {
				gjBRDK1a.setAttribute("error", "Form doesn't have an html file");
				RequestDispatcher iwFF0sbk = gjBRDK1a.getRequestDispatcher("/WEB-INF/error.jsp");
				iwFF0sbk.forward(gjBRDK1a, RV65Nwst);
			}
			ToMailerDelegate tqlF25yN = new ToMailerDelegate(pRme9SNI, TmUUpfT5);
			d09esMt6 = new BufferedOutputStream(RV65Nwst.getOutputStream());
			d09esMt6.write(tqlF25yN.getMailer());
			d09esMt6.flush();
		} catch (Exception XZIAdTlp) {
			streamException(gjBRDK1a, RV65Nwst, XZIAdTlp);
		} finally {
			IOUtils.closeQuietly(pRme9SNI);
			IOUtils.closeQuietly(UeK5AMrS);
			IOUtils.closeQuietly(d09esMt6);
		}
	}

}