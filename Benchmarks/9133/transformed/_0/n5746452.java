class n5746452 {
	private void fileUpload() throws IOException {
		HttpClient V0uTUKYr = new DefaultHttpClient();
		HttpPost SUuRpHPZ = new HttpPost(postURL);
		if (zShareAccount.loginsuccessful) {
			SUuRpHPZ.setHeader("Cookie", zShareAccount.getSidcookie() + ";" + zShareAccount.getMysessioncookie());
		} else {
			SUuRpHPZ.setHeader("Cookie", sidcookie + ";" + mysessioncookie);
		}
		generateZShareID();
		MultipartEntity fkmI6reW = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
		fkmI6reW.addPart("", new MonitoredFileBody(file, uploadProgress));
		fkmI6reW.addPart("TOS", new StringBody("1"));
		SUuRpHPZ.setEntity(fkmI6reW);
		NULogger.getLogger().log(Level.INFO, "executing request {0}", SUuRpHPZ.getRequestLine());
		status = UploadStatus.UPLOADING;
		NULogger.getLogger().info("Now uploading your file into zshare.net");
		HttpResponse sGkhBBoR = V0uTUKYr.execute(SUuRpHPZ);
		HttpEntity Xc2zMQtM = sGkhBBoR.getEntity();
		NULogger.getLogger().info(sGkhBBoR.getStatusLine().toString());
		if (Xc2zMQtM != null) {
			uploadresponse = EntityUtils.toString(Xc2zMQtM);
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
		V0uTUKYr.getConnectionManager().shutdown();
	}

}