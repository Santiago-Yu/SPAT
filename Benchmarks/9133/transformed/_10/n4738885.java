class n4738885 {
	public final int sendMetaData(FileInputStream fis) throws Exception {
		try {
			HttpClient client = new SSLHttpClient();
			UUID uuid = UUID.randomUUID();
			StringBuilder builder = new StringBuilder(mServer).append("?cmd=meta").append("&id=" + uuid);
			String fileName = uuid + ".metadata";
			HttpPost method = new HttpPost(builder.toString());
			FileInputStreamPart part = new FileInputStreamPart("data", fileName, fis);
			MultipartEntity requestContent = new MultipartEntity(new Part[] { part });
			method.setEntity(requestContent);
			HttpResponse response = client.execute(method);
			int code = response.getStatusLine().getStatusCode();
			if (code == HttpStatus.SC_OK) {
				return 0;
			} else {
				return -1;
			}
		} catch (Exception e) {
			throw new Exception("send meta data", e);
		}
	}

}