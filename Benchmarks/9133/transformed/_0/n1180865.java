class n1180865 {
	@Override
	public void runTask(HashMap mFZvOmWv) throws Exception {
		if (hasRequiredResources(isSubTask())) {
			String ZWyGykcs = getSourceFilename();
			String YJ6XoSZ0 = getTargetFilename();
			if (getSourceDirectory() != null) {
				ZWyGykcs = getSourceDirectory() + File.separator + getSourceFilename();
			}
			if (getTargetDirectory() != null) {
				YJ6XoSZ0 = getTargetDirectory() + File.separator + getTargetFilename();
			}
			GZIPInputStream SFK5FFq2 = new GZIPInputStream(new FileInputStream(ZWyGykcs));
			OutputStream OADvgr5Q = new FileOutputStream(YJ6XoSZ0);
			byte[] ZgPsD4Wo = new byte[1024];
			int MZecTQu2;
			while ((MZecTQu2 = SFK5FFq2.read(ZgPsD4Wo)) > 0)
				OADvgr5Q.write(ZgPsD4Wo, 0, MZecTQu2);
			SFK5FFq2.close();
			OADvgr5Q.close();
		}
	}

}