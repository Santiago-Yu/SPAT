class n2980809 {
	public void doGet(HttpServletRequest XSGRcx27, HttpServletResponse rfDNehNm) throws ServletException, IOException {
		String bbMIL9T0 = XSGRcx27.getParameter("proxyurl");
		URLConnection UtXPl828 = new URL(bbMIL9T0).openConnection();
		Reader bEgQ811Y = new InputStreamReader(UtXPl828.getInputStream(), rfDNehNm.getCharacterEncoding());
		rfDNehNm.setContentType(UtXPl828.getContentType());
		rfDNehNm.setContentLength(UtXPl828.getContentLength());
		Writer KrEG6Sgh = rfDNehNm.getWriter();
		char[] wOnwuI9o = new char[256];
		int wr9qVpy1;
		while ((wr9qVpy1 = bEgQ811Y.read(wOnwuI9o)) != -1) {
			KrEG6Sgh.write(wOnwuI9o, 0, wr9qVpy1);
		}
		bEgQ811Y.close();
		KrEG6Sgh.close();
		String bVM0Q4tM = XSGRcx27.getParameter("logging");
		if (bVM0Q4tM != null && bVM0Q4tM.toLowerCase().equals("true"))
			logRequest(XSGRcx27);
	}

}