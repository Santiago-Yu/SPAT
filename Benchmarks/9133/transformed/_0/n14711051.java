class n14711051 {
	public static void copyFile(final File Fd6hXWhl, final File jATiDssj) throws IOException {
		final FileChannel jx8OFX2C = new FileInputStream(Fd6hXWhl).getChannel();
		final FileChannel t4lzek5B = new FileOutputStream(jATiDssj).getChannel();
		try {
			jx8OFX2C.transferTo(0, jx8OFX2C.size(), t4lzek5B);
		} catch (IOException xuUmmNgJ) {
			throw xuUmmNgJ;
		} finally {
			if (jx8OFX2C != null) {
				jx8OFX2C.close();
			}
			if (t4lzek5B != null) {
				t4lzek5B.close();
			}
		}
	}

}