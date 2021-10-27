class n2664954 {
	public void run() {
		try {
			status = UploadStatus.INITIALISING;
			if (megaUploadAccount.loginsuccessful) {
				login = true;
				host = megaUploadAccount.username + " | MegaUpload.com";
			} else {
				login = false;
				host = "MegaUpload.com";
			}
			initialize();
			HttpClient elXBlb0l = new DefaultHttpClient();
			elXBlb0l.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
			filelength = file.length();
			generateMegaUploadID();
			if (login) {
				status = UploadStatus.GETTINGCOOKIE;
				usercookie = MegaUploadAccount.getUserCookie();
				postURL = megauploadlink + "upload_done.php?UPLOAD_IDENTIFIER=" + uploadID + "&" + usercookie + "&s="
						+ filelength;
			} else {
				postURL = megauploadlink + "upload_done.php?UPLOAD_IDENTIFIER=" + uploadID + "&user=undefined&s="
						+ filelength;
			}
			HttpPost yWuU91Rz = new HttpPost(postURL);
			yWuU91Rz.setHeader("Cookie", usercookie);
			MultipartEntity PBPqlH2I = new MultipartEntity();
			PBPqlH2I.addPart("", new MonitoredFileBody(file, uploadProgress));
			yWuU91Rz.setEntity(PBPqlH2I);
			NULogger.getLogger().info("Now uploading your file into megaupload...........................");
			status = UploadStatus.UPLOADING;
			HttpResponse xpe5Aq4Y = elXBlb0l.execute(yWuU91Rz);
			HttpEntity rLVqPrNN = xpe5Aq4Y.getEntity();
			NULogger.getLogger().info(xpe5Aq4Y.getStatusLine().toString());
			if (rLVqPrNN != null) {
				status = UploadStatus.GETTINGLINK;
				downloadlink = EntityUtils.toString(rLVqPrNN);
				downloadlink = CommonUploaderTasks.parseResponse(downloadlink, "downloadurl = '", "'");
				downURL = downloadlink;
				NULogger.getLogger().log(Level.INFO, "Download Link : {0}", downURL);
				uploadFinished();
			}
		} catch (Exception SoGMHfcx) {
			Logger.getLogger(MegaUpload.class.getName()).log(Level.SEVERE, null, SoGMHfcx);
			uploadFailed();
		}
	}

}