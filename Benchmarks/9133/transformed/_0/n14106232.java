class n14106232 {
	public void copyFile(File zk9XE2dk, File afXRbxCh) {
		try {
			InputStream pysKCTBT = new FileInputStream(zk9XE2dk);
			OutputStream DO28Eu0k = new FileOutputStream(afXRbxCh);
			int phS7QZFG;
			byte[] x8fLOmJ0 = new byte[1024];
			while ((phS7QZFG = pysKCTBT.read(x8fLOmJ0)) != -1) {
				DO28Eu0k.write(x8fLOmJ0, 0, phS7QZFG);
			}
			DO28Eu0k.flush();
			pysKCTBT.close();
			DO28Eu0k.close();
		} catch (Exception a0KtsyM5) {
			throw new BuildException(a0KtsyM5.getMessage(), a0KtsyM5);
		}
	}

}