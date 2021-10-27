class n2883828 {
	public static void copyFile(File from, File to) {
		try {
			FileInputStream in = new FileInputStream(from);
			FileOutputStream out = new FileOutputStream(to);
			byte[] buffer = new byte[1024 * 16];
			int read = 0;
			for (; (read = in.read(buffer)) >= 0;) {
				out.write(buffer, 0, read);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}