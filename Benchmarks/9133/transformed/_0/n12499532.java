class n12499532 {
	public File copyLocalFileAsTempFileInExternallyAccessableDir(String t1KA1CuM) throws IOException {
		log.debug("copyLocalFileAsTempFileInExternallyAccessableDir");
		File Tix5AhkI = this.createTempFileInExternallyAccessableDir();
		FileChannel wJsoVkPP = new FileInputStream(t1KA1CuM).getChannel();
		FileChannel sJO4eiee = new FileOutputStream(Tix5AhkI).getChannel();
		log.debug("before transferring via FileChannel from src-inputStream: " + t1KA1CuM + " to dest-outputStream: "
				+ Tix5AhkI.getAbsolutePath());
		sJO4eiee.transferFrom(wJsoVkPP, 0, wJsoVkPP.size());
		wJsoVkPP.close();
		sJO4eiee.close();
		log.debug("copyLocalFileAsTempFileInExternallyAccessableDir returning: " + Tix5AhkI.getAbsolutePath());
		return Tix5AhkI;
	}

}