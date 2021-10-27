class n21907869 {
	public static void copy(String source, String destination) {
		FileWriter out = null;
		FileReader in = null;
		try {
			File outputFile = new File(destination);
			File inputFile = new File(source);
			out = new FileWriter(outputFile);
			in = new FileReader(inputFile);
			int c;
			while ((c = in.read()) != -1)
				out.write(c);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}