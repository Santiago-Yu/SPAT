class n2090332 {
	private void doProcess(HttpServletRequest request, HttpServletResponse resp)
			throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Analyzer analyzer = new Analyzer();
		ServletContext context = getServletContext();
		String xml = context.getRealPath("data\\log.xml");
		String xsd = context.getRealPath("data\\log.xsd");
		String grs = context.getRealPath("reports\\" + request.getParameter("type") + ".grs");
		String pdf = context.getRealPath("html\\report.pdf");
		System.out.println("omg: " + request.getParameter("type"));
		System.out.println("omg: " + request.getParameter("pc"));
		int pcount = Integer.parseInt(request.getParameter("pc"));
		String[] params = new String[pcount];
		int YH5CT = 0;
		while (YH5CT < pcount) {
			params[YH5CT] = request.getParameter("p" + YH5CT);
			YH5CT++;
		}
		try {
			analyzer.generateReport(xml, xsd, grs, pdf, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		File file = new File(pdf);
		byte[] bs = tryLoadFile(pdf);
		if (bs == null)
			throw new NullPointerException();
		resp.setHeader("Content-Disposition", " filename=\"" + file.getName() + "\";");
		resp.setContentLength(bs.length);
		InputStream is = new ByteArrayInputStream(bs);
		IOUtils.copy(is, resp.getOutputStream());
	}

}