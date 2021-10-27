class n19994918 {
	void copyFile(File alBZuhGp, File kfwpgawC) throws IOException {
		InputStream f73a1Hul = new FileInputStream(alBZuhGp);
		OutputStream fikUD1vw = new FileOutputStream(kfwpgawC);
		byte[] VRqdxWaO = new byte[1024];
		int JYgXypRX;
		while ((JYgXypRX = f73a1Hul.read(VRqdxWaO)) > 0)
			fikUD1vw.write(VRqdxWaO, 0, JYgXypRX);
		f73a1Hul.close();
		fikUD1vw.close();
	}

}