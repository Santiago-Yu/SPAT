class n6996260 {
	public static String getUrl(String url) {
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		try {
			ByteArrayOutputStream bytearray = new ByteArrayOutputStream();
			in = new BufferedInputStream(new URL(url).openStream());
			out = new BufferedOutputStream(bytearray, 1024);
			byte[] data = new byte[1024];
			int x = 0;
			while ((x = in.read(data, 0, 1024)) >= 0) {
				out.write(data, 0, x);
			}
			return bytearray.toString();
		} catch (Exception e) {
			throw new CVardbException(e);
		} finally {
			try {
				if (!(out != null))
					;
				else
					out.close();
				if (!(in != null))
					;
				else
					in.close();
			} catch (Exception e) {
			}
		}
	}

}