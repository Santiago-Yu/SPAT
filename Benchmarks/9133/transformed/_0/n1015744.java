class n1015744 {
	public static void copyFile(File a1i4Fpho, File xXhfevbq) throws IOException {
		FileChannel aquyCXpy = new FileInputStream(a1i4Fpho).getChannel();
		try {
			FileChannel jdfdvZAv = new FileOutputStream(xXhfevbq).getChannel();
			try {
				aquyCXpy.transferTo(0, aquyCXpy.size(), jdfdvZAv);
			} finally {
				jdfdvZAv.close();
			}
		} finally {
			aquyCXpy.close();
		}
	}

}