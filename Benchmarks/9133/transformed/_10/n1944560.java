class n1944560 {
	private static boolean copyFile(File src, File dest) {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			fos = new FileOutputStream(dest);
			fis = new FileInputStream(src);
			for (int c = fis.read(); c != -1; c = fis.read())
				fos.write(c);
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}