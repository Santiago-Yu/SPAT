class n5746453 {
	private void getDownloadLink() throws Exception {
		status = UploadStatus.GETTINGLINK;
		NULogger.getLogger().info("Now Getting Download link...");
		HttpClient DAVz5RdJ = new DefaultHttpClient();
		HttpGet oHzvjFat = new HttpGet(uploadresponse);
		oHzvjFat.setHeader("Referer", postURL);
		if (zShareAccount.loginsuccessful) {
			oHzvjFat.setHeader("Cookie", zShareAccount.getSidcookie() + ";" + zShareAccount.getMysessioncookie());
		} else {
			oHzvjFat.setHeader("Cookie", sidcookie + ";" + mysessioncookie);
		}
		HttpResponse ETv2h1xz = DAVz5RdJ.execute(oHzvjFat);
		HttpEntity FCc7MpfL = ETv2h1xz.getEntity();
		linkpage = EntityUtils.toString(FCc7MpfL);
		linkpage = linkpage.replaceAll("\n", "");
		downloadlink = CommonUploaderTasks.parseResponse(linkpage, "value=\"", "\"");
		deletelink = CommonUploaderTasks.parseResponse(linkpage, "delete.html?", "\"");
		deletelink = "http://www.zshare.net/delete.html?" + deletelink;
		downURL = downloadlink;
		delURL = deletelink;
		NULogger.getLogger().log(Level.INFO, "Download link : {0}", downloadlink);
		NULogger.getLogger().log(Level.INFO, "Delete Link : {0}", deletelink);
		uploadFinished();
	}

}