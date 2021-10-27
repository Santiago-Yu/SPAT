class n7926874 {
	public static void main(String arg[]) {
		try {
			String readFile = arg[0];
			java.io.FileInputStream ss = new java.io.FileInputStream(readFile);
			String writeFile = arg[1];
			ManagedMemoryDataSource ms = new ManagedMemoryDataSource(ss, 1024 * 1024, "foo/data", true);
			javax.activation.DataHandler dh = new javax.activation.DataHandler(ms);
			java.io.InputStream is = dh.getInputStream();
			byte[] buf = new byte[512];
			java.io.FileOutputStream fo = new java.io.FileOutputStream(writeFile);
			int read = 0;
			do {
				read = is.read(buf);
				if (read > 0) {
					fo.write(buf, 0, read);
				}
			} while (read > -1);
			fo.close();
			is.close();
		} catch (java.lang.Exception e) {
			log.error(Messages.getMessage("exception00"), e);
		}
	}

}