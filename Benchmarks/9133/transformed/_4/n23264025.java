class n23264025 {
	private byte[] download(String URL) {
		byte[] result = null;
		HttpEntity httpEntity = null;
		try {
			HttpGet httpGet = new HttpGet(URL);
			httpGet.addHeader("Accept-Language", "zh-cn,zh,en");
			httpGet.addHeader("Accept-Encoding", "gzip,deflate");
			HttpResponse response = httpClient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() != 200) {
				return null;
			}
			Header header = response.getFirstHeader("content-type");
			if (header == null || header.getValue().indexOf("text/html") < 0) {
				return null;
			}
			int pos = header.getValue().indexOf("charset=");
			detectedEncoding = (pos >= 0) ? header.getValue().substring(pos + 8) : detectedEncoding;
			httpEntity = response.getEntity();
			InputStream in = null;
			in = httpEntity.getContent();
			header = response.getFirstHeader("Content-Encoding");
			if (null != header) {
				if (header.getValue().indexOf("gzip") >= 0) {
					in = new GZIPInputStream(in);
				} else
					in = (header.getValue().indexOf("deflate") >= 0) ? new InflaterInputStream(in, new Inflater(true))
							: in;
			}
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
			result = out.toByteArray();
		} catch (IOException ex) {
			LOG.warn("downloading error,abandon");
			result = null;
		}
		return result;
	}

}