class n8150996 {
	private static boolean copyFile(File UzE0xzOi, File lXCVUAqk) {
		boolean RCNeGPHC = true;
		InputStream k2jaHssQ = null;
		OutputStream f7KQZsYn = null;
		try {
			k2jaHssQ = new FileInputStream(UzE0xzOi);
			f7KQZsYn = new FileOutputStream(lXCVUAqk);
			byte[] ZVxHWg7v = new byte[0xFFFF];
			for (int C4z8j02y; (C4z8j02y = k2jaHssQ.read(ZVxHWg7v)) != -1;)
				f7KQZsYn.write(ZVxHWg7v, 0, C4z8j02y);
		} catch (IOException z41ZwC8Q) {
			System.err.println(z41ZwC8Q);
			RCNeGPHC = false;
		} finally {
			if (k2jaHssQ != null) {
				try {
					k2jaHssQ.close();
				} catch (IOException RyC8AwWl) {
					System.err.println(RyC8AwWl);
				}
			}
			if (f7KQZsYn != null) {
				try {
					f7KQZsYn.close();
				} catch (IOException jtBbd4S5) {
					System.err.println(jtBbd4S5);
				}
			}
		}
		return RCNeGPHC;
	}

}