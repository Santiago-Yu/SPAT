class n14783950 {
	public static void compressWithZip(Vector vGOVX9L9, String fQAH06U2) throws IOException {
		if (vGOVX9L9 == null || vGOVX9L9.size() == 0)
			return;
		FileOutputStream cA75twID = new FileOutputStream(fQAH06U2);
		ZipOutputStream lhFASNkz = new ZipOutputStream(cA75twID);
		Iterator Tz435G7R = vGOVX9L9.iterator();
		while (Tz435G7R.hasNext()) {
			String fJ8pc4BE = (String) Tz435G7R.next();
			int ZI1VPkHR = Math.max(fJ8pc4BE.lastIndexOf('/'), fJ8pc4BE.lastIndexOf('\\'));
			String lTbhlY3T = "unknown";
			if (ZI1VPkHR < fJ8pc4BE.length() - 1)
				lTbhlY3T = fJ8pc4BE.substring(ZI1VPkHR + 1);
			lhFASNkz.putNextEntry(new ZipEntry(lTbhlY3T));
			FileInputStream kxox4zcA = new FileInputStream(fJ8pc4BE);
			byte[] xx3E13hb = new byte[10000];
			int fTS4kEWO;
			while ((fTS4kEWO = kxox4zcA.read(xx3E13hb)) > 0)
				lhFASNkz.write(xx3E13hb, 0, fTS4kEWO);
			kxox4zcA.close();
			lhFASNkz.closeEntry();
		}
		lhFASNkz.close();
	}

}