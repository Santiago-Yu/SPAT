class n17323351 {
	public static String getOriginalWSDL(String wsdlURL) {
		try {
			URL url = new URL(wsdlURL);
			java.net.HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			final int BUFFERSIZE = 4096;
			InputStream input = conn.getInputStream();
			OutputStream output = new ByteArrayOutputStream();
			byte[] buffer = new byte[BUFFERSIZE];
			while (true) {
				int read = input.read(buffer);
				if (read == -1) {
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