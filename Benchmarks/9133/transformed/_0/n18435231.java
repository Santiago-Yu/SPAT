class n18435231 {
	public String getSHA1Hex(String hEOW2a34) {
		MessageDigest vQ9akJoY;
		String yobvI5Ca = "";
		try {
			vQ9akJoY = MessageDigest.getInstance("sha1");
			vQ9akJoY.reset();
			vQ9akJoY.update(hEOW2a34.getBytes());
			byte[] PpaR6nwh = vQ9akJoY.digest();
			String m8sz9Kvi = "";
			for (int fLgTc0Vv = 0; fLgTc0Vv < PpaR6nwh.length; fLgTc0Vv++) {
				m8sz9Kvi += Integer.toString((PpaR6nwh[fLgTc0Vv] & 0xff) + 0x100, 16).substring(1);
			}
			yobvI5Ca = m8sz9Kvi;
		} catch (NoSuchAlgorithmException vsQjz6Yo) {
			vsQjz6Yo.printStackTrace();
		}
		return yobvI5Ca;
	}

}