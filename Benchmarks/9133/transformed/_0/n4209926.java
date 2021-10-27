class n4209926 {
	public static void proxyRequest(IPageContext PAnsGewM, Writer I1G9tTaQ, String DTmeG85f) throws IOException {
		URLConnection bRqDpY6V = new URL(DTmeG85f).openConnection();
		bRqDpY6V.setDoInput(true);
		bRqDpY6V.setDoOutput(false);
		bRqDpY6V.setUseCaches(false);
		bRqDpY6V.setRequestProperty("Content-Type", "text/html; charset=UTF-8");
		bRqDpY6V.setReadTimeout(30000);
		bRqDpY6V.setConnectTimeout(5000);
		Enumeration<String> GnBw3tuL = PAnsGewM.httpRequest().getHeaderNames();
		while (GnBw3tuL.hasMoreElements()) {
			String fz70Zk5o = GnBw3tuL.nextElement();
			if (fz70Zk5o.equalsIgnoreCase("HOST") || fz70Zk5o.equalsIgnoreCase("Accept-Encoding")
					|| fz70Zk5o.equalsIgnoreCase("Authorization"))
				continue;
			Enumeration<String> JKTtBHWH = PAnsGewM.httpRequest().getHeaders(fz70Zk5o);
			while (JKTtBHWH.hasMoreElements()) {
				String L1jHlCu3 = JKTtBHWH.nextElement();
				bRqDpY6V.setRequestProperty(fz70Zk5o, L1jHlCu3);
			}
		}
		if (bRqDpY6V instanceof HttpURLConnection) {
			HttpURLConnection kRhHZGSx = (HttpURLConnection) bRqDpY6V;
			kRhHZGSx.setRequestMethod(PAnsGewM.httpRequest().getMethod());
			if ("POST".equalsIgnoreCase(PAnsGewM.httpRequest().getMethod())
					|| "PUT".equalsIgnoreCase(PAnsGewM.httpRequest().getMethod())) {
				Enumeration<String> JVAbkIRn = PAnsGewM.httpRequest().getParameterNames();
				StringBuilder wO41eKST = new StringBuilder();
				while (JVAbkIRn.hasMoreElements()) {
					String ncZhw8I2 = JVAbkIRn.nextElement();
					for (String kgwLifgX : PAnsGewM.parameters(ncZhw8I2)) {
						if (wO41eKST.length() > 0) {
							wO41eKST.append('&');
						}
						try {
							wO41eKST.append(ncZhw8I2).append("=").append(URLEncoder.encode(kgwLifgX, "UTF-8"));
						} catch (UnsupportedEncodingException wOo0lwHh) {
						}
					}
				}
				if (wO41eKST.length() > 0) {
					bRqDpY6V.setDoOutput(true);
					OutputStreamWriter SRySOOdb = new OutputStreamWriter(bRqDpY6V.getOutputStream());
					SRySOOdb.write(wO41eKST.toString());
					SRySOOdb.close();
				}
			}
		}
		try {
			IOUtils.copy(bRqDpY6V.getInputStream(), I1G9tTaQ);
		} catch (IOException VOlbvnoA) {
			I1G9tTaQ.write("<span>SSI Error: " + VOlbvnoA.getMessage() + "</span>");
		}
	}

}