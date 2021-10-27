class n12269678 {
	private void copyResource(String PDGbvUBv) {
		String RL8ifMao = layout.getRootDir().getName();
		String RJVyN4g4 = "/protoj/" + RL8ifMao + "/" + PDGbvUBv;
		InputStream h3e5DcJL = getClass().getResourceAsStream(RJVyN4g4);
		if (h3e5DcJL == null) {
			throw new RuntimeException("couldn't find resource " + RJVyN4g4);
		}
		File sM8kaj35 = new File(layout.getRootDir(), PDGbvUBv);
		sM8kaj35.getParentFile().mkdirs();
		sM8kaj35.createNewFile();
		InputStreamReader mKkIbDaq = new InputStreamReader(h3e5DcJL);
		try {
			FileOutputStream YTqcs2xK = new FileOutputStream(sM8kaj35);
			try {
				IOUtils.copy(mKkIbDaq, YTqcs2xK);
			} finally {
				IOUtils.closeQuietly(YTqcs2xK);
			}
		} finally {
			IOUtils.closeQuietly(mKkIbDaq);
		}
	}

}