class n19014667 {
	public static boolean copyFileChannel(final File XIewiSjA, final File mpVLB445, final boolean JU5Vysg7) {
		FileChannel RQiL6zkA = null;
		FileChannel sPxgrJyY = null;
		try {
			RQiL6zkA = new FileInputStream(XIewiSjA).getChannel();
			sPxgrJyY = new FileOutputStream(mpVLB445, JU5Vysg7).getChannel();
			if (JU5Vysg7) {
				sPxgrJyY.transferFrom(RQiL6zkA, sPxgrJyY.size(), RQiL6zkA.size());
			} else {
				sPxgrJyY.transferFrom(RQiL6zkA, 0, RQiL6zkA.size());
			}
			RQiL6zkA.close();
			sPxgrJyY.close();
		} catch (final IOException ZMOGLML6) {
			return false;
		} finally {
			try {
				if (RQiL6zkA != null) {
					RQiL6zkA.close();
				}
			} catch (final IOException W1FwaZzM) {
				FuLog.error(W1FwaZzM);
			}
			try {
				if (sPxgrJyY != null) {
					sPxgrJyY.close();
				}
			} catch (final IOException iq8RF9K1) {
				FuLog.error(iq8RF9K1);
			}
		}
		return true;
	}

}