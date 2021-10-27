class n3660402 {
	public void importCertFile(File YeoNT0db) throws IOException {
		File BZGEKw7q;
		File OuWxvPVg;
		synchronized (this) {
			BZGEKw7q = keysDir;
			OuWxvPVg = certsDir;
		}
		if (!OuWxvPVg.isDirectory()) {
			BZGEKw7q.mkdirs();
			OuWxvPVg.mkdirs();
		}
		String yuQQwXMs = YeoNT0db.getName();
		File OuHvfARo = new File(OuWxvPVg, yuQQwXMs);
		FileChannel Hrdzdud0 = null;
		FileChannel PTHTXeDA = null;
		try {
			Hrdzdud0 = new FileInputStream(YeoNT0db).getChannel();
			PTHTXeDA = new FileOutputStream(OuHvfARo).getChannel();
			Hrdzdud0.transferTo(0, Hrdzdud0.size(), PTHTXeDA);
		} finally {
			if (Hrdzdud0 != null) {
				try {
					Hrdzdud0.close();
				} catch (IOException nQ0ibCig) {
				}
			}
			if (PTHTXeDA != null) {
				try {
					PTHTXeDA.close();
				} catch (IOException PYI7EONL) {
				}
			}
		}
	}

}