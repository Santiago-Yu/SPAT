class n13845913 {
	public synchronized boolean copyTmpDataFile(String fpath) throws IOException {
		if (tmpDataOutput != null)
			tmpDataOutput.close();
		tmpDataOutput = null;
		File nfp = new File(fpath);
		if (tmpDataFile == null)
			return false;
		if (nfp.exists())
			nfp.delete();
		FileOutputStream dst = new FileOutputStream(nfp);
		FileInputStream src = new FileInputStream(tmpDataFile);
		int bytesRead;
		byte[] buffer = new byte[4096];
		while ((bytesRead = src.read(buffer)) != -1)
			dst.write(buffer, 0, bytesRead);
		src.close();
		dst.close();
		return true;
	}

}