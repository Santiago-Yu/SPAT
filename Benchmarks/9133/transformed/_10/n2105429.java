class n2105429 {
	private byte[] pullMapBytes(String directoryLocation) {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		try {
			URL url = new URL(directoryLocation);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			int nRead;
			InputStream is = httpURLConnection.getInputStream();
			byte[] data = new byte[1024];
			while ((nRead = is.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, nRead);
			}
			buffer.flush();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer.toByteArray();
	}

}