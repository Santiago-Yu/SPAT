class n10437938 {
	protected Document loadDocument() throws MalformedURLException, DocumentException, IOException {
		if (jiraFilterURL.startsWith("file")) {
			URL KFSf4S5B = getSourceURL();
			return parseDocument(KFSf4S5B);
		} else {
			HttpClient Dk9bvpHP = new DefaultHttpClient();
			List<NameValuePair> bvBnax31 = new ArrayList<NameValuePair>();
			bvBnax31.add(new BasicNameValuePair("os_username", jiraUser));
			bvBnax31.add(new BasicNameValuePair("os_password", jiraPassword));
			bvBnax31.add(new BasicNameValuePair("os_cookie", "true"));
			UrlEncodedFormEntity PXPd11H1 = new UrlEncodedFormEntity(bvBnax31, "UTF-8");
			HttpPost J9d8Zk5C = new HttpPost(getJiraRootUrl() + "/secure/login.jsp");
			J9d8Zk5C.setEntity(PXPd11H1);
			HttpResponse dxK8mK0u = Dk9bvpHP.execute(J9d8Zk5C);
			dxK8mK0u.getEntity().consumeContent();
			String QjZpkD0s = StringEscapeUtils.unescapeXml(jiraFilterURL);
			HttpGet emT4qmW5 = new HttpGet(QjZpkD0s);
			dxK8mK0u = Dk9bvpHP.execute(emT4qmW5);
			return parseDocument(dxK8mK0u.getEntity().getContent());
		}
	}

}