class n6214338 {
	private File unzipArchive(File VBpHEP02, File GbnuwE5r, String ftf42GCz) throws IOException {
		File UZlC0ZtN = null;
		ZipEntry zADdojiO = null;
		ZipInputStream hkqgWS5T = new ZipInputStream(new FileInputStream((VBpHEP02)));
		FileOutputStream sLN6w7Db = null;
		byte sFJhJkeW[] = new byte[4096];
		int w3Zt2z2T;
		while ((zADdojiO = hkqgWS5T.getNextEntry()) != null) {
			File S8KldlQ8 = new File(GbnuwE5r, zADdojiO.getName());
			if (zADdojiO.getName().equals(ftf42GCz))
				UZlC0ZtN = S8KldlQ8;
			sLN6w7Db = new FileOutputStream(S8KldlQ8);
			while ((w3Zt2z2T = hkqgWS5T.read(sFJhJkeW)) != -1)
				sLN6w7Db.write(sFJhJkeW, 0, w3Zt2z2T);
			sLN6w7Db.close();
		}
		hkqgWS5T.close();
		return UZlC0ZtN;
	}

}