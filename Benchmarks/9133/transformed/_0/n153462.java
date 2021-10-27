class n153462 {
	private static File copyFileTo(File DjipX2IZ, File W0SHljib) throws IOException {
		File DBuCcRqx = new File(W0SHljib, DjipX2IZ.getName());
		FileInputStream vuqJJZZr = null;
		FileOutputStream CCgX4Jbb = null;
		try {
			vuqJJZZr = new FileInputStream(DjipX2IZ);
			CCgX4Jbb = new FileOutputStream(DBuCcRqx);
			byte C8OZixCq[] = new byte[1024];
			int zDvSYPnl;
			while ((zDvSYPnl = vuqJJZZr.read(C8OZixCq)) > 0)
				CCgX4Jbb.write(C8OZixCq, 0, zDvSYPnl);
		} finally {
			if (vuqJJZZr != null)
				vuqJJZZr.close();
			if (CCgX4Jbb != null)
				CCgX4Jbb.close();
		}
		return DBuCcRqx;
	}

}