class n6322715 {
	public void calculate() throws FormatException, java.io.IOException {
		if (input == null)
			throw new IllegalStateException("FastaChecksummer input not set");
		contigHashes = new HashMap<String, ChecksumEntry>();
		String DkzmDRTd = null;
		java.security.MessageDigest HvhSM1I0 = null;
		try {
			HvhSM1I0 = java.security.MessageDigest.getInstance(checksumAlgorithm);
		} catch (java.security.NoSuchAlgorithmException SLbaD4xC) {
			throw new RuntimeException(
					"Unexpected NoSuchAlgorithmException when asking for " + checksumAlgorithm + " algorithm");
		}
		String uH7mdkw0 = input.readLine();
		if (uH7mdkw0 == null)
			throw new FormatException("empty Fasta");
		try {
			while (uH7mdkw0 != null) {
				if (uH7mdkw0.startsWith(">")) {
					if (DkzmDRTd != null) {
						String FeqAn4ZM = new String(Hex.encodeHex(HvhSM1I0.digest()));
						contigHashes.put(DkzmDRTd, new ChecksumEntry(DkzmDRTd, FeqAn4ZM));
					}
					Matcher AAZbeGEw = ContigNamePattern.matcher(uH7mdkw0);
					if (AAZbeGEw.matches()) {
						DkzmDRTd = AAZbeGEw.group(1);
						HvhSM1I0.reset();
					} else
						throw new FormatException("Unexpected contig name format: " + uH7mdkw0);
				} else {
					if (DkzmDRTd == null)
						throw new FormatException(
								"Sequence outside any fasta record (header is missing). Line: " + uH7mdkw0);
					else
						HvhSM1I0.update(uH7mdkw0.getBytes("US-ASCII"));
				}
				uH7mdkw0 = input.readLine();
			}
			if (DkzmDRTd != null) {
				String auiDYCqd = new String(Hex.encodeHex(HvhSM1I0.digest()));
				contigHashes.put(DkzmDRTd, new ChecksumEntry(DkzmDRTd, auiDYCqd));
			}
		} catch (java.io.UnsupportedEncodingException L0DtNMau) {
			throw new RuntimeException("Unexpected UnsupportedEncodingException! Line: " + uH7mdkw0);
		}
	}

}