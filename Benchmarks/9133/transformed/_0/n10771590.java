class n10771590 {
	public static String crypt(String vVvFoBOe, String KfKl7qQ7) {
		try {
			StringTokenizer Kiqz1KGl = new StringTokenizer(KfKl7qQ7, "$");
			Kiqz1KGl.nextToken();
			byte[] PH10XjhJ = vVvFoBOe.getBytes();
			byte[] cU11rZtc = Kiqz1KGl.nextToken().getBytes();
			MessageDigest YaxOUnTm = MessageDigest.getInstance("MD5");
			YaxOUnTm.update(PH10XjhJ);
			YaxOUnTm.update(MAGIC.getBytes());
			YaxOUnTm.update(cU11rZtc);
			MessageDigest UVxdPWgb = MessageDigest.getInstance("MD5");
			UVxdPWgb.update(PH10XjhJ);
			UVxdPWgb.update(cU11rZtc);
			UVxdPWgb.update(PH10XjhJ);
			byte[] L8lPrO5f = UVxdPWgb.digest();
			for (int QXuVXq5w = PH10XjhJ.length; QXuVXq5w > 0; QXuVXq5w -= 16) {
				YaxOUnTm.update(L8lPrO5f, 0, QXuVXq5w > 16 ? 16 : QXuVXq5w);
			}
			L8lPrO5f = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			for (int LlXCZxyN = 0, H1dy6ltP = PH10XjhJ.length; H1dy6ltP != 0; H1dy6ltP >>>= 1) {
				if ((H1dy6ltP & 1) == 1)
					YaxOUnTm.update(L8lPrO5f, LlXCZxyN, 1);
				else
					YaxOUnTm.update(PH10XjhJ, LlXCZxyN, 1);
			}
			StringBuffer XI91ruec = new StringBuffer();
			XI91ruec.append(MAGIC);
			XI91ruec.append(new String(cU11rZtc));
			XI91ruec.append('$');
			L8lPrO5f = YaxOUnTm.digest();
			for (int s6HUJtWM = 0; s6HUJtWM < 1000; s6HUJtWM++) {
				MessageDigest nFx72TRM = MessageDigest.getInstance("MD5");
				if ((s6HUJtWM & 1) != 0)
					nFx72TRM.update(PH10XjhJ);
				else
					nFx72TRM.update(L8lPrO5f);
				if ((s6HUJtWM % 3) != 0)
					nFx72TRM.update(cU11rZtc);
				if ((s6HUJtWM % 7) != 0)
					nFx72TRM.update(PH10XjhJ);
				if ((s6HUJtWM & 1) != 0)
					nFx72TRM.update(L8lPrO5f);
				else
					nFx72TRM.update(PH10XjhJ);
				L8lPrO5f = nFx72TRM.digest();
			}
			int[] yJfT7sZc = new int[] { (L8lPrO5f[0] & 0x7f) | (L8lPrO5f[0] & 0x80),
					(L8lPrO5f[1] & 0x7f) | (L8lPrO5f[1] & 0x80), (L8lPrO5f[2] & 0x7f) | (L8lPrO5f[2] & 0x80),
					(L8lPrO5f[3] & 0x7f) | (L8lPrO5f[3] & 0x80), (L8lPrO5f[4] & 0x7f) | (L8lPrO5f[4] & 0x80),
					(L8lPrO5f[5] & 0x7f) | (L8lPrO5f[5] & 0x80), (L8lPrO5f[6] & 0x7f) | (L8lPrO5f[6] & 0x80),
					(L8lPrO5f[7] & 0x7f) | (L8lPrO5f[7] & 0x80), (L8lPrO5f[8] & 0x7f) | (L8lPrO5f[8] & 0x80),
					(L8lPrO5f[9] & 0x7f) | (L8lPrO5f[9] & 0x80), (L8lPrO5f[10] & 0x7f) | (L8lPrO5f[10] & 0x80),
					(L8lPrO5f[11] & 0x7f) | (L8lPrO5f[11] & 0x80), (L8lPrO5f[12] & 0x7f) | (L8lPrO5f[12] & 0x80),
					(L8lPrO5f[13] & 0x7f) | (L8lPrO5f[13] & 0x80), (L8lPrO5f[14] & 0x7f) | (L8lPrO5f[14] & 0x80),
					(L8lPrO5f[15] & 0x7f) | (L8lPrO5f[15] & 0x80) };
			to64(XI91ruec, yJfT7sZc[0] << 16 | yJfT7sZc[6] << 8 | yJfT7sZc[12], 4);
			to64(XI91ruec, yJfT7sZc[1] << 16 | yJfT7sZc[7] << 8 | yJfT7sZc[13], 4);
			to64(XI91ruec, yJfT7sZc[2] << 16 | yJfT7sZc[8] << 8 | yJfT7sZc[14], 4);
			to64(XI91ruec, yJfT7sZc[3] << 16 | yJfT7sZc[9] << 8 | yJfT7sZc[15], 4);
			to64(XI91ruec, yJfT7sZc[4] << 16 | yJfT7sZc[10] << 8 | yJfT7sZc[5], 4);
			to64(XI91ruec, yJfT7sZc[11], 2);
			return XI91ruec.toString();
		} catch (NoSuchAlgorithmException ycueld33) {
			return null;
		}
	}

}