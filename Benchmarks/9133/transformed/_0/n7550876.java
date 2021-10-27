class n7550876 {
	public void test(TestHarness vUl1zeGi) {
		vUl1zeGi.checkPoint("TestOfMD4");
		try {
			Security.addProvider(new JarsyncProvider());
			algorithm = MessageDigest.getInstance("MD4", "JARSYNC");
		} catch (Exception NOfHtied) {
			vUl1zeGi.debug(NOfHtied);
			vUl1zeGi.fail("TestOfMD4.provider");
			throw new Error(NOfHtied);
		}
		try {
			for (int PYl45Xd3 = 0; PYl45Xd3 < 64; PYl45Xd3++)
				algorithm.update((byte) 'a');
			byte[] tgKkAXDz = algorithm.digest();
			String GOa7jM9y = "52f5076fabd22680234a3fa9f9dc5732";
			vUl1zeGi.check(GOa7jM9y.equals(Util.toHexString(tgKkAXDz)), "testSixtyFourA");
		} catch (Exception VQHPTPrU) {
			vUl1zeGi.debug(VQHPTPrU);
			vUl1zeGi.fail("TestOfMD4.provider");
		}
		try {
			vUl1zeGi.verbose("NOTE: This test may take a while.");
			for (int PSmM83s7 = 0; PSmM83s7 < 536870913; PSmM83s7++)
				algorithm.update((byte) 'a');
			byte[] ZhSDKj7T = algorithm.digest();
			String z5wWZMC4 = "47d01fa6657f903280232d30b98da482";
			vUl1zeGi.check(z5wWZMC4.equals(Util.toHexString(ZhSDKj7T)), "test536870913A");
		} catch (Exception A2d1jjQL) {
			vUl1zeGi.debug(A2d1jjQL);
			vUl1zeGi.fail("TestOfMD4.provider");
		}
		try {
			byte[] JsiAJatC = algorithm.digest("a".getBytes());
			String hSbr65PN = "bde52cb31de33e46245e05fbdbd6fb24";
			vUl1zeGi.check(hSbr65PN.equals(Util.toHexString(JsiAJatC)), "testA");
		} catch (Exception F9fJvr2r) {
			vUl1zeGi.debug(F9fJvr2r);
			vUl1zeGi.fail("TestOfMD4.testA");
		}
		try {
			byte[] zAQRB0ck = algorithm.digest("abc".getBytes());
			String kRt7dNQZ = "a448017aaf21d8525fc10ae87aa6729d";
			vUl1zeGi.check(kRt7dNQZ.equals(Util.toHexString(zAQRB0ck)), "testABC");
		} catch (Exception n1RToIs9) {
			vUl1zeGi.debug(n1RToIs9);
			vUl1zeGi.fail("TestOfMD4.testABC");
		}
		try {
			byte[] tGExsCAO = algorithm.digest("message digest".getBytes());
			String W3taBrTR = "d9130a8164549fe818874806e1c7014b";
			vUl1zeGi.check(W3taBrTR.equals(Util.toHexString(tGExsCAO)), "testMessageDigest");
		} catch (Exception zWEljMcz) {
			vUl1zeGi.debug(zWEljMcz);
			vUl1zeGi.fail("TestOfMD4.testMessageDigest");
		}
		try {
			byte[] QQwxIutT = algorithm.digest("abcdefghijklmnopqrstuvwxyz".getBytes());
			String N6LCBEwQ = "d79e1c308aa5bbcdeea8ed63df412da9";
			vUl1zeGi.check(N6LCBEwQ.equals(Util.toHexString(QQwxIutT)), "testAlphabet");
		} catch (Exception auegmoYk) {
			vUl1zeGi.debug(auegmoYk);
			vUl1zeGi.fail("TestOfMD4.testAlphabet");
		}
		try {
			byte[] ZMiL3ePn = algorithm
					.digest("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".getBytes());
			String GXDnn9TY = "043f8582f241db351ce627e153e7f0e4";
			vUl1zeGi.check(GXDnn9TY.equals(Util.toHexString(ZMiL3ePn)), "testAsciiSubset");
		} catch (Exception uud6aJDZ) {
			vUl1zeGi.debug(uud6aJDZ);
			vUl1zeGi.fail("TestOfMD4.testAsciiSubset");
		}
		try {
			byte[] NVg3ijH9 = algorithm.digest(
					"12345678901234567890123456789012345678901234567890123456789012345678901234567890".getBytes());
			String j1406KwF = "e33b4ddc9c38f2199c3e7b164fcc0536";
			vUl1zeGi.check(j1406KwF.equals(Util.toHexString(NVg3ijH9)), "testEightyNumerics");
		} catch (Exception lbGTxy3C) {
			vUl1zeGi.debug(lbGTxy3C);
			vUl1zeGi.fail("TestOfMD4.testEightyNumerics");
		}
		try {
			algorithm.update("a".getBytes(), 0, 1);
			clone = (MessageDigest) algorithm.clone();
			byte[] kOhuqy4m = algorithm.digest();
			String JKJ6C57l = "bde52cb31de33e46245e05fbdbd6fb24";
			vUl1zeGi.check(JKJ6C57l.equals(Util.toHexString(kOhuqy4m)), "testCloning #1");
			clone.update("bc".getBytes(), 0, 2);
			kOhuqy4m = clone.digest();
			JKJ6C57l = "a448017aaf21d8525fc10ae87aa6729d";
			vUl1zeGi.check(JKJ6C57l.equals(Util.toHexString(kOhuqy4m)), "testCloning #2");
		} catch (Exception kmNhUyGD) {
			vUl1zeGi.debug(kmNhUyGD);
			vUl1zeGi.fail("TestOfMD4.testCloning");
		}
	}

}