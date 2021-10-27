class n15828584 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = null;
		InputStream stream = null;
		File in = new File("in.txt");
		try {
			URL url = new URL(args[0]);
			fos = new FileOutputStream(in);
			stream = url.openStream();
			int i;
			while ((i = stream.read()) != -1) {
				fos.write(i);
			}
			fos.flush();
			fos.close();
			new FileRunner(in, new File("out.txt")).run();
			FileReader reader = new FileReader("out.txt");
			System.out.println(reader.toString());
		} finally {
			if (stream != null)
				stream.close();
		}
	}

}