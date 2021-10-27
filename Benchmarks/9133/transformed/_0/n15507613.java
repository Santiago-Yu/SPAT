class n15507613 {
	@Override
	public void doGet(HttpServletRequest Qtgx1DMa, HttpServletResponse KlDH2CMp) throws ServletException, IOException {
		KlDH2CMp.setContentType("text/html");
		PrintWriter j5cKkErd = KlDH2CMp.getWriter();
		int I0rTMmHV;
		String SvK8jenu = Qtgx1DMa.getParameter("datasetURL");
		String i2DjCkgj = Qtgx1DMa.getParameter("contentType");
		String gouwb43P = Qtgx1DMa.getParameter("studyUID");
		String U1iXECjp = Qtgx1DMa.getParameter("seriesUID");
		String MUmxbdeq = Qtgx1DMa.getParameter("objectUID");
		SvK8jenu += "&contentType=" + i2DjCkgj + "&studyUID=" + gouwb43P + "&seriesUID=" + U1iXECjp + "&objectUID="
				+ MUmxbdeq + "&transferSyntax=1.2.840.10008.1.2.1";
		SvK8jenu = SvK8jenu.replace("+", "%2B");
		InputStream Sgne8LlK = null;
		DataInputStream otZA2Cjg = null;
		try {
			URL GmbvD8Fy = new URL(SvK8jenu);
			Sgne8LlK = GmbvD8Fy.openStream();
			otZA2Cjg = new DataInputStream(Sgne8LlK);
			for (I0rTMmHV = 0; I0rTMmHV < dicomData.length; I0rTMmHV++)
				dicomData[I0rTMmHV] = otZA2Cjg.readUnsignedByte();
			String cogouiAd = getElementValue("00281050");
			String ivw49wYQ = getElementValue("00281051");
			Qtgx1DMa.getSession(true).setAttribute(WINDOW_CENTER_PARAM, cogouiAd == null ? null : cogouiAd.trim());
			Qtgx1DMa.getSession(true).setAttribute(WINDOW_WIDTH_PARAM, ivw49wYQ == null ? null : ivw49wYQ.trim());
			otZA2Cjg.skipBytes(50000000);
			Sgne8LlK.close();
			otZA2Cjg.close();
			j5cKkErd.println("Success");
			j5cKkErd.close();
		} catch (Exception pUJy7Ht6) {
			log.error("Unable to read and send the DICOM dataset page", pUJy7Ht6);
		}
	}

}