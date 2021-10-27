class n1037402 {
	public static final String getContent(String address) {
		OutputStream out = null;
		String content = "";
		InputStream in = null;
		URLConnection conn = null;
		try {
			out = new ByteArrayOutputStream();
			URL url = new URL(address);
			conn = url.openConnection();
			byte[] buffer = new byte[1024];
			in = conn.getInputStream();
			int numRead;
			while ((numRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, numRead);
			}
			content = out.toString();
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException ioe) {
			}
		}
		return content;
	}

}