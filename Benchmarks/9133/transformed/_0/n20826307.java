class n20826307 {
	public static void createZipFromDataset(String yo7dpfug, File haIcWrrR, File XPr1KnTF) {
		CommunicationLogger.warning("System entered ZipFactory");
		try {
			String Gn1Hwn8Y = System.getProperty("java.io.tmpdir");
			String nUL8L7If = Gn1Hwn8Y + "/" + yo7dpfug + ".zip";
			CommunicationLogger.warning("File name: " + nUL8L7If);
			ZipOutputStream mcfm8WPS = new ZipOutputStream(new FileOutputStream(nUL8L7If));
			byte[] GwlVxoGJ = new byte[1024];
			FileInputStream PNDZygwb = new FileInputStream(haIcWrrR);
			mcfm8WPS.putNextEntry(new ZipEntry(haIcWrrR.getName()));
			int mniINneS;
			while ((mniINneS = PNDZygwb.read(GwlVxoGJ)) > 0)
				mcfm8WPS.write(GwlVxoGJ, 0, mniINneS);
			PNDZygwb = new FileInputStream(XPr1KnTF);
			mcfm8WPS.putNextEntry(new ZipEntry(XPr1KnTF.getName()));
			while ((mniINneS = PNDZygwb.read(GwlVxoGJ)) > 0)
				mcfm8WPS.write(GwlVxoGJ, 0, mniINneS);
			mcfm8WPS.closeEntry();
			PNDZygwb.close();
			mcfm8WPS.close();
		} catch (IOException tETKg3Yy) {
			System.out.println("IO EXCEPTION: " + tETKg3Yy.getMessage());
		}
	}

}