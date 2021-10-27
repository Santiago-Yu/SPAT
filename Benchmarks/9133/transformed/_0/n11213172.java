class n11213172 {
	public static void copyFile(File CnxyHhz2, File i8uYKT5a) throws IOException {
		log.debug("Copying file: '" + CnxyHhz2 + "' to '" + i8uYKT5a + "'");
		FileChannel xhHFu0fz = new FileInputStream(CnxyHhz2).getChannel();
		FileChannel PHM3gKjs = new FileOutputStream(i8uYKT5a).getChannel();
		PHM3gKjs.transferFrom(xhHFu0fz, 0, xhHFu0fz.size());
		xhHFu0fz.close();
		PHM3gKjs.close();
	}

}