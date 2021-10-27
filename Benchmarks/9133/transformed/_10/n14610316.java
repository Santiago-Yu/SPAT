class n14610316 {
	public static void fileUpload() throws IOException {
		HttpClient httpclient = new DefaultHttpClient();
		httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		file = new File("H:\\FileServeUploader.java");
		HttpPost httppost = new HttpPost(postURL);
		httppost.setHeader("Cookie", langcookie + ";" + sessioncookie + ";" + mailcookie + ";" + namecookie + ";"
				+ rolecookie + ";" + orderbycookie + ";" + directioncookie + ";");
		ContentBody cbFile = new FileBody(file);
		MultipartEntity mpEntity = new MultipartEntity();
		mpEntity.addPart("files[]", cbFile);
		httppost.setEntity(mpEntity);
		System.out.println("Now uploading your file into wupload...........................");
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity resEntity = response.getEntity();
		System.out.println(response.getStatusLine());
	}

}