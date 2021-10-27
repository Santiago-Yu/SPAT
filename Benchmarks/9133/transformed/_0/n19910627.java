class n19910627 {
	public String getData(DefaultHttpClient Z4MYZVxy) {
		try {
			HttpGet QkyBifiJ = new HttpGet("http://3dforandroid.appspot.com/api/v1/note");
			QkyBifiJ.setHeader("Content-Type", "application/json");
			QkyBifiJ.setHeader("Accept", "*/*");
			HttpResponse JC5CCFHW = Z4MYZVxy.execute(QkyBifiJ);
			HttpEntity FDcfnozh = JC5CCFHW.getEntity();
			InputStream Lf3AYCI5 = FDcfnozh.getContent();
			responseMessage = read(Lf3AYCI5);
			if (Lf3AYCI5 != null)
				Lf3AYCI5.close();
		} catch (ClientProtocolException GGnemtj8) {
			GGnemtj8.printStackTrace();
		} catch (IOException PSfjPMBS) {
			PSfjPMBS.printStackTrace();
		}
		return responseMessage;
	}

}