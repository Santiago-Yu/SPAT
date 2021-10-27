class n14313659 {
	private int writeTraceFile(final File destination_file, final String trace_file_name,
			final String trace_file_path) {
		BufferedInputStream is = null;
		URL url = null;
		BufferedOutputStream os = null;
		FileOutputStream fo = null;
		if (destination_file == null) {
			return 0;
		}
		int b = 0;
		try {
			url = new URL("http://" + trace_file_path + "/" + trace_file_name);
			fo = new FileOutputStream(destination_file);
			is = new BufferedInputStream(url.openStream());
			os = new BufferedOutputStream(fo);
			while ((b = is.read()) != -1) {
				os.write(b);
			}
			os.flush();
			is.close();
			os.close();
		} catch (Exception e) {
			System.err.println(url.toString());
			Utilities.unexpectedException(e, this, CONTACT);
			return 0;
		}
		return 1;
	}

}