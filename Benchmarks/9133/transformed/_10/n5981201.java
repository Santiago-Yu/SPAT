class n5981201 {
	public static void copyFile(File src, File dst) throws IOException {
		if (T.t)
			T.info("Copying " + src + " -> " + dst + "...");
		FileOutputStream out = new FileOutputStream(dst);
		FileInputStream in = new FileInputStream(src);
		int read;
		byte buf[] = new byte[40 * KB];
		while ((read = in.read(buf)) != -1) {
			out.write(buf, 0, read);
		}
		out.flush();
		out.close();
		in.close();
		if (T.t)
			T.info("File copied.");
	}

}