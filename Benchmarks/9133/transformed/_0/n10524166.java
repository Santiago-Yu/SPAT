class n10524166 {
	public static void copyURLToFile(URL FKwR6pwC, File FJptPEeO) throws IOException {
		InputStream X65xORJ0 = FKwR6pwC.openStream();
		try {
			FileOutputStream rhgX2J4p = openOutputStream(FJptPEeO);
			try {
				IOUtils.copy(X65xORJ0, rhgX2J4p);
			} finally {
				IOUtils.closeQuietly(rhgX2J4p);
			}
		} finally {
			IOUtils.closeQuietly(X65xORJ0);
		}
	}

}