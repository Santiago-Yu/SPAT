class n23677113 {
	public static String downloadWebpage3(String djFcolr9) throws ClientProtocolException, IOException {
		HttpClient OM5lAgl4 = HttpClientBuilder.create().build();
		HttpGet JFNmkTZ9 = new HttpGet(djFcolr9);
		HttpResponse Ss5Wb0ER = OM5lAgl4.execute(JFNmkTZ9);
		BufferedReader rRa9xcnd = new BufferedReader(new InputStreamReader(Ss5Wb0ER.getEntity().getContent()));
		String mCcBkT3J;
		String KVU5UapW = "";
		while ((mCcBkT3J = rRa9xcnd.readLine()) != null) {
			KVU5UapW += mCcBkT3J + "\n";
		}
		rRa9xcnd.close();
		return KVU5UapW;
	}

}