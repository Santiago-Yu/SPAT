class n16944401 {
	public static void copyFile(File vulnWyLt, File cIQJxRuX) throws IOException {
		FileChannel uL1vTnFf = new FileInputStream(vulnWyLt).getChannel();
		FileChannel yejGodU5 = new FileOutputStream(cIQJxRuX).getChannel();
		try {
			uL1vTnFf.transferTo(0, uL1vTnFf.size(), yejGodU5);
		} finally {
			uL1vTnFf.close();
			yejGodU5.close();
		}
	}

}