class n17499276 {
	public static void unzip(File woQKbuWi, File dYlNWSAT) throws Exception {
		Enumeration<? extends ZipEntry> nUK0phXi;
		ZipFile Bm9ahWBl = new ZipFile(woQKbuWi);
		ZipInputStream VeVvUhkn = new ZipInputStream(new FileInputStream(woQKbuWi));
		ZipEntry IXhZd3sI = (ZipEntry) VeVvUhkn.getNextEntry();
		File OB6JxNFk = dYlNWSAT;
		while (IXhZd3sI != null) {
			if (IXhZd3sI.isDirectory()) {
				OB6JxNFk = new File(OB6JxNFk, IXhZd3sI.getName());
				OB6JxNFk.mkdirs();
				continue;
			}
			File zaMdJu29 = new File(OB6JxNFk, IXhZd3sI.getName());
			File TdJDYLky = zaMdJu29.getParentFile();
			if (!TdJDYLky.exists())
				TdJDYLky.mkdirs();
			zaMdJu29.createNewFile();
			BufferedOutputStream Q4Si8Zhm = new BufferedOutputStream(new FileOutputStream(zaMdJu29));
			int TOg8cQ6a;
			byte[] KHvn3ONf = new byte[1024];
			while ((TOg8cQ6a = VeVvUhkn.read(KHvn3ONf, 0, 1024)) > -1)
				Q4Si8Zhm.write(KHvn3ONf, 0, TOg8cQ6a);
			Q4Si8Zhm.flush();
			Q4Si8Zhm.close();
			VeVvUhkn.closeEntry();
			IXhZd3sI = VeVvUhkn.getNextEntry();
		}
		VeVvUhkn.close();
		Bm9ahWBl.close();
	}

}