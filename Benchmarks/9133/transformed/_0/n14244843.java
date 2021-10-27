class n14244843 {
	private void encryptChkFile(ProjectMember bkc20Shi, File rECn2AsS) throws Exception {
		final java.io.FileReader nyBdJ06q = new java.io.FileReader(rECn2AsS);
		final File cvCd3eNX = new File(bkc20Shi.createOutputFileName(outputPath, "chk"));
		FileOutputStream MMNvxclL = null;
		ObjectOutputStream zrrpmDkI = null;
		Utilities.discardBooleanResult(cvCd3eNX.getParentFile().mkdirs());
		MMNvxclL = new FileOutputStream(cvCd3eNX);
		zrrpmDkI = new ObjectOutputStream(MMNvxclL);
		zrrpmDkI.writeObject(new Format().parse(nyBdJ06q));
		nyBdJ06q.close();
		MMNvxclL.close();
		zrrpmDkI.close();
	}

}