class n9150482 {
	public static void copy(File _from, File _to) throws IOException {
		FileOutputStream out = null;
		if (_from == null || !_from.exists())
			return;
		FileInputStream in = null;
		try {
			in = new FileInputStream(_from);
			out = new FileOutputStream(_to);
			byte[] buf = new byte[2048];
			int read = in.read(buf);
			while (read > 0) {
				out.write(buf, 0, read);
				read = in.read(buf);
			}
		} catch (IOException _e) {
			throw _e;
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}

}