class n7550876 {
	public void test(TestHarness harness) {
		harness.checkPoint("TestOfMD4");
		try {
			Security.addProvider(new JarsyncProvider());
			algorithm = MessageDigest.getInstance("MD4", "JARSYNC");
		} catch (Exception x) {
			harness.debug(x);
			harness.fail("TestOfMD4.provider");
			throw new Error(x);
		}
		try {
			for (int i = 0; i < 64; i++)
				algorithm.update((byte) 'a');
			String exp = "52f5076fabd22680234a3fa9f9dc5732";
			byte[] md = algorithm.digest();
			harness.check(exp.equals(Util.toHexString(md)), "testSixtyFourA");
		} catch (Exception x) {
			harness.debug(x);
			harness.fail("TestOfMD4.provider");
		}
		try {
			harness.verbose("NOTE: This test may take a while.");
			for (int i = 0; i < 536870913; i++)
				algorithm.update((byte) 'a');
			String exp = "47d01fa6657f903280232d30b98da482";
			byte[] md = algorithm.digest();
			harness.check(exp.equals(Util.toHexString(md)), "test536870913A");
		} catch (Exception x) {
			harness.debug(x);
			harness.fail("TestOfMD4.provider");
		}
		try {
			String exp = "bde52cb31de33e46245e05fbdbd6fb24";
			byte[] md = algorithm.digest("a".getBytes());
			harness.check(exp.equals(Util.toHexString(md)), "testA");
		} catch (Exception x) {
			harness.debug(x);
			harness.fail("TestOfMD4.testA");
		}
		try {
			String exp = "a448017aaf21d8525fc10ae87aa6729d";
			byte[] md = algorithm.digest("abc".getBytes());
			harness.check(exp.equals(Util.toHexString(md)), "testABC");
		} catch (Exception x) {
			harness.debug(x);
			harness.fail("TestOfMD4.testABC");
		}
		try {
			String exp = "d9130a8164549fe818874806e1c7014b";
			byte[] md = algorithm.digest("message digest".getBytes());
			harness.check(exp.equals(Util.toHexString(md)), "testMessageDigest");
		} catch (Exception x) {
			harness.debug(x);
			harness.fail("TestOfMD4.testMessageDigest");
		}
		try {
			String exp = "d79e1c308aa5bbcdeea8ed63df412da9";
			byte[] md = algorithm.digest("abcdefghijklmnopqrstuvwxyz".getBytes());
			harness.check(exp.equals(Util.toHexString(md)), "testAlphabet");
		} catch (Exception x) {
			harness.debug(x);
			harness.fail("TestOfMD4.testAlphabet");
		}
		try {
			String exp = "043f8582f241db351ce627e153e7f0e4";
			byte[] md = algorithm.digest("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".getBytes());
			harness.check(exp.equals(Util.toHexString(md)), "testAsciiSubset");
		} catch (Exception x) {
			harness.debug(x);
			harness.fail("TestOfMD4.testAsciiSubset");
		}
		try {
			String exp = "e33b4ddc9c38f2199c3e7b164fcc0536";
			byte[] md = algorithm.digest(
					"12345678901234567890123456789012345678901234567890123456789012345678901234567890".getBytes());
			harness.check(exp.equals(Util.toHexString(md)), "testEightyNumerics");
		} catch (Exception x) {
			harness.debug(x);
			harness.fail("TestOfMD4.testEightyNumerics");
		}
		try {
			algorithm.update("a".getBytes(), 0, 1);
			clone = (MessageDigest) algorithm.clone();
			String exp = "bde52cb31de33e46245e05fbdbd6fb24";
			byte[] md = algorithm.digest();
			harness.check(exp.equals(Util.toHexString(md)), "testCloning #1");
			clone.update("bc".getBytes(), 0, 2);
			exp = "a448017aaf21d8525fc10ae87aa6729d";
			md = clone.digest();
			harness.check(exp.equals(Util.toHexString(md)), "testCloning #2");
		} catch (Exception x) {
			harness.debug(x);
			harness.fail("TestOfMD4.testCloning");
		}
	}

}