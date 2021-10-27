class n6044146 {
	@Test
	public void unacceptableMimeTypeTest() throws IOException {
		HttpPost httppost = new HttpPost("http://localhost:8080/alfresco/sword/deposit/company_home");
		HttpClient httpclient = new DefaultHttpClient();
		File file = new File("/Library/Application Support/Apple/iChat Icons/Planets/Mars.gif");
		FileEntity entity = new FileEntity(file, "text/xml");
		entity.setChunked(true);
		httppost.setEntity(entity);
		Date date = new Date();
		Long time = date.getTime();
		httppost.addHeader("content-disposition", "filename=x" + time + "x.gif");
		System.out.println("Executing request...." + httppost.getRequestLine());
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity resEntity = response.getEntity();
		if (resEntity != null) {
			InputStream is = resEntity.getContent();
			String line = "";
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty())
					System.out.println(line);
			}
		}
		if (resEntity != null) {
			resEntity.consumeContent();
		}
		httpclient.getConnectionManager().shutdown();
	}

}