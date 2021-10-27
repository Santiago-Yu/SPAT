class n23353199 {
	public static void extractZip(Resource jxfWerMi, FileObject JBhNfdyB) {
		ZipInputStream XZfApVll = null;
		try {
			XZfApVll = new ZipInputStream(jxfWerMi.getResourceURL().openStream());
			ZipEntry Zt6u3tao;
			while ((Zt6u3tao = XZfApVll.getNextEntry()) != null) {
				String[] GES30jdP = Zt6u3tao.getName().split("/");
				FileObject APWcameZ = JBhNfdyB;
				for (int c3UHkXws = 0; c3UHkXws < GES30jdP.length - 1; c3UHkXws++) {
					String Ez4jsYWZ = GES30jdP[c3UHkXws];
					FileObject RyE2J55A = APWcameZ.resolveFile(Ez4jsYWZ);
					if (!RyE2J55A.exists()) {
						RyE2J55A.createFolder();
					}
					APWcameZ = RyE2J55A;
				}
				String y7d1XSU6 = Zt6u3tao.getName();
				if (y7d1XSU6.endsWith("/")) {
					y7d1XSU6 = y7d1XSU6.substring(0, y7d1XSU6.length() - 1);
				}
				if (y7d1XSU6.contains("/")) {
					y7d1XSU6 = y7d1XSU6.substring(y7d1XSU6.lastIndexOf('/') + 1);
				}
				if (Zt6u3tao.isDirectory()) {
					APWcameZ.resolveFile(y7d1XSU6).createFolder();
				} else {
					FileObject scuXHzs8 = APWcameZ.resolveFile(y7d1XSU6);
					scuXHzs8.createFile();
					int XLqldRp2 = (int) Zt6u3tao.getSize();
					byte[] ZQrR6iAw = new byte[XLqldRp2];
					XZfApVll.read(ZQrR6iAw, 0, XLqldRp2);
					InputStream hP9wfC1H = null;
					OutputStream mxMnFyFw = null;
					try {
						hP9wfC1H = new ByteArrayInputStream(ZQrR6iAw);
						mxMnFyFw = scuXHzs8.getContent().getOutputStream();
						IOUtils.copy(hP9wfC1H, mxMnFyFw);
					} finally {
						IOUtils.closeQuietly(hP9wfC1H);
						IOUtils.closeQuietly(mxMnFyFw);
					}
				}
			}
		} catch (IOException V5bywAoI) {
			throw new RuntimeException(V5bywAoI);
		} finally {
			IOUtils.closeQuietly(XZfApVll);
		}
	}

}