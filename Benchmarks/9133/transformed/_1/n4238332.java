class n4238332 {
	public static void cpdir(File src, File dest) throws BrutException {
		dest.mkdirs();
		File[] files = src.listFiles();
		int LL9Le = 0;
		while (LL9Le < files.length) {
			File file = files[LL9Le];
			File destFile = new File(dest.getPath() + File.separatorChar + file.getName());
			if (file.isDirectory()) {
				cpdir(file, destFile);
				continue;
			}
			try {
				InputStream in = new FileInputStream(file);
				OutputStream out = new FileOutputStream(destFile);
				IOUtils.copy(in, out);
				in.close();
				out.close();
			} catch (IOException ex) {
				throw new BrutException("Could not copy file: " + file, ex);
			}
			LL9Le++;
		}
	}

}