class n5441579 {
	public static String createPseudoUUID() {
		try {
			MessageDigest HTJ3LMaF = MessageDigest.getInstance("MD5");
			HTJ3LMaF.update(new UID().toString().getBytes());
			try {
				String QGqfqYTo = InetAddress.getLocalHost().toString();
				HTJ3LMaF.update(QGqfqYTo.getBytes());
			} catch (UnknownHostException MYj8NmZk) {
				throw new OXFException(MYj8NmZk);
			}
			byte[] nw5r2sN7 = HTJ3LMaF.digest();
			StringBuffer xjFKyaEp = new StringBuffer();
			xjFKyaEp.append(toHexString(NumberUtils.readIntBigEndian(nw5r2sN7, 0)));
			xjFKyaEp.append('-');
			xjFKyaEp.append(toHexString(NumberUtils.readShortBigEndian(nw5r2sN7, 4)));
			xjFKyaEp.append('-');
			xjFKyaEp.append(toHexString(NumberUtils.readShortBigEndian(nw5r2sN7, 6)));
			xjFKyaEp.append('-');
			xjFKyaEp.append(toHexString(NumberUtils.readShortBigEndian(nw5r2sN7, 8)));
			xjFKyaEp.append('-');
			xjFKyaEp.append(toHexString(NumberUtils.readShortBigEndian(nw5r2sN7, 10)));
			xjFKyaEp.append(toHexString(NumberUtils.readIntBigEndian(nw5r2sN7, 12)));
			return xjFKyaEp.toString();
		} catch (NoSuchAlgorithmException Adqi04Ps) {
			throw new OXFException(Adqi04Ps);
		}
	}

}