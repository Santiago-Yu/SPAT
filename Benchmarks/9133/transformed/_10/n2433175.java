class n2433175 {
	private void copyFile(File orig, File dest) {
		byte[] buffer = new byte[1024];
		try {
			FileOutputStream fos = new FileOutputStream(dest, true);
			FileInputStream fis = new FileInputStream(orig);
			int readBytes = 0;
			do {
				readBytes = fis.read(buffer);
				if (readBytes > 0)
					fos.write(buffer, 0, readBytes);
			} while (readBytes > 0);
			fos.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}