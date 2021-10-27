class n15708288 {
	private Response postRequest(String NOAPUO6W, String FyVPItfr) throws Exception {
		URL zT7B1Dso = new URL(NOAPUO6W);
		HttpURLConnection dAcgoqdm = (HttpURLConnection) zT7B1Dso.openConnection();
		dAcgoqdm.setDoInput(true);
		dAcgoqdm.setDoOutput(true);
		dAcgoqdm.setUseCaches(false);
		dAcgoqdm.setAllowUserInteraction(false);
		dAcgoqdm.setRequestMethod("POST");
		dAcgoqdm.setRequestProperty("ContentType", "application/x-www-form-urlencoded");
		dAcgoqdm.setRequestProperty("User-Agent", "CytoLinkFromMJ");
		if (cookie != null)
			dAcgoqdm.setRequestProperty("Cookie", cookie);
		PrintStream Ev7qRHPs = new PrintStream(dAcgoqdm.getOutputStream());
		Ev7qRHPs.print(FyVPItfr);
		Ev7qRHPs.flush();
		Ev7qRHPs.close();
		dAcgoqdm.connect();
		StringBuffer x0JJVDbN = new StringBuffer();
		String IZWJuee2;
		BufferedReader cL5VMTR6 = new BufferedReader(new InputStreamReader(dAcgoqdm.getInputStream()));
		while ((IZWJuee2 = cL5VMTR6.readLine()) != null) {
			x0JJVDbN.append(IZWJuee2 + "\n");
		}
		cL5VMTR6.close();
		Response Kk6M4mxw = new Response();
		Kk6M4mxw.content = x0JJVDbN.toString();
		Kk6M4mxw.contentType = dAcgoqdm.getHeaderField("Content-Type");
		Kk6M4mxw.cookie = dAcgoqdm.getHeaderField("Set-Cookie");
		return Kk6M4mxw;
	}

}