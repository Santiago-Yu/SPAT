class n21369761 {
	protected void copyFile(final File MBkQfhHK, final File fOhiIQVg) throws IOException {
		final FileChannel w9c2eBcT = new FileInputStream(MBkQfhHK).getChannel();
		final FileChannel CIplCmk5 = new FileOutputStream(fOhiIQVg).getChannel();
		try {
			w9c2eBcT.transferTo(0, w9c2eBcT.size(), CIplCmk5);
		} catch (final IOException eMvQPjq4) {
			throw eMvQPjq4;
		} finally {
			if (w9c2eBcT != null) {
				w9c2eBcT.close();
			}
			if (CIplCmk5 != null) {
				CIplCmk5.close();
			}
		}
	}

}