class n2024243 {
	@Test
	public void requestWebapp() throws Exception {
		final HttpClient pqz4hgMB = new DefaultHttpClient();
		final String VtkXXKc3 = "ShrinkWrap>Tomcat Integration";
		final List<NameValuePair> mGnzAP6r = new ArrayList<NameValuePair>();
		mGnzAP6r.add(new BasicNameValuePair("to", PATH_ECHO_SERVLET));
		mGnzAP6r.add(new BasicNameValuePair("echo", VtkXXKc3));
		final URI zCRhiZjH = URIUtils.createURI("http", BIND_HOST, HTTP_BIND_PORT,
				NAME_SIPAPP + SEPARATOR + servletClass.getSimpleName(), URLEncodedUtils.format(mGnzAP6r, "UTF-8"),
				null);
		final HttpGet y6E6C09K = new HttpGet(zCRhiZjH);
		log.info("Executing request to: " + y6E6C09K.getURI());
		final HttpResponse qdeDxbAM = pqz4hgMB.execute(y6E6C09K);
		System.out.println(qdeDxbAM.getStatusLine());
		final HttpEntity saxCeHjN = qdeDxbAM.getEntity();
		if (saxCeHjN == null) {
			Assert.fail("Request returned no entity");
		}
		final BufferedReader QY26Ejv3 = new BufferedReader(new InputStreamReader(saxCeHjN.getContent()));
		final String eKx6pDPV = QY26Ejv3.readLine();
		Assert.assertEquals("Unexpected response from Servlet", VtkXXKc3 + NAME_SIPAPP, eKx6pDPV);
	}

}