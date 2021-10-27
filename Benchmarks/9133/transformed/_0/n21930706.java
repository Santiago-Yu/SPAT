class n21930706 {
	public static void copyFile(File FBf5QxG6, File vPOOaD9F) throws Exception {
		if (!FBf5QxG6.exists())
			return;
		FileInputStream lPgBGG1e = new FileInputStream(FBf5QxG6);
		FileOutputStream EMAgS79Q = new FileOutputStream(vPOOaD9F);
		byte[] V9JheklR = new byte[BUFFER_SIZE];
		int EL8CELfq;
		while (true) {
			EL8CELfq = lPgBGG1e.read(V9JheklR);
			if (EL8CELfq == -1)
				break;
			EMAgS79Q.write(V9JheklR, 0, EL8CELfq);
		}
		EMAgS79Q.flush();
		EMAgS79Q.close();
		lPgBGG1e.close();
	}

}