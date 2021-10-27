class n21454371 {
	private static void compressZip(String ZwGLOlbj, String Y7HWIBxf) throws Exception {
		File JpjeSBz6 = new File(ZwGLOlbj);
		if (JpjeSBz6.exists()) {
			if (JpjeSBz6.isDirectory()) {
				List<File> Ya6DHXAW = getSubFiles(new File(ZwGLOlbj));
				ZipOutputStream CkbfeDRN = new ZipOutputStream(new FileOutputStream(Y7HWIBxf));
				CkbfeDRN.setEncoding("GBK");
				ZipEntry Q2mcyeNh = null;
				byte[] m6LGqGeI = new byte[2048];
				int yGsycMX3 = 0;
				for (int Zb3a9Z2W = 0; Zb3a9Z2W < Ya6DHXAW.size(); Zb3a9Z2W++) {
					File z1EEPyxK = Ya6DHXAW.get(Zb3a9Z2W);
					if (z1EEPyxK.isDirectory()) {
						Q2mcyeNh = new ZipEntry(getAbsFileName(ZwGLOlbj, z1EEPyxK) + "/");
					} else {
						Q2mcyeNh = new ZipEntry(getAbsFileName(ZwGLOlbj, z1EEPyxK));
					}
					Q2mcyeNh.setSize(z1EEPyxK.length());
					Q2mcyeNh.setTime(z1EEPyxK.lastModified());
					CkbfeDRN.putNextEntry(Q2mcyeNh);
					if (z1EEPyxK.isFile()) {
						InputStream Ar1yfTPp = new BufferedInputStream(new FileInputStream(z1EEPyxK));
						while ((yGsycMX3 = Ar1yfTPp.read(m6LGqGeI, 0, 1024)) != -1) {
							CkbfeDRN.write(m6LGqGeI, 0, yGsycMX3);
						}
						Ar1yfTPp.close();
					}
				}
				CkbfeDRN.close();
			} else {
				throw new Exception("Can not do this operation!.");
			}
		} else {
			JpjeSBz6.mkdirs();
			compressZip(ZwGLOlbj, Y7HWIBxf);
		}
	}

}