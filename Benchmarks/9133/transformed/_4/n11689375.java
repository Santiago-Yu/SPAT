class n11689375 {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestPath = req.getRequestURI();
		String cdecUrl = "http://cdec.water.ca.gov" + requestPath + "?" + req.getQueryString();
		System.out.println("CDEC URL: " + cdecUrl);
		URL url = new URL(cdecUrl);
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		StringBuffer buffer = new StringBuffer();
		String line = null;
		int ncolumnInner = 0;
		while ((line = reader.readLine()) != null) {
			if (line.contains("<div class=\"column_inner\"")) {
				ncolumnInner++;
			}
			if (ncolumnInner == 2) {
				if (line.contains("</div>")) {
					break;
				}
				line = (line.contains("href")) ? line.replaceAll("href", "  target=\"external_page\" href") : line;
				line = (line.contains("http://cdec.water.ca.gov:80"))
						? line.replaceAll("http://cdec.water.ca.gov:80/", "/")
						: line;
				line = (line.contains("href=")) ? line.replaceAll("(href=\"|href=)", "$1http://cdec.water.ca.gov")
						: line;
				buffer.append(line);
			} else {
				continue;
			}
		}
		resp.getWriter().write(buffer.toString());
		resp.getWriter().flush();
		reader.close();
	}

}