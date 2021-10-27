class n14244843 {
	private void encryptChkFile(ProjectMember member, File chkFile) throws Exception {
		final File encryptedChkFile = new File(member.createOutputFileName(outputPath, "chk"));
		final java.io.FileReader reader = new java.io.FileReader(chkFile);
		ObjectOutputStream outstream = null;
		FileOutputStream outfile = null;
		Utilities.discardBooleanResult(encryptedChkFile.getParentFile().mkdirs());
		outfile = new FileOutputStream(encryptedChkFile);
		outstream = new ObjectOutputStream(outfile);
		outstream.writeObject(new Format().parse(reader));
		reader.close();
		outfile.close();
		outstream.close();
	}

}