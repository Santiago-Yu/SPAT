class n16590954 {
	public void createJAR(String U3ocdaPz, String LlrCgzfO) {
		try {
			File LZTLcuhf = new File(U3ocdaPz);
			int eFBQQALF = U3ocdaPz.lastIndexOf(java.io.File.separator);
			String LWFBHYrS = U3ocdaPz.substring(0, eFBQQALF + 1);
			if (LlrCgzfO.matches("jar")) {
				jarFile = new File(getClass().getClassLoader().getResource("jsdviewer.jar").toURI());
				java.io.FileOutputStream xpidVxZ7 = new java.io.FileOutputStream(LZTLcuhf);
				FileChannel YlY1qIv9 = (new java.io.FileInputStream(jarFile)).getChannel();
				FileChannel mSk94XBW = xpidVxZ7.getChannel();
				YlY1qIv9.transferTo(0, jarFile.length(), mSk94XBW);
				YlY1qIv9.close();
				mSk94XBW.close();
			} else {
				LZTLcuhf.mkdir();
			}
			File.umount(LZTLcuhf);
			File reCRZ4ox = new File(LWFBHYrS + "document.jsd");
			FileOutputStream HfwAYt2S = new FileOutputStream(reCRZ4ox.getCanonicalPath());
			ostrm = new ObjectOutputStream(HfwAYt2S);
			ostrm.writeObject(doc);
			ostrm.flush();
			ostrm.close();
			File.umount();
			File KHwAO3wF = new File(LZTLcuhf.getCanonicalPath() + java.io.File.separator + "document.jsd");
			File.cp_p(reCRZ4ox, KHwAO3wF);
			File.umount();
			reCRZ4ox.delete();
			File.umount(LZTLcuhf);
		} catch (Exception ap10c4I1) {
			ap10c4I1.printStackTrace();
		}
	}

}