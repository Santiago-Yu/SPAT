class n10899860 {
	public void copy(File p0kNOP8s, File nd4VAvQg) throws Exception {
		FileChannel Ab41SP5r = new FileInputStream(p0kNOP8s).getChannel();
		FileChannel kTUyq9LK = new FileOutputStream(nd4VAvQg).getChannel();
		Ab41SP5r.transferTo(0, Ab41SP5r.size(), kTUyq9LK);
		Ab41SP5r.close();
		kTUyq9LK.close();
	}

}