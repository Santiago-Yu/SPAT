class n5380646 {
	private static String getToken(HttpClient client) throws Exception {
		String token = null;
		HttpGet httpget = new HttpGet("https://libsys.arlingtonva.us/iii/cas/login?service=http&scope=1");
		HttpResponse response = client.execute(httpget);
		HttpEntity entity = response.getEntity();
		entity = (entity != null) ? new BufferedHttpEntity(entity) : entity;
		if (entity != null) {
			String resp = EntityUtils.toString(entity);
			EntityUtils.consume(entity);
			Pattern pattern = Pattern.compile("<input .*name=\"lt\".*value=\"(.*)\".*/>");
			Matcher matcher = pattern.matcher(resp);
			token = (matcher.find()) ? matcher.group(1) : token;
		}
		return token;
	}

}