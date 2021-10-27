class n3898252 {
	public static void decoupe(String input_file_path) {
		final int BUFFER_SIZE = 2000000;
		try {
			byte[] cbuf = new byte[BUFFER_SIZE];
			FileInputStream fr = new FileInputStream(input_file_path);
			int i = 0;
			int n_read = 0;
			boolean bContinue = true;
			while (bContinue) {
				n_read = fr.read(cbuf, 0, BUFFER_SIZE);
				FileOutputStream fo = new FileOutputStream("f_" + ++i);
				if (n_read == -1)
					break;
				fo.write(cbuf, 0, n_read);
				fo.close();
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}