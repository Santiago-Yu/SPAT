class n3667135 {
	public void fileCopy(File inFile, File outFile) {
		try {
			FileOutputStream out = new FileOutputStream(outFile);
			FileInputStream in = new FileInputStream(inFile);
			int c;
			while ((c = in.read()) != -1)
				out.write(c);
			in.close();
			out.close();
		} catch (IOException e) {
			System.err.println("Hubo un error de entrada/salida!!!");
		}
	}

}