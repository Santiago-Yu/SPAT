class n13309014 {
	public String[] getElements() throws IOException {
		PushbackInputStream in = null;
		Vector v = new Vector();
		try {
			URLConnection urlConn = dtdURL.openConnection();
			in = new PushbackInputStream(new BufferedInputStream(urlConn.getInputStream()));
			while (scanForLTBang(in)) {
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
			throw new IOException("Error reading DTD: " + exc.toString());
			if (in != null) {
				try {
					in.close();
				} catch (Exception ignore) {
				}
			}
		}
	}

}