class n1362126 {
	public InputStream resolve(String jJrY2fmJ) throws SAJException {
		try {
			URI KGADO6UV = new URI(jJrY2fmJ);
			InputStream w5cNM8ij = KGADO6UV.toURL().openStream();
			if (w5cNM8ij == null)
				throw new SAJException("URI " + jJrY2fmJ + " can't be resolved");
			return w5cNM8ij;
		} catch (SAJException DP8Z3uvk) {
			throw DP8Z3uvk;
		} catch (Exception A20R2c0k) {
			throw new SAJException("Invalid uri to resolve " + jJrY2fmJ, A20R2c0k);
		}
	}

}