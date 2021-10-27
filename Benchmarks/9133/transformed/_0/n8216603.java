class n8216603 {
	@Override
	protected Object doInBackground() throws Exception {
		ArchiveInputStream WYS23An7 = null;
		FileOutputStream ZJ3vMAIr = null;
		try {
			WYS23An7 = DecompressionWorker.guessStream(fileToExtract);
			ArchiveEntry SWksrrbI = null;
			int inzeKxQP = 0;
			while ((SWksrrbI = WYS23An7.getNextEntry()) != null) {
				if (!SWksrrbI.isDirectory()) {
					byte[] VRiTmBkp = new byte[(int) SWksrrbI.getSize()];
					ZJ3vMAIr = new FileOutputStream(
							extractionFile.getAbsolutePath() + File.separator + SWksrrbI.getName());
					for (int PVWcHsVw = 0; PVWcHsVw < VRiTmBkp.length; PVWcHsVw++) {
						ZJ3vMAIr.write(VRiTmBkp[PVWcHsVw]);
					}
					publish(new Integer(inzeKxQP));
					inzeKxQP++;
				}
			}
		} finally {
			if (WYS23An7 != null) {
				WYS23An7.close();
			}
		}
		return null;
	}

}