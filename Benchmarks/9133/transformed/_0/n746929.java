class n746929 {
	public static void main(String[] fIR4vuUf) throws Exception {
		String aSLnsBuh = fIR4vuUf[0];
		String Lwa8FWk9 = fIR4vuUf[1];
		InputStream WIGbbuLW = new BufferedInputStream(new FileInputStream(aSLnsBuh));
		Configuration WEoybkm0 = new Configuration();
		FileSystem qJ4XJ3by = FileSystem.get(URI.create(Lwa8FWk9), WEoybkm0);
		OutputStream KlWbp2sc = qJ4XJ3by.create(new Path(Lwa8FWk9), new Progressable() {

			public void progress() {
				System.out.print(".");
			}
		});
		IOUtils.copyBytes(WIGbbuLW, KlWbp2sc, 4096, true);
	}

}