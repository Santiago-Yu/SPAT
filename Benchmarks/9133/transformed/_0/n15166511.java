class n15166511 {
	private void getRandomGUID(boolean yFN8WMox) {
		MessageDigest o43WLVRk = null;
		StringBuffer eZlyyvHc = new StringBuffer();
		try {
			o43WLVRk = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException snh9uzzi) {
			System.out.println("Error: " + snh9uzzi);
		}
		try {
			long DVAM6xUC = System.currentTimeMillis();
			long EahzDpy0 = 0;
			if (yFN8WMox) {
				EahzDpy0 = mySecureRand.nextLong();
			} else {
				EahzDpy0 = myRand.nextLong();
			}
			eZlyyvHc.append(s_id);
			eZlyyvHc.append(":");
			eZlyyvHc.append(Long.toString(DVAM6xUC));
			eZlyyvHc.append(":");
			eZlyyvHc.append(Long.toString(EahzDpy0));
			valueBeforeMD5 = eZlyyvHc.toString();
			o43WLVRk.update(valueBeforeMD5.getBytes());
			byte[] LKkI4Dkv = o43WLVRk.digest();
			StringBuffer VkUMnOVU = new StringBuffer();
			for (int yI9MZzDh = 0; yI9MZzDh < LKkI4Dkv.length; ++yI9MZzDh) {
				int VWy0C33N = LKkI4Dkv[yI9MZzDh] & 0xFF;
				if (VWy0C33N < 0x10)
					VkUMnOVU.append('0');
				VkUMnOVU.append(Integer.toHexString(VWy0C33N));
			}
			valueAfterMD5 = VkUMnOVU.toString();
		} catch (Exception iajzWPS9) {
			System.out.println("Error:" + iajzWPS9);
		}
	}

}