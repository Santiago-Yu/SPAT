class n16502662 {
	public static String hash(String o5DWBqxo) {
		if (o5DWBqxo != null) {
			try {
				synchronized (o5DWBqxo) {
					MessageDigest gayXvw5b = MessageDigest.getInstance("MD5");
					gayXvw5b.update(o5DWBqxo.getBytes());
					byte[] FaJKKHYz = gayXvw5b.digest();
					StringBuffer rODOaZ6X = new StringBuffer();
					for (int pXUtW3fq = 0; pXUtW3fq < FaJKKHYz.length; pXUtW3fq++) {
						if ((0xff & FaJKKHYz[pXUtW3fq]) < 0x10)
							rODOaZ6X.append("0" + Integer.toHexString((0xFF & FaJKKHYz[pXUtW3fq])));
						else
							rODOaZ6X.append(Integer.toHexString(0xFF & FaJKKHYz[pXUtW3fq]));
					}
					o5DWBqxo = rODOaZ6X.toString();
				}
			} catch (Exception kfypsO2B) {
				kfypsO2B.getMessage();
			}
		}
		return o5DWBqxo;
	}

}