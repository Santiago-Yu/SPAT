class n10480049 {
	public static SearchItem register(String... args) {
		SearchItem _return = new SearchItem();
		String line = null;
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(URL_REGISTER);
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(6);
			nameValuePairs.add(new BasicNameValuePair("format", "xml"));
			nameValuePairs.add(new BasicNameValuePair("firtname", args[0]));
			nameValuePairs.add(new BasicNameValuePair("lastname", args[1]));
			nameValuePairs.add(new BasicNameValuePair("email", args[2]));
			nameValuePairs.add(new BasicNameValuePair("phone", args[3]));
			nameValuePairs.add(new BasicNameValuePair("password", args[4]));
			nameValuePairs.add(new BasicNameValuePair("confirmpassword", args[5]));
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpClient.execute(httpPost);
			line = EntityUtils.toString(response.getEntity());
			Document document = XMLfunctions.XMLfromString(line);
			NodeList nodes = document.getElementsByTagName("response");
			Element e = (Element) nodes.item(0);
			_return.set(0, XMLfunctions.getValue(e, "success"));
			if (!("false".endsWith(_return.get(0)))) {
				_return.set(1, XMLfunctions.getValue(e, "message"));
			} else {
				_return.set(1, XMLfunctions.getValue(e, "error"));
			}
			return _return;
		} catch (Exception e) {
			line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
			line = null;
			_return.set(0, "false");
			_return.set(1, "");
		}
		return _return;
	}

}