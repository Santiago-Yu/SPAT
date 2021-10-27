class n21492246 {
	public void run() {
		try {
			host = (netLoadAccount.loginsuccessful) ? netLoadAccount.username + " | Netload.in" : "Netload.in";
			status = UploadStatus.INITIALISING;
			initialize();
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(postURL);
			if (netLoadAccount.loginsuccessful) {
				httppost.setHeader("Cookie", usercookie);
			}
			MultipartEntity mpEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
			if (netLoadAccount.loginsuccessful) {
				mpEntity.addPart("upload_hash", new StringBody(upload_hash));
			}
			mpEntity.addPart("file", new MonitoredFileBody(file, uploadProgress));
			httppost.setEntity(mpEntity);
			NULogger.getLogger().log(Level.INFO, "executing request {0}", httppost.getRequestLine());
			NULogger.getLogger().info("Now uploading your file into netload");
			status = UploadStatus.UPLOADING;
			HttpResponse response = httpclient.execute(httppost);
			status = UploadStatus.GETTINGLINK;
			HttpEntity resEntity = response.getEntity();
			NULogger.getLogger().info(response.getStatusLine().toString());
			httpclient.getConnectionManager().shutdown();
			if (response.containsHeader("Location")) {
				Header firstHeader = response.getFirstHeader("Location");
				NULogger.getLogger().info(firstHeader.getValue());
				uploadresponse = getData(firstHeader.getValue());
				downloadlink = CommonUploaderTasks.parseResponse(uploadresponse, "The download link is: <br/>",
						"\" target=\"_blank\">");
				downloadlink = downloadlink.substring(downloadlink.indexOf("href=\""));
				downloadlink = downloadlink.replace("href=\"", "");
				NULogger.getLogger().log(Level.INFO, "download link : {0}", downloadlink);
				deletelink = CommonUploaderTasks.parseResponse(uploadresponse, "The deletion link is: <br/>",
						"\" target=\"_blank\">");
				deletelink = deletelink.substring(deletelink.indexOf("href=\""));
				deletelink = deletelink.replace("href=\"", "");
				NULogger.getLogger().log(Level.INFO, "delete link : {0}", deletelink);
				downURL = downloadlink;
				delURL = deletelink;
				uploadFinished();
			} else {
				throw new Exception(
						"There might be a problem with your internet connection or server error. Please try after some time :(");
			}
		} catch (Exception e) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
			uploadFailed();
		}
	}

}