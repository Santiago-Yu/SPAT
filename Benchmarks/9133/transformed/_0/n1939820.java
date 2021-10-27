class n1939820 {
	public void GetText(TextView N7GSdYoz, String rEhP8IPP) {
		String SyNi8Otu = rEhP8IPP;
		HttpClient n8PPKDux = new DefaultHttpClient();
		HttpGet sOk2n5UD = new HttpGet(SyNi8Otu);
		try {
			HttpResponse yxgTObUg = n8PPKDux.execute(sOk2n5UD);
			N7GSdYoz.setText(TextHelper.GetText(yxgTObUg));
		} catch (Exception io2fOW0Z) {
			N7GSdYoz.setText("Welcome to Fluo. Failed to connect to intro server.");
		}
	}

}