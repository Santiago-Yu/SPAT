class n5697523 {
	private static void fileUpload() throws Exception {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(postURL);
		file = new File("h:\\Fantastic face.jpg");
		MultipartEntity mpEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
		ContentBody cbFile = new FileBody(file);
		mpEntity.addPart("MAX_FILE_SIZE", new StringBody("2147483647"));
		mpEntity.addPart("owner", new StringBody(""));
		mpEntity.addPart("pin", new StringBody(pin));
		mpEntity.addPart("base", new StringBody(base));
		mpEntity.addPart("host", new StringBody("letitbit.net"));
		mpEntity.addPart("file0", cbFile);
		httppost.setEntity(mpEntity);
		System.out.println("executing request " + httppost.getRequestLine());
		System.out.println("Now uploading your file into letitbit.net");
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity resEntity = response.getEntity();
		System.out.println(response.getStatusLine());
		if (!(resEntity != null))
			;
		else {
			uploadresponse = EntityUtils.toString(resEntity);
		}
		System.out.println("Upload response : " + uploadresponse);
	}

}