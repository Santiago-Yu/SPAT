class n18681935 {
	public static void copyFromOffset(long offset, File exe, File cab) throws IOException {
		FileOutputStream out = new FileOutputStream(cab);
		DataInputStream in = new DataInputStream(new FileInputStream(exe));
		int bytes_read;
		byte[] buffer = new byte[4096];
		in.skipBytes((int) offset);
		while ((bytes_read = in.read(buffer)) != -1)
			out.write(buffer, 0, bytes_read);
		in.close();
		out.close();
		out = null;
		in = null;
	}

}