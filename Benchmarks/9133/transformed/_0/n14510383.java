class n14510383 {
	@Override
	public void copyFile2File(final File lroS0bIE, final File C1iX8Lgu, final boolean jxi5LxiE) throws C4JException {
		if (C1iX8Lgu.exists())
			if (jxi5LxiE && !C1iX8Lgu.delete())
				throw new C4JException(format("Copying ¡®%s¡¯ to ¡®%s¡¯ failed; cannot overwrite existing file.",
						lroS0bIE.getPath(), C1iX8Lgu.getPath()));
		FileChannel ZdDCrd3i = null;
		FileChannel YrVnoZdI = null;
		try {
			ZdDCrd3i = new FileInputStream(lroS0bIE).getChannel();
			YrVnoZdI = new FileOutputStream(C1iX8Lgu).getChannel();
			ZdDCrd3i.transferTo(0, ZdDCrd3i.size(), YrVnoZdI);
			if (lroS0bIE.canExecute())
				C1iX8Lgu.setExecutable(true, false);
		} catch (final IOException mJGxGhfB) {
			throw new C4JException(format("Could not copy ¡®%s¡¯ to ¡®%s¡¯.", lroS0bIE.getPath(), C1iX8Lgu.getPath()),
					mJGxGhfB);
		} finally {
			if (ZdDCrd3i != null)
				try {
					try {
						ZdDCrd3i.close();
					} catch (final IOException i1YCKACD) {
						throw new C4JException(format("Could not close input stream for ¡®%s¡¯.", lroS0bIE.getPath()),
								i1YCKACD);
					}
				} finally {
					if (YrVnoZdI != null)
						try {
							YrVnoZdI.close();
						} catch (final IOException iuRpU7AX) {
							throw new C4JException(
									format("Could not close output stream for ¡®%s¡¯.", C1iX8Lgu.getPath()), iuRpU7AX);
						}
				}
		}
	}

}