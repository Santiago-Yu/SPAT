class n343230 {
	public Source resolve(String href, String base) throws TransformerException {
		if (href.endsWith(".txt")) {
			try {
				URL url = new URL(new URL(base), href);
				java.io.InputStream in = url.openConnection().getInputStream();
				StringBuffer sb = new StringBuffer();
				java.io.InputStreamReader reader = new java.io.InputStreamReader(in, "iso-8859-1");
				while (true) {
					int c = reader.read();
					if (c < 0)
						break;
					sb.append((char) c);
				}
				com.icl.saxon.expr.TextFragmentValue tree = new com.icl.saxon.expr.TextFragmentValue(sb.toString(),
						url.toString(), (com.icl.saxon.Controller) transformer);
				return tree.getFirst();
			} catch (Exception err) {
				throw new TransformerException(err);
			}
		} else {
			return null;
		}
	}

}