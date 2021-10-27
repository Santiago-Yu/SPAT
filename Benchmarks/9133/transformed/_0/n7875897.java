class n7875897 {
	@SuppressWarnings("unchecked")
	protected void handleRequest(HttpServletRequest aOunUPxV, HttpServletResponse FF6Pp4lU, boolean FX6tIsgd)
			throws ServletException, IOException {
		HttpClient JGgtekME = WebReader.getHttpClient();
		try {
			StringBuffer TGfdxF3n = new StringBuffer();
			TGfdxF3n.append(targetServer);
			TGfdxF3n.append(aOunUPxV.getRequestURI());
			if (aOunUPxV.getQueryString() != null) {
				TGfdxF3n.append("?" + aOunUPxV.getQueryString());
			}
			HttpRequestBase Tblj3UlD = null;
			if (FX6tIsgd) {
				HttpPost EbGkasaS = new HttpPost(TGfdxF3n.toString());
				Enumeration<String> R6L0Ll8i = aOunUPxV.getParameterNames();
				String lTsllflz = null;
				List<NameValuePair> osTOjsmV = new ArrayList<NameValuePair>();
				while (R6L0Ll8i.hasMoreElements()) {
					lTsllflz = R6L0Ll8i.nextElement();
					osTOjsmV.add(new BasicNameValuePair(lTsllflz, aOunUPxV.getParameterValues(lTsllflz)[0]));
				}
				EbGkasaS.setEntity(new UrlEncodedFormEntity(osTOjsmV, HTTP.UTF_8));
				Tblj3UlD = EbGkasaS;
			} else {
				System.out.println("GET");
				HttpGet sVdheqBO = new HttpGet(TGfdxF3n.toString());
				Tblj3UlD = sVdheqBO;
			}
			HttpResponse EOG8tAYI = JGgtekME.execute(Tblj3UlD);
			HttpEntity lA4jEW22 = EOG8tAYI.getEntity();
			InputStream usxyzxH0 = lA4jEW22.getContent();
			OutputStream tY2XpVIE = FF6Pp4lU.getOutputStream();
			BufferedReader U6L7pK3J = new BufferedReader(new InputStreamReader(usxyzxH0));
			BufferedWriter sPqAesPo = new BufferedWriter(new OutputStreamWriter(tY2XpVIE));
			String sCV0Ogep = U6L7pK3J.readLine();
			while (sCV0Ogep != null) {
				sPqAesPo.write(sCV0Ogep + "\n");
				sCV0Ogep = U6L7pK3J.readLine();
			}
			U6L7pK3J.close();
			sPqAesPo.close();
		} finally {
			WebReader.returnHttpClient(JGgtekME);
		}
	}

}