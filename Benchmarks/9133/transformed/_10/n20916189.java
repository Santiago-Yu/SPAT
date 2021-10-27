class n20916189 {
	public void fileUpload() throws Exception {
		HttpPost httppost = new HttpPost(postURL);
		DefaultHttpClient httpclient = new DefaultHttpClient();
		MultipartEntity reqEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
		reqEntity.addPart("fff", new MonitoredFileBody(file, uploadProgress));
		httppost.setEntity(reqEntity);
		NULogger.getLogger().info("Now uploading your file into 2shared.com. Please wait......................");
		status = UploadStatus.UPLOADING;
		HttpResponse response = httpclient.execute(httppost);
		status = UploadStatus.GETTINGLINK;
		HttpEntity resEntity = response.getEntity();
		if (resEntity != null) {
			String page = EntityUtils.toString(resEntity);
			NULogger.getLogger().log(Level.INFO, "PAGE :{0}", page);
		}
	}

}