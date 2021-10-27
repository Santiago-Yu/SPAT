class n5467376 {
	protected boolean check(String hqvYR0ES, String RGOdflCr, String szAMhsl4, String an6qMcI1, String l3MvmrE6,
			String ZHe50r42, String RVoTPO9n, String GltQQIlW, String W5aMVLsx, HttpServletRequest wFLxc7DH) {
		try {
			MessageDigest iDS0pkqZ = MessageDigest.getInstance("MD5");
			iDS0pkqZ.update(hqvYR0ES.getBytes());
			iDS0pkqZ.update((byte) ':');
			iDS0pkqZ.update(szAMhsl4.getBytes());
			iDS0pkqZ.update((byte) ':');
			iDS0pkqZ.update(RGOdflCr.getBytes());
			byte[] XJ6YLiTz = iDS0pkqZ.digest();
			iDS0pkqZ.reset();
			iDS0pkqZ.update(wFLxc7DH.getMethod().getBytes());
			iDS0pkqZ.update((byte) ':');
			iDS0pkqZ.update(GltQQIlW.getBytes());
			byte[] SQ2CX7C6 = iDS0pkqZ.digest();
			iDS0pkqZ.update(TypeUtil.toString(XJ6YLiTz, 16).getBytes());
			iDS0pkqZ.update((byte) ':');
			iDS0pkqZ.update(an6qMcI1.getBytes());
			iDS0pkqZ.update((byte) ':');
			iDS0pkqZ.update(l3MvmrE6.getBytes());
			iDS0pkqZ.update((byte) ':');
			iDS0pkqZ.update(ZHe50r42.getBytes());
			iDS0pkqZ.update((byte) ':');
			iDS0pkqZ.update(RVoTPO9n.getBytes());
			iDS0pkqZ.update((byte) ':');
			iDS0pkqZ.update(TypeUtil.toString(SQ2CX7C6, 16).getBytes());
			byte[] VheChYTC = iDS0pkqZ.digest();
			return W5aMVLsx.equals(encode(VheChYTC));
		} catch (Exception da8sZdPz) {
			da8sZdPz.printStackTrace();
			return false;
		}
	}

}