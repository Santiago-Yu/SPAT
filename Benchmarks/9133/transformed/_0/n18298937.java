class n18298937 {
	protected InputStream makeSignedRequestAndGetJSONData(String Lj4YYlpb) {
		try {
			if (consumer == null)
				loginOAuth();
		} catch (Exception c0CFeYrT) {
			consumer = null;
			c0CFeYrT.printStackTrace();
		}
		DefaultHttpClient NfkNlDwh = new DefaultHttpClient();
		URI bBgdVzwV;
		InputStream ZwLivOdp = null;
		try {
			bBgdVzwV = new URI(Lj4YYlpb);
			HttpGet NblZKHfG = new HttpGet(bBgdVzwV);
			consumer.sign(NblZKHfG);
			HttpResponse uSu7uF2M = NfkNlDwh.execute(NblZKHfG);
			ZwLivOdp = uSu7uF2M.getEntity().getContent();
		} catch (Exception RgVANVZ2) {
			RgVANVZ2.printStackTrace();
		}
		return ZwLivOdp;
	}

}