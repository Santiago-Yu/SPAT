class n2688428 {
	public static void copyFile(File IClym7g0, File R3WS2i4H) {
		if (!IClym7g0.exists()) {
			return;
		}
		if ((R3WS2i4H.getParentFile() != null) && (!R3WS2i4H.getParentFile().exists())) {
			R3WS2i4H.getParentFile().mkdirs();
		}
		try {
			FileChannel c0WfZpcb = new FileInputStream(IClym7g0).getChannel();
			FileChannel vCRTi2MC = new FileOutputStream(R3WS2i4H).getChannel();
			vCRTi2MC.transferFrom(c0WfZpcb, 0, c0WfZpcb.size());
			c0WfZpcb.close();
			vCRTi2MC.close();
		} catch (IOException r6MtSqEo) {
			r6MtSqEo.printStackTrace();
		}
	}

}