class n343230 {
	public Source resolve(String edbYkWln, String Cv5tVeuU) throws TransformerException {
		if (edbYkWln.endsWith(".txt")) {
			try {
				URL tGOu95Rb = new URL(new URL(Cv5tVeuU), edbYkWln);
				java.io.InputStream lRuNAArb = tGOu95Rb.openConnection().getInputStream();
				java.io.InputStreamReader uj8L25nC = new java.io.InputStreamReader(lRuNAArb, "iso-8859-1");
				StringBuffer LVKB8hNS = new StringBuffer();
				while (true) {
					int YKVdpSBU = uj8L25nC.read();
					if (YKVdpSBU < 0)
						break;
					LVKB8hNS.append((char) YKVdpSBU);
				}
				com.icl.saxon.expr.TextFragmentValue GsFo56hg = new com.icl.saxon.expr.TextFragmentValue(
						LVKB8hNS.toString(), tGOu95Rb.toString(), (com.icl.saxon.Controller) transformer);
				return GsFo56hg.getFirst();
			} catch (Exception LIJfhFtR) {
				throw new TransformerException(LIJfhFtR);
			}
		} else {
			return null;
		}
	}

}