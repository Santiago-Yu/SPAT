class n9030329 {
	private HttpURLConnection sendData(URL o2JqJhNn, String FtZxaBHc, String O41PovHs)
			throws IOException, IllegalArgumentException {
		String EWGAV2vl = "";
		if (FtZxaBHc != null) {
			EWGAV2vl = FtZxaBHc;
		}
		final String pl76KZSF = EWGAV2vl;
		String iCeiuzVW = "";
		if (O41PovHs != null) {
			iCeiuzVW = O41PovHs;
		}
		final String Ozy3IJkC = iCeiuzVW;
		Authenticator.setDefault(new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(pl76KZSF, Ozy3IJkC.toCharArray());
			}
		});
		HttpURLConnection MEisWfaI = (HttpURLConnection) o2JqJhNn.openConnection();
		MEisWfaI.setRequestMethod("GET");
		MEisWfaI.setReadTimeout(1000);
		MEisWfaI.connect();
		return MEisWfaI;
	}

}