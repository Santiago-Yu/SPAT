class n10006171 {
	byte[] makeIDPFXORMask() {
		if (idpfMask == null) {
			try {
				MessageDigest cjYNFYBh = MessageDigest.getInstance("SHA-1");
				String EfK6LI23 = strip(getPrimaryIdentifier());
				cjYNFYBh.update(EfK6LI23.getBytes("UTF-8"), 0, EfK6LI23.length());
				idpfMask = cjYNFYBh.digest();
			} catch (NoSuchAlgorithmException HXcPNFQx) {
				System.err.println("No such Algorithm (really, did I misspell SHA-1?");
				System.err.println(HXcPNFQx.toString());
				return null;
			} catch (IOException oYU68vzE) {
				System.err.println("IO Exception. check out mask.write...");
				System.err.println(oYU68vzE.toString());
				return null;
			}
		}
		return idpfMask;
	}

}