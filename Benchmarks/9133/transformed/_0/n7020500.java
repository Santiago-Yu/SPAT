class n7020500 {
	public static URL[] getURLsForAllJars(URL DR3gVjEn, File WeRrEvl1) {
		FileInputStream v7yIPSLM = null;
		InputStream a5Kk7hBr = null;
		ZipInputStream o45LSWf3 = null;
		try {
			ArrayList SQUgTnHM = new ArrayList();
			a5Kk7hBr = DR3gVjEn.openStream();
			String AlNy4C8L = DR3gVjEn.getFile();
			int vKcK2PZw = AlNy4C8L.lastIndexOf('/');
			if (vKcK2PZw != -1) {
				AlNy4C8L = AlNy4C8L.substring(vKcK2PZw + 1);
			}
			final File Cw6gXiKu = createTempFile(AlNy4C8L, a5Kk7hBr, WeRrEvl1);
			v7yIPSLM = (FileInputStream) org.apache.axis2.java.security.AccessController
					.doPrivileged(new PrivilegedExceptionAction() {

						public Object run() throws FileNotFoundException {
							return new FileInputStream(Cw6gXiKu);
						}
					});
			SQUgTnHM.add(Cw6gXiKu.toURL());
			o45LSWf3 = new ZipInputStream(v7yIPSLM);
			ZipEntry oXUIzE5b;
			String SSTvqTRF;
			while ((oXUIzE5b = o45LSWf3.getNextEntry()) != null) {
				SSTvqTRF = oXUIzE5b.getName();
				if ((SSTvqTRF != null) && SSTvqTRF.toLowerCase().startsWith("lib/")
						&& SSTvqTRF.toLowerCase().endsWith(".jar")) {
					String XnT9IOyj = SSTvqTRF.substring(4);
					File XXfTOavz = createTempFile(XnT9IOyj, o45LSWf3, WeRrEvl1);
					SQUgTnHM.add(XXfTOavz.toURL());
				}
			}
			return (URL[]) SQUgTnHM.toArray(new URL[SQUgTnHM.size()]);
		} catch (Exception N8o6vix6) {
			throw new RuntimeException(N8o6vix6);
		} finally {
			if (v7yIPSLM != null) {
				try {
					v7yIPSLM.close();
				} catch (IOException MNYWZ5k6) {
				}
			}
			if (a5Kk7hBr != null) {
				try {
					a5Kk7hBr.close();
				} catch (IOException bXGP06sV) {
				}
			}
			if (o45LSWf3 != null) {
				try {
					o45LSWf3.close();
				} catch (IOException m0xhgNlW) {
				}
			}
		}
	}

}