class n4238332 {
	public static void cpdir(File src, File dest) throws BrutException {
		dest.mkdirs();
		File[] files = src.listFiles();
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			File destFile = new File(dest.getPath() + File.separatorChar + file.getName());
			if (file.isDirectory()) {
				cpdir(file, destFile);
				continue;
			}
			try {
				OutputStream out = new FileOutputStream(destFile);
				InputStream in = new FileInputStream(file);
				IOUtils.copy(in, out);
				in.close();
				out.close();
			} catch (IOException ex) {
				throw new BrutException("Could not copy file: " + file, ex);
			}
		}
	}

}