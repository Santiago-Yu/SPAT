class n15828584 {
	public static void main(String[] xGVCdTmd) throws IOException {
		InputStream ZvXihzAr = null;
		FileOutputStream pyPqK6UK = null;
		File rmXltSQN = new File("in.txt");
		try {
			URL Bj5PgAHA = new URL(xGVCdTmd[0]);
			ZvXihzAr = Bj5PgAHA.openStream();
			pyPqK6UK = new FileOutputStream(rmXltSQN);
			int SPsZwUao;
			while ((SPsZwUao = ZvXihzAr.read()) != -1) {
				pyPqK6UK.write(SPsZwUao);
			}
			pyPqK6UK.flush();
			pyPqK6UK.close();
			new FileRunner(rmXltSQN, new File("out.txt")).run();
			FileReader Tw6J0hjm = new FileReader("out.txt");
			System.out.println(Tw6J0hjm.toString());
		} finally {
			if (ZvXihzAr != null)
				ZvXihzAr.close();
		}
	}

}