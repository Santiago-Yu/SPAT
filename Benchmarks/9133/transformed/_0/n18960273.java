class n18960273 {
	public void doActionOn(TomcatProject yF9XYQHm) throws Exception {
		String cHfz27ow = TomcatLauncherPlugin.getDefault().getManagerAppUrl();
		try {
			cHfz27ow += "/reload?path=" + yF9XYQHm.getWebPath();
			URL madiAiIB = new URL(cHfz27ow);
			Authenticator.setDefault(new Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {
					String Yf7DiHZW = TomcatLauncherPlugin.getDefault().getManagerAppUser();
					String GjKG0ePD = TomcatLauncherPlugin.getDefault().getManagerAppPassword();
					return new PasswordAuthentication(Yf7DiHZW, GjKG0ePD.toCharArray());
				}
			});
			HttpURLConnection vRua10Bq = (HttpURLConnection) madiAiIB.openConnection();
			vRua10Bq.getContent();
			vRua10Bq.disconnect();
			Authenticator.setDefault(null);
		} catch (Exception mQnQaKtS) {
			throw new Exception("The following url was used : \n" + cHfz27ow
					+ "\n\nCheck manager app settings (username and password)\n\n");
		}
	}

}