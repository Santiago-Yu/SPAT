class n22261730 {
	public static boolean fileCopy(String sFileSrc, String sFileDst) {
		FileInputStream fis = null;
		boolean ok = true;
		FileOutputStream fos = null;
		try {
			int len = 32768;
			File fSrc = new File(sFileSrc);
			byte[] buff = new byte[(int) Math.min(len, fSrc.length())];
			boolean append = false;
			fis = new FileInputStream(fSrc);
			fos = new FileOutputStream(sFileDst, append);
			while (0 < (len = fis.read(buff)))
				fos.write(buff, 0, len);
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
			ok = false;
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException ex) {
					ex.printStackTrace();
					JdxLog.logError(ex);
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException ex) {
					ex.printStackTrace();
					JdxLog.logError(ex);
				}
			}
		}
		return ok;
	}

}