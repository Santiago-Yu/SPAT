class n19660598 {
	private static void replaceEntityMappings(File oU5QCHjU, File uradv78I) throws ZipException, IOException {
		ZipInputStream qvy0VxaJ = new ZipInputStream(new FileInputStream(oU5QCHjU));
		ByteArrayOutputStream KG9FjiCo = new ByteArrayOutputStream();
		ZipOutputStream rQkVxAiH = new ZipOutputStream(KG9FjiCo);
		ZipEntry hSAEDeWe = qvy0VxaJ.getNextEntry();
		while (hSAEDeWe != null) {
			ByteArrayOutputStream RFqOIFyV = new ByteArrayOutputStream();
			byte[] dO3dnREN = new byte[30000];
			int XGNm6B77;
			while ((XGNm6B77 = qvy0VxaJ.read(dO3dnREN)) != -1) {
				RFqOIFyV.write(dO3dnREN, 0, XGNm6B77);
			}
			if (hSAEDeWe.getName().equals("signserver-ejb.jar")) {
				RFqOIFyV = replaceEntityMappings(RFqOIFyV, uradv78I);
				hSAEDeWe = new ZipEntry("signserver-ejb.jar");
			}
			rQkVxAiH.putNextEntry(hSAEDeWe);
			rQkVxAiH.write(RFqOIFyV.toByteArray());
			hSAEDeWe = qvy0VxaJ.getNextEntry();
		}
		qvy0VxaJ.close();
		rQkVxAiH.close();
		FileOutputStream Q1ajZOG9 = new FileOutputStream(oU5QCHjU);
		Q1ajZOG9.write(KG9FjiCo.toByteArray());
		Q1ajZOG9.close();
	}

}