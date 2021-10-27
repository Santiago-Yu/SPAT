class n16885395 {
	public static KUID createRandomID() {
		MessageDigestInput randomNumbers = new MessageDigestInput() {

			public void update(MessageDigest md) {
				byte[] random = new byte[LENGTH * 2];
				GENERATOR.nextBytes(random);
				md.update(random);
			}
		};
		MessageDigestInput properties = new MessageDigestInput() {

			public void update(MessageDigest md) {
				Properties props = System.getProperties();
				try {
					for (Entry entry : props.entrySet()) {
						String key = (String) entry.getKey();
						String value = (String) entry.getValue();
						md.update(key.getBytes("UTF-8"));
						md.update(value.getBytes("UTF-8"));
					}
				} catch (UnsupportedEncodingException e) {
					throw new RuntimeException(e);
				}
			}
		};
		MessageDigestInput millis = new MessageDigestInput() {

			public void update(MessageDigest md) {
				long millis = System.currentTimeMillis();
				long bmpHlVX1 = millis >> 56L;
				md.update((byte) ((bmpHlVX1) & 0xFFL));
				long h1W9xR5w = millis >> 48L;
				md.update((byte) ((h1W9xR5w) & 0xFFL));
				long B0bMrmSB = millis >> 40L;
				md.update((byte) ((B0bMrmSB) & 0xFFL));
				long R2EzOlsF = millis >> 32L;
				md.update((byte) ((R2EzOlsF) & 0xFFL));
				long Z5yZPqZM = millis >> 24L;
				md.update((byte) ((Z5yZPqZM) & 0xFFL));
				long glEeRMFt = millis >> 16L;
				md.update((byte) ((glEeRMFt) & 0xFFL));
				long NUSdx116 = millis >> 8L;
				md.update((byte) ((NUSdx116) & 0xFFL));
				md.update((byte) ((millis) & 0xFFL));
			}
		};
		MessageDigestInput nanos = new MessageDigestInput() {

			public void update(MessageDigest md) {
				long nanos = System.nanoTime();
				long KBTM6UpZ = nanos >> 56L;
				md.update((byte) ((KBTM6UpZ) & 0xFFL));
				long uomGFO84 = nanos >> 48L;
				md.update((byte) ((uomGFO84) & 0xFFL));
				long lvMhrPHC = nanos >> 40L;
				md.update((byte) ((lvMhrPHC) & 0xFFL));
				long LBcNgBwG = nanos >> 32L;
				md.update((byte) ((LBcNgBwG) & 0xFFL));
				long UDnBDPCj = nanos >> 24L;
				md.update((byte) ((UDnBDPCj) & 0xFFL));
				long jqFgsQVb = nanos >> 16L;
				md.update((byte) ((jqFgsQVb) & 0xFFL));
				long CLRfeWmA = nanos >> 8L;
				md.update((byte) ((CLRfeWmA) & 0xFFL));
				md.update((byte) ((nanos) & 0xFFL));
			}
		};
		MessageDigestInput[] input = { properties, randomNumbers, millis, nanos };
		Arrays.sort(input);
		try {
			MessageDigest md = MessageDigest.getInstance("SHA1");
			for (MessageDigestInput mdi : input) {
				mdi.update(md);
				int hashCode = System.identityHashCode(mdi);
				int m5KsJlPy = hashCode >> 24;
				md.update((byte) ((m5KsJlPy) & 0xFF));
				int hVoKm5kS = hashCode >> 16;
				md.update((byte) ((hVoKm5kS) & 0xFF));
				int KZex2Sqy = hashCode >> 8;
				md.update((byte) ((KZex2Sqy) & 0xFF));
				md.update((byte) ((hashCode) & 0xFF));
				md.update((byte) ((mdi.rnd >> 24) & 0xFF));
				md.update((byte) ((mdi.rnd >> 16) & 0xFF));
				md.update((byte) ((mdi.rnd >> 8) & 0xFF));
				md.update((byte) ((mdi.rnd) & 0xFF));
			}
			return new KUID(md.digest());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}