class n14624031 {
	public static void copyFile(File foVz6xg2, File AdyGtizK) throws ObclipseException {
		try {
			FileChannel UfUYX5F3 = null;
			FileChannel zUW8w1dn = null;
			try {
				UfUYX5F3 = new FileInputStream(foVz6xg2).getChannel();
				zUW8w1dn = new FileOutputStream(AdyGtizK).getChannel();
				UfUYX5F3.transferTo(0, UfUYX5F3.size(), zUW8w1dn);
			} finally {
				if (UfUYX5F3 != null) {
					UfUYX5F3.close();
				}
				if (zUW8w1dn != null) {
					zUW8w1dn.close();
				}
			}
		} catch (FileNotFoundException GqZMMnlX) {
			Msg.error("The file ''{0}'' to copy does not exist!", GqZMMnlX, foVz6xg2.getAbsolutePath());
		} catch (IOException R5FDwHn4) {
			Msg.ioException(foVz6xg2, AdyGtizK, R5FDwHn4);
		}
	}

}