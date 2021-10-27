class n13309014 {
	public String[] getElements() throws IOException {
		Vector v = new Vector();
		PushbackInputStream in = null;
		try {
			URLConnection urlConn = dtdURL.openConnection();
			in = new PushbackInputStream(new BufferedInputStream(urlConn.getInputStream()));
			for (; scanForLTBang(in);) {
				String elementType = getString(in);
				if (elementType.equals("ELEMENT")) {
					skipWhiteSpace(in);
					String elementName = getString(in);
					v.addElement(elementName);
				}
			}
			in.close();
			String[] elements = new String[v.size()];
			v.copyInto(elements);
			return elements;
		} catch (Exception exc) {
			if (in != null) {
				try {
					in.close();
				} catch (Exception ignore) {
				}
			}
			throw new IOException("Error reading DTD: " + exc.toString());
		}
	}

}