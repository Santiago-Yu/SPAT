class n10536444 {
	public static void copyFile(File source, File destination) throws IOException {
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destination));
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(source));
		int read = -1;
		byte[] buffer = new byte[4096];
		while ((read = in.read(buffer)) != -1) {
			out.write(buffer, 0, read);
		}
		out.flush();
		out.close();
		in.close();
	}

}