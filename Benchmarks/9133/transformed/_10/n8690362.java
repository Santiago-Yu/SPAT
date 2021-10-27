class n8690362 {
	public static void fileUpload() throws IOException {
		HttpClient httpclient = new DefaultHttpClient();
		httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		File file = new File("d:/hai.html");
		HttpPost httppost = new HttpPost(postURL);
		System.out.println(ukeycookie);
		httppost.setHeader("Cookie", ukeycookie + ";" + skeycookie + ";" + usercookie);
		ContentBody cbFile = new FileBody(file);
		MultipartEntity mpEntity = new MultipartEntity();
		mpEntity.addPart("", cbFile);
		httppost.setEntity(mpEntity);
		System.out.println("Now uploading your file into mediafire...........................");
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity resEntity = response.getEntity();
		System.out.println(response.getStatusLine());
		if (resEntity != null) {
			System.out.println("Getting upload response key value..........");
			uploadresponsekey = EntityUtils.toString(resEntity);
			getUploadResponseKey();
			System.out.println("upload resoponse key " + uploadresponsekey);
		}
	}

}