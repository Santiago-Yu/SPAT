class n6790585 {
	private void sendToServer(String i1z5KyFi, String CDCh2BIy)
			throws FileNotFoundException, ParserConfigurationException, SAXException, IOException, URISyntaxException {
		ArrayList ndqLYdmA = new ArrayList();
		ndqLYdmA.add(new BasicNameValuePair("xml", CDCh2BIy));
		ndqLYdmA.add(new BasicNameValuePair("idForm", i1z5KyFi));
		URI zQ8ByjCK = URIUtils.createURI("http", "172.20.9.144", 8080, "/PSFServer/SaveAnswers",
				URLEncodedUtils.format(ndqLYdmA, "UTF-8"), null);
		HttpPost txwYqgmt = new HttpPost(zQ8ByjCK);
		txwYqgmt.setEntity(new UrlEncodedFormEntity(ndqLYdmA, HTTP.UTF_8));
		HttpClient GXhyXZz2 = new DefaultHttpClient();
		HttpResponse SpLCrqwP = GXhyXZz2.execute(txwYqgmt);
		BufferedReader yMjQdDHZ = new BufferedReader(new InputStreamReader(SpLCrqwP.getEntity().getContent()));
		StringBuffer HI21yxWQ = new StringBuffer("");
		String B436kSr5 = "";
		String GI6gEmSj = System.getProperty("line.separator");
		while ((B436kSr5 = yMjQdDHZ.readLine()) != null) {
			HI21yxWQ.append(B436kSr5 + GI6gEmSj);
		}
		yMjQdDHZ.close();
		String gFWIxfUQ = HI21yxWQ.toString();
		if (gFWIxfUQ != null || gFWIxfUQ != "") {
			new DatabaseManager(this).getWritableDatabase().execSQL("delete from " + DatabaseManager.getTableDados());
		}
		backToMain();
	}

}