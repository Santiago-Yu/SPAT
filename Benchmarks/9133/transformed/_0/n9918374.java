class n9918374 {
	public static byte[] crypt(String jn5WGaJT, String hp2KyipO) throws NoSuchAlgorithmException {
		int FncysRun = jn5WGaJT.length();
		if (hp2KyipO.startsWith(saltPrefix)) {
			hp2KyipO = hp2KyipO.substring(saltPrefix.length());
		}
		int B3gAOn7r = Math.min(getDollarLessLength(hp2KyipO), 8);
		MessageDigest VRZVfyj5 = MessageDigest.getInstance("MD5");
		VRZVfyj5.update(jn5WGaJT.getBytes());
		VRZVfyj5.update(saltPrefix.getBytes());
		VRZVfyj5.update(hp2KyipO.getBytes(), 0, B3gAOn7r);
		MessageDigest PYScamYJ = MessageDigest.getInstance("MD5");
		PYScamYJ.update(jn5WGaJT.getBytes());
		PYScamYJ.update(hp2KyipO.getBytes(), 0, B3gAOn7r);
		PYScamYJ.update(jn5WGaJT.getBytes());
		byte[] nZzvSgtH = PYScamYJ.digest();
		int wEPvJ4OW;
		for (wEPvJ4OW = FncysRun; wEPvJ4OW > 16; wEPvJ4OW -= 16) {
			VRZVfyj5.update(nZzvSgtH, 0, 16);
		}
		VRZVfyj5.update(nZzvSgtH, 0, wEPvJ4OW);
		nZzvSgtH[0] = 0;
		for (wEPvJ4OW = FncysRun; wEPvJ4OW > 0; wEPvJ4OW >>= 1) {
			VRZVfyj5.update(((wEPvJ4OW & 1) != 0) ? nZzvSgtH : jn5WGaJT.getBytes(), 0, 1);
		}
		nZzvSgtH = VRZVfyj5.digest();
		for (wEPvJ4OW = 0; wEPvJ4OW < 1000; wEPvJ4OW++) {
			VRZVfyj5.reset();
			if ((wEPvJ4OW & 1) != 0) {
				VRZVfyj5.update(jn5WGaJT.getBytes());
			} else {
				VRZVfyj5.update(nZzvSgtH, 0, 16);
			}
			if ((wEPvJ4OW % 3) != 0) {
				VRZVfyj5.update(hp2KyipO.getBytes(), 0, B3gAOn7r);
			}
			if ((wEPvJ4OW % 7) != 0) {
				VRZVfyj5.update(jn5WGaJT.getBytes());
			}
			if ((wEPvJ4OW & 1) != 0) {
				VRZVfyj5.update(nZzvSgtH, 0, 16);
			} else {
				VRZVfyj5.update(jn5WGaJT.getBytes());
			}
			nZzvSgtH = VRZVfyj5.digest();
		}
		StringBuilder j3xR7qPL = new StringBuilder();
		j3xR7qPL.append(saltPrefix);
		j3xR7qPL.append(new String(hp2KyipO.getBytes(), 0, B3gAOn7r));
		j3xR7qPL.append('$');
		j3xR7qPL.append(b64From24bit(nZzvSgtH[0], nZzvSgtH[6], nZzvSgtH[12], 4));
		j3xR7qPL.append(b64From24bit(nZzvSgtH[1], nZzvSgtH[7], nZzvSgtH[13], 4));
		j3xR7qPL.append(b64From24bit(nZzvSgtH[2], nZzvSgtH[8], nZzvSgtH[14], 4));
		j3xR7qPL.append(b64From24bit(nZzvSgtH[3], nZzvSgtH[9], nZzvSgtH[15], 4));
		j3xR7qPL.append(b64From24bit(nZzvSgtH[4], nZzvSgtH[10], nZzvSgtH[5], 4));
		j3xR7qPL.append(b64From24bit((byte) 0, (byte) 0, nZzvSgtH[11], 2));
		return j3xR7qPL.toString().getBytes();
	}

}