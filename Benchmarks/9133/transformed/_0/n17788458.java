class n17788458 {
	private static synchronized boolean doCopyFile(File rufEB3pg, File k6xs2U8G, boolean QsPoTUmy) throws IOException {
		if (k6xs2U8G.exists() && k6xs2U8G.isDirectory()) {
			k6xs2U8G = new File(k6xs2U8G + FILE_SEPARATOR + rufEB3pg.getName());
		}
		FileInputStream b5mb1g2d = new FileInputStream(rufEB3pg);
		try {
			FileOutputStream srjDzO3F = new FileOutputStream(k6xs2U8G);
			try {
				IOUtils.copy(b5mb1g2d, srjDzO3F);
			} finally {
				IOUtils.closeQuietly(srjDzO3F);
			}
		} finally {
			IOUtils.closeQuietly(b5mb1g2d);
		}
		if (rufEB3pg.length() != k6xs2U8G.length()) {
			throw new IOException("Failed to copy full contents from '" + rufEB3pg + "' to '" + k6xs2U8G + "'");
		}
		if (QsPoTUmy) {
			k6xs2U8G.setLastModified(rufEB3pg.lastModified());
		}
		return k6xs2U8G.exists();
	}

}