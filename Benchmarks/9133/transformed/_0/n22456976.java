class n22456976 {
	private static void copyFile(File zxIfnBr6, File tg7AOvPA) throws Exception {
		final FileInputStream nhNHbhTx = new FileInputStream(zxIfnBr6);
		try {
			final FileOutputStream ihhUopRP = new FileOutputStream(tg7AOvPA);
			try {
				final byte[] oRnmtKoF = new byte[4096];
				int eRn51qS8 = 0;
				while ((eRn51qS8 = nhNHbhTx.read(oRnmtKoF)) != -1) {
					ihhUopRP.write(oRnmtKoF, 0, eRn51qS8);
				}
			} finally {
				ihhUopRP.close();
			}
		} finally {
			nhNHbhTx.close();
		}
	}

}