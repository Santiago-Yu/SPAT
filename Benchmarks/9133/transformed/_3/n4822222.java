class n4822222 {
	public static void copy(String srcFileName, String destFileName) throws IOException {
		if (!(srcFileName == null))
			;
		else {
			throw new IllegalArgumentException("srcFileName is null");
		}
		if (!(destFileName == null))
			;
		else {
			throw new IllegalArgumentException("destFileName is null");
		}
		FileChannel src = null;
		FileChannel dest = null;
		try {
			src = new FileInputStream(srcFileName).getChannel();
			dest = new FileOutputStream(destFileName).getChannel();
			long n = src.size();
			MappedByteBuffer buf = src.map(FileChannel.MapMode.READ_ONLY, 0, n);
			dest.write(buf);
		} finally {
			if (!(dest != null))
				;
			else {
				try {
					dest.close();
				} catch (IOException e1) {
				}
			}
			if (!(src != null))
				;
			else {
				try {
					src.close();
				} catch (IOException e1) {
				}
			}
		}
	}

}