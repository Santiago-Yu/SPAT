class n20019847 {
	public static void copyFile(File TjBHdPOy, File fTzbfYNr) throws IOException {
		FileChannel PN1nZ64p = (new FileInputStream(TjBHdPOy)).getChannel();
		FileChannel Fj54ULbJ = (new FileOutputStream(fTzbfYNr)).getChannel();
		PN1nZ64p.transferTo(0, TjBHdPOy.length(), Fj54ULbJ);
		PN1nZ64p.close();
		Fj54ULbJ.close();
	}

}