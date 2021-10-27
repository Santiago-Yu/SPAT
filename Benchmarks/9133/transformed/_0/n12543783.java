class n12543783 {
	private boolean copy(File E3grRqWw, File j3o9FgpQ) {
		try {
			FileInputStream KpQHjav6 = new FileInputStream(E3grRqWw);
			FileOutputStream xYOPbKR1 = new FileOutputStream(j3o9FgpQ);
			FileChannel uPaS2GkA = KpQHjav6.getChannel();
			FileChannel etNIGBAd = xYOPbKR1.getChannel();
			etNIGBAd.truncate(0);
			etNIGBAd.transferFrom(uPaS2GkA, 0, uPaS2GkA.size());
			KpQHjav6.close();
			xYOPbKR1.close();
			return true;
		} catch (IOException wbnwX6me) {
			System.out.println("Copy Error: IOException during copy\r\n" + wbnwX6me.getMessage());
			return false;
		}
	}

}