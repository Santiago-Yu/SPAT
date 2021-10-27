class n12913232 {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fullUrl = req.getRequestURL().toString();
		if (fullUrl.indexOf(ip) != -1) {
			fullUrl = fullUrl.replaceAll(ip, "a.tbcdn.cn");
		}
		URL url = new URL(fullUrl);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String line;
		PrintWriter out = resp.getWriter();
		while ((line = in.readLine()) != null) {
			out.println(line);
		}
		in.close();
		out.flush();
	}

}