class n4800020 {
	private void download(String groupId, String artifactId, String version, String type)
			throws ClientProtocolException, IOException {
		String finalName = artifactId + "-" + version;
		File file = new File(deployables, groupId + "/" + artifactId + "/" + version + "/" + finalName + "." + type);
		if (file.exists()) {
			log.warn("Won't download {} found at {}", finalName, file.getAbsolutePath());
			return;
		}
		String url = repository + groupId + "/" + artifactId + "/" + version + "/" + finalName + "." + type;
		HttpGet get = new HttpGet(url);
		HttpResponse response = httpclient.execute(get);
		if (200 == response.getStatusLine().getStatusCode())
			writeContent(get, response.getEntity(), file);
		else
			throw new RuntimeException("Failed to download " + url + " due to error " + response.getStatusLine());
	}

}