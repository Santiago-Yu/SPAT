class n3058819 {
	public static void decryptFile(String G3ukNldn, String wlcUp8lH, String M4mB6Bp8) throws Exception {
		CipherInputStream VrYg3WDY;
		OutputStream JfIxAK13;
		Cipher PhMwiM6D;
		SecretKey KC9OUp7T;
		byte[] xiuKv14P;
		PhMwiM6D = Cipher.getInstance("DES");
		KC9OUp7T = new SecretKeySpec(M4mB6Bp8.getBytes(), "DES");
		PhMwiM6D.init(Cipher.DECRYPT_MODE, KC9OUp7T);
		VrYg3WDY = new CipherInputStream(new FileInputStream(G3ukNldn), PhMwiM6D);
		JfIxAK13 = new FileOutputStream(wlcUp8lH);
		xiuKv14P = new byte[1024];
		for (int oafD6z5B; (oafD6z5B = VrYg3WDY.read(xiuKv14P)) != -1; JfIxAK13.write(xiuKv14P, 0, oafD6z5B))
			;
		VrYg3WDY.close();
		JfIxAK13.close();
	}

}