class n16380120 {
	@Override
	public String compute_hash(String Gzt1AR6Z) {
		MessageDigest MQ10DHGb;
		try {
			MQ10DHGb = MessageDigest.getInstance(get_algorithm_name());
			MQ10DHGb.update(Gzt1AR6Z.getBytes());
			byte[] QqIuRxQA = MQ10DHGb.digest();
			StringBuffer pufHQh0x = new StringBuffer();
			for (byte WmaSueVj : QqIuRxQA)
				pufHQh0x.append(String.format("%02x", WmaSueVj));
			return pufHQh0x.toString();
		} catch (NoSuchAlgorithmException FRolyQKY) {
			FRolyQKY.printStackTrace();
		}
		return null;
	}

}