class n13772486 {
	private static void fileUpload() throws IOException {
		HttpClient H6ypt4aG = new DefaultHttpClient();
		HttpPost dcjEwR9q = new HttpPost(postURL);
		file = new File("h:/UploadingdotcomUploaderPlugin.java");
		MultipartEntity I0grkYfv = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
		ContentBody rH6lideR = new FileBody(file);
		I0grkYfv.addPart("upload_type", new StringBody("file"));
		I0grkYfv.addPart("sess_id", new StringBody(sessid));
		I0grkYfv.addPart("srv_tmp_url", new StringBody(servertmpurl));
		I0grkYfv.addPart("file_0", rH6lideR);
		I0grkYfv.addPart("submit_btn", new StringBody(" Upload!"));
		dcjEwR9q.setEntity(I0grkYfv);
		System.out.println("executing request " + dcjEwR9q.getRequestLine());
		System.out.println("Now uploading your file into enterupload.com");
		HttpResponse NcddFgTm = H6ypt4aG.execute(dcjEwR9q);
		HttpEntity zGNQW29b = NcddFgTm.getEntity();
		System.out.println(NcddFgTm.getStatusLine());
		if (zGNQW29b != null) {
			uploadresponse = EntityUtils.toString(zGNQW29b);
		}
		downloadid = parseResponse(uploadresponse, "<textarea name='fn'>", "<");
		H6ypt4aG.getConnectionManager().shutdown();
	}

}