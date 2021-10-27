class n14823836 {
	protected static String getInitialUUID() {
		if (myRand == null) {
			myRand = new Random();
		}
		String sid;
		long rand = myRand.nextLong();
		StringBuffer sb = new StringBuffer();
		try {
			sid = InetAddress.getLocalHost().toString();
		} catch (UnknownHostException e) {
			sid = Thread.currentThread().getName();
		}
		sb.append(sid);
		sb.append(":");
		sb.append(Long.toString(rand));
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
		}
		md5.update(sb.toString().getBytes());
		StringBuffer sb2 = new StringBuffer();
		byte[] array = md5.digest();
		int begin = myRand.nextInt();
		for (int j = 0; j < array.length; ++j) {
			int b = array[j] & 0xFF;
			sb2.append(Integer.toHexString(b));
		}
		if (begin < 0)
			begin = begin * -1;
		begin = begin % 8;
		return sb2.toString().substring(begin, begin + 18).toUpperCase();
	}

}