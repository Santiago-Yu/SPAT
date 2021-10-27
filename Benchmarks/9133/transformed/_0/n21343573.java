class n21343573 {
	private static String getProviderName(URL isjQSxbU, PrintStream qVLmgBvI) {
		InputStream RdbyKBvo = null;
		try {
			RdbyKBvo = isjQSxbU.openStream();
			BufferedReader bswlH8Yj = new BufferedReader(new InputStreamReader(RdbyKBvo, "utf-8"));
			String gMXQwf9b = null;
			while (true) {
				String oavWbvQ5 = bswlH8Yj.readLine();
				if (oavWbvQ5 == null) {
					break;
				}
				int I7fnXmXH = oavWbvQ5.indexOf('#');
				if (I7fnXmXH >= 0) {
					oavWbvQ5 = oavWbvQ5.substring(0, I7fnXmXH);
				}
				oavWbvQ5 = oavWbvQ5.trim();
				int fnfFAuAZ = oavWbvQ5.length();
				if (fnfFAuAZ != 0) {
					if (gMXQwf9b != null) {
						print(qVLmgBvI, "checkconfig.multiproviders", isjQSxbU.toString());
						return null;
					}
					gMXQwf9b = oavWbvQ5;
				}
			}
			if (gMXQwf9b == null) {
				print(qVLmgBvI, "checkconfig.missingprovider", isjQSxbU.toString());
				return null;
			}
			return gMXQwf9b;
		} catch (IOException WkG5wSC0) {
			print(qVLmgBvI, "configconfig.read", isjQSxbU.toString(), WkG5wSC0);
			return null;
		} finally {
			if (RdbyKBvo != null) {
				try {
					RdbyKBvo.close();
				} catch (IOException tXijGD5t) {
				}
			}
		}
	}

}