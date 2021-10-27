class n22628847 {
	public static void main(String[] zEsExAwF) throws Exception {
		System.out.println("Opening destination cbrout.jizz");
		OutputStream JSeP2jC3 = new BufferedOutputStream(new FileOutputStream("cbrout.jizz"));
		System.out.println("Opening source output.jizz");
		InputStream ZcjTQUQb = new CbrLiveStream(new BufferedInputStream(new FileInputStream("output.jizz")),
				System.currentTimeMillis() + 10000, 128);
		System.out.println("Starting read/write loop");
		boolean YMKKhDu1 = false;
		int V45Ir3J3;
		byte[] jBTWWCH9 = new byte[4 * 1024];
		while ((V45Ir3J3 = ZcjTQUQb.read(jBTWWCH9)) > -1) {
			if (!YMKKhDu1) {
				System.out.println("Starting at " + new Date());
				YMKKhDu1 = true;
			}
			JSeP2jC3.write(jBTWWCH9, 0, V45Ir3J3);
		}
		System.out.println("Finished at " + new Date());
		JSeP2jC3.close();
		ZcjTQUQb.close();
	}

}