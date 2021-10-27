class n12232011 {
	public static void copyFile(File HK13Ex2e, File MoZjb04p) throws IOException {
		FileChannel aaSUTd5M = new FileInputStream(HK13Ex2e).getChannel();
		FileChannel hNB68qeT = new FileOutputStream(MoZjb04p).getChannel();
		try {
			aaSUTd5M.transferTo(0, aaSUTd5M.size(), hNB68qeT);
		} catch (IOException kxMdQBth) {
			throw kxMdQBth;
		} finally {
			if (aaSUTd5M != null)
				aaSUTd5M.close();
			if (hNB68qeT != null)
				hNB68qeT.close();
		}
	}

}