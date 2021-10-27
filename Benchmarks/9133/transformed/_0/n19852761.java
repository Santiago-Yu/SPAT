class n19852761 {
	private int getCountFromUrl(String qoFW13Mu) {
		HttpGet JGInzLqo = new HttpGet(qoFW13Mu);
		try {
			HttpResponse AQRnhOgC = httpClient.execute(JGInzLqo);
			int cnIZme1u = AQRnhOgC.getStatusLine().getStatusCode();
			if (cnIZme1u != HttpStatus.SC_OK) {
				ByteArrayOutputStream PwmnmdOU = new ByteArrayOutputStream();
				AQRnhOgC.getEntity().writeTo(PwmnmdOU);
				Log.e(TAG, PwmnmdOU.toString());
			} else {
				InputStream SRNTLTjX = AQRnhOgC.getEntity().getContent();
				BufferedReader cDlqoWbo = new BufferedReader(new InputStreamReader(SRNTLTjX), 10);
				String Mhqh5cNN = cDlqoWbo.readLine();
				SRNTLTjX.close();
				return Integer.parseInt(Mhqh5cNN);
			}
		} catch (IOException RIUOjczK) {
			Log.e(TAG, Log.getStackTraceString(RIUOjczK));
		}
		return -1;
	}

}