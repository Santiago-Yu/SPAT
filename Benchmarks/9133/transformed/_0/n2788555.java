class n2788555 {
	private void uploadLogin() {
		try {
			status = UploadStatus.INITIALISING;
			if (file.length() > 419430400) {
				JOptionPane.showMessageDialog(neembuuuploader.NeembuuUploader.getInstance(),
						"<html><b>" + getClass().getSimpleName() + "</b> "
								+ TranslationProvider.get("neembuuuploader.uploaders.maxfilesize")
								+ ": <b>400MB</b></html>",
						getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
				uploadFailed();
				return;
			}
			status = UploadStatus.GETTINGCOOKIE;
			HttpParams FnAFhMZe = new BasicHttpParams();
			FnAFhMZe.setParameter("http.useragent",
					"Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB; rv:1.9.2) Gecko/20100115 Firefox/3.6");
			DefaultHttpClient txm8TWEw = new DefaultHttpClient(FnAFhMZe);
			httpget = new HttpGet("http://hotfile.com/?cookiecheck=1");
			httpget.setHeader("Referer", "http://www.hotfile.com/");
			httpget.setHeader("Cache-Control", "max-age=0");
			httpget.setHeader("Origin", "http://www.hotfile.com/");
			httpget.setHeader("Accept",
					"application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
			txm8TWEw = new DefaultHttpClient(FnAFhMZe);
			txm8TWEw.getCookieStore().addCookie(HotFileAccount.getHfcookie());
			HttpResponse sQIV2Um7 = txm8TWEw.execute(httpget);
			strResponse = EntityUtils.toString(sQIV2Um7.getEntity());
			start = "<form action=\"";
			link = strResponse.substring(strResponse.indexOf(start + "http://") + start.length());
			link = link.substring(0, link.indexOf("\""));
			NULogger.getLogger().info(link);
			httppost = new HttpPost(link);
			httppost.setHeader("Referer", "http://www.hotfile.com/");
			httppost.setHeader("Cache-Control", "max-age=0");
			httppost.setHeader("Origin", "http://www.hotfile.com/");
			httppost.setHeader("Accept",
					"application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
			MultipartEntity rAutiZVY = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
			rAutiZVY.addPart("uploads[]", new MonitoredFileBody(file, uploadProgress));
			rAutiZVY.addPart("iagree", new StringBody("on"));
			rAutiZVY.addPart("", new StringBody("Upload"));
			httppost.setEntity(rAutiZVY);
			status = UploadStatus.UPLOADING;
			sQIV2Um7 = txm8TWEw.execute(httppost);
			manageURL = sQIV2Um7.getHeaders("Location")[0].getValue();
			NULogger.getLogger().log(Level.INFO, "HotFile Manage URL{0}", manageURL);
			NULogger.getLogger().info("Getting links from Manage URL");
			status = UploadStatus.GETTINGLINK;
			httpget = new HttpGet(manageURL);
			txm8TWEw = new DefaultHttpClient(FnAFhMZe);
			sQIV2Um7 = txm8TWEw.execute(httpget);
			strResponse = EntityUtils.toString(sQIV2Um7.getEntity());
			start = "<input type=\"text\" name=\"url\" id=\"url\" class=\"textfield\" value=\"";
			downURL = strResponse.substring(strResponse.indexOf(start) + start.length());
			downURL = downURL.substring(0, downURL.indexOf("\""));
			start = "<input type=\"text\" name=\"delete\" id=\"delete\" class=\"textfield\" value=\"";
			delURL = strResponse.substring(strResponse.indexOf(start) + start.length());
			delURL = delURL.substring(0, delURL.indexOf("\""));
			NULogger.getLogger().log(Level.INFO, "Download Link: {0}", downURL);
			NULogger.getLogger().log(Level.INFO, "Delete link: {0}", delURL);
			uploadFinished();
		} catch (Exception JVt29gFS) {
			JVt29gFS.printStackTrace();
			NULogger.getLogger().severe(JVt29gFS.toString());
			uploadFailed();
		}
	}

}