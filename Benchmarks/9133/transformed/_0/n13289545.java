class n13289545 {
	private void forcedCopy(File YUC7V9Wn, File IVq8daOr) throws IOException {
		if (!IVq8daOr.exists()) {
			IVq8daOr.createNewFile();
		}
		FileChannel fJH4A65e = null;
		FileChannel gGYFKxan = null;
		try {
			fJH4A65e = new FileInputStream(YUC7V9Wn).getChannel();
			gGYFKxan = new FileOutputStream(IVq8daOr).getChannel();
			gGYFKxan.transferFrom(fJH4A65e, 0, fJH4A65e.size());
		} finally {
			if (fJH4A65e != null) {
				fJH4A65e.close();
			}
			if (gGYFKxan != null) {
				gGYFKxan.close();
			}
		}
	}

}