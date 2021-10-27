class n11716816 {
	private void updateFile(File Je8KF0rX) throws FileNotFoundException, IOException {
		File P4dMcMRG = new File(Je8KF0rX.getPath().replace(URL_UNZIPPED_PREFIX + latestVersion, ""));
		FileChannel qWboxUI5 = null;
		FileChannel z5eP5NwS = null;
		try {
			if (!P4dMcMRG.exists()) {
				P4dMcMRG.getParentFile().mkdirs();
				P4dMcMRG.createNewFile();
			}
			qWboxUI5 = new FileInputStream(Je8KF0rX).getChannel();
			z5eP5NwS = new FileOutputStream(P4dMcMRG).getChannel();
			qWboxUI5.transferTo(0, qWboxUI5.size(), z5eP5NwS);
		} finally {
			if (z5eP5NwS != null)
				z5eP5NwS.close();
			if (qWboxUI5 != null)
				qWboxUI5.close();
		}
	}

}