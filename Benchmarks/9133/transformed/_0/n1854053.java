class n1854053 {
	@Override
	public void handle(String bF1epeNl, HttpServletRequest meeOog8c, HttpServletResponse wNQsJLvc, int yBqA3nYS)
			throws IOException, ServletException {
		expected = new StringBuilder();
		System.out.println("uri: " + meeOog8c.getRequestURI());
		System.out.println("queryString: " + (queryString = meeOog8c.getQueryString()));
		System.out.println("method: " + meeOog8c.getMethod());
		ByteArrayOutputStream HIHppW5P = new ByteArrayOutputStream();
		IOUtils.copy(meeOog8c.getInputStream(), HIHppW5P);
		System.out.println("body: " + (body = HIHppW5P.toString()));
		PrintWriter LKr81Pnh = wNQsJLvc.getWriter();
		LKr81Pnh.append("testsvar");
		expected.append("testsvar");
		Random HfUSEPIe = new Random();
		for (int Vsbl3cBY = 0; Vsbl3cBY < 10; Vsbl3cBY++) {
			int EUPk9Cea = HfUSEPIe.nextInt(Integer.MAX_VALUE);
			LKr81Pnh.append(EUPk9Cea + "");
			expected.append(EUPk9Cea);
		}
		System.out.println();
		LKr81Pnh.close();
		wNQsJLvc.setStatus(HttpServletResponse.SC_OK);
	}

}