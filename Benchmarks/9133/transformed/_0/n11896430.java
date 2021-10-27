class n11896430 {
	protected InputStream createIconType(HttpServletRequest AWZV4DKQ, HttpServletResponse Ie5tReqR)
			throws ServletException, IOException {
		JavaliController.debug(JavaliController.LG_VERBOSE, "Creating iconType");
		String MBhxalvw = PRM_TYPE + "=" + TP_ICON;
		String yacRyY7m = AWZV4DKQ.getParameter("iconName");
		if (yacRyY7m == null) {
			Ie5tReqR.sendError(Ie5tReqR.SC_NOT_FOUND);
			return null;
		}
		Locale V2wyEQcG = null;
		HttpSession gzWLSyTP = AWZV4DKQ.getSession(false);
		JavaliSession YRKsLnvM = null;
		int wZBvugZl = -1;
		String nHBzE0Uv = AWZV4DKQ.getParameter(PRM_MENU_TYPE);
		try {
			wZBvugZl = new Integer(nHBzE0Uv).intValue();
		} catch (Exception Dop8nO7o) {
		}
		if (gzWLSyTP != null)
			YRKsLnvM = (JavaliSession) gzWLSyTP.getAttribute(FormConstants.SESSION_BINDING);
		if (YRKsLnvM != null && YRKsLnvM.getUser() != null)
			V2wyEQcG = YRKsLnvM.getUser().getLocale();
		else if (gzWLSyTP != null)
			V2wyEQcG = (Locale) gzWLSyTP.getAttribute(FormConstants.LOCALE_BINDING);
		if (V2wyEQcG == null)
			V2wyEQcG = Locale.getDefault();
		if (wZBvugZl == -1)
			wZBvugZl = MENU_TYPE_TEXTICON;
		String wRVi7cjr = JavaliResource.getString("icon." + yacRyY7m, V2wyEQcG);
		if (wRVi7cjr == null) {
			wRVi7cjr = AWZV4DKQ.getParameter(PRM_MENU_NAME);
			if (wRVi7cjr == null)
				wRVi7cjr = "";
		}
		MBhxalvw += ", " + PRM_ICON_NAME + "=" + yacRyY7m + ", text=" + wRVi7cjr + ", menuType=" + wZBvugZl;
		String Ble75ec8 = null;
		String neo6ViXO = AWZV4DKQ.getParameter(PRM_FONT_NAME);
		if (neo6ViXO == null) {
			neo6ViXO = "Helvetica";
		}
		MBhxalvw += "," + PRM_FONT_NAME + "=" + neo6ViXO;
		String V2RH2KQI = AWZV4DKQ.getParameter(PRM_FONT_SIZE);
		int CZKnR4gk;
		try {
			CZKnR4gk = Integer.parseInt(V2RH2KQI);
		} catch (NumberFormatException n8U04WcG) {
			CZKnR4gk = 12;
		}
		MBhxalvw += "," + PRM_FONT_SIZE + "=" + CZKnR4gk;
		String RCewLEK3 = AWZV4DKQ.getParameter(PRM_FONT_TYPE);
		int Og4K98qj = Font.BOLD;
		if ("PLAIN".equalsIgnoreCase(RCewLEK3))
			Og4K98qj = Font.PLAIN;
		if ("BOLD".equalsIgnoreCase(RCewLEK3))
			Og4K98qj = Font.BOLD;
		if ("ITALIC".equalsIgnoreCase(RCewLEK3))
			Og4K98qj = Font.ITALIC;
		if ("ITALICBOLD".equalsIgnoreCase(RCewLEK3) || "BOLDITALIC".equalsIgnoreCase(RCewLEK3)
				|| "BOLD_ITALIC".equalsIgnoreCase(RCewLEK3) || "ITALIC_BOLD".equalsIgnoreCase(RCewLEK3)) {
			Og4K98qj = Font.ITALIC | Font.BOLD;
		}
		MBhxalvw += "," + PRM_FONT_TYPE + "=" + Og4K98qj;
		String W3AsvPNm = AWZV4DKQ.getParameter(PRM_FONT_COLOR);
		if (W3AsvPNm == null || W3AsvPNm.equals(""))
			W3AsvPNm = "0x000000";
		MBhxalvw += "," + PRM_FONT_COLOR + "=" + W3AsvPNm;
		String Kbq2WjGf = cacheInfo.file(MBhxalvw);
		JavaliController.debug(JavaliController.LG_VERBOSE, "Called for: " + Kbq2WjGf);
		if (Kbq2WjGf == null) {
			JavaliController.debug(JavaliController.LG_VERBOSE, "No cache found for: " + MBhxalvw);
			if (getServletConfig() != null && getServletConfig().getServletContext() != null) {
				if (yacRyY7m != null && yacRyY7m.startsWith("/"))
					Ble75ec8 = getServletConfig().getServletContext().getRealPath(yacRyY7m + ".gif");
				else
					Ble75ec8 = getServletConfig().getServletContext().getRealPath("/icons/" + yacRyY7m + ".gif");
				File n5QjtJSn = new File(Ble75ec8);
				if (!n5QjtJSn.exists()) {
					JavaliController.debug(JavaliController.LG_VERBOSE, "Could not find: " + Ble75ec8);
					Ie5tReqR.sendError(Ie5tReqR.SC_NOT_FOUND);
					return null;
				}
				Ble75ec8 = n5QjtJSn.getAbsolutePath();
				JavaliController.debug(JavaliController.LG_VERBOSE, "file: " + Ble75ec8 + " and cHash=" + MBhxalvw);
			} else {
				JavaliController.debug(JavaliController.LG_VERBOSE,
						"No ServletConfig=" + getServletConfig() + " or servletContext");
				Ie5tReqR.sendError(Ie5tReqR.SC_NOT_FOUND);
				return null;
			}
			File JXWb3SrY = File.createTempFile(PREFIX, SUFIX, cacheDir);
			OutputStream eZ7LYxFk = new FileOutputStream(JXWb3SrY);
			if (wZBvugZl == MENU_TYPE_ICON) {
				FileInputStream IW13UHVL = new FileInputStream(Ble75ec8);
				byte XraKUzeX[] = new byte[2048];
				int B6lOAoJJ = -1;
				while ((B6lOAoJJ = IW13UHVL.read(XraKUzeX)) != -1)
					eZ7LYxFk.write(XraKUzeX, 0, B6lOAoJJ);
			} else if (wZBvugZl == MENU_TYPE_TEXT)
				MessageImage.sendAsGIF(MessageImage.makeMessageImage(wRVi7cjr, neo6ViXO, CZKnR4gk, Og4K98qj, W3AsvPNm,
						false, "0x000000", true), eZ7LYxFk);
			else
				MessageImage.sendAsGIF(
						MessageImage.makeIconImage(Ble75ec8, wRVi7cjr, neo6ViXO, W3AsvPNm, CZKnR4gk, Og4K98qj),
						eZ7LYxFk);
			eZ7LYxFk.close();
			cacheInfo.putFile(MBhxalvw, JXWb3SrY);
			Kbq2WjGf = cacheInfo.file(MBhxalvw);
		}
		return new FileInputStream(new File(cacheDir, Kbq2WjGf));
	}

}