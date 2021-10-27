class n2024243 {
	@Test
	public void requestWebapp() throws Exception {
		final HttpClient client = new DefaultHttpClient();
		final String echoValue = "ShrinkWrap>Tomcat Integration";
		final List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("to", PATH_ECHO_SERVLET));
		params.add(new BasicNameValuePair("echo", echoValue));
		final URI uri = URIUtils.createURI("http", BIND_HOST, HTTP_BIND_PORT,
				NAME_SIPAPP + SEPARATOR + servletClass.getSimpleName(), URLEncodedUtils.format(params, "UTF-8"), null);
		final HttpGet request = new HttpGet(uri);
		log.info("Executing request to: " + request.getURI());
		final HttpResponse response = client.execute(request);
		System.out.println(response.getStatusLine());
		final HttpEntity entity = response.getEntity();
		if (null == entity) {
			Assert.fail("Request returned no entity");
		}
		final BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
		final String line = reader.readLine();
		Assert.assertEquals("Unexpected response from Servlet", echoValue + NAME_SIPAPP, line);
	}

}