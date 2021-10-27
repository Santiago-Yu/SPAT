class n8747840 {
	public static void copy(File W8RlDrWH, File yugPsw85) throws FileNotFoundException, IOException {
		FileInputStream Z8wjsKRS = new FileInputStream(W8RlDrWH);
		FileOutputStream IvREmH3t = new FileOutputStream(yugPsw85);
		try {
			byte[] fF9a3bFq = new byte[1024];
			int SlfGJgkA = -1;
			while ((SlfGJgkA = Z8wjsKRS.read(fF9a3bFq)) > 0)
				IvREmH3t.write(fF9a3bFq, 0, SlfGJgkA);
		} finally {
			Z8wjsKRS.close();
			IvREmH3t.close();
		}
	}

}