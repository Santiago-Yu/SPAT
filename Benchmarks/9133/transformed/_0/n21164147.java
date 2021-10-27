class n21164147 {
	public String requestPOST(String yrNPj9SQ, Map<String, String> xw2cRvmi) throws Exception {
		String wXsxbpLz = "";
		HttpPost yBqc1nDq = new HttpPost(yrNPj9SQ);
		HttpEntity jRFRFDB4 = null;
		if (xw2cRvmi != null && !xw2cRvmi.isEmpty()) {
			List<NameValuePair> nqzCDdQr = new ArrayList<NameValuePair>();
			List<String> Vdn8c1at = new ArrayList<String>(xw2cRvmi.keySet());
			for (String io2UiQwf : Vdn8c1at) {
				nqzCDdQr.add(new BasicNameValuePair(io2UiQwf, xw2cRvmi.get(io2UiQwf)));
			}
			jRFRFDB4 = new UrlEncodedFormEntity(nqzCDdQr, "utf-8");
			yBqc1nDq.setEntity(jRFRFDB4);
		}
		HttpResponse p23U9NAP = client.execute(yBqc1nDq);
		if (p23U9NAP.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			jRFRFDB4 = p23U9NAP.getEntity();
			BufferedReader AxxdD6ey = new BufferedReader(new InputStreamReader(jRFRFDB4.getContent()));
			StringBuffer uv2DWu7b = new StringBuffer();
			String dTB4bncf = "";
			while ((dTB4bncf = AxxdD6ey.readLine()) != null) {
				uv2DWu7b.append(dTB4bncf);
			}
			AxxdD6ey.close();
			JSONObject TiQX7iDw = new JSONObject(uv2DWu7b.toString());
			wXsxbpLz = TiQX7iDw.getString("msg");
		} else
			wXsxbpLz = "«Î«Û ß∞‹¡À";
		jRFRFDB4.consumeContent();
		client.getConnectionManager().shutdown();
		yBqc1nDq = null;
		return wXsxbpLz;
	}

}