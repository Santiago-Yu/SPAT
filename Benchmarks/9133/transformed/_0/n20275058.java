class n20275058 {
	protected void doGetPost(HttpServletRequest OAn8GUVu, HttpServletResponse dyNxSJBI, boolean N5J8fDI9)
			throws ServletException, IOException {
		if (responseBufferSize > 0)
			dyNxSJBI.setBufferSize(responseBufferSize);
		String Lmxw9kXc = OAn8GUVu.getPathInfo();
		if (Lmxw9kXc == null) {
			String nDlvZbJC = OAn8GUVu.getParameter(REMOTE_URL);
			if (nDlvZbJC == null) {
				dyNxSJBI.sendError(HttpServletResponse.SC_BAD_REQUEST,
						ResourceBundle.getBundle(MESSAGES, OAn8GUVu.getLocale(), new UTF8ResourceBundleControl())
								.getString("error.nourl"));
				return;
			}
			boolean hIi3b5Mw = "true".equals(OAn8GUVu.getParameter(ALLOW_COOKIE_FORWARDING));
			boolean hJ8x6KoZ = "true".equals(OAn8GUVu.getParameter(ALLOW_FORM_DATA_FORWARDING));
			String YDc0Rg37 = new JGlossURLRewriter(OAn8GUVu.getContextPath() + OAn8GUVu.getServletPath(),
					new URL(HttpUtils.getRequestURL(OAn8GUVu).toString()), null, hIi3b5Mw, hJ8x6KoZ).rewrite(nDlvZbJC,
							true);
			dyNxSJBI.sendRedirect(YDc0Rg37);
			return;
		}
		Set El0H3J1g;
		if (OAn8GUVu.isSecure())
			El0H3J1g = secureAllowedProtocols;
		else
			El0H3J1g = allowedProtocols;
		Object[] Khv50a4Z = JGlossURLRewriter.parseEncodedPath(Lmxw9kXc);
		if (Khv50a4Z == null) {
			dyNxSJBI.sendError(HttpServletResponse.SC_BAD_REQUEST,
					MessageFormat.format(
							ResourceBundle.getBundle(MESSAGES, OAn8GUVu.getLocale(), new UTF8ResourceBundleControl())
									.getString("error.malformedrequest"),
							new Object[] { Lmxw9kXc }));
			return;
		}
		boolean bvSJk00t = ((Boolean) Khv50a4Z[0]).booleanValue();
		boolean wOddfckZ = ((Boolean) Khv50a4Z[1]).booleanValue();
		String UCZAHnA6 = (String) Khv50a4Z[2];
		getServletContext().log("received request for " + UCZAHnA6);
		if (UCZAHnA6.toLowerCase().indexOf(OAn8GUVu.getServletPath().toLowerCase()) != -1) {
			dyNxSJBI.sendError(HttpServletResponse.SC_FORBIDDEN, MessageFormat.format(
					ResourceBundle.getBundle(MESSAGES, OAn8GUVu.getLocale()).getString("error.addressnotallowed"),
					new Object[] { UCZAHnA6 }));
			return;
		}
		if (UCZAHnA6.indexOf(':') == -1) {
			if (OAn8GUVu.isSecure()) {
				if (secureAllowedProtocols.contains("https"))
					UCZAHnA6 = "https://" + UCZAHnA6;
			} else {
				if (allowedProtocols.contains("http"))
					UCZAHnA6 = "http://" + UCZAHnA6;
			}
		}
		URL wRkvjOFb;
		try {
			wRkvjOFb = new URL(UCZAHnA6);
		} catch (MalformedURLException FfmbOy9A) {
			dyNxSJBI.sendError(HttpServletResponse.SC_BAD_REQUEST,
					MessageFormat.format(
							ResourceBundle.getBundle(MESSAGES, OAn8GUVu.getLocale()).getString("error.malformedurl"),
							new Object[] { UCZAHnA6 }));
			return;
		}
		String cPnmBOYH = wRkvjOFb.getProtocol();
		if (!El0H3J1g.contains(cPnmBOYH)) {
			dyNxSJBI.sendError(HttpServletResponse.SC_FORBIDDEN, MessageFormat.format(
					ResourceBundle.getBundle(MESSAGES, OAn8GUVu.getLocale()).getString("error.protocolnotallowed"),
					new Object[] { cPnmBOYH }));
			getServletContext().log("protocol not allowed accessing " + wRkvjOFb.toString());
			return;
		}
		boolean mGqCb7B5 = cPnmBOYH.equals("http") || cPnmBOYH.equals("https");
		boolean RGOBcr9g = mGqCb7B5 && enableCookieForwarding && bvSJk00t;
		boolean gsIp00x2 = mGqCb7B5 && enableFormDataForwarding && wOddfckZ && (enableFormDataSecureInsecureForwarding
				|| !OAn8GUVu.isSecure() || wRkvjOFb.getProtocol().equals("https"));
		if (gsIp00x2) {
			String zZNxkZVH = OAn8GUVu.getQueryString();
			if (zZNxkZVH != null && zZNxkZVH.length() > 0) {
				if (wRkvjOFb.getQuery() == null || wRkvjOFb.getQuery().length() == 0)
					wRkvjOFb = new URL(wRkvjOFb.toExternalForm() + "?" + zZNxkZVH);
				else
					wRkvjOFb = new URL(wRkvjOFb.toExternalForm() + "&" + zZNxkZVH);
			}
		}
		JGlossURLRewriter qPZ0p8zN = new JGlossURLRewriter(
				new URL(OAn8GUVu.getScheme(), OAn8GUVu.getServerName(), OAn8GUVu.getServerPort(),
						OAn8GUVu.getContextPath() + OAn8GUVu.getServletPath()).toExternalForm(),
				wRkvjOFb, El0H3J1g, bvSJk00t, wOddfckZ);
		URLConnection Ce1bkP9K = wRkvjOFb.openConnection();
		if (gsIp00x2 && N5J8fDI9 && mGqCb7B5) {
			getServletContext().log("using POST");
			try {
				((HttpURLConnection) Ce1bkP9K).setRequestMethod("POST");
			} catch (ClassCastException XjAHCy1C) {
				getServletContext().log("failed to set method POST: " + XjAHCy1C.getMessage());
			}
			Ce1bkP9K.setDoInput(true);
			Ce1bkP9K.setDoOutput(true);
		}
		String gON8lNfB = buildAcceptEncoding(OAn8GUVu.getHeader("accept-encoding"));
		getServletContext().log("accept-encoding: " + gON8lNfB);
		if (gON8lNfB != null)
			Ce1bkP9K.setRequestProperty("Accept-Encoding", gON8lNfB);
		forwardRequestHeaders(Ce1bkP9K, OAn8GUVu);
		if (RGOBcr9g && (enableCookieSecureInsecureForwarding || !OAn8GUVu.isSecure()
				|| wRkvjOFb.getProtocol().equals("https")))
			CookieTools.addRequestCookies(Ce1bkP9K, OAn8GUVu.getCookies(), getServletContext());
		try {
			Ce1bkP9K.connect();
		} catch (UnknownHostException pMxJgC6V) {
			dyNxSJBI.sendError(HttpServletResponse.SC_BAD_GATEWAY,
					MessageFormat.format(
							ResourceBundle.getBundle(MESSAGES, OAn8GUVu.getLocale()).getString("error.unknownhost"),
							new Object[] { wRkvjOFb.toExternalForm(), wRkvjOFb.getHost() }));
			return;
		} catch (IOException fD8vF8RV) {
			dyNxSJBI.sendError(HttpServletResponse.SC_BAD_GATEWAY, MessageFormat.format(
					ResourceBundle.getBundle(MESSAGES, OAn8GUVu.getLocale()).getString("error.connect"),
					new Object[] { wRkvjOFb.toExternalForm(), fD8vF8RV.getClass().getName(), fD8vF8RV.getMessage() }));
			return;
		}
		if (gsIp00x2 && N5J8fDI9 && mGqCb7B5) {
			InputStream w5yybdBH = OAn8GUVu.getInputStream();
			OutputStream zdxyojxK = Ce1bkP9K.getOutputStream();
			byte[] w6ZK9qbs = new byte[512];
			int Y9oGoOgr;
			while ((Y9oGoOgr = w5yybdBH.read(w6ZK9qbs)) != -1)
				zdxyojxK.write(w6ZK9qbs, 0, Y9oGoOgr);
			w5yybdBH.close();
			zdxyojxK.close();
		}
		forwardResponseHeaders(Ce1bkP9K, OAn8GUVu, dyNxSJBI, qPZ0p8zN);
		if (RGOBcr9g && (enableCookieSecureInsecureForwarding || OAn8GUVu.isSecure()
				|| !wRkvjOFb.getProtocol().equals("https")))
			CookieTools.addResponseCookies(Ce1bkP9K, dyNxSJBI, OAn8GUVu.getServerName(),
					OAn8GUVu.getContextPath() + OAn8GUVu.getServletPath(), OAn8GUVu.isSecure(), getServletContext());
		if (mGqCb7B5) {
			try {
				int yGYIdi0h = ((HttpURLConnection) Ce1bkP9K).getResponseCode();
				getServletContext().log("response code " + yGYIdi0h);
				dyNxSJBI.setStatus(yGYIdi0h);
				if (yGYIdi0h == 304)
					return;
			} catch (ClassCastException BNVzGNm9) {
				getServletContext().log("failed to read response code: " + BNVzGNm9.getMessage());
			}
		}
		String c0WV7pNY = Ce1bkP9K.getContentType();
		getServletContext().log("content type " + c0WV7pNY + " url " + Ce1bkP9K.getURL().toString());
		boolean C8BGMu29 = false;
		if (c0WV7pNY != null) {
			for (int u6qvSgmL = 0; u6qvSgmL < rewrittenContentTypes.length; u6qvSgmL++)
				if (c0WV7pNY.startsWith(rewrittenContentTypes[u6qvSgmL])) {
					C8BGMu29 = true;
					break;
				}
		}
		if (C8BGMu29) {
			String ZMiw3GFC = Ce1bkP9K.getContentEncoding();
			C8BGMu29 = ZMiw3GFC == null || ZMiw3GFC.endsWith("gzip") || ZMiw3GFC.endsWith("deflate")
					|| ZMiw3GFC.equals("identity");
		}
		if (C8BGMu29)
			rewrite(Ce1bkP9K, OAn8GUVu, dyNxSJBI, qPZ0p8zN);
		else
			tunnel(Ce1bkP9K, OAn8GUVu, dyNxSJBI);
	}

}