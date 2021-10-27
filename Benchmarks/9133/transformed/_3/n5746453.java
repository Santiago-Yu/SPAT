class n5746453 {
	private void getDownloadLink() throws Exception {
		status = UploadStatus.GETTINGLINK;
		NULogger.getLogger().info("Now Getting Download link...");
		HttpClient client = new DefaultHttpClient();
		HttpGet h = new HttpGet(uploadresponse);
		h.setHeader("Referer", postURL);
		if (!(zShareAccount.loginsuccessful)) {
			h.setHeader("Cookie", sidcookie + ";" + mysessioncookie);
		} else {
			h.setHeader("Cookie", zShareAccount.getSidcookie() + ";" + zShareAccount.getMysessioncookie());
		}
		HttpResponse res = client.execute(h);
		HttpEntity entity = res.getEntity();
		linkpage = EntityUtils.toString(entity);
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