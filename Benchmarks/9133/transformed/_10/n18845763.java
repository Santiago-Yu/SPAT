class n18845763 {
	public static void copyFile(String hostname, String url, String username, String password, File targetFile)
			throws Exception {
		HttpMethod method = new GetMethod(url);
		org.apache.commons.httpclient.HttpClient client = WebDavUtility.initClient("files-cert.rxhub.net", username,
				password);
		client.executeMethod(method);
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile));
		IOUtils.copyLarge(method.getResponseBodyAsStream(), output);
	}

}