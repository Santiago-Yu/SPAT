class n13075308 {
	private static void fileUpload() throws Exception {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(postURL);
		file = new File("h:\\Rock Lee.jpg");
		MultipartEntity mpEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
		ContentBody cbFile = new FileBody(file);
		mpEntity.addPart("file", cbFile);
		httppost.setEntity(mpEntity);
		System.out.println("executing request " + httppost.getRequestLine());
		System.out.println("Now uploading your file into bayfiles.com");
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity resEntity = response.getEntity();
		System.out.println(response.getStatusLine());
		uploadresponse = (resEntity != null) ? EntityUtils.toString(resEntity) : uploadresponse;
		System.out.println("Upload response : " + uploadresponse);
		downloadlink = parseResponse(uploadresponse, "\"downloadUrl\":\"", "\"");
		downloadlink = downloadlink.replaceAll("\\\\", "");
		deletelink = parseResponse(uploadresponse, "\"deleteUrl\":\"", "\"");
		deletelink = deletelink.replaceAll("\\\\", "");
		System.out.println("Download link : " + downloadlink);
		System.out.println("Delete link : " + deletelink);
	}

}