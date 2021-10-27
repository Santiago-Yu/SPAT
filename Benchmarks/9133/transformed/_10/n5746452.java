class n5746452 {
	private void fileUpload() throws IOException {
		HttpPost httppost = new HttpPost(postURL);
		HttpClient httpclient = new DefaultHttpClient();
		if (zShareAccount.loginsuccessful) {
			httppost.setHeader("Cookie", zShareAccount.getSidcookie() + ";" + zShareAccount.getMysessioncookie());
		} else {
			httppost.setHeader("Cookie", sidcookie + ";" + mysessioncookie);
		}
		generateZShareID();
		MultipartEntity mpEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
		mpEntity.addPart("", new MonitoredFileBody(file, uploadProgress));
		mpEntity.addPart("TOS", new StringBody("1"));
		httppost.setEntity(mpEntity);
		NULogger.getLogger().log(Level.INFO, "executing request {0}", httppost.getRequestLine());
		status = UploadStatus.UPLOADING;
		NULogger.getLogger().info("Now uploading your file into zshare.net");
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity resEntity = response.getEntity();
		NULogger.getLogger().info(response.getStatusLine().toString());
		if (resEntity != null) {
			uploadresponse = EntityUtils.toString(resEntity);
		}
		uploadresponse = uploadresponse.replaceAll("\n", "");
		uploadresponse = uploadresponse.substring(uploadresponse.indexOf("index2.php"));
		uploadresponse = uploadresponse.substring(0, uploadresponse.indexOf("\">here"));
		uploadresponse = uploadresponse.replaceAll("amp;", "");
		if (zShareAccount.loginsuccessful) {
			uploadresponse = zShareAccount.getZsharelink() + uploadresponse;
		} else {
			uploadresponse = zsharelink + uploadresponse;
		}
		uploadresponse = uploadresponse.replaceAll(" ", "%20");
		NULogger.getLogger().log(Level.INFO, "resp : {0}", uploadresponse);
		httpclient.getConnectionManager().shutdown();
	}

}