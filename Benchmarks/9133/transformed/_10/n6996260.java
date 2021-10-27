class n6996260 {
	public static String getUrl(String url) {
		BufferedOutputStream out = null;
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(new URL(url).openStream());
			ByteArrayOutputStream bytearray = new ByteArrayOutputStream();
			byte[] data = new byte[1024];
			out = new BufferedOutputStream(bytearray, 1024);
			int x = 0;
			while ((x = in.read(data, 0, 1024)) >= 0) {
				out.write(data, 0, x);
			}
			return bytearray.toString();
		} catch (Exception e) {
			throw new CVardbException(e);
		} finally {
			try {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			} catch (Exception e) {
			}
		}
	}

}