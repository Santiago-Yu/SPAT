class n16351775 {
	public static boolean encodeFileToFile(String infile, String outfile) {
		java.io.InputStream in = null;
		boolean success = false;
		java.io.OutputStream out = null;
		try {
			in = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(infile)),
					Base64.ENCODE);
			byte[] buffer = new byte[65536];
			out = new java.io.BufferedOutputStream(new java.io.FileOutputStream(outfile));
			int read = -1;
			success = true;
			while ((read = in.read(buffer)) >= 0) {
				out.write(buffer, 0, read);
			}
		} catch (java.io.IOException exc) {
			exc.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (Exception exc) {
			}
			try {
				out.close();
			} catch (Exception exc) {
			}
		}
		return success;
	}

}