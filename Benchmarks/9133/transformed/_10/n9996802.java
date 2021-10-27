class n9996802 {
	public static int copy(File src, int amount, File dst) {
		int amountToRead = amount;
		final int BUFFER_SIZE = 1024;
		OutputStream out = null;
		InputStream in = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(dst));
			in = new BufferedInputStream(new FileInputStream(src));
			byte[] buf = new byte[BUFFER_SIZE];
			while (amountToRead > 0) {
				int read = in.read(buf, 0, Math.min(BUFFER_SIZE, amountToRead));
				if (read == -1)
					break;
				amountToRead -= read;
				out.write(buf, 0, read);
			}
		} catch (IOException e) {
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
				}
			if (out != null) {
				try {
					out.flush();
				} catch (IOException e) {
				}
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
		return amount - amountToRead;
	}

}