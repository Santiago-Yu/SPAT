class n662295 {
	public static void copy(URL YDlvuyXk, String W8hWtgbu) throws IOException {
		System.out.println("copying from: " + YDlvuyXk + " to " + W8hWtgbu);
		InputStream MituZlBm = YDlvuyXk.openStream();
		FileOutputStream qn5U5OjM = new FileOutputStream(W8hWtgbu);
		byte[] ynXiSzBO = new byte[8192];
		int fBC3PjGl = -1;
		while ((fBC3PjGl = MituZlBm.read(ynXiSzBO)) != -1) {
			qn5U5OjM.write(ynXiSzBO, 0, fBC3PjGl);
		}
		qn5U5OjM.close();
	}

}