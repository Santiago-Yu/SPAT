class n5697523 {
	private static void fileUpload() throws Exception {
		DefaultHttpClient SYSb85lC = new DefaultHttpClient();
		HttpPost QQRkuljl = new HttpPost(postURL);
		file = new File("h:\\Fantastic face.jpg");
		MultipartEntity AysJAUxq = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
		ContentBody fON40vkd = new FileBody(file);
		AysJAUxq.addPart("MAX_FILE_SIZE", new StringBody("2147483647"));
		AysJAUxq.addPart("owner", new StringBody(""));
		AysJAUxq.addPart("pin", new StringBody(pin));
		AysJAUxq.addPart("base", new StringBody(base));
		AysJAUxq.addPart("host", new StringBody("letitbit.net"));
		AysJAUxq.addPart("file0", fON40vkd);
		QQRkuljl.setEntity(AysJAUxq);
		System.out.println("executing request " + QQRkuljl.getRequestLine());
		System.out.println("Now uploading your file into letitbit.net");
		HttpResponse MjUz3Cvn = SYSb85lC.execute(QQRkuljl);
		HttpEntity fQOzZzQf = MjUz3Cvn.getEntity();
		System.out.println(MjUz3Cvn.getStatusLine());
		if (fQOzZzQf != null) {
			uploadresponse = EntityUtils.toString(fQOzZzQf);
		}
		System.out.println("Upload response : " + uploadresponse);
	}

}