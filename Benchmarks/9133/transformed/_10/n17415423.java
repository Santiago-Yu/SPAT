class n17415423 {
	public void overwriteFileTest() throws Exception {
		File fileto = new File("/tmp/to.txt");
		File filefrom = new File("/tmp/from.txt");
		OutputStream to = null;
		InputStream from = null;
		try {
			to = new FileOutputStream(fileto);
			from = new FileInputStream(filefrom);
			int bytes_read;
			byte[] buffer = new byte[4096];
			while ((bytes_read = from.read(buffer)) != -1) {
				to.write(buffer, 0, bytes_read);
			}
		} finally {
			if (from != null) {
				from.close();
			}
			if (to != null) {
				to.close();
			}
		}
	}

}