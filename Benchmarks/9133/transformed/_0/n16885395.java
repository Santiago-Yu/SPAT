class n16885395 {
	public static KUID createRandomID() {
		MessageDigestInput pC3rbMbZ = new MessageDigestInput() {

			public void update(MessageDigest m6ye8Lvs) {
				byte[] tWO2DA7q = new byte[LENGTH * 2];
				GENERATOR.nextBytes(tWO2DA7q);
				m6ye8Lvs.update(tWO2DA7q);
			}
		};
		MessageDigestInput hHIa1O98 = new MessageDigestInput() {

			public void update(MessageDigest YTx52Zrh) {
				Properties wOE542R4 = System.getProperties();
				try {
					for (Entry jEZUnZeB : wOE542R4.entrySet()) {
						String QuAftTNQ = (String) jEZUnZeB.getKey();
						String KZMbYgW1 = (String) jEZUnZeB.getValue();
						YTx52Zrh.update(QuAftTNQ.getBytes("UTF-8"));
						YTx52Zrh.update(KZMbYgW1.getBytes("UTF-8"));
					}
				} catch (UnsupportedEncodingException kVXGT6Ig) {
					throw new RuntimeException(kVXGT6Ig);
				}
			}
		};
		MessageDigestInput rS4iC41C = new MessageDigestInput() {

			public void update(MessageDigest FIarmN2o) {
				long Mbh0BKH6 = System.currentTimeMillis();
				FIarmN2o.update((byte) ((Mbh0BKH6 >> 56L) & 0xFFL));
				FIarmN2o.update((byte) ((Mbh0BKH6 >> 48L) & 0xFFL));
				FIarmN2o.update((byte) ((Mbh0BKH6 >> 40L) & 0xFFL));
				FIarmN2o.update((byte) ((Mbh0BKH6 >> 32L) & 0xFFL));
				FIarmN2o.update((byte) ((Mbh0BKH6 >> 24L) & 0xFFL));
				FIarmN2o.update((byte) ((Mbh0BKH6 >> 16L) & 0xFFL));
				FIarmN2o.update((byte) ((Mbh0BKH6 >> 8L) & 0xFFL));
				FIarmN2o.update((byte) ((Mbh0BKH6) & 0xFFL));
			}
		};
		MessageDigestInput NbOStlj3 = new MessageDigestInput() {

			public void update(MessageDigest eDgwafQe) {
				long rh2vTc70 = System.nanoTime();
				eDgwafQe.update((byte) ((rh2vTc70 >> 56L) & 0xFFL));
				eDgwafQe.update((byte) ((rh2vTc70 >> 48L) & 0xFFL));
				eDgwafQe.update((byte) ((rh2vTc70 >> 40L) & 0xFFL));
				eDgwafQe.update((byte) ((rh2vTc70 >> 32L) & 0xFFL));
				eDgwafQe.update((byte) ((rh2vTc70 >> 24L) & 0xFFL));
				eDgwafQe.update((byte) ((rh2vTc70 >> 16L) & 0xFFL));
				eDgwafQe.update((byte) ((rh2vTc70 >> 8L) & 0xFFL));
				eDgwafQe.update((byte) ((rh2vTc70) & 0xFFL));
			}
		};
		MessageDigestInput[] g8pQiSlH = { hHIa1O98, pC3rbMbZ, rS4iC41C, NbOStlj3 };
		Arrays.sort(g8pQiSlH);
		try {
			MessageDigest NTWFCYpa = MessageDigest.getInstance("SHA1");
			for (MessageDigestInput nSJg1lov : g8pQiSlH) {
				nSJg1lov.update(NTWFCYpa);
				int EoUTUFPL = System.identityHashCode(nSJg1lov);
				NTWFCYpa.update((byte) ((EoUTUFPL >> 24) & 0xFF));
				NTWFCYpa.update((byte) ((EoUTUFPL >> 16) & 0xFF));
				NTWFCYpa.update((byte) ((EoUTUFPL >> 8) & 0xFF));
				NTWFCYpa.update((byte) ((EoUTUFPL) & 0xFF));
				NTWFCYpa.update((byte) ((nSJg1lov.rnd >> 24) & 0xFF));
				NTWFCYpa.update((byte) ((nSJg1lov.rnd >> 16) & 0xFF));
				NTWFCYpa.update((byte) ((nSJg1lov.rnd >> 8) & 0xFF));
				NTWFCYpa.update((byte) ((nSJg1lov.rnd) & 0xFF));
			}
			return new KUID(NTWFCYpa.digest());
		} catch (NoSuchAlgorithmException V7hu6wbl) {
			throw new RuntimeException(V7hu6wbl);
		}
	}

}