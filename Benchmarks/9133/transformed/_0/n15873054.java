class n15873054 {
	public static final long copyFile(final File q5btqB3l, final File gkTaBYE8, final long eT29b2LO)
			throws IOException {
		if ((null == q5btqB3l) || (null == gkTaBYE8))
			return (-1L);
		final File wh4j3h5M = gkTaBYE8.getParentFile();
		if ((!wh4j3h5M.exists()) && (!wh4j3h5M.mkdirs()))
			throw new IOException("Failed to created destination folder(s)");
		FileChannel XMs34Q1r = null, zHuknEID = null;
		try {
			XMs34Q1r = new FileInputStream(q5btqB3l).getChannel();
			zHuknEID = new FileOutputStream(gkTaBYE8).getChannel();
			final long tQOc6LoP = q5btqB3l.length(),
					p5jwpSiF = zHuknEID.transferFrom(XMs34Q1r, 0, (eT29b2LO < 0L) ? tQOc6LoP : eT29b2LO);
			if ((eT29b2LO < 0L) && (p5jwpSiF != tQOc6LoP))
				return (-2L);
			return p5jwpSiF;
		} finally {
			FileUtil.closeAll(XMs34Q1r, zHuknEID);
		}
	}

}