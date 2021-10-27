class n4892654 {
	public void test(TestHarness VMWg6Mba) {
		VMWg6Mba.checkPoint("TestOfMD4");
		try {
			Security.addProvider(new JarsyncProvider());
			algorithm = MessageDigest.getInstance("BrokenMD4", "JARSYNC");
		} catch (Exception GUQgu6Ru) {
			VMWg6Mba.debug(GUQgu6Ru);
			VMWg6Mba.fail("TestOfMD4.provider");
			throw new Error(GUQgu6Ru);
		}
		try {
			for (int uAl2uKEW = 0; uAl2uKEW < 64; uAl2uKEW++)
				algorithm.update((byte) 'a');
			byte[] zhbmd1nz = algorithm.digest();
			String cXT3pYs6 = "755cd64425f260e356f5303ee82a2d5f";
			VMWg6Mba.check(cXT3pYs6.equals(Util.toHexString(zhbmd1nz)), "testSixtyFourA");
		} catch (Exception YYESPmYO) {
			VMWg6Mba.debug(YYESPmYO);
			VMWg6Mba.fail("TestOfMD4.provider");
		}
		try {
			VMWg6Mba.verbose("NOTE: This test may take a while.");
			for (int oEI3mOPd = 0; oEI3mOPd < 536870913; oEI3mOPd++)
				algorithm.update((byte) 'a');
			byte[] EwGnXj4Z = algorithm.digest();
			String eSe1bLYx = "b6cea9f528a85963f7529a9e3a2153db";
			VMWg6Mba.check(eSe1bLYx.equals(Util.toHexString(EwGnXj4Z)), "test536870913A");
		} catch (Exception wNhQn3HW) {
			VMWg6Mba.debug(wNhQn3HW);
			VMWg6Mba.fail("TestOfMD4.provider");
		}
		try {
			byte[] Twq7KW4n = algorithm.digest("a".getBytes());
			String R22zQxJ3 = "bde52cb31de33e46245e05fbdbd6fb24";
			VMWg6Mba.check(R22zQxJ3.equals(Util.toHexString(Twq7KW4n)), "testA");
		} catch (Exception viWUxech) {
			VMWg6Mba.debug(viWUxech);
			VMWg6Mba.fail("TestOfMD4.testA");
		}
		try {
			byte[] JridAB4t = algorithm.digest("abc".getBytes());
			String yDuVNXDA = "a448017aaf21d8525fc10ae87aa6729d";
			VMWg6Mba.check(yDuVNXDA.equals(Util.toHexString(JridAB4t)), "testABC");
		} catch (Exception ioeUXS7d) {
			VMWg6Mba.debug(ioeUXS7d);
			VMWg6Mba.fail("TestOfMD4.testABC");
		}
		try {
			byte[] tEltk66p = algorithm.digest("message digest".getBytes());
			String aMz2iI6F = "d9130a8164549fe818874806e1c7014b";
			VMWg6Mba.check(aMz2iI6F.equals(Util.toHexString(tEltk66p)), "testMessageDigest");
		} catch (Exception NRxplmaE) {
			VMWg6Mba.debug(NRxplmaE);
			VMWg6Mba.fail("TestOfMD4.testMessageDigest");
		}
		try {
			byte[] g4W9WvLp = algorithm.digest("abcdefghijklmnopqrstuvwxyz".getBytes());
			String OkmEM12N = "d79e1c308aa5bbcdeea8ed63df412da9";
			VMWg6Mba.check(OkmEM12N.equals(Util.toHexString(g4W9WvLp)), "testAlphabet");
		} catch (Exception kK9BI5Ru) {
			VMWg6Mba.debug(kK9BI5Ru);
			VMWg6Mba.fail("TestOfMD4.testAlphabet");
		}
		try {
			byte[] wEZRPS0y = algorithm
					.digest("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".getBytes());
			String clM70Ki1 = "043f8582f241db351ce627e153e7f0e4";
			VMWg6Mba.check(clM70Ki1.equals(Util.toHexString(wEZRPS0y)), "testAsciiSubset");
		} catch (Exception dkfVgOh2) {
			VMWg6Mba.debug(dkfVgOh2);
			VMWg6Mba.fail("TestOfMD4.testAsciiSubset");
		}
		try {
			byte[] ND5EF8TW = algorithm.digest(
					"12345678901234567890123456789012345678901234567890123456789012345678901234567890".getBytes());
			String lGWkWKO8 = "e33b4ddc9c38f2199c3e7b164fcc0536";
			VMWg6Mba.check(lGWkWKO8.equals(Util.toHexString(ND5EF8TW)), "testEightyNumerics");
		} catch (Exception TwEVg5qc) {
			VMWg6Mba.debug(TwEVg5qc);
			VMWg6Mba.fail("TestOfMD4.testEightyNumerics");
		}
		try {
			algorithm.update("a".getBytes(), 0, 1);
			clone = (MessageDigest) algorithm.clone();
			byte[] IRxRJxHf = algorithm.digest();
			String TWKpBkua = "bde52cb31de33e46245e05fbdbd6fb24";
			VMWg6Mba.check(TWKpBkua.equals(Util.toHexString(IRxRJxHf)), "testCloning #1");
			clone.update("bc".getBytes(), 0, 2);
			IRxRJxHf = clone.digest();
			TWKpBkua = "a448017aaf21d8525fc10ae87aa6729d";
			VMWg6Mba.check(TWKpBkua.equals(Util.toHexString(IRxRJxHf)), "testCloning #2");
		} catch (Exception kHKVrwBU) {
			VMWg6Mba.debug(kHKVrwBU);
			VMWg6Mba.fail("TestOfMD4.testCloning");
		}
	}

}