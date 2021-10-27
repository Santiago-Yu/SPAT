class n18600879 {
	public static void copyFile(File gHQFuzlE, File HQYPEkk0) throws Exception {
		FileReader DaIoQXTG = new FileReader(gHQFuzlE);
		FileWriter tH24Rgn2 = new FileWriter(HQYPEkk0);
		int nD2t4Cux;
		while ((nD2t4Cux = DaIoQXTG.read()) != -1)
			tH24Rgn2.write(nD2t4Cux);
		DaIoQXTG.close();
		tH24Rgn2.close();
	}

}