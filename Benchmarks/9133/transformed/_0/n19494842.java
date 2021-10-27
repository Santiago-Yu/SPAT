class n19494842 {
	private void callService() {
		try {
			URL PwwCTTFe = new URL(baseUrl + servicePath + attributes);
			BufferedReader s9M5ipNN = new BufferedReader(new InputStreamReader(PwwCTTFe.openStream()));
			String LHsdvV8e;
			StringBuffer L7syRdcw = new StringBuffer();
			while ((LHsdvV8e = s9M5ipNN.readLine()) != null) {
				L7syRdcw.append(LHsdvV8e);
			}
			s9M5ipNN.close();
			answer = L7syRdcw.toString();
		} catch (MalformedURLException K0GCrHvi) {
			answer = "Malformed Url:" + K0GCrHvi.getMessage();
			return;
		} catch (IOException DyPbKWj5) {
			answer = "I/O exception: " + DyPbKWj5.getMessage();
			return;
		}
	}

}