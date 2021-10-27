class n17323351 {
	public static String getOriginalWSDL(String wsdlURL) {
		try {
			URL url = new URL(wsdlURL);
			java.net.HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			InputStream input = conn.getInputStream();
			final int BUFFERSIZE = 4096;
			byte[] buffer = new byte[BUFFERSIZE];
			OutputStream output = new ByteArrayOutputStream();
			while (true) {
				int read = input.read(buffer);
				if (-1 == read) {
					break;
				}
				output.write(buffer, 0, read);
			}
			output.close();
			input.close();
			conn.disconnect();
			String s = output.toString();
			return s;
		} catch (Exception e) {
			return null;
		}
	}

}