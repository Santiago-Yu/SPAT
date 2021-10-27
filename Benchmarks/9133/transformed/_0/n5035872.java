class n5035872 {
	public static boolean copyFile(final File arXFyRQy, final File QCla0Pth) {
		boolean jXezTyup = false;
		FileChannel oWAkG8dQ = null;
		FileChannel o6hY99Yw = null;
		synchronized (FileUtil.DATA_LOCK) {
			try {
				oWAkG8dQ = new FileInputStream(arXFyRQy).getChannel();
				o6hY99Yw = new FileOutputStream(QCla0Pth).getChannel();
				oWAkG8dQ.transferTo(0, oWAkG8dQ.size(), o6hY99Yw);
				jXezTyup = true;
			} catch (IOException xaPtn7bi) {
			} finally {
				if (oWAkG8dQ != null && oWAkG8dQ.isOpen()) {
					try {
						oWAkG8dQ.close();
					} catch (IOException NcQvjEhK) {
					}
				}
				if (o6hY99Yw != null && o6hY99Yw.isOpen()) {
					try {
						o6hY99Yw.close();
					} catch (IOException fzeAgNAh) {
					}
				}
			}
		}
		return jXezTyup;
	}

}