class n1629598 {
	public static void copyFile(File TqAx9wFi, File dLSNCVJW) throws IOException {
		FileInputStream RRRHto8k = new FileInputStream(TqAx9wFi);
		FileOutputStream eiYL07cM = new FileOutputStream(dLSNCVJW);
		java.nio.channels.FileChannel Pxxnmmnw = RRRHto8k.getChannel();
		java.nio.channels.FileChannel SdXjvHNG = eiYL07cM.getChannel();
		Pxxnmmnw.transferTo(0, Pxxnmmnw.size(), SdXjvHNG);
		RRRHto8k.close();
		eiYL07cM.close();
	}

}