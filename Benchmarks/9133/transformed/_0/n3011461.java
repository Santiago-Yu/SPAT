class n3011461 {
	private String sendToServer(String proDPh7A) throws IOException {
		Log.d("test", "request body " + proDPh7A);
		String r4TGA8rE = null;
		maybeCreateHttpClient();
		HttpPost yN38aPun = new HttpPost(Config.APP_BASE_URI);
		yN38aPun.addHeader("Content-Type", "text/vnd.aexp.json.req");
		yN38aPun.setEntity(new StringEntity(proDPh7A));
		HttpResponse cghJRbs5 = httpClient.execute(yN38aPun);
		int OCNBryJt = cghJRbs5.getStatusLine().getStatusCode();
		if (OCNBryJt != HttpStatus.SC_OK)
			throw new IOException("HTTP status: " + Integer.toString(OCNBryJt));
		DataInputStream eyQwUQgB = new DataInputStream(cghJRbs5.getEntity().getContent());
		r4TGA8rE = eyQwUQgB.readLine();
		return r4TGA8rE;
	}

}