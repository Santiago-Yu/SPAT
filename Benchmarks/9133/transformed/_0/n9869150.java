class n9869150 {
	private String unJar(String EkhX2A0r, String nguADqF2) {
		String KvKBVVmQ;
		if (EkhX2A0r.lastIndexOf("lib/") >= 0)
			KvKBVVmQ = EkhX2A0r.substring(0, EkhX2A0r.lastIndexOf("lib/"));
		else
			KvKBVVmQ = EkhX2A0r.substring(0, EkhX2A0r.lastIndexOf("/"));
		String VfhcTUtq = nguADqF2.substring(0, nguADqF2.lastIndexOf("/"));
		try {
			new File(KvKBVVmQ + "/" + VfhcTUtq).mkdirs();
			JarFile EZe59INV = new JarFile(EkhX2A0r);
			ZipEntry oJpxPkla = EZe59INV.getEntry(nguADqF2);
			File UtuRbLqf = new File(KvKBVVmQ + "/" + nguADqF2);
			IOUtils.copy(EZe59INV.getInputStream(oJpxPkla), new FileOutputStream(UtuRbLqf));
		} catch (Exception QTedVbVp) {
			QTedVbVp.printStackTrace();
		}
		return KvKBVVmQ + "/" + nguADqF2;
	}

}