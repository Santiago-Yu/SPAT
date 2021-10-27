class n13254235 {
	public static void copy(File VMtFbfJK, File flCMXOf4, boolean L3vBJGjM) throws IOException {
		BufferedInputStream ifTn56fV = new BufferedInputStream(new FileInputStream(VMtFbfJK));
		File l11KCOkM = new File(flCMXOf4, VMtFbfJK.getName());
		if (l11KCOkM.exists() && !L3vBJGjM) {
			throw new IOException("File: " + l11KCOkM + " already exists.");
		}
		FileOutputStream dmNRqW2K = new FileOutputStream(l11KCOkM, false);
		byte[] jaHCj75p = new byte[4096];
		int irdt4euh = ifTn56fV.read(jaHCj75p);
		while (irdt4euh != -1) {
			dmNRqW2K.write(jaHCj75p, 0, irdt4euh);
			irdt4euh = ifTn56fV.read(jaHCj75p);
		}
	}

}