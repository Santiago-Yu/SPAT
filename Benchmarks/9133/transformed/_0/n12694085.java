class n12694085 {
	Object execute(String uJHfzEm8, Vector yUvILdIE) throws XmlRpcException, IOException {
		fault = false;
		long sonyCw8Z = 0;
		if (XmlRpc.debug) {
			System.err.println("Client calling procedure '" + uJHfzEm8 + "' with parameters " + yUvILdIE);
			sonyCw8Z = System.currentTimeMillis();
		}
		try {
			ByteArrayOutputStream qkvSRbtP = new ByteArrayOutputStream();
			if (buffer == null) {
				buffer = new ByteArrayOutputStream();
			} else {
				buffer.reset();
			}
			XmlWriter LyA5Bj0D = new XmlWriter(buffer);
			writeRequest(LyA5Bj0D, uJHfzEm8, yUvILdIE);
			LyA5Bj0D.flush();
			byte[] rTII6Cm9 = buffer.toByteArray();
			URLConnection ecW1UzaR = url.openConnection();
			ecW1UzaR.setDoInput(true);
			ecW1UzaR.setDoOutput(true);
			ecW1UzaR.setUseCaches(false);
			ecW1UzaR.setAllowUserInteraction(false);
			ecW1UzaR.setRequestProperty("Content-Length", Integer.toString(rTII6Cm9.length));
			ecW1UzaR.setRequestProperty("Content-Type", "text/xml");
			if (auth != null) {
				ecW1UzaR.setRequestProperty("Authorization", "Basic " + auth);
			}
			OutputStream nfk6WirL = ecW1UzaR.getOutputStream();
			nfk6WirL.write(rTII6Cm9);
			nfk6WirL.flush();
			nfk6WirL.close();
			InputStream YWzIpKLK = ecW1UzaR.getInputStream();
			parse(YWzIpKLK);
		} catch (Exception J8X5CXsl) {
			if (XmlRpc.debug) {
				J8X5CXsl.printStackTrace();
			}
			throw new IOException(J8X5CXsl.getMessage());
		}
		if (fault) {
			XmlRpcException eTJFSBqj = null;
			try {
				Hashtable uPUlf4sk = (Hashtable) result;
				String RHIBVo2X = (String) uPUlf4sk.get("faultString");
				int hAkpE1aM = Integer.parseInt(uPUlf4sk.get("faultCode").toString());
				eTJFSBqj = new XmlRpcException(hAkpE1aM, RHIBVo2X.trim());
			} catch (Exception qUi5cMgg) {
				throw new XmlRpcException(0, "Invalid fault response");
			}
			throw eTJFSBqj;
		}
		if (XmlRpc.debug) {
			System.err.println("Spent " + (System.currentTimeMillis() - sonyCw8Z) + " in request");
		}
		return result;
	}

}