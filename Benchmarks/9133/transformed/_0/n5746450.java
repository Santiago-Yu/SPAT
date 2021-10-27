class n5746450 {
	private String getData(String IJ8yFFI2) throws Exception {
		URL sHmNZDgi = new URL(IJ8yFFI2);
		uc = (HttpURLConnection) sHmNZDgi.openConnection();
		br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		String DGQBOOpv = "", MELCIfO8 = "";
		while ((DGQBOOpv = br.readLine()) != null) {
			MELCIfO8 += DGQBOOpv;
		}
		br.close();
		return MELCIfO8;
	}

}