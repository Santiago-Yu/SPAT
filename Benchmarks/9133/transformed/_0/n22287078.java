class n22287078 {
	@Override
	List<String> HttpGet(URL hiYZGLzL) throws IOException {
		List<String> xX1k46J3 = new ArrayList<String>();
		Logger.getInstance().logInfo("HTTP GET: " + hiYZGLzL, null, getGatewayId());
		HttpURLConnection U2i1ZBvM = (HttpURLConnection) hiYZGLzL.openConnection();
		U2i1ZBvM.setConnectTimeout(20000);
		U2i1ZBvM.setAllowUserInteraction(false);
		xX1k46J3.add(U2i1ZBvM.getResponseCode() + " " + U2i1ZBvM.getResponseMessage());
		InputStream XF96GGdL = U2i1ZBvM.getErrorStream();
		if (XF96GGdL == null)
			XF96GGdL = U2i1ZBvM.getInputStream();
		BufferedReader hHlce6LV = new BufferedReader(new InputStreamReader(XF96GGdL));
		String medZ9iLj;
		while ((medZ9iLj = hHlce6LV.readLine()) != null)
			xX1k46J3.add(medZ9iLj);
		hHlce6LV.close();
		return xX1k46J3;
	}

}