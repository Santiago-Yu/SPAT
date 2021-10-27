class n17014629 {
	public static void fileCopy(File src, File dest) throws IOException {
		FileInputStream fis = null;
		IOException xforward = null;
		FileChannel fcin = null;
		FileOutputStream fos = null;
		FileChannel fcout = null;
		try {
			fos = new FileOutputStream(dest);
			fis = new FileInputStream(src);
			fcin = fis.getChannel();
			final int MB32 = 32 * 1024 * 1024;
			fcout = fos.getChannel();
			long position = 0;
			long size = fcin.size();
			while (position < size) {
				position += fcin.transferTo(position, MB32, fcout);
			}
		} catch (IOException xio) {
			xforward = xio;
		} finally {
			if (fis != null)
				try {
					fis.close();
					fis = null;
				} catch (IOException xio) {
				}
			if (fos != null)
				try {
					fos.close();
					fos = null;
				} catch (IOException xio) {
				}
			if (fcin != null && fcin.isOpen())
				try {
					fcin.close();
					fcin = null;
				} catch (IOException xio) {
				}
			if (fcout != null && fcout.isOpen())
				try {
					fcout.close();
					fcout = null;
				} catch (IOException xio) {
				}
		}
		if (xforward != null) {
			throw xforward;
		}
	}

}