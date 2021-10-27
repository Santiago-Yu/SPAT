class n5414796 {
	public static void upper() throws Exception {
		File PNnb6XcC = new File("dateiname");
		PostMethod k9SOHYUp = new PostMethod("url");
		k9SOHYUp.setRequestBody(new FileInputStream(PNnb6XcC));
		if (PNnb6XcC.length() < Integer.MAX_VALUE)
			k9SOHYUp.setRequestContentLength((int) PNnb6XcC.length());
		else
			k9SOHYUp.setRequestContentLength(EntityEnclosingMethod.CONTENT_LENGTH_CHUNKED);
		k9SOHYUp.setRequestHeader("Content-type", "text/xml; charset=ISO-8859?1");
		HttpClient JZy9QJjB = new HttpClient();
		JZy9QJjB.executeMethod(k9SOHYUp);
		k9SOHYUp.releaseConnection();
		URL RTlRMDEp = new URL("https://www.amazon.de/");
		URLConnection qvvdtFTD = RTlRMDEp.openConnection();
		BufferedReader pxV34Qc4 = new BufferedReader(new InputStreamReader(qvvdtFTD.getInputStream()));
		String P8olGBFC;
		while ((P8olGBFC = pxV34Qc4.readLine()) != null) {
			System.out.println(P8olGBFC);
		}
		pxV34Qc4.close();
	}

}