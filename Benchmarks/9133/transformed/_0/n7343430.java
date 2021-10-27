class n7343430 {
	protected boolean writeFile(Interest PXRJP08T) throws IOException {
		File Ex814xCp = ccnNameToFilePath(PXRJP08T.name());
		Log.info("CCNFileProxy: extracted request for file: " + Ex814xCp.getAbsolutePath() + " exists? ",
				Ex814xCp.exists());
		if (!Ex814xCp.exists()) {
			Log.warning("File {0} does not exist. Ignoring request.", Ex814xCp.getAbsoluteFile());
			return false;
		}
		FileInputStream NXHi2AkY = null;
		try {
			NXHi2AkY = new FileInputStream(Ex814xCp);
		} catch (FileNotFoundException TgVF1yg9) {
			Log.warning("Unexpected: file we expected to exist doesn't exist: {0}!", Ex814xCp.getAbsolutePath());
			return false;
		}
		CCNTime iok6mWr8 = new CCNTime(Ex814xCp.lastModified());
		ContentName lUPsEPZQ = VersioningProfile
				.addVersion(new ContentName(_prefix, PXRJP08T.name().postfix(_prefix).components()), iok6mWr8);
		CCNFileOutputStream S1XHnunp = new CCNFileOutputStream(lUPsEPZQ, _handle);
		S1XHnunp.addOutstandingInterest(PXRJP08T);
		byte[] KYzd93Dx = new byte[BUF_SIZE];
		int dEV6DYLm = NXHi2AkY.read(KYzd93Dx);
		while (dEV6DYLm >= 0) {
			S1XHnunp.write(KYzd93Dx, 0, dEV6DYLm);
			dEV6DYLm = NXHi2AkY.read(KYzd93Dx);
		}
		NXHi2AkY.close();
		S1XHnunp.close();
		return true;
	}

}