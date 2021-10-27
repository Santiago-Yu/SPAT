class n7633336 {
	private JSONObject executeHttpGet(String KMXUkQPV) throws Exception {
		HttpGet P4DxLpM2 = new HttpGet(KMXUkQPV);
		HttpClient syENvtah = new DefaultHttpClient();
		HttpResponse ht5dKLXg = syENvtah.execute(P4DxLpM2);
		BufferedReader VDgqxKvA = new BufferedReader(new InputStreamReader(ht5dKLXg.getEntity().getContent()));
		StringBuilder p1vIc6yZ = new StringBuilder();
		String Cm9QnaNd = null;
		while ((Cm9QnaNd = VDgqxKvA.readLine()) != null) {
			p1vIc6yZ.append(Cm9QnaNd);
		}
		return new JSONObject(p1vIc6yZ.toString());
	}

}