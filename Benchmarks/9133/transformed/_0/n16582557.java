class n16582557 {
	protected void doGet(HttpServletRequest D8skbHYB, HttpServletResponse FgmUiz4o)
			throws ServletException, IOException {
		session = D8skbHYB.getSession(true);
		FgmUiz4o.setContentType("text/html");
		FgmUiz4o.setCharacterEncoding("UTF-8");
		PrintWriter qeJJAJ7m = FgmUiz4o.getWriter();
		try {
			String NEruWZyR = new String();
			if (D8skbHYB.getParameter("searchdb") != null) {
				NEruWZyR = D8skbHYB.getParameter("searchdb");
				qeJJAJ7m.write("<ul>");
				PreparedStatement TJBUC8D6 = conn
						.prepareStatement("SELECT * FROM ENTRIES WHERE XTM_SESSION_ID = ? AND XTM_TEXT LIKE ?");
				TJBUC8D6.setString(1, session.getId());
				TJBUC8D6.setString(2, new String("%" + NEruWZyR + "%"));
				ResultSet nZheEioM = TJBUC8D6.executeQuery();
				while (nZheEioM.next()) {
					qeJJAJ7m.write("<li>");
					qeJJAJ7m.write(nZheEioM.getString("XTM_TEXT"));
					qeJJAJ7m.write("</li>");
				}
				qeJJAJ7m.write("</ul>");
				nZheEioM.close();
			}
			if (D8skbHYB.getParameter("searchwiki") != null) {
				NEruWZyR = D8skbHYB.getParameter("searchwiki");
				qeJJAJ7m.write("<ul>");
				try {
					NEruWZyR = URLEncoder.encode(NEruWZyR, "UTF-8");
					URL hrYqbjy1 = new URL("http://www.wikipedia.de/suggest.php?lang=de&search=" + NEruWZyR);
					URLConnection t2nOQixe = hrYqbjy1.openConnection();
					BufferedReader StF2toeF = new BufferedReader(
							new InputStreamReader(t2nOQixe.getInputStream(), "UTF-8"));
					String WZLwo0UN;
					while ((WZLwo0UN = StF2toeF.readLine()) != null) {
						qeJJAJ7m.write("<li>");
						String[] e0a9vRZR = WZLwo0UN.split("\t");
						qeJJAJ7m.write(e0a9vRZR[0]);
						qeJJAJ7m.write("</li>");
					}
					StF2toeF.close();
				} catch (Exception HUAQilYC) {
					HUAQilYC.printStackTrace();
				}
				qeJJAJ7m.write("</ul>");
			} else {
				return;
			}
		} catch (SQLException eKNzdzrU) {
			qeJJAJ7m.println("Caught SQLException:" + eKNzdzrU.getMessage());
		}
		;
	}

}