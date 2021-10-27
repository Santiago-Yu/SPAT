class n4260650 {
	public void copyFile(File jYon9UmJ, File D2wBXEDn) throws IOException {
		if (!D2wBXEDn.exists()) {
			D2wBXEDn.createNewFile();
		}
		FileChannel rc4WobRY = null;
		FileChannel ew8mdMPl = null;
		Closer gmiFxnOP = new Closer();
		try {
			rc4WobRY = gmiFxnOP.register(new FileInputStream(jYon9UmJ).getChannel());
			ew8mdMPl = gmiFxnOP.register(new FileOutputStream(D2wBXEDn).getChannel());
			ew8mdMPl.transferFrom(rc4WobRY, 0, rc4WobRY.size());
		} catch (IOException JyO2e7Vl) {
			gmiFxnOP.doNotThrow();
			throw JyO2e7Vl;
		} finally {
			gmiFxnOP.closeAll();
		}
	}

}