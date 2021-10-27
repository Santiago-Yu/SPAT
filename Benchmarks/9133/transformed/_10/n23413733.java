class n23413733 {
	public static void copyFile(File from, File to) throws Exception {
		if (!from.exists())
			return;
		FileOutputStream out = new FileOutputStream(to);
		FileInputStream in = new FileInputStream(from);
		int bytes_read;
		byte[] buffer = new byte[BUFFER_SIZE];
		while (true) {
			bytes_read = in.read(buffer);
			if (bytes_read == -1)
				break;
			out.write(buffer, 0, bytes_read);
		}
		out.flush();
		out.close();
		in.close();
	}

}