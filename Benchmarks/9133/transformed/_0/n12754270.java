class n12754270 {
	private void fileUpload() throws IOException {
		HttpClient Mnc6dbtD = new DefaultHttpClient();
		HttpPost PwpelOtk = new HttpPost(postURL);
		MultipartEntity wGQVXzfP = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
		wGQVXzfP.addPart("Filename", new StringBody(file.getName()));
		wGQVXzfP.addPart("Filedata", new MonitoredFileBody(file, uploadProgress));
		PwpelOtk.setEntity(wGQVXzfP);
		NULogger.getLogger().log(Level.INFO, "executing request {0}", PwpelOtk.getRequestLine());
		NULogger.getLogger().info("Now uploading your file into sharesend.com");
		status = UploadStatus.UPLOADING;
		HttpResponse yIjQj3OG = Mnc6dbtD.execute(PwpelOtk);
		status = UploadStatus.GETTINGLINK;
		HttpEntity cSdJuCCC = yIjQj3OG.getEntity();
		NULogger.getLogger().info(yIjQj3OG.getStatusLine().toString());
		if (cSdJuCCC != null) {
			uploadresponse = EntityUtils.toString(cSdJuCCC);
		}
		NULogger.getLogger().log(Level.INFO, "Upload Response : {0}", uploadresponse);
		NULogger.getLogger().log(Level.INFO, "Download Link : http://sharesend.com/{0}", uploadresponse);
		downloadlink = "http://sharesend.com/" + uploadresponse;
		downURL = downloadlink;
		Mnc6dbtD.getConnectionManager().shutdown();
		uploadFinished();
	}

}