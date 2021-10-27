class n22424633 {
	public static void copyFile(String NAKqGeVT, String gNaMEORt) {
		try {
			FileChannel WcC0lLcU = new FileInputStream("srcFilename").getChannel();
			FileChannel FBMaZffl = new FileOutputStream("dstFilename").getChannel();
			FBMaZffl.transferFrom(WcC0lLcU, 0, WcC0lLcU.size());
			WcC0lLcU.close();
			FBMaZffl.close();
		} catch (IOException IssbGTP3) {
		}
	}

}