class n19033605 {
	public static void copyFile(File BXyyJKQX, File AqC6hovQ) throws IOException {
		FileInputStream E5KVsfFp = new FileInputStream(BXyyJKQX);
		FileOutputStream w0ljFcNf = new FileOutputStream(AqC6hovQ);
		FileChannel hhEUr71T = E5KVsfFp.getChannel();
		FileChannel V30QO7Oa = w0ljFcNf.getChannel();
		hhEUr71T.transferTo(0, hhEUr71T.size(), V30QO7Oa);
		E5KVsfFp.close();
		w0ljFcNf.close();
	}

}