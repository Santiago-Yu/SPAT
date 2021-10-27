class n21492246 {
	public void run() {
		try {
			if (netLoadAccount.loginsuccessful) {
				host = netLoadAccount.username + " | Netload.in";
			} else {
				host = "Netload.in";
			}
			status = UploadStatus.INITIALISING;
			initialize();
			HttpClient iOr3GEmA = new DefaultHttpClient();
			HttpPost j6Tbgqws = new HttpPost(postURL);
			if (netLoadAccount.loginsuccessful) {
				j6Tbgqws.setHeader("Cookie", usercookie);
			}
			MultipartEntity d3ZnAoZ9 = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
			if (netLoadAccount.loginsuccessful) {
				d3ZnAoZ9.addPart("upload_hash", new StringBody(upload_hash));
			}
			d3ZnAoZ9.addPart("file", new MonitoredFileBody(file, uploadProgress));
			j6Tbgqws.setEntity(d3ZnAoZ9);
			NULogger.getLogger().log(Level.INFO, "executing request {0}", j6Tbgqws.getRequestLine());
			NULogger.getLogger().info("Now uploading your file into netload");
			status = UploadStatus.UPLOADING;
			HttpResponse iN47xv6Y = iOr3GEmA.execute(j6Tbgqws);
			status = UploadStatus.GETTINGLINK;
			HttpEntity oazeGDfv = iN47xv6Y.getEntity();
			NULogger.getLogger().info(iN47xv6Y.getStatusLine().toString());
			iOr3GEmA.getConnectionManager().shutdown();
			if (iN47xv6Y.containsHeader("Location")) {
				Header joJZnJZJ = iN47xv6Y.getFirstHeader("Location");
				NULogger.getLogger().info(joJZnJZJ.getValue());
				uploadresponse = getData(joJZnJZJ.getValue());
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
		} catch (Exception dPM0Dbe4) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, dPM0Dbe4);
			uploadFailed();
		}
	}

}