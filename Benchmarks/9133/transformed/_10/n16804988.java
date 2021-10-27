class n16804988 {
	public void init() {
		String filename = getParameter("filename");
		if (filename == null) {
			Error("Illegal filename");
			return;
		}
		Dimension dim = DEFAULT_SIZE;
		InputStream in;
		try {
			int w = Integer.parseInt(getParameter("width"));
			int h = Integer.parseInt(getParameter("height"));
			dim = new Dimension(w, h);
		} catch (Exception e) {
		}
		try {
			File ff = new File(filename);
			in = new FileInputStream(ff);
		} catch (Exception ignore) {
			try {
				URL url = new URL(filename);
				in = url.openStream();
			} catch (Exception e) {
				Error("Graph viewer: Failed to open: " + filename + "\n" + e);
				return;
			}
		}
		getContentPane().add(getWindow(in));
		resize(dim);
		repaint();
	}

}