class n19922657 {
	protected static boolean copyFile(File src, File dest) {
		try {
			FileInputStream fis = new FileInputStream(src);
			if (!dest.exists()) {
				dest.createNewFile();
			}
			byte[] temp = new byte[1024 * 8];
			FileOutputStream fos = new FileOutputStream(dest);
			int readSize = 0;
			do {
				readSize = fis.read(temp);
				fos.write(temp, 0, readSize);
			} while (readSize == temp.length);
			temp = null;
			fis.close();
			fos.flush();
			fos.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}