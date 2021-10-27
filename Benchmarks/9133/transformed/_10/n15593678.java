class n15593678 {
	private static void copyFile(File in, File out) throws Exception {
		final FileInputStream input = new FileInputStream(in);
		try {
			final FileOutputStream output = new FileOutputStream(out);
			try {
				int readBytes = 0;
				final byte[] buf = new byte[4096];
				while ((readBytes = input.read(buf)) != -1) {
					output.write(buf, 0, readBytes);
				}
			} finally {
				output.close();
			}
		} finally {
			input.close();
		}
	}

}