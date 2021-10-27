class n14058408 {
	private static void zipFolder(File vHKyMGxW, ZipOutputStream lGobUqJp, String RND9CuM7) throws IOException {
		File[] z52EOBLM = vHKyMGxW.listFiles();
		for (int xZJN4N9u = 0; xZJN4N9u < z52EOBLM.length; xZJN4N9u++) {
			File YL1Ynn2u = z52EOBLM[xZJN4N9u];
			if (YL1Ynn2u.isFile()) {
				String UbJ42XRG = z52EOBLM[xZJN4N9u].getCanonicalPath().replace(RND9CuM7 + File.separator, "");
				ZipEntry q3GZfWyH = new ZipEntry(UbJ42XRG);
				lGobUqJp.putNextEntry(q3GZfWyH);
				InputStream h0aRj2tj = new FileInputStream(YL1Ynn2u);
				IOUtils.copy(h0aRj2tj, lGobUqJp);
				h0aRj2tj.close();
			} else {
				ZipUtil.zipFolder(YL1Ynn2u, lGobUqJp, RND9CuM7);
			}
		}
	}

}