class n923861 {
	public static void main(String yqzxBajb[]) {
		InputStream i8f5Pb48 = System.in;
		OutputStream UXImklUT = System.out;
		if (yqzxBajb.length > 0) {
			try {
				i8f5Pb48 = new FileInputStream(yqzxBajb[0]);
			} catch (FileNotFoundException wHUlHnLM) {
				System.err.println("Unable to open file: " + yqzxBajb[0]);
				System.exit(-1);
			} catch (IOException uUGKWHv6) {
				System.err.println("Unable to access file: " + yqzxBajb[0]);
				System.exit(-1);
			}
		}
		if (yqzxBajb.length > 1) {
			try {
				UXImklUT = new FileOutputStream(yqzxBajb[1]);
			} catch (FileNotFoundException VOe1Ixeo) {
				System.err.println("Unable to open file: " + yqzxBajb[1]);
				System.exit(-1);
			} catch (IOException tWcEA2QK) {
				System.err.println("Unable to access file: " + yqzxBajb[1]);
				System.exit(-1);
			}
		}
		byte jLMV9Khu[] = new byte[512];
		int IYBnJ40Z;
		try {
			while ((IYBnJ40Z = i8f5Pb48.read(jLMV9Khu)) > 0)
				UXImklUT.write(jLMV9Khu, 0, IYBnJ40Z);
		} catch (IOException w2fvxdJ2) {
			System.err.println("Error copying file");
		} finally {
			i8f5Pb48.close();
			UXImklUT.close();
		}
	}

}