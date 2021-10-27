class n2980810 {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("proxyurl");
		URLConnection conn = new URL(url).openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
		boolean first = true;
		Enumeration params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String param = (String) params.nextElement();
			if (!param.equals("proxyurl")) {
				if (first) {
					first = false;
				} else {
					dos.writeBytes("&");
				}
				dos.writeBytes(URLEncoder.encode(param));
				dos.writeBytes("=");
				dos.writeBytes(URLEncoder.encode(request.getParameter(param)));
			}
		}
		dos.close();
		Reader in = new InputStreamReader(conn.getInputStream(), response.getCharacterEncoding());
		response.setContentType(conn.getContentType());
		response.setContentLength(conn.getContentLength());
		char[] buf = new char[256];
		Writer out = response.getWriter();
		int len;
		while ((len = in.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
		String log = request.getParameter("logging");
		if (log != null && log.toLowerCase().equals("true"))
			logRequest(request);
	}

}