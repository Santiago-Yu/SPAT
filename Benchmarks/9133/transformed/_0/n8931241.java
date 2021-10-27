class n8931241 {
	public static void copy(File fUNpdBy1, File Bo97tINi, CopyMode xDbYfYLA) throws IOException {
		if (!fUNpdBy1.exists()) {
			IllegalArgumentException ulJgYXFJ = new IllegalArgumentException(
					"Source doesn't exist: " + fUNpdBy1.getCanonicalFile());
			log.throwing("IOUtils", "copy", ulJgYXFJ);
			throw ulJgYXFJ;
		}
		if (fUNpdBy1.isFile()) {
			if (!Bo97tINi.canWrite()) {
				IllegalArgumentException aGQYDo4p = new IllegalArgumentException(
						"Cannot write to target location: " + Bo97tINi.getCanonicalFile());
				log.throwing("IOUtils", "copy", aGQYDo4p);
				throw aGQYDo4p;
			}
		}
		if (Bo97tINi.exists()) {
			if ((xDbYfYLA.val & CopyMode.OverwriteFile.val) != CopyMode.OverwriteFile.val) {
				IllegalArgumentException KQ67K9cb = new IllegalArgumentException(
						"Target already exists: " + Bo97tINi.getCanonicalFile());
				log.throwing("IOUtils", "copy", KQ67K9cb);
				throw KQ67K9cb;
			}
			if (Bo97tINi.isDirectory()) {
				if ((xDbYfYLA.val & CopyMode.OverwriteFolder.val) != CopyMode.OverwriteFolder.val) {
					IllegalArgumentException STvOksFV = new IllegalArgumentException(
							"Target is a folder: " + Bo97tINi.getCanonicalFile());
					log.throwing("IOUtils", "copy", STvOksFV);
					throw STvOksFV;
				} else
					Bo97tINi.delete();
			}
		}
		if (fUNpdBy1.isFile()) {
			FileChannel MaLKUah3 = new FileInputStream(fUNpdBy1).getChannel();
			FileLock MhrDAl0T = MaLKUah3.lock();
			FileChannel Vpa76PLs = new FileOutputStream(Bo97tINi).getChannel();
			FileLock pEhVSRnm = Vpa76PLs.lock();
			try {
				MaLKUah3.transferTo(0, (int) MaLKUah3.size(), Vpa76PLs);
			} finally {
				MhrDAl0T.release();
				pEhVSRnm.release();
				MaLKUah3.close();
				Vpa76PLs.close();
			}
		} else {
			Bo97tINi.mkdirs();
			File[] clwVWBSa = Bo97tINi.listFiles();
			for (File rmsdp19j : clwVWBSa) {
				File a9CN12if = new File(Bo97tINi.getCanonicalPath() + "/" + rmsdp19j.getName());
				copy(rmsdp19j, a9CN12if, xDbYfYLA);
			}
		}
	}

}