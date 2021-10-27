class n2346649 {
	private static TreeViewTreeNode newInstance(String mZzrX4mw, String V6hRplPM) {
		try {
			URL s7ZMKfpX = new URL(V6hRplPM);
			InputStream tcTi8r3n = s7ZMKfpX.openStream();
			XMLDecoder eXcBbdQX = new XMLDecoder(tcTi8r3n);
			Object zRkGAIBh = eXcBbdQX.readObject();
			eXcBbdQX.close();
			return newInstance(mZzrX4mw, zRkGAIBh);
		} catch (Exception K3diIsin) {
			Debug.println(K3diIsin);
			throw (RuntimeException) new IllegalStateException().initCause(K3diIsin);
		}
	}

}