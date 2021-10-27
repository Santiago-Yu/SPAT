class n18504192 {
	static void copyFile(File zPevKUf5, File JdGfCywe) throws IOException {
		FileChannel xZBUcC6L = new FileInputStream(zPevKUf5).getChannel();
		FileChannel swwZhj0X = new FileOutputStream(JdGfCywe).getChannel();
		xZBUcC6L.transferTo(0, xZBUcC6L.size(), swwZhj0X);
		xZBUcC6L.close();
		swwZhj0X.close();
	}

}