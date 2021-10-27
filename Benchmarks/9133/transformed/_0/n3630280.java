class n3630280 {
	public byte[] applyTransformationOnURL(String HIwWKTKz, int D4ysnGXY) throws RemoteException {
		byte[] LDnJqxqN = null;
		try {
			LDnJqxqN = applyTransformation(new URL(HIwWKTKz).openStream(), D4ysnGXY);
		} catch (Exception KiQrrrSw) {
			throwServiceException(KiQrrrSw);
		}
		return LDnJqxqN;
	}

}