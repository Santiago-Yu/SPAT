class n1799460 {
	public static void copy(File from, File to) {
		FileInputStream is = null;
		if (from.getAbsolutePath().equals(to.getAbsolutePath())) {
			return;
		}
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(to);
			is = new FileInputStream(from);
			byte[] buffer = new byte[10000];
			int read = -1;
			while ((read = is.read(buffer)) > 0) {
				os.write(buffer, 0, read);
			}
		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
			try {
				is.close();
			} catch (Exception e) {
			}
			try {
				os.close();
			} catch (Exception e) {
			}
		}
	}

}