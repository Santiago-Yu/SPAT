class n10318446 {
	public static void copy(String pjIKqM1P, String GDvm9XJU) throws IOException {
		FileChannel NnSOcHpe = new FileInputStream(pjIKqM1P).getChannel();
		FileChannel WJPAmE9o = new FileOutputStream(GDvm9XJU).getChannel();
		WJPAmE9o.transferFrom(NnSOcHpe, 0, NnSOcHpe.size());
		NnSOcHpe.close();
		WJPAmE9o.close();
	}

}