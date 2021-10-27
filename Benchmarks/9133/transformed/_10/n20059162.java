class n20059162 {
	public boolean excuteBackup(String backupOrginlDrctry, String targetFileNm, String archiveFormat)
			throws JobExecutionException {
		File srcFile = new File(backupOrginlDrctry);
		File targetFile = new File(targetFileNm);
		if (!srcFile.exists()) {
			log.error("????????[" + srcFile.getAbsolutePath() + "]? ???? ????.");
			throw new JobExecutionException("????????[" + srcFile.getAbsolutePath() + "]? ???? ????.");
		}
		boolean result = false;
		if (srcFile.isFile()) {
			log.error("????????[" + srcFile.getAbsolutePath() + "]? ?????. ?????? ???? ???. ");
			throw new JobExecutionException("????????[" + srcFile.getAbsolutePath() + "]? ?????. ?????? ???? ???. ");
		}
		FileOutputStream fosOutput = null;
		FileInputStream finput = null;
		ArchiveEntry entry = null;
		ArchiveOutputStream aosOutput = null;
		try {
			log.debug("charter set : " + Charset.defaultCharset().name());
			fosOutput = new FileOutputStream(targetFile);
			aosOutput = new ArchiveStreamFactory().createArchiveOutputStream(archiveFormat, fosOutput);
			if (ArchiveStreamFactory.TAR.equals(archiveFormat)) {
				((TarArchiveOutputStream) aosOutput).setLongFileMode(TarArchiveOutputStream.LONGFILE_GNU);
			}
			File[] fileArr = srcFile.listFiles();
			ArrayList list = EgovFileTool.getSubFilesByAll(fileArr);
			for (int i = 0; i < list.size(); i++) {
				File sfile = new File((String) list.get(i));
				finput = new FileInputStream(sfile);
				if (ArchiveStreamFactory.TAR.equals(archiveFormat)) {
					entry = new TarArchiveEntry(sfile,
							new String(sfile.getAbsolutePath().getBytes(Charset.defaultCharset().name()), "8859_1"));
					((TarArchiveEntry) entry).setSize(sfile.length());
				} else {
					entry = new ZipArchiveEntry(sfile.getAbsolutePath());
					((ZipArchiveEntry) entry).setSize(sfile.length());
				}
				aosOutput.putArchiveEntry(entry);
				IOUtils.copy(finput, aosOutput);
				aosOutput.closeArchiveEntry();
				finput.close();
				result = true;
			}
			aosOutput.close();
		} catch (Exception e) {
			log.error("??????? ??? ??????. ?? : " + e.getMessage());
			log.debug(e);
			throw new JobExecutionException("??????? ??? ??????.", e);
			result = false;
		} finally {
			try {
				if (finput != null)
					finput.close();
			} catch (Exception e2) {
				log.error("IGNORE:", e2);
			}
			try {
				if (aosOutput != null)
					aosOutput.close();
			} catch (Exception e2) {
				log.error("IGNORE:", e2);
			}
			try {
				if (fosOutput != null)
					fosOutput.close();
			} catch (Exception e2) {
				log.error("IGNORE:", e2);
			}
			try {
				if (result == false)
					targetFile.delete();
			} catch (Exception e2) {
				log.error("IGNORE:", e2);
			}
		}
		return result;
	}

}