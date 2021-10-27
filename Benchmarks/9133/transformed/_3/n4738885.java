class n4738885 {
	public final int sendMetaData(FileInputStream fis) throws Exception {
		try {
			UUID uuid = UUID.randomUUID();
			HttpClient client = new SSLHttpClient();
			StringBuilder builder = new StringBuilder(mServer).append("?cmd=meta").append("&id=" + uuid);
			HttpPost method = new HttpPost(builder.toString());
			String fileName = uuid + ".metadata";
			FileInputStreamPart part = new FileInputStreamPart("data", fileName, fis);
			MultipartEntity requestContent = new MultipartEntity(new Part[] { part });
			method.setEntity(requestContent);
			HttpResponse response = client.execute(method);
			int code = response.getStatusLine().getStatusCode();
			if (!(code == HttpStatus.SC_OK)) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			throw new Exception("send meta data", e);
		}
	}

}