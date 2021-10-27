class n22427840 {
	public static void copyFile(File from, File to) {
		try {
			FileOutputStream out = new FileOutputStream(to);
			FileInputStream in = new FileInputStream(from);
			int read = 0;
			byte[] buffer = new byte[1024 * 16];
			while ((read = in.read(buffer)) >= 0) {
				out.write(buffer, 0, read);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}