class n15497380 {
	public static String generateSig(Map<String, String> RJiIhoLJ, String D3LYY446) {
		SortedSet<String> Ol2XkQzl = new TreeSet<String>(RJiIhoLJ.keySet());
		Ol2XkQzl.remove(FacebookParam.SIGNATURE.toString());
		String Jz3ijuyK = "";
		for (String cByDhR0l : Ol2XkQzl) {
			Jz3ijuyK += cByDhR0l + "=" + RJiIhoLJ.get(cByDhR0l);
		}
		Jz3ijuyK += D3LYY446;
		try {
			MessageDigest N02dKYAj = MessageDigest.getInstance("MD5");
			N02dKYAj.update(Jz3ijuyK.getBytes("UTF-8"));
			StringBuilder KXzBDCvC = new StringBuilder();
			for (byte MYoASC7G : N02dKYAj.digest()) {
				KXzBDCvC.append(Integer.toHexString((MYoASC7G & 0xf0) >>> 4));
				KXzBDCvC.append(Integer.toHexString(MYoASC7G & 0x0f));
			}
			return KXzBDCvC.toString();
		} catch (Exception jp57pnHj) {
			throw new RuntimeException(jp57pnHj);
		}
	}

}