class n17371628 {
	public static void copyFile(final File ATCZpFvM, final File LCUPM7Jm) throws IOException {
		final FileChannel mT5InxyX = new FileInputStream(ATCZpFvM).getChannel();
		final FileChannel hR9DISYS = new FileOutputStream(LCUPM7Jm).getChannel();
		try {
			mT5InxyX.transferTo(0, mT5InxyX.size(), hR9DISYS);
		} catch (final IOException WLJobdUX) {
			throw WLJobdUX;
		} finally {
			if (mT5InxyX != null) {
				mT5InxyX.close();
			}
			if (hR9DISYS != null) {
				hR9DISYS.close();
			}
		}
	}

}