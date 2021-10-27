class n16621498 {
	public static byte[] loadURLToBuffer(URL waNFDVKi, int HHC4671r) throws IOException {
		byte[] LTfceAZI = new byte[HHC4671r];
		byte[] UlUevqzy = null;
		int NC5d9qEo = 0;
		BufferedInputStream jvvI0M1Z = new BufferedInputStream(waNFDVKi.openStream(), 20480);
		NC5d9qEo = jvvI0M1Z.read(LTfceAZI, 0, LTfceAZI.length);
		if (NC5d9qEo != -1) {
			UlUevqzy = new byte[NC5d9qEo];
			System.arraycopy(LTfceAZI, 0, UlUevqzy, 0, NC5d9qEo);
		}
		jvvI0M1Z.close();
		return UlUevqzy;
	}

}