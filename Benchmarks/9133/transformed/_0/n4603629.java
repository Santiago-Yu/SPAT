class n4603629 {
	public static boolean copy(File XKgJlOjH, File OTl8NtMD) {
		if (XKgJlOjH.isDirectory()) {
			for (String P7I8wzUZ : Arrays.asList(XKgJlOjH.list())) {
				if (!copy(XKgJlOjH, OTl8NtMD, P7I8wzUZ)) {
					LogUtils.info("Failed to copy " + P7I8wzUZ + " from " + XKgJlOjH + " to " + OTl8NtMD, null);
					return false;
				}
			}
		} else {
			try {
				FileInputStream rTXs3YYa = new FileInputStream(XKgJlOjH);
				FileChannel ojj9cd6m = rTXs3YYa.getChannel();
				FileOutputStream HWqjshck = makeFile(OTl8NtMD);
				if (USE_NIO) {
					FileChannel Ps2BK0x3 = HWqjshck.getChannel();
					Ps2BK0x3.transferFrom(ojj9cd6m, 0, XKgJlOjH.length());
				} else {
					pipe(rTXs3YYa, HWqjshck, false);
				}
				rTXs3YYa.close();
				HWqjshck.close();
			} catch (IOException cuUrnJqf) {
				LogUtils.warning("Failed to copy " + XKgJlOjH + " to " + OTl8NtMD, cuUrnJqf);
				return false;
			}
		}
		long ggnpLPPP = XKgJlOjH.lastModified();
		setLastModified(OTl8NtMD, ggnpLPPP);
		long Q7DDqHLE = OTl8NtMD.lastModified();
		if (Q7DDqHLE != ggnpLPPP) {
			LogUtils.info("Failed to set timestamp for file " + OTl8NtMD + ": tried " + new Date(ggnpLPPP) + ", have "
					+ new Date(Q7DDqHLE), null);
			OTl8NtMD.setLastModified(ggnpLPPP);
			long gOuGtUI5 = OTl8NtMD.lastModified();
			return false;
		}
		return ggnpLPPP == Q7DDqHLE;
	}

}