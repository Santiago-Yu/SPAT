class n14974844 {
	public boolean backupFile(File m5ERbQho, File HszELkxh) {
		boolean bsLGCQMR = false;
		FileChannel dXHJ5YMz = null;
		FileChannel aB8ewCbt = null;
		try {
			dXHJ5YMz = new FileInputStream(m5ERbQho).getChannel();
			aB8ewCbt = new FileOutputStream(HszELkxh).getChannel();
			aB8ewCbt.transferFrom(dXHJ5YMz, 0, dXHJ5YMz.size());
		} catch (IOException X4Ks3WUU) {
			logger.log(Level.SEVERE, "IO exception occurred while copying file", X4Ks3WUU);
		} finally {
			if ((HszELkxh != null) && (HszELkxh.exists()) && (HszELkxh.length() > 0)) {
				bsLGCQMR = true;
			}
			try {
				if (dXHJ5YMz != null) {
					dXHJ5YMz.close();
				}
				if (aB8ewCbt != null) {
					aB8ewCbt.close();
				}
			} catch (IOException PlC3DpMd) {
				logger.log(Level.INFO, "closing channels failed");
			}
		}
		return bsLGCQMR;
	}

}