class n21840034 {
	public FileOutputStream transfer(File XTOEhB0S, File PV1F8NJW, long EdBgnFPZ)
			throws IOException, InterruptedException {
		if (out != null) {
			close();
		}
		FileChannel t1HPFj7k = new FileInputStream(XTOEhB0S).getChannel();
		FileChannel E46x95jh = new FileOutputStream(PV1F8NJW).getChannel();
		long xGkjH5q3 = EdBgnFPZ;
		int KPZJkyBf = 0;
		try {
			while ((KPZJkyBf += E46x95jh.transferFrom(t1HPFj7k, KPZJkyBf, xGkjH5q3 - KPZJkyBf)) < xGkjH5q3) {
			}
		} finally {
			t1HPFj7k.close();
			E46x95jh.close();
		}
		out = create(PV1F8NJW);
		return out;
	}

}