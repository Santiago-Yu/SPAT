class n11373801 {
	public boolean resolve(String parameters, Reader in, Writer out, DataFieldResolver dataFieldResolver,
			int[] arrayPositioner) throws IOException {
		URL url = new URL(parameters);
		PrintWriter printOut = new PrintWriter(out);
		Reader urlIn = new InputStreamReader(url.openStream());
		int ch = urlIn.read();
		while (ch != -1) {
			out.write(ch);
			ch = urlIn.read();
		}
		out.flush();
		return false;
	}

}