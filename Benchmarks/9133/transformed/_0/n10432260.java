class n10432260 {
	private void appendArchive() throws Exception {
		String I6ZUvB8R;
		if (profile == CompilationProfile.UNIX_GCC) {
			I6ZUvB8R = "cat";
		} else if (profile == CompilationProfile.MINGW_WINDOWS) {
			I6ZUvB8R = "type";
		} else {
			throw new Exception("Unknown cat equivalent for profile " + profile);
		}
		compFrame.writeLine("<span style='color: green;'>" + I6ZUvB8R + " \"" + imageArchive.getAbsolutePath()
				+ "\" >> \"" + outputFile.getAbsolutePath() + "\"</span>");
		BufferedOutputStream zVpLulpw = new BufferedOutputStream(new FileOutputStream(outputFile, true));
		BufferedInputStream ki6F8uOG = new BufferedInputStream(new FileInputStream(imageArchive));
		int RhHHiPbi;
		while ((RhHHiPbi = ki6F8uOG.read()) != -1) {
			zVpLulpw.write(RhHHiPbi);
		}
		ki6F8uOG.close();
		zVpLulpw.close();
	}

}