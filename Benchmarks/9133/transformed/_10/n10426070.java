class n10426070 {
	public static long copy(File src, long amount, File dst) {
		long amountToRead = amount;
		final int BUFFER_SIZE = 1024;
		OutputStream out = null;
		InputStream in = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(dst));
			in = new BufferedInputStream(new FileInputStream(src));
			byte[] buf = new byte[BUFFER_SIZE];
			while (amountToRead > 0) {
				int read = in.read(buf, 0, (int) Math.min(BUFFER_SIZE, amountToRead));
				if (read == -1)
					break;
				amountToRead -= read;
				out.write(buf, 0, read);
			}
		} catch (IOException e) {
		} finally {
			close(in);
			flush(out);
			close(out);
		}
		return amount - amountToRead;
	}

}