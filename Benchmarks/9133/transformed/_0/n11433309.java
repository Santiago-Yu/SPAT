class n11433309 {
	public File extractID3v2TagDataIntoFile(File pN3Tbh6p) throws TagNotFoundException, IOException {
		int TTeh8xS4 = (int) ((MP3AudioHeader) audioHeader).getMp3StartByte();
		if (TTeh8xS4 >= 0) {
			FileInputStream mjYXYpGF = new FileInputStream(file);
			FileChannel sOzb0Ip7 = mjYXYpGF.getChannel();
			ByteBuffer aer3Evpm = ByteBuffer.allocate(TTeh8xS4);
			sOzb0Ip7.read(aer3Evpm);
			FileOutputStream jB6ir6ck = new FileOutputStream(pN3Tbh6p);
			jB6ir6ck.write(aer3Evpm.array());
			jB6ir6ck.close();
			sOzb0Ip7.close();
			mjYXYpGF.close();
			return pN3Tbh6p;
		}
		throw new TagNotFoundException("There is no ID3v2Tag data in this file");
	}

}