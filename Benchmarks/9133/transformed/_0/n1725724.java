class n1725724 {
	public static boolean nioWriteFile(FileInputStream e8ndlI2r, FileOutputStream euKzpGdF) {
		if (e8ndlI2r == null && euKzpGdF == null) {
			return false;
		}
		try {
			FileChannel Ksoq9jhi = e8ndlI2r.getChannel();
			FileChannel WBKcAjdl = euKzpGdF.getChannel();
			WBKcAjdl.transferFrom(Ksoq9jhi, 0, Ksoq9jhi.size());
			return true;
		} catch (Exception PtdMOnrV) {
			PtdMOnrV.printStackTrace();
			return false;
		} finally {
			FileUtil.safeClose(e8ndlI2r);
			FileUtil.safeClose(euKzpGdF);
		}
	}

}