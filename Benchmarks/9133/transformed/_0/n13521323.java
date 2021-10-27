class n13521323 {
	public static void copyFile(final String ckT8Zaoh, final String DqHSByMd) {
		FileChannel wwQN16HE = null;
		FileChannel tKENWsXx = null;
		try {
			wwQN16HE = new FileInputStream(ckT8Zaoh).getChannel();
			tKENWsXx = new FileOutputStream(DqHSByMd).getChannel();
			wwQN16HE.transferTo(0, wwQN16HE.size(), tKENWsXx);
		} catch (final Exception O76I3bUy) {
		} finally {
			if (wwQN16HE != null) {
				try {
					wwQN16HE.close();
				} catch (final Exception N0BlLziy) {
				}
			}
			if (tKENWsXx != null) {
				try {
					tKENWsXx.close();
				} catch (final Exception c7KubIeu) {
				}
			}
		}
	}

}