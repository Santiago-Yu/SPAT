class n10893111 {
	public static void copyFile(File in, File out) throws IOException {
		try {
			OutputStreamWriter outf = new OutputStreamWriter(new FileOutputStream(out), "UTF-8");
			FileReader inf = new FileReader(in);
			int c;
			while ((c = inf.read()) != -1)
				outf.write(c);
			inf.close();
			outf.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}