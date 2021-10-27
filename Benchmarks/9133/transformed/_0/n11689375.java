class n11689375 {
	@Override
	protected void doGet(HttpServletRequest IXpDsiLI, HttpServletResponse W3S6Gu91)
			throws ServletException, IOException {
		String f17fyk4P = IXpDsiLI.getRequestURI();
		String fTDmZ83A = "http://cdec.water.ca.gov" + f17fyk4P + "?" + IXpDsiLI.getQueryString();
		System.out.println("CDEC URL: " + fTDmZ83A);
		URL d8VR4h2s = new URL(fTDmZ83A);
		BufferedReader hDcZKEQk = new BufferedReader(new InputStreamReader(d8VR4h2s.openStream()));
		StringBuffer WcrKryi4 = new StringBuffer();
		String mnZXFyVK = null;
		int j98eHBDX = 0;
		while ((mnZXFyVK = hDcZKEQk.readLine()) != null) {
			if (mnZXFyVK.contains("<div class=\"column_inner\"")) {
				j98eHBDX++;
			}
			if (j98eHBDX == 2) {
				if (mnZXFyVK.contains("</div>")) {
					break;
				}
				if (mnZXFyVK.contains("href")) {
					mnZXFyVK = mnZXFyVK.replaceAll("href", "  target=\"external_page\" href");
				}
				if (mnZXFyVK.contains("http://cdec.water.ca.gov:80")) {
					mnZXFyVK = mnZXFyVK.replaceAll("http://cdec.water.ca.gov:80/", "/");
				}
				if (mnZXFyVK.contains("href=")) {
					mnZXFyVK = mnZXFyVK.replaceAll("(href=\"|href=)", "$1http://cdec.water.ca.gov");
				}
				WcrKryi4.append(mnZXFyVK);
			} else {
				continue;
			}
		}
		W3S6Gu91.getWriter().write(WcrKryi4.toString());
		W3S6Gu91.getWriter().flush();
		hDcZKEQk.close();
	}

}