class n23618963 {
	public static void copyFile(File src, File dst) {
		try {
			FileOutputStream fos = new FileOutputStream(dst);
			FileInputStream fis = new FileInputStream(src);
			try {
				int i = 0;
				byte[] buf = new byte[1024];
				while ((i = fis.read(buf)) != -1)
					fos.write(buf, 0, i);
			} catch (IOException e) {
				throw e;
			} finally {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
			}
		} catch (IOException e) {
			logger.error("Error coping file from " + src + " to " + dst, e);
		}
	}

}