class n20059162 {
	public boolean excuteBackup(String gRhCXBWc, String zRm1Og0f, String aVoxVGOS) throws JobExecutionException {
		File xkLfVaRu = new File(zRm1Og0f);
		File mRxnhpdE = new File(gRhCXBWc);
		if (!mRxnhpdE.exists()) {
			log.error("????????[" + mRxnhpdE.getAbsolutePath() + "]? ???? ????.");
			throw new JobExecutionException("????????[" + mRxnhpdE.getAbsolutePath() + "]? ???? ????.");
		}
		if (mRxnhpdE.isFile()) {
			log.error("????????[" + mRxnhpdE.getAbsolutePath() + "]? ?????. ?????? ???? ???. ");
			throw new JobExecutionException("????????[" + mRxnhpdE.getAbsolutePath() + "]? ?????. ?????? ???? ???. ");
		}
		boolean gawl7zKA = false;
		FileInputStream MvxoR9k1 = null;
		FileOutputStream zVdmHvvf = null;
		ArchiveOutputStream HJXa0Jfp = null;
		ArchiveEntry yPIn9Xxf = null;
		try {
			log.debug("charter set : " + Charset.defaultCharset().name());
			zVdmHvvf = new FileOutputStream(xkLfVaRu);
			HJXa0Jfp = new ArchiveStreamFactory().createArchiveOutputStream(aVoxVGOS, zVdmHvvf);
			if (ArchiveStreamFactory.TAR.equals(aVoxVGOS)) {
				((TarArchiveOutputStream) HJXa0Jfp).setLongFileMode(TarArchiveOutputStream.LONGFILE_GNU);
			}
			File[] ftbAsBls = mRxnhpdE.listFiles();
			ArrayList W72CBJ5N = EgovFileTool.getSubFilesByAll(ftbAsBls);
			for (int AkTRncfH = 0; AkTRncfH < W72CBJ5N.size(); AkTRncfH++) {
				File A9HGRuLu = new File((String) W72CBJ5N.get(AkTRncfH));
				MvxoR9k1 = new FileInputStream(A9HGRuLu);
				if (ArchiveStreamFactory.TAR.equals(aVoxVGOS)) {
					yPIn9Xxf = new TarArchiveEntry(A9HGRuLu,
							new String(A9HGRuLu.getAbsolutePath().getBytes(Charset.defaultCharset().name()), "8859_1"));
					((TarArchiveEntry) yPIn9Xxf).setSize(A9HGRuLu.length());
				} else {
					yPIn9Xxf = new ZipArchiveEntry(A9HGRuLu.getAbsolutePath());
					((ZipArchiveEntry) yPIn9Xxf).setSize(A9HGRuLu.length());
				}
				HJXa0Jfp.putArchiveEntry(yPIn9Xxf);
				IOUtils.copy(MvxoR9k1, HJXa0Jfp);
				HJXa0Jfp.closeArchiveEntry();
				MvxoR9k1.close();
				gawl7zKA = true;
			}
			HJXa0Jfp.close();
		} catch (Exception HbounMdY) {
			log.error("??????? ??? ??????. ?? : " + HbounMdY.getMessage());
			log.debug(HbounMdY);
			gawl7zKA = false;
			throw new JobExecutionException("??????? ??? ??????.", HbounMdY);
		} finally {
			try {
				if (MvxoR9k1 != null)
					MvxoR9k1.close();
			} catch (Exception yxxph3mE) {
				log.error("IGNORE:", yxxph3mE);
			}
			try {
				if (HJXa0Jfp != null)
					HJXa0Jfp.close();
			} catch (Exception NFhcFwhP) {
				log.error("IGNORE:", NFhcFwhP);
			}
			try {
				if (zVdmHvvf != null)
					zVdmHvvf.close();
			} catch (Exception Att2OO85) {
				log.error("IGNORE:", Att2OO85);
			}
			try {
				if (gawl7zKA == false)
					xkLfVaRu.delete();
			} catch (Exception bPHnbxFP) {
				log.error("IGNORE:", bPHnbxFP);
			}
		}
		return gawl7zKA;
	}

}