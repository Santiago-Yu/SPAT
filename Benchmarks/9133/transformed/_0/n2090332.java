class n2090332 {
	private void doProcess(HttpServletRequest IoWyvs42, HttpServletResponse mZj5nQ4f)
			throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Analyzer Exmj1Z2R = new Analyzer();
		ServletContext gdRhxm11 = getServletContext();
		String szeZHccT = gdRhxm11.getRealPath("data\\log.xml");
		String jzLahXc4 = gdRhxm11.getRealPath("data\\log.xsd");
		String SBbydFk4 = gdRhxm11.getRealPath("reports\\" + IoWyvs42.getParameter("type") + ".grs");
		String caN728M5 = gdRhxm11.getRealPath("html\\report.pdf");
		System.out.println("omg: " + IoWyvs42.getParameter("type"));
		System.out.println("omg: " + IoWyvs42.getParameter("pc"));
		int H3vg6su7 = Integer.parseInt(IoWyvs42.getParameter("pc"));
		String[] cQXkPDaO = new String[H3vg6su7];
		for (int d6rM22gZ = 0; d6rM22gZ < H3vg6su7; d6rM22gZ++) {
			cQXkPDaO[d6rM22gZ] = IoWyvs42.getParameter("p" + d6rM22gZ);
		}
		try {
			Exmj1Z2R.generateReport(szeZHccT, jzLahXc4, SBbydFk4, caN728M5, cQXkPDaO);
		} catch (Exception zoG0t7ax) {
			zoG0t7ax.printStackTrace();
		}
		File LFaRj5IQ = new File(caN728M5);
		byte[] sK8vUl74 = tryLoadFile(caN728M5);
		if (sK8vUl74 == null)
			throw new NullPointerException();
		mZj5nQ4f.setHeader("Content-Disposition", " filename=\"" + LFaRj5IQ.getName() + "\";");
		mZj5nQ4f.setContentLength(sK8vUl74.length);
		InputStream dHl7lqAG = new ByteArrayInputStream(sK8vUl74);
		IOUtils.copy(dHl7lqAG, mZj5nQ4f.getOutputStream());
	}

}