class n1468131 {
	public void run() {
		try {
			if (FileDenAccount.loginsuccessful) {
				host = FileDenAccount.username + " | FileDen.com";
			} else {
				host = "FileDen.com";
				uploadFailed();
				return;
			}
			if (file.length() > 1073741824) {
				JOptionPane.showMessageDialog(neembuuuploader.NeembuuUploader.getInstance(),
						"<html><b>" + getClass().getSimpleName() + "</b> "
								+ TranslationProvider.get("neembuuuploader.uploaders.maxfilesize")
								+ ": <b>1GB</b></html>",
						getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
				uploadFailed();
				return;
			}
			String[] unsupported = new String[] { "html", "htm", "php", "php3", "phtml", "htaccess", "htpasswd", "cgi",
					"pl", "asp", "aspx", "cfm", "exe", "ade", "adp", "bas", "bat", "chm", "cmd", "com", "cpl", "crt",
					"hlp", "hta", "inf", "ins", "isp", "jse", "lnk", "mdb", "mde", "msc", "msi", "msp", "mst", "pcd",
					"pif", "reg", "scr", "sct", "shs", "url", "vbe", "vbs", "wsc", "wsf", "wsh", "shb", "js", "vb",
					"ws", "mdt", "mdw", "mdz", "shb", "scf", "pl", "pm", "dll" };
			file_ext = file.getName().substring(file.getName().lastIndexOf(".") + 1);
			for (int i = 0; i < unsupported.length; i++) {
				if (file_ext.equalsIgnoreCase(unsupported[i])) {
					file_extension_not_supported = true;
					break;
				}
			}
			if (file_extension_not_supported) {
				JOptionPane.showMessageDialog(neembuuuploader.NeembuuUploader.getInstance(),
						"<html><b>" + getClass().getSimpleName() + "</b> "
								+ TranslationProvider.get("neembuuuploader.uploaders.filetypenotsupported") + ": <b>"
								+ file_ext + "</b></html>",
						getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
				uploadFailed();
				return;
			}
			DefaultHttpClient httpclient = new DefaultHttpClient();
			status = UploadStatus.INITIALISING;
			HttpPost httppost = new HttpPost("http://www.fileden.com/upload_old.php");
			httppost.setHeader("Cookie", FileDenAccount.getCookies().toString());
			MultipartEntity mpEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
			mpEntity.addPart("Filename", new StringBody(file.getName()));
			mpEntity.addPart("action", new StringBody("upload"));
			mpEntity.addPart("upload_to", new StringBody(""));
			mpEntity.addPart("overwrite_option", new StringBody("overwrite"));
			mpEntity.addPart("thumbnail_size", new StringBody("small"));
			mpEntity.addPart("create_img_tags", new StringBody("1"));
			mpEntity.addPart("file0", new MonitoredFileBody(file, uploadProgress));
			httppost.setEntity(mpEntity);
			NULogger.getLogger().log(Level.INFO, "executing request {0}", httppost.getRequestLine());
			NULogger.getLogger().info("Now uploading your file into fileden");
			status = UploadStatus.UPLOADING;
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity resEntity = response.getEntity();
			NULogger.getLogger().info(response.getStatusLine().toString());
			status = UploadStatus.GETTINGLINK;
			if (resEntity != null) {
				uploadresponse = EntityUtils.toString(resEntity);
			}
			NULogger.getLogger().info(uploadresponse);
			downloadlink = CommonUploaderTasks.parseResponse(uploadresponse, "'link':'", "'");
			NULogger.getLogger().log(Level.INFO, "Download link : {0}", downloadlink);
			downURL = downloadlink;
			httpclient.getConnectionManager().shutdown();
			uploadFinished();
		} catch (Exception e) {
			Logger.getLogger(RapidShare.class.getName()).log(Level.SEVERE, null, e);
			uploadFailed();
		}
	}

}