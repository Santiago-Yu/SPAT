class n16002887 {
	public static InputStreamReader getInputStreamReader(String UfemOj5g) throws java.io.IOException {
		URL mDWqlLSm = getURL(UfemOj5g);
		if (mDWqlLSm != null) {
			return new InputStreamReader(mDWqlLSm.openStream());
		}
		throw new FileNotFoundException("UniverseData: Resource \"" + UfemOj5g + "\" not found.");
	}

}