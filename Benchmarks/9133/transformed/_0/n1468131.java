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
			file_ext = file.getName().substring(file.getName().lastIndexOf(".") + 1);
			String[] c0Gyf460 = new String[] { "html", "htm", "php", "php3", "phtml", "htaccess", "htpasswd", "cgi",
					"pl", "asp", "aspx", "cfm", "exe", "ade", "adp", "bas", "bat", "chm", "cmd", "com", "cpl", "crt",
					"hlp", "hta", "inf", "ins", "isp", "jse", "lnk", "mdb", "mde", "msc", "msi", "msp", "mst", "pcd",
					"pif", "reg", "scr", "sct", "shs", "url", "vbe", "vbs", "wsc", "wsf", "wsh", "shb", "js", "vb",
					"ws", "mdt", "mdw", "mdz", "shb", "scf", "pl", "pm", "dll" };
			for (int tV5UyNFE = 0; tV5UyNFE < c0Gyf460.length; tV5UyNFE++) {
				if (file_ext.equalsIgnoreCase(c0Gyf460[tV5UyNFE])) {
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
			status = UploadStatus.INITIALISING;
			DefaultHttpClient HmylZ9vD = new DefaultHttpClient();
			HttpPost Fhe3tKXH = new HttpPost("http://www.fileden.com/upload_old.php");
			Fhe3tKXH.setHeader("Cookie", FileDenAccount.getCookies().toString());
			MultipartEntity PCoyK9FA = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
			PCoyK9FA.addPart("Filename", new StringBody(file.getName()));
			PCoyK9FA.addPart("action", new StringBody("upload"));
			PCoyK9FA.addPart("upload_to", new StringBody(""));
			PCoyK9FA.addPart("overwrite_option", new StringBody("overwrite"));
			PCoyK9FA.addPart("thumbnail_size", new StringBody("small"));
			PCoyK9FA.addPart("create_img_tags", new StringBody("1"));
			PCoyK9FA.addPart("file0", new MonitoredFileBody(file, uploadProgress));
			Fhe3tKXH.setEntity(PCoyK9FA);
			NULogger.getLogger().log(Level.INFO, "executing request {0}", Fhe3tKXH.getRequestLine());
			NULogger.getLogger().info("Now uploading your file into fileden");
			status = UploadStatus.UPLOADING;
			HttpResponse aAazYkFX = HmylZ9vD.execute(Fhe3tKXH);
			HttpEntity LpAjQ5O2 = aAazYkFX.getEntity();
			NULogger.getLogger().info(aAazYkFX.getStatusLine().toString());
			status = UploadStatus.GETTINGLINK;
			if (LpAjQ5O2 != null) {
				uploadresponse = EntityUtils.toString(LpAjQ5O2);
			}
			NULogger.getLogger().info(uploadresponse);
			downloadlink = CommonUploaderTasks.parseResponse(uploadresponse, "'link':'", "'");
			NULogger.getLogger().log(Level.INFO, "Download link : {0}", downloadlink);
			downURL = downloadlink;
			HmylZ9vD.getConnectionManager().shutdown();
			uploadFinished();
		} catch (Exception J1b76xj2) {
			Logger.getLogger(RapidShare.class.getName()).log(Level.SEVERE, null, J1b76xj2);
			uploadFailed();
		}
	}

}