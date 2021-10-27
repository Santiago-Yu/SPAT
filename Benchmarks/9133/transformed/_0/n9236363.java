class n9236363 {
	private void unJarStart(String iMOHOiTZ, String Rod9PTnt) {
		String swiQgWzL;
		if (iMOHOiTZ.lastIndexOf("lib/") >= 0)
			swiQgWzL = iMOHOiTZ.substring(0, iMOHOiTZ.lastIndexOf("lib/"));
		else
			swiQgWzL = iMOHOiTZ.substring(0, iMOHOiTZ.lastIndexOf("/"));
		String PqkdBqqb = Rod9PTnt.substring(0, Rod9PTnt.lastIndexOf("/"));
		try {
			new File(swiQgWzL + "/" + PqkdBqqb).mkdirs();
			JarFile Mr1qccKG = new JarFile(iMOHOiTZ);
			Enumeration<JarEntry> ZOo06OEo = Mr1qccKG.entries();
			while (ZOo06OEo.hasMoreElements()) {
				JarEntry wJFjQJ3S = ZOo06OEo.nextElement();
				String DrniZdbs = wJFjQJ3S.getName();
				if (DrniZdbs.startsWith(Rod9PTnt)) {
					ZipEntry gXlrmuw6 = Mr1qccKG.getEntry(DrniZdbs);
					File IATuTF9W = new File(swiQgWzL + "/" + DrniZdbs);
					IOUtils.copy(Mr1qccKG.getInputStream(gXlrmuw6), new FileOutputStream(IATuTF9W));
				}
			}
		} catch (Exception UgAiy6om) {
			UgAiy6om.printStackTrace();
		}
	}

}