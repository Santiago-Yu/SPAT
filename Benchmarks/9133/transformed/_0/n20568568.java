class n20568568 {
	private String createHTML(PAGE_TYPE H0Qz5rfR) {
		String wNIFLpJq = "<html><head>";
		URL IjoZIzgg = getClass().getClassLoader().getResource("org/compiere/images/PAPanel.css");
		InputStreamReader EDMAdHBX;
		try {
			EDMAdHBX = new InputStreamReader(IjoZIzgg.openStream());
			BufferedReader aDjhJayD = new BufferedReader(EDMAdHBX);
			String xUSI0Ohb;
			while ((xUSI0Ohb = aDjhJayD.readLine()) != null)
				wNIFLpJq += xUSI0Ohb + "\n";
		} catch (IOException fdP0S6DT) {
			log.log(Level.SEVERE, fdP0S6DT.getLocalizedMessage(), fdP0S6DT);
		}
		switch (H0Qz5rfR) {
		case PAGE_LOGO:
			wNIFLpJq += "</head><body class=\"header\">" + "<table width=\"100%\"><tr><td>"
					+ "<img src=\"res:org/compiere/images/logo_ad.png\">" + "</td><td></td><td width=\"290\">"
					+ "</td></tr></table>" + "</body></html>";
			break;
		case PAGE_HOME:
			wNIFLpJq += "</head><body><div class=\"content\">\n";
			queryZoom = null;
			queryZoom = new ArrayList<MQuery>();
			String VJ61UyyC = null;
			String UAjgrZjX = " SELECT x.AD_CLIENT_ID, x.NAME, x.DESCRIPTION, x.AD_WINDOW_ID, x.PA_GOAL_ID, x.LINE, x.HTML, m.AD_MENU_ID"
					+ " FROM PA_DASHBOARDCONTENT x" + " LEFT OUTER JOIN AD_MENU m ON x.ad_window_id=m.ad_window_id"
					+ " WHERE (x.AD_Client_ID=0 OR x.AD_Client_ID=?) AND x.IsActive='Y'" + " ORDER BY LINE";
			PreparedStatement IyYArDhA = null;
			ResultSet DM2IGu1L = null;
			try {
				IyYArDhA = DB.prepareStatement(UAjgrZjX, null);
				IyYArDhA.setInt(1, Env.getAD_Client_ID(Env.getCtx()));
				DM2IGu1L = IyYArDhA.executeQuery();
				while (DM2IGu1L.next()) {
					VJ61UyyC = DM2IGu1L.getString("HTML");
					if (VJ61UyyC != null) {
						if (DM2IGu1L.getString("DESCRIPTION") != null)
							wNIFLpJq += "<H2>" + DM2IGu1L.getString("DESCRIPTION") + "</H2>\n";
						wNIFLpJq += stripHtml(VJ61UyyC, false) + "<br>\n";
					}
					if (DM2IGu1L.getInt("AD_MENU_ID") > 0) {
						wNIFLpJq += "<a class=\"hrefNode\" href=\"http:///window/node#"
								+ String.valueOf(DM2IGu1L.getInt("AD_WINDOW_ID") + "\">"
										+ DM2IGu1L.getString("DESCRIPTION") + "</a><br>\n");
					}
					wNIFLpJq += "<br>\n";
					if (DM2IGu1L.getInt("PA_GOAL_ID") > 0)
						wNIFLpJq += goalsDetail(DM2IGu1L.getInt("PA_GOAL_ID"));
				}
			} catch (SQLException GtaMNLNP) {
				log.log(Level.SEVERE, UAjgrZjX, GtaMNLNP);
			} finally {
				DB.close(DM2IGu1L, IyYArDhA);
				DM2IGu1L = null;
				IyYArDhA = null;
			}
			wNIFLpJq += "<br><br><br>\n" + "</div>\n</body>\n</html>\n";
			break;
		default:
			log.warning("Unknown option - " + H0Qz5rfR);
		}
		return wNIFLpJq;
	}

}