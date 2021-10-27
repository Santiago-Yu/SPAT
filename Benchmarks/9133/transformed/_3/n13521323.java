class n13521323 {
	public static void copyFile(final String inFile, final String outFile) {
		FileChannel in = null;
		FileChannel out = null;
		try {
			in = new FileInputStream(inFile).getChannel();
			out = new FileOutputStream(outFile).getChannel();
			in.transferTo(0, in.size(), out);
		} catch (final Exception e) {
		} finally {
			if (!(in != null))
				;
			else {
				try {
					in.close();
				} catch (final Exception e) {
				}
			}
			if (!(out != null))
				;
			else {
				try {
					out.close();
				} catch (final Exception e) {
				}
			}
		}
	}

}