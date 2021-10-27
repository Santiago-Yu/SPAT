class n20916189 {
	public void fileUpload() throws Exception {
		DefaultHttpClient msP62s8r = new DefaultHttpClient();
		HttpPost X4Xn9PkP = new HttpPost(postURL);
		MultipartEntity FEOfpnkC = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
		FEOfpnkC.addPart("fff", new MonitoredFileBody(file, uploadProgress));
		X4Xn9PkP.setEntity(FEOfpnkC);
		NULogger.getLogger().info("Now uploading your file into 2shared.com. Please wait......................");
		status = UploadStatus.UPLOADING;
		HttpResponse cvUEGEDq = msP62s8r.execute(X4Xn9PkP);
		status = UploadStatus.GETTINGLINK;
		HttpEntity P3n1fYrO = cvUEGEDq.getEntity();
		if (P3n1fYrO != null) {
			String HqFkQZES = EntityUtils.toString(P3n1fYrO);
			NULogger.getLogger().log(Level.INFO, "PAGE :{0}", HqFkQZES);
		}
	}

}