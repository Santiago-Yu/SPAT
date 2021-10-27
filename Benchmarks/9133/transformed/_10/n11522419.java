class n11522419 {
	public static void copyFile(File in, File out) {
		byte[] buffer = new byte[1024];
		int len;
		try {
			FileOutputStream fout = new FileOutputStream(out);
			FileInputStream fin = new FileInputStream(in);
			while ((len = fin.read(buffer)) >= 0)
				fout.write(buffer, 0, len);
			fin.close();
			fout.close();
		} catch (IOException ex) {
		}
	}

}