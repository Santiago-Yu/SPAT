class n3672328 {
	public static void copy(String SpGMoyq2, String fBigWHTf) throws IOException {
		FileChannel kP0BCXUk = new FileInputStream(SpGMoyq2).getChannel();
		FileChannel Ww6PMoKN = new FileOutputStream(fBigWHTf).getChannel();
		Ww6PMoKN.transferFrom(kP0BCXUk, 0, kP0BCXUk.size());
		kP0BCXUk.close();
		Ww6PMoKN.close();
	}

}