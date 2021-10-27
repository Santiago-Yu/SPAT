class n7401182 {
	@Override
	public void run() {
		try {
			status = UploadStatus.INITIALISING;
			DefaultHttpClient nLCvMPS7 = new DefaultHttpClient();
			HttpGet mTW8OODR = new HttpGet("http://www.filedropper.com");
			mTW8OODR.setHeader("User-Agent",
					"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2 GTBDFff GTB7.0");
			HttpResponse z6ddYO0d = nLCvMPS7.execute(mTW8OODR);
			z6ddYO0d.getEntity().consumeContent();
			httppost = new HttpPost("http://www.filedropper.com/index.php?xml=true");
			httppost.setHeader("User-Agent",
					"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2 GTBDFff GTB7.0");
			MultipartEntity a4He8s37 = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
			a4He8s37.addPart("file", new MonitoredFileBody(file, uploadProgress));
			a4He8s37.addPart("Upload", new StringBody("Submit Query"));
			httppost.setEntity(a4He8s37);
			status = UploadStatus.UPLOADING;
			z6ddYO0d = nLCvMPS7.execute(httppost);
			String wcfQgjgo = EntityUtils.toString(z6ddYO0d.getEntity());
			status = UploadStatus.GETTINGLINK;
			downURL = "http://www.filedropper.com/" + wcfQgjgo.substring(wcfQgjgo.lastIndexOf("=") + 1);
			NULogger.getLogger().info(downURL);
			uploadFinished();
		} catch (Exception skRXHrgN) {
			skRXHrgN.printStackTrace();
			NULogger.getLogger().severe(skRXHrgN.toString());
			uploadFailed();
		}
	}

}