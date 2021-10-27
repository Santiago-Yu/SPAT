class n19915605 {
	public static String Execute(HttpRequestBase i78atgK7) throws IOException, ClientProtocolException {
		i78atgK7.setHeader("Accept", "application/json");
		i78atgK7.setHeader("Content-type", "application/json");
		String uTd3osmA = "";
		HttpClient xrMt8tgW = new DefaultHttpClient();
		HttpResponse ZnnS7Fr6 = xrMt8tgW.execute(i78atgK7);
		BufferedReader VyFS650s = new BufferedReader(new InputStreamReader(ZnnS7Fr6.getEntity().getContent()));
		String MLLCQkyn = "";
		while ((MLLCQkyn = VyFS650s.readLine()) != null) {
			uTd3osmA += MLLCQkyn + "\n";
		}
		return uTd3osmA;
	}

}