class n8407905 {
	private void copyResources(File RZxrv9Op, String[] VYIReu4E, String sMyzbxMP)
			throws FileNotFoundException, IOException {
		for (int XrS7iXI6 = 0; XrS7iXI6 < VYIReu4E.length; XrS7iXI6++) {
			String CNsFGulr = sMyzbxMP + VYIReu4E[XrS7iXI6];
			InputStream VvFLXLDf = this.getClass().getResourceAsStream(CNsFGulr);
			if (VvFLXLDf == null)
				throw new IllegalArgumentException("cannot find resource '" + CNsFGulr + "'");
			File SWv9TePw = new File(RZxrv9Op, VYIReu4E[XrS7iXI6]);
			if (!SWv9TePw.exists() || SWv9TePw.length() == 0) {
				FileOutputStream OHKxDsgB = new FileOutputStream(SWv9TePw);
				try {
					IOUtils.copyStreams(VvFLXLDf, OHKxDsgB);
				} finally {
					OHKxDsgB.close();
				}
			}
		}
	}

}