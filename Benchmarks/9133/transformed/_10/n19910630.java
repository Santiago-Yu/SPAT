class n19910630 {
	public String postData(String result, DefaultHttpClient httpclient) {
		try {
			StringEntity se = new StringEntity(result);
			HttpPost post = new HttpPost("http://3dforandroid.appspot.com/api/v1/note/create");
			se.setContentEncoding(HTTP.UTF_8);
			se.setContentType("application/json");
			post.setEntity(se);
			post.setHeader("Content-Type", "application/json");
			post.setHeader("Accept", "*/*");
			HttpResponse response = httpclient.execute(post);
			InputStream instream;
			HttpEntity entity = response.getEntity();
			instream = entity.getContent();
			responseMessage = read(instream);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseMessage;
	}

}