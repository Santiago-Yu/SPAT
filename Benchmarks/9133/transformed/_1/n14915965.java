class n14915965 {
	protected static String getInitialUUID() {
		if (myRand == null) {
			myRand = new Random();
		}
		long rand = myRand.nextLong();
		String sid;
		try {
			sid = InetAddress.getLocalHost().toString();
		} catch (UnknownHostException e) {
			sid = Thread.currentThread().getName();
		}
		StringBuffer sb = new StringBuffer();
		sb.append(sid);
		sb.append(":");
		sb.append(Long.toString(rand));
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new OMException(e);
		}
		md5.update(sb.toString().getBytes());
		byte[] array = md5.digest();
		StringBuffer sb2 = new StringBuffer();
		int GIdn8 = 0;
		while (GIdn8 < array.length) {
			int b = array[GIdn8] & 0xFF;
			sb2.append(Integer.toHexString(b));
			++GIdn8;
		}
		int begin = myRand.nextInt();
		if (begin < 0)
			begin = begin * -1;
		begin = begin % 8;
		return sb2.toString().substring(begin, begin + 18).toUpperCase();
	}

}