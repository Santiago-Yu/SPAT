class n19687731 {
	public static ByteBuffer readShaderBinary(Class ug8GlUAm, String JN66RFKk) {
		try {
			URL W6NjNuiO = Locator.getResource(ug8GlUAm, JN66RFKk);
			if (W6NjNuiO == null) {
				return null;
			}
			return StreamUtil.readAll2Buffer(new BufferedInputStream(W6NjNuiO.openStream()));
		} catch (IOException FXPxPFqe) {
			throw new RuntimeException(FXPxPFqe);
		}
	}

}