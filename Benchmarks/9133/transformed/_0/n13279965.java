class n13279965 {
	public static void fileUpload() throws IOException {
		HttpClient ViEcer7j = new DefaultHttpClient();
		ViEcer7j.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		file = new File("H:\\FileServeUploader.java");
		HttpPost t4Vn6hok = new HttpPost(postURL);
		t4Vn6hok.setHeader("Cookie", uprandcookie + ";" + autologincookie);
		MultipartEntity Nfh4rL8E = new MultipartEntity();
		ContentBody J91hIeph = new FileBody(file);
		Nfh4rL8E.addPart("MAX_FILE_SIZE", new StringBody("2097152000"));
		Nfh4rL8E.addPart("UPLOAD_IDENTIFIER", new StringBody(uid));
		Nfh4rL8E.addPart("go", new StringBody("1"));
		Nfh4rL8E.addPart("files", J91hIeph);
		t4Vn6hok.setEntity(Nfh4rL8E);
		System.out.println("Now uploading your file into depositfiles...........................");
		HttpResponse ILumrmOP = ViEcer7j.execute(t4Vn6hok);
		HttpEntity pdDAIpPC = ILumrmOP.getEntity();
		System.out.println(ILumrmOP.getStatusLine());
		if (pdDAIpPC != null) {
			uploadresponse = EntityUtils.toString(pdDAIpPC);
			downloadlink = parseResponse(uploadresponse, "ud_download_url = '", "'");
			deletelink = parseResponse(uploadresponse, "ud_delete_url = '", "'");
			System.out.println("download link : " + downloadlink);
			System.out.println("delete link : " + deletelink);
		}
	}

}