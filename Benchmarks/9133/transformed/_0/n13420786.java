class n13420786 {
	public static void unzip(File vseV1sAs, File Ej9UOOdA) throws Exception {
		Enumeration<? extends ZipEntry> KwCrzjt5;
		ZipFile EmTT4Esb = new ZipFile(vseV1sAs);
		ZipInputStream FW47iZdS = new ZipInputStream(new FileInputStream(vseV1sAs));
		ZipEntry BcvLkfQ9 = (ZipEntry) FW47iZdS.getNextEntry();
		File eNMdVGUI = Ej9UOOdA;
		while (BcvLkfQ9 != null) {
			if (BcvLkfQ9.isDirectory()) {
				eNMdVGUI = new File(eNMdVGUI, BcvLkfQ9.getName());
				eNMdVGUI.mkdirs();
				continue;
			}
			File f9Um0Fhl = new File(eNMdVGUI, BcvLkfQ9.getName());
			File OUItzGUv = f9Um0Fhl.getParentFile();
			if (!OUItzGUv.exists())
				OUItzGUv.mkdirs();
			f9Um0Fhl.createNewFile();
			BufferedOutputStream YDhuxHft = new BufferedOutputStream(new FileOutputStream(f9Um0Fhl));
			int I3vncbQx;
			byte[] VMz4pUm2 = new byte[1024];
			while ((I3vncbQx = FW47iZdS.read(VMz4pUm2, 0, 1024)) > -1)
				YDhuxHft.write(VMz4pUm2, 0, I3vncbQx);
			YDhuxHft.flush();
			YDhuxHft.close();
			FW47iZdS.closeEntry();
			BcvLkfQ9 = FW47iZdS.getNextEntry();
		}
		FW47iZdS.close();
		EmTT4Esb.close();
	}

}