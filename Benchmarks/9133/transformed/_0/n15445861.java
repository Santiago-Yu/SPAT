class n15445861 {
	public static void copyFile(File rxgKx49U, File gjMrXCiB) throws IOException {
		if (!(rxgKx49U.exists() && rxgKx49U.isFile()))
			throw new IllegalArgumentException("Source file doesn't exist: " + rxgKx49U.getAbsolutePath());
		if (gjMrXCiB.exists() && gjMrXCiB.isDirectory())
			throw new IllegalArgumentException("Destination file is directory: " + gjMrXCiB.getAbsolutePath());
		FileInputStream WGpkJM3s = new FileInputStream(rxgKx49U);
		FileOutputStream Xylkv1Qk = new FileOutputStream(gjMrXCiB);
		byte[] Z1jp7K4N = new byte[4096];
		int wjMTi7My = 0;
		try {
			while ((wjMTi7My = WGpkJM3s.read(Z1jp7K4N)) != -1)
				Xylkv1Qk.write(Z1jp7K4N, 0, wjMTi7My);
		} finally {
			WGpkJM3s.close();
			Xylkv1Qk.close();
		}
	}

}