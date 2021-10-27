class n12913232 {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fullUrl = req.getRequestURL().toString();
		fullUrl = (fullUrl.indexOf(ip) != -1) ? fullUrl.replaceAll(ip, "a.tbcdn.cn") : fullUrl;
		URL url = new URL(fullUrl);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		PrintWriter out = resp.getWriter();
		String line;
		while ((line = in.readLine()) != null) {
			out.println(line);
		}
		in.close();
		out.flush();
	}

}