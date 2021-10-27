class n3459078 {
	public static void copyFile(File dpwGbjSa, File XPjWAis9) {
		try {
			XPjWAis9.getParentFile().mkdirs();
			byte[] VqTEdQEu = new byte[4096];
			int l3xARtEp = 0;
			FileInputStream TjieFC6T = new FileInputStream(dpwGbjSa);
			FileOutputStream CyewuI97 = new FileOutputStream(XPjWAis9);
			while ((l3xARtEp = TjieFC6T.read(VqTEdQEu)) != -1)
				CyewuI97.write(VqTEdQEu, 0, l3xARtEp);
			TjieFC6T.close();
			CyewuI97.close();
		} catch (Exception RI8Boye8) {
			System.out.println(RI8Boye8);
		}
	}

}