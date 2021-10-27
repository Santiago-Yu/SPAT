class n5246170 {
	public static void fileCopy(String src, String dst) {
		try {
			FileOutputStream fos = new FileOutputStream(dst);
			FileInputStream fis = new FileInputStream(src);
			byte[] buf = new byte[8192];
			int read = -1;
			while ((read = fis.read(buf)) != -1) {
				fos.write(buf, 0, read);
			}
			fos.flush();
			fos.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}