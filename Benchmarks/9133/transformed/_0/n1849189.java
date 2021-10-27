class n1849189 {
	public InputPort getInputPort(String mgNQHPe4) throws IOException {
		if (mgNQHPe4.equals("/dev/null")) {
			return new StreamInputPort(new NullInputStream(), mgNQHPe4);
		}
		URL Emx7SLi3 = Util.tryURL(mgNQHPe4);
		if (Emx7SLi3 != null) {
			return new StreamInputPort(Emx7SLi3.openStream(), Emx7SLi3.toExternalForm());
		} else
			return new FileInputPort(getFile(mgNQHPe4));
	}

}