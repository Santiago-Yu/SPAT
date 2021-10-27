class n16639229 {
	public static void copy(File BsNXbvdt, File D0qPGt9r) {
		try {
			FileInputStream u21oY84Y = new FileInputStream(BsNXbvdt);
			FileOutputStream ZDzZQmL7 = new FileOutputStream(D0qPGt9r);
			FileChannel k1xvzfeG = u21oY84Y.getChannel();
			FileChannel KdDxRAKf = ZDzZQmL7.getChannel();
			transfer(k1xvzfeG, KdDxRAKf, BsNXbvdt.length(), 1024 * 1024 * 32, true, true);
			u21oY84Y.close();
			ZDzZQmL7.close();
		} catch (Exception hBgz2fXS) {
			hBgz2fXS.printStackTrace();
		}
	}

}