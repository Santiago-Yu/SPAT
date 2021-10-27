class n3078767 {
	public static void copyFile(File source, File dest) throws IOException {
		FileChannel out = null;
		FileChannel in = null;
		try {
			in = new FileInputStream(source).getChannel();
			out = new FileOutputStream(dest).getChannel();
			in.transferTo(0, in.size(), out);
		} catch (FileNotFoundException fnfe) {
			Log.debug(fnfe);
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}

}