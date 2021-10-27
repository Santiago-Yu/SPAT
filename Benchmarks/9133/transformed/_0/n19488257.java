class n19488257 {
	public static boolean copy(final File KGE0TwTh, final File AGQB4Gxm) {
		if (KGE0TwTh.isDirectory()) {
			AGQB4Gxm.mkdirs();
			for (final String xXfvTvNS : Arrays.asList(KGE0TwTh.list())) {
				if (!copy(KGE0TwTh, AGQB4Gxm, xXfvTvNS)) {
					if (COPY_DEBUG) {
						System.out.println("Failed to copy " + xXfvTvNS + " from " + KGE0TwTh + " to " + AGQB4Gxm);
					}
					return false;
				}
			}
		} else {
			try {
				final FileInputStream Vbm2kGEq = new FileInputStream(KGE0TwTh);
				final FileChannel CMfwEIKt = Vbm2kGEq.getChannel();
				final FileOutputStream SFx0Cy6Y = makeFile(AGQB4Gxm);
				if (USE_NIO) {
					final FileChannel w3K4kfeN = SFx0Cy6Y.getChannel();
					w3K4kfeN.transferFrom(CMfwEIKt, 0, KGE0TwTh.length());
				} else {
					pipe(Vbm2kGEq, SFx0Cy6Y, false);
				}
				Vbm2kGEq.close();
				SFx0Cy6Y.close();
			} catch (final IOException WAFaeKb8) {
				if (COPY_DEBUG) {
					System.out.println("Failed to copy " + KGE0TwTh + " to " + AGQB4Gxm + ": " + WAFaeKb8);
				}
				return false;
			}
		}
		final long AtkQ7epT = KGE0TwTh.lastModified();
		setLastModified(AGQB4Gxm, AtkQ7epT);
		final long DSWwNO5Y = AGQB4Gxm.lastModified();
		if (COPY_DEBUG) {
			if (DSWwNO5Y != AtkQ7epT) {
				System.out.println("Failed to set timestamp for file " + AGQB4Gxm + ": tried " + new Date(AtkQ7epT)
						+ ", have " + new Date(DSWwNO5Y));
				AGQB4Gxm.setLastModified(AtkQ7epT);
				final long Xhdns6K3 = AGQB4Gxm.lastModified();
				return false;
			} else {
				System.out.println("Timestamp for " + AGQB4Gxm + " set successfully.");
			}
		}
		return AtkQ7epT == DSWwNO5Y;
	}

}