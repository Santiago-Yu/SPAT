class n14417449 {
	public static void compressAll(File Wczu8CJm, File j2nYpAqk) throws IOException {
		if (!Wczu8CJm.isDirectory())
			throw new IllegalArgumentException("Given file is no directory");
		ZipOutputStream CmSbD72d = new ZipOutputStream(new FileOutputStream(j2nYpAqk));
		CmSbD72d.setLevel(0);
		String[] zuBLEm6N = Wczu8CJm.list();
		byte[] Qmdtdoca = new byte[4096];
		int G2VM0mK5;
		for (int UQrtbVTS = 0; UQrtbVTS < zuBLEm6N.length; UQrtbVTS++) {
			File SsroBboy = new File(Wczu8CJm, zuBLEm6N[UQrtbVTS]);
			if (SsroBboy.isDirectory())
				continue;
			FileInputStream TaLqiR3s = new FileInputStream(SsroBboy);
			ZipEntry frXwwfUz = new ZipEntry(SsroBboy.getName());
			CmSbD72d.putNextEntry(frXwwfUz);
			while ((G2VM0mK5 = TaLqiR3s.read(Qmdtdoca)) != -1)
				CmSbD72d.write(Qmdtdoca, 0, G2VM0mK5);
			TaLqiR3s.close();
		}
		CmSbD72d.close();
	}

}