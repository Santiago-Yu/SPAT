class n19113613 {
	public static void copy(File xmkA6T3g, File oRT2OhhA) throws IOException {
		if (xmkA6T3g.exists() && xmkA6T3g != null && oRT2OhhA != null) {
			if (!oRT2OhhA.exists()) {
				if (xmkA6T3g.isDirectory()) {
					oRT2OhhA.mkdirs();
				} else {
					oRT2OhhA.createNewFile();
				}
			}
			String o1tbdTRn = xmkA6T3g.isDirectory() ? "directory" : "file";
			String cf2PrWxm = oRT2OhhA.isDirectory() ? "directory" : "file";
			if (!o1tbdTRn.equals(cf2PrWxm)) {
				throw new IOException("Can't duplicate " + o1tbdTRn + " as " + cf2PrWxm);
			} else {
				if (o1tbdTRn.equals("directory")) {
					File[] o9u4FVDb = xmkA6T3g.listFiles();
					for (File Ywdk5VGf : o9u4FVDb) {
						copy(Ywdk5VGf, new File(oRT2OhhA, Ywdk5VGf.getName()));
					}
				} else {
					FileChannel EYhR1cVK = new FileInputStream(xmkA6T3g).getChannel();
					FileChannel KXAQrwYQ = new FileOutputStream(oRT2OhhA).getChannel();
					EYhR1cVK.transferTo(0, EYhR1cVK.size(), KXAQrwYQ);
				}
			}
		}
	}

}