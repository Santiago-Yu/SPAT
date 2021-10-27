class n1037402 {
	public static final String getContent(String address) {
		String content = "";
		OutputStream out = null;
		URLConnection conn = null;
		InputStream in = null;
		try {
			URL url = new URL(address);
			out = new ByteArrayOutputStream();
			conn = url.openConnection();
			in = conn.getInputStream();
			byte[] buffer = new byte[1024];
			int numRead;
			for (; (numRead = in.read(buffer)) != -1;) {
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