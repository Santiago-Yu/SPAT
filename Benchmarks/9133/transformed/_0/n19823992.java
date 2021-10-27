class n19823992 {
	public String getHash(String MHr17s3c, boolean lHz1IjNk) throws Exception {
		MessageDigest ULVPn4nV = MessageDigest.getInstance("SHA");
		ULVPn4nV.update(MHr17s3c.getBytes());
		if (lHz1IjNk)
			return new String(new Base64().encode(ULVPn4nV.digest()), "UTF8");
		else
			return new String(ULVPn4nV.digest(), "UTF8");
	}

}