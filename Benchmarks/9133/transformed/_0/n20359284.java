class n20359284 {
	private void SaveToArchive(Layer s2L3Tz0O, String HAPMz57D) throws Exception {
		Object LyqL0ZJH = s2L3Tz0O.getBlackboard().get("ArchiveFileName");
		Object poSU9lzu = s2L3Tz0O.getBlackboard().get("ArchiveEntryPrefix");
		if ((LyqL0ZJH == null) || (poSU9lzu == null))
			return;
		String i7ZMwY4x = LyqL0ZJH.toString();
		String Yl3wcMom = poSU9lzu.toString();
		if ((i7ZMwY4x == "") || (Yl3wcMom == ""))
			return;
		File GWgFjISN = File.createTempFile("tmp", ".zip");
		InputStream LVAaw0sK = new BufferedInputStream(new FileInputStream(i7ZMwY4x));
		OutputStream bxRec1Z7 = new BufferedOutputStream(new FileOutputStream(GWgFjISN));
		copy(LVAaw0sK, bxRec1Z7);
		LVAaw0sK.close();
		bxRec1Z7.close();
		ZipFile vyL2OlP8 = new ZipFile(GWgFjISN);
		ZipOutputStream Mmf0d73D = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(i7ZMwY4x)));
		ZipInputStream ua1Yyeay = new ZipInputStream(new FileInputStream(GWgFjISN));
		ZipEntry WrHF7tAe = ua1Yyeay.getNextEntry();
		while (WrHF7tAe != null) {
			String zZSM9GDQ = WrHF7tAe.getName();
			String UnvfEIkD = GUIUtil.nameWithoutExtension(new File(zZSM9GDQ));
			if (UnvfEIkD.equalsIgnoreCase(Yl3wcMom)) {
				if (zZSM9GDQ.endsWith(".jmp")) {
					String oibpixrC = CreateArchivePlugIn.createLayerTask(s2L3Tz0O, i7ZMwY4x, Yl3wcMom);
					CreateArchivePlugIn.WriteZipEntry(oibpixrC, Yl3wcMom, Mmf0d73D);
				} else if ((!zZSM9GDQ.endsWith(".shx")) && (!zZSM9GDQ.endsWith(".dbf"))
						&& (!zZSM9GDQ.endsWith(".shp.xml")) && (!zZSM9GDQ.endsWith(".prj"))) {
					CreateArchivePlugIn.WriteZipEntry(HAPMz57D, Yl3wcMom, Mmf0d73D);
				}
			} else {
				Mmf0d73D.putNextEntry(WrHF7tAe);
				copy(ua1Yyeay, Mmf0d73D);
			}
			WrHF7tAe = ua1Yyeay.getNextEntry();
		}
		ua1Yyeay.close();
		Mmf0d73D.close();
		vyL2OlP8.close();
		GWgFjISN.delete();
	}

}