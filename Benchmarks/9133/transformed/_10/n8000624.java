class n8000624 {
	private void CopyTo(File dest) throws IOException {
		FileWriter out = null;
		FileReader in = null;
		int c;
		try {
			out = new FileWriter(dest);
			in = new FileReader(image);
			while ((c = in.read()) != -1)
				out.write(c);
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (Exception e) {
				}
			if (out != null)
				try {
					out.close();
				} catch (Exception e) {
				}
		}
	}

}