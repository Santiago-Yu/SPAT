class n2945889 {
	public void fileUpload() throws Exception {
		HttpClient f1Rsk5SP = new DefaultHttpClient();
		f1Rsk5SP.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		HttpPost fuBIkwFA = new HttpPost("http://upload.1fichier.com/en/upload.cgi?id=" + uid);
		if (oneFichierAccount.loginsuccessful) {
			fuBIkwFA.setHeader("Cookie", OneFichierAccount.getSidcookie());
		}
		MultipartEntity xXhbMuaX = new MultipartEntity();
		xXhbMuaX.addPart("file[]", new MonitoredFileBody(file, uploadProgress));
		xXhbMuaX.addPart("domain", new StringBody("0"));
		fuBIkwFA.setEntity(xXhbMuaX);
		NULogger.getLogger().info("Now uploading your file into 1fichier...........................");
		NULogger.getLogger().log(Level.INFO, "Now executing.......{0}", fuBIkwFA.getRequestLine());
		status = UploadStatus.UPLOADING;
		HttpResponse BYYc5c5f = f1Rsk5SP.execute(fuBIkwFA);
		status = UploadStatus.GETTINGLINK;
		f1Rsk5SP.getConnectionManager().shutdown();
		NULogger.getLogger().info(BYYc5c5f.getStatusLine().toString());
		if (BYYc5c5f.containsHeader("Location")) {
			uploadresponse = BYYc5c5f.getFirstHeader("Location").getValue();
			NULogger.getLogger().log(Level.INFO, "Upload location link : {0}", uploadresponse);
		} else {
			throw new Exception(
					"There might be a problem with your internet connection or server error. Please try again");
		}
	}

}