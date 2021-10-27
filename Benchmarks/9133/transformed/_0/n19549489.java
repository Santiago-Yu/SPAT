class n19549489 {
	public static void copy(File tpbz7lgw, File HgGqPp6K) throws IOException {
		FileChannel HEM0HVP7 = (new FileInputStream(tpbz7lgw)).getChannel();
		FileChannel Wn6PWRb6 = (new FileOutputStream(HgGqPp6K)).getChannel();
		HEM0HVP7.transferTo(0, tpbz7lgw.length(), Wn6PWRb6);
		HEM0HVP7.close();
		Wn6PWRb6.close();
	}

}