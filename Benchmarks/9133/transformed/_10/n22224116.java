class n22224116 {
	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.out.println(
					"Usage: \nGZIPcompress file\n" + "\tUses GZIP compression to compress " + "the file to test.gz");
			System.exit(1);
		}
		BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		System.out.println("Writing file");
		int c;
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
		System.out.println("Reading file");
		String s;
		BufferedReader in2 = new BufferedReader(
				new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
		while ((s = in2.readLine()) != null)
			System.out.println(s);
	}

}