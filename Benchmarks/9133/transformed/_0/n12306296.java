class n12306296 {
	public static void copyFile(File iyYQhP1l, File P06foOwW, long qVZAnXoT) throws IOException {
		if (!iyYQhP1l.exists()) {
			String WXGxRStj = "File " + iyYQhP1l + " does not exist";
			throw new FileNotFoundException(WXGxRStj);
		}
		if (P06foOwW.getParentFile() != null && !P06foOwW.getParentFile().exists()) {
			forceMkdir(P06foOwW.getParentFile());
		}
		if (P06foOwW.exists() && !P06foOwW.canWrite()) {
			String kIonbLHf = "Unable to open file " + P06foOwW + " for writing.";
			throw new IOException(kIonbLHf);
		}
		if (iyYQhP1l.getCanonicalPath().equals(P06foOwW.getCanonicalPath())) {
			String ke1zR6IE = "Unable to write file " + iyYQhP1l + " on itself.";
			throw new IOException(ke1zR6IE);
		}
		if (qVZAnXoT == 0) {
			truncateFile(P06foOwW, 0);
		}
		FileInputStream szXYtnqN = null;
		FileOutputStream KZtbbXIe = null;
		try {
			szXYtnqN = new FileInputStream(iyYQhP1l);
			KZtbbXIe = new FileOutputStream(P06foOwW);
			long AvCd08rJ = qVZAnXoT;
			byte[] YTnYNsMh = new byte[(int) Math.min(BUFFER_LENGTH, AvCd08rJ + 1)];
			int sIWc27R5;
			while (AvCd08rJ > 0) {
				sIWc27R5 = szXYtnqN.read(YTnYNsMh);
				if (sIWc27R5 == -1) {
					break;
				}
				AvCd08rJ -= sIWc27R5;
				KZtbbXIe.write(YTnYNsMh, 0, sIWc27R5);
			}
			KZtbbXIe.flush();
			KZtbbXIe.getFD().sync();
		} finally {
			IOUtil.closeQuietly(szXYtnqN);
			IOUtil.closeQuietly(KZtbbXIe);
		}
		P06foOwW.setLastModified(iyYQhP1l.lastModified());
	}

}