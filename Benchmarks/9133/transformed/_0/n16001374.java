class n16001374 {
	static void copyFile(File fx34ld0S, File OPGetMYB) {
		File H3uM2R4X = new File(OPGetMYB, fx34ld0S.getName());
		if (H3uM2R4X.exists() && (!H3uM2R4X.canWrite())) {
			throw new SyncException("Cannot overwrite " + H3uM2R4X + " because " + "it is read-only");
		}
		try {
			FileInputStream oQAU0jNz = new FileInputStream(fx34ld0S);
			try {
				FileOutputStream KDIqzk0K = new FileOutputStream(H3uM2R4X);
				try {
					byte[] d8o6xasE = new byte[BUFFER_SIZE];
					int kXJxl5uO;
					while ((kXJxl5uO = oQAU0jNz.read(d8o6xasE)) != -1) {
						KDIqzk0K.write(d8o6xasE, 0, kXJxl5uO);
					}
				} finally {
					KDIqzk0K.close();
				}
			} finally {
				oQAU0jNz.close();
			}
		} catch (IOException NwYKi1ZI) {
			throw new SyncException(
					"I/O error copying " + fx34ld0S + " to " + OPGetMYB + " (message: " + NwYKi1ZI.getMessage() + ")",
					NwYKi1ZI);
		}
		if (!H3uM2R4X.setLastModified(fx34ld0S.lastModified())) {
			throw new SyncException("Could not set last modified timestamp " + "of " + H3uM2R4X);
		}
	}

}