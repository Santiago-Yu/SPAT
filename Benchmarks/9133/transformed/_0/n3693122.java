class n3693122 {
	private static byte[] get256RandomBits() throws IOException {
		URL kY7Mmcro = null;
		try {
			kY7Mmcro = new URL(SRV_URL);
		} catch (MalformedURLException YrvEsdAE) {
			YrvEsdAE.printStackTrace();
		}
		HttpsURLConnection SsMxspQw = (HttpsURLConnection) kY7Mmcro.openConnection();
		SsMxspQw.setConnectTimeout(2500);
		InputStream XtUbe8qU = SsMxspQw.getInputStream();
		byte[] Z0ZiNdTa = new byte[XtUbe8qU.available()];
		XtUbe8qU.read(Z0ZiNdTa);
		XtUbe8qU.close();
		SsMxspQw.disconnect();
		byte[] VN2D0u37 = new byte[32];
		String MOfWxwsS = new String(Z0ZiNdTa);
		Matcher hSyaQpGo = DETAIL.matcher(MOfWxwsS);
		if (hSyaQpGo.find()) {
			for (int FXb49fzy = 0; FXb49fzy < 32; FXb49fzy++)
				VN2D0u37[FXb49fzy] = (byte) (Integer
						.parseInt(hSyaQpGo.group(1).substring(FXb49fzy * 2, FXb49fzy * 2 + 2), 16) & 0xFF);
		}
		return VN2D0u37;
	}

}