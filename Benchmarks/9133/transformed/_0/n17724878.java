class n17724878 {
	public byte[] getDigest(OMProcessingInstruction hF4QBFIB, String BjUvZSII) throws OMException {
		byte[] Z8VbG8KL = new byte[0];
		try {
			MessageDigest RU3KgX5d = MessageDigest.getInstance(BjUvZSII);
			RU3KgX5d.update((byte) 0);
			RU3KgX5d.update((byte) 0);
			RU3KgX5d.update((byte) 0);
			RU3KgX5d.update((byte) 7);
			RU3KgX5d.update(hF4QBFIB.getTarget().getBytes("UnicodeBigUnmarked"));
			RU3KgX5d.update((byte) 0);
			RU3KgX5d.update((byte) 0);
			RU3KgX5d.update(hF4QBFIB.getValue().getBytes("UnicodeBigUnmarked"));
			Z8VbG8KL = RU3KgX5d.digest();
		} catch (NoSuchAlgorithmException z0XcGxyA) {
			throw new OMException(z0XcGxyA);
		} catch (UnsupportedEncodingException v3yo9F7o) {
			throw new OMException(v3yo9F7o);
		}
		return Z8VbG8KL;
	}

}