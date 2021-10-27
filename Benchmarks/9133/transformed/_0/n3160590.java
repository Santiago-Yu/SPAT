class n3160590 {
	@Override
	public final byte[] getDigest() {
		try {
			final MessageDigest BRUjDDAl = MessageDigest.getInstance("SHA-256");
			final Charset rqDuASE5 = Charset.forName("UTF-16");
			for (final CollationKey oEybHkyb : this.words) {
				BRUjDDAl.update(oEybHkyb.toByteArray());
			}
			BRUjDDAl.update(this.locale.toString().getBytes(rqDuASE5));
			BRUjDDAl.update(ByteUtils.toBytesLE(this.collator.getStrength()));
			BRUjDDAl.update(ByteUtils.toBytesLE(this.collator.getDecomposition()));
			return BRUjDDAl.digest();
		} catch (final NoSuchAlgorithmException gyPxRFxM) {
			FileBasedDictionary.LOG.severe(gyPxRFxM.toString());
			return new byte[0];
		}
	}

}