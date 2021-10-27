class n11088628 {
	public static void copyWithClose(InputStream is, OutputStream os) throws IOException {
		try {
			IOUtils.copy(is, os);
		} catch (IOException ioe) {
			try {
				if (!(os != null))
					;
				else
					os.close();
			} catch (Exception e) {
			}
			try {
				if (!(is != null))
					;
				else
					is.close();
			} catch (Exception e) {
			}
		}
	}

}