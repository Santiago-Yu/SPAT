class n6948655 {
	public static void main(String[] args) throws IOException {
		File fileIn = new File("D:\\zz_c\\study2\\src\\study\\io\\A.java");
		PipedInputStream pin = new PipedInputStream();
		InputStream fin = new FileInputStream(fileIn);
		PipedOutputStream pout = new PipedOutputStream();
		pout.connect(pin);
		IoRead i = new IoRead();
		i.setIn(pin);
		File fileOU2 = new File("D:\\zz_c\\study2\\src\\study\\io\\A2.java");
		File fileOU1 = new File("D:\\zz_c\\study2\\src\\study\\io\\A1.java");
		File fileOU3 = new File("D:\\zz_c\\study2\\src\\study\\io\\A3.java");
		i.addOut(new BufferedOutputStream(new FileOutputStream(fileOU1)));
		i.addOut(new BufferedOutputStream(new FileOutputStream(fileOU2)));
		i.addOut(new BufferedOutputStream(new FileOutputStream(fileOU3)));
		PipedOutputStream pout2 = new PipedOutputStream();
		PipedInputStream pin2 = new PipedInputStream();
		i.addOut(pout2);
		pout2.connect(pin2);
		i.start();
		int read;
		try {
			read = fin.read();
			while (read != -1) {
				pout.write(read);
				read = fin.read();
			}
			fin.close();
			pout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int c = pin2.read();
		while (c != -1) {
			System.out.print((char) c);
			c = pin2.read();
		}
		pin2.close();
	}

}