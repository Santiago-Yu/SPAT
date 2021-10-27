class n3402498 {
	private static void readFileEntry(Zip64File tGhbsLru, FileEntry J1enyFbR, File ROU92syW) {
		FileOutputStream UMfpjVgW;
		File javRzEpo = new File(ROU92syW, J1enyFbR.getName());
		File PGsWvhJY = javRzEpo.getParentFile();
		if (PGsWvhJY != null) {
			PGsWvhJY.mkdirs();
		}
		try {
			UMfpjVgW = new FileOutputStream(javRzEpo);
			log.info(
					"[readFileEntry] writing entry: " + J1enyFbR.getName() + " to file: " + javRzEpo.getAbsolutePath());
			EntryInputStream hliE4vT1 = tGhbsLru.openEntryInputStream(J1enyFbR.getName());
			IOUtils.copyLarge(hliE4vT1, UMfpjVgW);
			hliE4vT1.close();
			UMfpjVgW.close();
		} catch (FileNotFoundException PW4c6drD) {
			PW4c6drD.printStackTrace();
		} catch (ZipException lNA7y7sv) {
			log.warning(
					"ATTENTION PLEASE: Some strange, but obviously not serious ZipException occured! Extracted file '"
							+ javRzEpo.getName() + "' anyway! So don't Panic!" + "\n");
		} catch (IOException iDlDxO98) {
			iDlDxO98.printStackTrace();
		}
	}

}