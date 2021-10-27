class n7532475 {
	private String getLatestVersion(URL MgprWL95) throws IOException {
		HttpURLConnection tRF3Jwx2 = (HttpURLConnection) MgprWL95.openConnection();
		tRF3Jwx2.connect();
		BufferedReader WpaKvEKJ = new BufferedReader(
				new InputStreamReader(new BufferedInputStream(tRF3Jwx2.getInputStream())));
		String tM859u30 = "";
		String OKUPympx = null;
		while ((OKUPympx = WpaKvEKJ.readLine()) != null) {
			tM859u30 += OKUPympx;
		}
		tRF3Jwx2.disconnect();
		return tM859u30;
	}

}