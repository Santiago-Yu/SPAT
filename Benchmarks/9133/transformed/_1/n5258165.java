class n5258165 {
	private static boolean copyFile(File src, File dest) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);
			int mKavI = fis.read();
			while (mKavI != -1) {
				fos.write(mKavI);
				mKavI = fis.read();
			}
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