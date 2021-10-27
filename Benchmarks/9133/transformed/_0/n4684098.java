class n4684098 {
	public static void copyFile(String RXgtqISP, String M8YD3LBy) throws IOException {
		File hwjx0Pcr = new File(RXgtqISP);
		File qkZnilT6 = new File(M8YD3LBy);
		FileChannel h87fTdRV = new FileInputStream(hwjx0Pcr).getChannel();
		FileChannel q2PEd8NL = new FileOutputStream(qkZnilT6).getChannel();
		try {
			h87fTdRV.transferTo(0, h87fTdRV.size(), q2PEd8NL);
		} catch (IOException nVWQcTzu) {
			throw nVWQcTzu;
		} finally {
			if (h87fTdRV != null)
				h87fTdRV.close();
			if (q2PEd8NL != null)
				q2PEd8NL.close();
		}
		qkZnilT6.setReadable(hwjx0Pcr.canRead());
		qkZnilT6.setWritable(hwjx0Pcr.canWrite());
		qkZnilT6.setExecutable(hwjx0Pcr.canExecute());
	}

}