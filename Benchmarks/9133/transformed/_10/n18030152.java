class n18030152 {
	public static boolean copyFile(File from, File tu) {
		final int BUFFER_SIZE = 4096;
		byte[] buffer = new byte[BUFFER_SIZE];
		try {
			FileOutputStream out = new FileOutputStream(tu);
			FileInputStream in = new FileInputStream(from);
			int read;
			while ((read = in.read(buffer)) != -1) {
				out.write(buffer, 0, read);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

}