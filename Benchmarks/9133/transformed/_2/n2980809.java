class n2980809 {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("proxyurl");
		URLConnection conn = new URL(url).openConnection();
		Reader in = new InputStreamReader(conn.getInputStream(), response.getCharacterEncoding());
		response.setContentType(conn.getContentType());
		response.setContentLength(conn.getContentLength());
		Writer out = response.getWriter();
		char[] buf = new char[256];
		int len;
		for (; (len = in.read(buf)) != -1;) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
		String log = request.getParameter("logging");
		if (log != null && log.toLowerCase().equals("true"))
			logRequest(request);
	}

}