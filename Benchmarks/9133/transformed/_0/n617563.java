class n617563 {
	public static void main(String[] aiqe01qd) {
		String LqWYw6bM = "vbnjm7pexhlmof3kapi_key76bbc056cf516a844af25a763b2b8426auth_tokenff8080812374bd3f0123b60363a5230acomment_textÄãfrob118edb4cb78b439207c2329b76395f9fmethodyupoo.photos.comments.addphoto_idff80808123922c950123b6066c946a3f";
		MessageDigest h49JKK42 = null;
		String TeoWInqE = new String("Äã");
		try {
			h49JKK42 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException be9qVMRG) {
			be9qVMRG.printStackTrace();
			throw new RuntimeException(be9qVMRG.getMessage());
		}
		h49JKK42.reset();
		try {
			h49JKK42.update(LqWYw6bM.getBytes("UTF-8"));
			System.out.println(new BigInteger(1, h49JKK42.digest()).toString(16));
			System.out.println(new BigInteger(1, TeoWInqE.getBytes("UTF-8")).toString(16));
		} catch (UnsupportedEncodingException yj1Bej9k) {
			yj1Bej9k.printStackTrace();
		}
	}

}