class n5659863 {
	public static FileChannel newFileChannel(File file, String rw, boolean enableException) throws IOException {
		if (file == null)
			return null;
		if (rw == null || rw.length() == 0) {
			return null;
		}
		rw = rw.toLowerCase();
		if ((MODE_READ != null && MODE_READ.equals(rw))) {
			if (FileUtil.exists(file, enableException)) {
				FileInputStream fis = new FileInputStream(file);
				FileChannel ch = fis.getChannel();
				setObjectMap(ch.hashCode(), fis, FIS);
				return ch;
			}
		} else if ((MODE_WRITE != null && MODE_WRITE.equals(rw))) {
			FileOutputStream fos = new FileOutputStream(file);
			FileChannel ch = fos.getChannel();
			setObjectMap(ch.hashCode(), fos, FOS_W);
			return ch;
		} else if ((MODE_APPEND != null && MODE_APPEND.equals(rw))) {
			if (FileUtil.exists(file, enableException)) {
				RandomAccessFile raf = new RandomAccessFile(file, "rw");
				FileChannel ch = raf.getChannel();
				ch.position(ch.size());
				setObjectMap(ch.hashCode(), raf, FOS_A);
				return ch;
			}
		} else if ((MODE_READ_WRITE != null && MODE_READ_WRITE.equals(rw))) {
			if (FileUtil.exists(file, enableException)) {
				RandomAccessFile raf = new RandomAccessFile(file, rw);
				FileChannel ch = raf.getChannel();
				setObjectMap(ch.hashCode(), raf, RAF);
				return ch;
			}
		} else {
			throw new IllegalArgumentException("Illegal read/write type : [" + rw + "]\n"
					+ "You can use following types for: \n" + "  (1) Read Only  = \"r\"\n"
					+ "  (2) Write Only = \"w\"\n" + "  (3) Read/Write = \"rw\"\n" + "  (4) Append     = \"a\"");
		}
		return null;
	}

}