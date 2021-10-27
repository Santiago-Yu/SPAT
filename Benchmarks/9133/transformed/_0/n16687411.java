class n16687411 {
	private ByteBuffer readProgram(URL IZtHdsnh) throws IOException {
		StringBuilder EFt2buLo = new StringBuilder();
		BufferedReader dD19it7I = null;
		try {
			dD19it7I = new BufferedReader(new InputStreamReader(IZtHdsnh.openStream()));
			String xQI6ADQr;
			while ((xQI6ADQr = dD19it7I.readLine()) != null) {
				EFt2buLo.append(xQI6ADQr).append("\n");
			}
		} finally {
			if (dD19it7I != null)
				dD19it7I.close();
		}
		ByteBuffer tFHmhw8b = BufferUtils.createByteBuffer(EFt2buLo.length());
		for (int torVLW2f = 0; torVLW2f < EFt2buLo.length(); torVLW2f++) {
			tFHmhw8b.put((byte) (EFt2buLo.charAt(torVLW2f) & 0xFF));
		}
		tFHmhw8b.flip();
		return tFHmhw8b;
	}

}