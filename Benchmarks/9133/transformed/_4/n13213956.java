class n13213956 {
	private void fileUpload() throws Exception {
		NULogger.getLogger().info("now file upload code");
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost("https://dl-web.dropbox.com/upload");
		httppost.setHeader("Referer", "https://www.dropbox.com/home/Public");
		httppost.setHeader("Cookie", DropBoxAccount.getForumjarcookie() + ";" + DropBoxAccount.getForumlidcookie() + ";"
				+ DropBoxAccount.getTouchcookie());
		MultipartEntity mpEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
		mpEntity.addPart("t", new StringBody(token));
		mpEntity.addPart("plain", new StringBody("yes"));
		mpEntity.addPart("dest", new StringBody("/Public"));
		mpEntity.addPart("file", new MonitoredFileBody(file, uploadProgress));
		httppost.setEntity(mpEntity);
		NULogger.getLogger().log(Level.INFO, "executing request {0}", httppost.getRequestLine());
		NULogger.getLogger().info("Now uploading your file into dropbox.com");
		status = UploadStatus.UPLOADING;
		HttpResponse response = httpclient.execute(httppost);
		status = UploadStatus.GETTINGLINK;
		HttpEntity resEntity = response.getEntity();
		NULogger.getLogger().info(response.getStatusLine().toString());
		uploadresponse = (resEntity != null) ? EntityUtils.toString(resEntity) : uploadresponse;
		NULogger.getLogger().log(Level.INFO, "Upload response : {0}", uploadresponse);
		if (uploadresponse.contains("The resource was found at https://www.dropbox.com/home/Public")) {
			downloadlink = "http://dl.dropbox.com/u/" + uid + "/"
					+ (URLEncoder.encode(file.getName(), "UTF-8").replace("+", "%20"));
			NULogger.getLogger().log(Level.INFO, "Downloadlink : {0}", downloadlink);
			downURL = downloadlink;
		} else {
			throw new Exception("Dropbox server problem or network problem.. Couldn't get proper response.");
		}
	}

}