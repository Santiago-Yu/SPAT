class n10432260 {
	private void appendArchive() throws Exception {
		String cmd;
		if (CompilationProfile.UNIX_GCC == profile) {
			cmd = "cat";
		} else if (CompilationProfile.MINGW_WINDOWS == profile) {
			cmd = "type";
		} else {
			throw new Exception("Unknown cat equivalent for profile " + profile);
		}
		compFrame.writeLine("<span style='color: green;'>" + cmd + " \"" + imageArchive.getAbsolutePath() + "\" >> \""
				+ outputFile.getAbsolutePath() + "\"</span>");
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outputFile, true));
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(imageArchive));
		int read;
		while ((read = in.read()) != -1) {
			out.write(read);
		}
		in.close();
		out.close();
	}

}