class n7263928 {
	private void copyFile(File TWu9N0es, File BgGBwXwJ) {
		InputStream N5ul3nzl = null;
		OutputStream sz6UQ6Ao = null;
		try {
			int QxNTQab2;
			N5ul3nzl = new BufferedInputStream(new FileInputStream(TWu9N0es));
			sz6UQ6Ao = new BufferedOutputStream(new FileOutputStream(BgGBwXwJ));
			while ((QxNTQab2 = N5ul3nzl.read()) != -1)
				sz6UQ6Ao.write(QxNTQab2);
		} catch (Exception rrUhsh7x) {
			XRepository.getLogger().warning(this, "Error on copying the plugin file!");
			XRepository.getLogger().warning(this, rrUhsh7x);
		} finally {
			try {
				N5ul3nzl.close();
				sz6UQ6Ao.close();
			} catch (Exception h6jUJvJs) {
			}
		}
	}

}