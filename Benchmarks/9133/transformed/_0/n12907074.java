class n12907074 {
	public static int sendButton(String E9JM2Dcs, String lG2P5CH5, String YHu99ehV)
			throws ClientProtocolException, IOException {
		String QGpHKmXO = E9JM2Dcs + "/rest/button/" + lG2P5CH5 + "/" + YHu99ehV;
		HttpClient WxK8PpJm = new DefaultHttpClient();
		HttpPost bw2pC35V = new HttpPost(QGpHKmXO);
		HttpResponse guUpmyIA = WxK8PpJm.execute(bw2pC35V);
		int qf5imaGp = guUpmyIA.getStatusLine().getStatusCode();
		return qf5imaGp;
	}

}