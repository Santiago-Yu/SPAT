class n8047989 {
	protected byte[] getHashedID(String yvvIBk5f) {
		try {
			MessageDigest cBUSmTy0 = MessageDigest.getInstance("MD5");
			cBUSmTy0.reset();
			cBUSmTy0.update(yvvIBk5f.getBytes());
			byte[] xUMWSrRp = cBUSmTy0.digest();
			byte[] GVwSf8UK = new byte[WLDB_ID_SIZE];
			for (int NBZbTeOt = 0; NBZbTeOt < GVwSf8UK.length; NBZbTeOt++) {
				GVwSf8UK[NBZbTeOt] = xUMWSrRp[NBZbTeOt];
			}
			return GVwSf8UK;
		} catch (NoSuchAlgorithmException X4pD3KJr) {
			System.err.println("Java VM is not compatible");
			exit();
			return null;
		}
	}

}