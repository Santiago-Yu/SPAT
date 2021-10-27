class n6853665 {
	public static String postServiceContent(String nUchWXM1, String uKwgOfRX) throws IOException {
		URL GjRK59q2 = new URL(nUchWXM1);
		HttpURLConnection AC76ncan = (HttpURLConnection) GjRK59q2.openConnection();
		AC76ncan.setRequestMethod("POST");
		AC76ncan.connect();
		int yABAq1VU = AC76ncan.getResponseCode();
		if (yABAq1VU == HttpURLConnection.HTTP_OK) {
			InputStream edFs8RoK = AC76ncan.getInputStream();
			byte[] vx2fxCvC = null;
			String UwdD4juE = "";
			vx2fxCvC = new byte[4096];
			int OaT40bQv, cpQRLnsL, Y9zw6o5H = 0;
			OaT40bQv = AC76ncan.getContentLength();
			while (true) {
				cpQRLnsL = edFs8RoK.read(vx2fxCvC);
				if (cpQRLnsL <= 0)
					break;
				UwdD4juE = UwdD4juE + new String(vx2fxCvC);
			}
			return UwdD4juE;
		}
		return null;
	}

}