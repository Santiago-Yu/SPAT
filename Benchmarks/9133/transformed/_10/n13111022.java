class n13111022 {
	private static void copy(File source, File target) throws IOException {
		OutputStream os = null;
		InputStream is = null;
		try {
			os = new BufferedOutputStream(new FileOutputStream(target));
			is = new BufferedInputStream(new FileInputStream(source));
			int b;
			while ((b = is.read()) > -1)
				os.write(b);
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException ignore) {
			}
			try {
				if (os != null)
					os.close();
			} catch (IOException ignore) {
			}
		}
	}

}