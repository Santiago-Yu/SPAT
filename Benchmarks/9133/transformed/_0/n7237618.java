class n7237618 {
	public static void copyFile(File dysDIMiz, File F8lyOJSs) throws IOException {
		FileChannel rjFtqyAl = new FileInputStream(dysDIMiz).getChannel();
		FileChannel uMELbd3J = new FileOutputStream(F8lyOJSs).getChannel();
		try {
			rjFtqyAl.transferTo(0, rjFtqyAl.size(), uMELbd3J);
		} catch (IOException YoAzjpuM) {
			throw YoAzjpuM;
		} finally {
			if (rjFtqyAl != null)
				rjFtqyAl.close();
			if (uMELbd3J != null)
				uMELbd3J.close();
		}
	}

}