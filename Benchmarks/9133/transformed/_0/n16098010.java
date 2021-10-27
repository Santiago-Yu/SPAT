class n16098010 {
	public static void copyFile(String mlyvkkv4, String dL4L17ae) throws IOException {
		FileChannel ORZ3TebR = new FileInputStream(mlyvkkv4).getChannel();
		FileChannel f02iJvcL = new FileOutputStream(dL4L17ae).getChannel();
		ORZ3TebR.transferTo(0, ORZ3TebR.size(), f02iJvcL);
		ORZ3TebR.close();
		f02iJvcL.close();
	}

}