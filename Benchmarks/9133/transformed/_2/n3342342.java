class n3342342 {
	private void downloadPhoto(File photo, String url) {
		try {
			HttpClient httpClient = new DefaultHttpClient();
			Log.v(TAG, "Dowloading photo from " + Server.URL + url);
			HttpGet request = new HttpGet(Server.URL + url);
			HttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			InputStream serverPhoto = entity.getContent();
			photo.createNewFile();
			FileOutputStream photoStream = new FileOutputStream(photo);
			byte[] buf = new byte[1024];
			int len;
			for (; (len = serverPhoto.read(buf)) > 0;) {
				photoStream.write(buf, 0, len);
			}
			photoStream.flush();
			photoStream.close();
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
		}
	}

}