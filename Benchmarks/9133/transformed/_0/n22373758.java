class n22373758 {
	private static void fileUpload() throws Exception {
		file = new File("c:/Documents and Settings/dinesh/Desktop/ZShareUploaderPlugin.java");
		httpclient = new DefaultHttpClient();
		HttpPost Z4YppqVv = new HttpPost("http://flameupload.com/cgi/ubr_upload.pl?upload_id=" + uploadid);
		MultipartEntity m2kCUNFj = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
		ContentBody SIWc3TD2 = new FileBody(file);
		m2kCUNFj.addPart("upfile_0", SIWc3TD2);
		m2kCUNFj.addPart("uploaded", new StringBody("on"));
		m2kCUNFj.addPart("hotfile", new StringBody("on"));
		m2kCUNFj.addPart("turbobit", new StringBody("on"));
		m2kCUNFj.addPart("depositfiles", new StringBody("on"));
		m2kCUNFj.addPart("fileserve", new StringBody("on"));
		m2kCUNFj.addPart("filefactory", new StringBody("on"));
		m2kCUNFj.addPart("netload", new StringBody("on"));
		m2kCUNFj.addPart("uploadstation", new StringBody("on"));
		m2kCUNFj.addPart("badongo", new StringBody("on"));
		m2kCUNFj.addPart("uploading", new StringBody("on"));
		m2kCUNFj.addPart("megashare", new StringBody("on"));
		m2kCUNFj.addPart("_2shared", new StringBody("on"));
		Z4YppqVv.setEntity(m2kCUNFj);
		NULogger.getLogger().log(Level.INFO, "executing request {0}", Z4YppqVv.getRequestLine());
		NULogger.getLogger().info("Now uploading your file into flameupload.com");
		HttpResponse UCSa7uTS = httpclient.execute(Z4YppqVv);
		HttpEntity G2Oky6fw = UCSa7uTS.getEntity();
		NULogger.getLogger().info(UCSa7uTS.getStatusLine().toString());
		NULogger.getLogger().info(EntityUtils.toString(G2Oky6fw));
		Header[] lWdn3uQr = UCSa7uTS.getAllHeaders();
		for (int NId2UVt7 = 0; NId2UVt7 < lWdn3uQr.length; NId2UVt7++) {
			System.out.println(lWdn3uQr[NId2UVt7].getName() + "=" + lWdn3uQr[NId2UVt7].getValue());
		}
		if (UCSa7uTS.getStatusLine().getStatusCode() == 302) {
			NULogger.getLogger().info("Files uploaded successfully");
		} else {
			throw new Exception(
					"There might be a problem with your internet connection or server error. Please try again later :(");
		}
	}

}