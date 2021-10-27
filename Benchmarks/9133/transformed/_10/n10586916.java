class n10586916 {
	public static void CreateBackupOfDataFile(String _src, String _dest) {
		try {
			File dest = new File(_dest);
			File src = new File(_src);
			if (new File(_src).exists()) {
				BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest));
				int len = 128;
				byte[] read = new byte[128];
				while ((len = in.read(read)) > 0)
					out.write(read, 0, len);
				out.flush();
				out.close();
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}