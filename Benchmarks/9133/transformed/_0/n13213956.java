class n13213956 {
	private void fileUpload() throws Exception {
		NULogger.getLogger().info("now file upload code");
		DefaultHttpClient aOI10E9q = new DefaultHttpClient();
		HttpPost dnySmyZR = new HttpPost("https://dl-web.dropbox.com/upload");
		dnySmyZR.setHeader("Referer", "https://www.dropbox.com/home/Public");
		dnySmyZR.setHeader("Cookie", DropBoxAccount.getForumjarcookie() + ";" + DropBoxAccount.getForumlidcookie() + ";"
				+ DropBoxAccount.getTouchcookie());
		MultipartEntity UGcdoaAw = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
		UGcdoaAw.addPart("t", new StringBody(token));
		UGcdoaAw.addPart("plain", new StringBody("yes"));
		UGcdoaAw.addPart("dest", new StringBody("/Public"));
		UGcdoaAw.addPart("file", new MonitoredFileBody(file, uploadProgress));
		dnySmyZR.setEntity(UGcdoaAw);
		NULogger.getLogger().log(Level.INFO, "executing request {0}", dnySmyZR.getRequestLine());
		NULogger.getLogger().info("Now uploading your file into dropbox.com");
		status = UploadStatus.UPLOADING;
		HttpResponse HGqFmr91 = aOI10E9q.execute(dnySmyZR);
		status = UploadStatus.GETTINGLINK;
		HttpEntity GQa2Zql1 = HGqFmr91.getEntity();
		NULogger.getLogger().info(HGqFmr91.getStatusLine().toString());
		if (GQa2Zql1 != null) {
			uploadresponse = EntityUtils.toString(GQa2Zql1);
		}
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