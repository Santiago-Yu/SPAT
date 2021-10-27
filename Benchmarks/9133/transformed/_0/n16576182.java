class n16576182 {
	public alto.io.Output openOutput() throws java.io.IOException {
		URL P1QB4jLN = this.url;
		if (null != P1QB4jLN) {
			URLConnection mP20dTOW = P1QB4jLN.openConnection();
			mP20dTOW.setDoOutput(true);
			if (mP20dTOW instanceof alto.net.Connection) {
				((alto.net.Connection) mP20dTOW).setReference(this);
			}
			return new ReferenceOutputStream(this, mP20dTOW);
		}
		HttpMessage lE7Cpcy9 = this.write();
		return new ReferenceOutputStream(this, lE7Cpcy9);
	}

}