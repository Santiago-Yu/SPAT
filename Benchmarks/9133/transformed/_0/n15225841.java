class n15225841 {
	public void copyFile(File cTYOmVUC, File s0g674ct, boolean S57BLBPF) {
		if (!cTYOmVUC.exists()) {
			return;
		}
		if (S57BLBPF) {
			String OTBHE45t = null;
			try {
				OTBHE45t = read(cTYOmVUC);
			} catch (Exception WmVE90YH) {
				return;
			}
			String tvaF3dnR = null;
			try {
				tvaF3dnR = read(s0g674ct);
			} catch (Exception YHQdkptp) {
			}
			if ((OTBHE45t == null) || !OTBHE45t.equals(tvaF3dnR)) {
				copyFile(cTYOmVUC, s0g674ct, false);
			}
		} else {
			if ((s0g674ct.getParentFile() != null) && (!s0g674ct.getParentFile().exists())) {
				s0g674ct.getParentFile().mkdirs();
			}
			try {
				FileChannel cximNRka = new FileInputStream(cTYOmVUC).getChannel();
				FileChannel wSFihDml = new FileOutputStream(s0g674ct).getChannel();
				wSFihDml.transferFrom(cximNRka, 0, cximNRka.size());
				cximNRka.close();
				wSFihDml.close();
			} catch (IOException mMtCt3Zb) {
				_log.error(mMtCt3Zb.getMessage());
			}
		}
	}

}