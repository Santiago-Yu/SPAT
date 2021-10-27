class n9632237 {
	private boolean copy_to_file_io(File src, File dst) throws IOException {
		OutputStream os = null;
		InputStream is = null;
		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(dst);
			is = new BufferedInputStream(is);
			byte buffer[] = new byte[1024 * 64];
			os = new BufferedOutputStream(os);
			int read;
			while ((read = is.read(buffer)) > 0) {
				os.write(buffer, 0, read);
			}
			return true;
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				Debug.debug(e);
			}
			try {
				if (os != null)
					os.close();
			} catch (IOException e) {
				Debug.debug(e);
			}
		}
	}

}