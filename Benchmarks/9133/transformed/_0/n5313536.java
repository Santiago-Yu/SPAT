class n5313536 {
	public void merge(VMImage am3uIokb, VMSnapShot qFLAmWzT) throws VMException {
		if (path == null || qFLAmWzT.getPath() == null)
			throw new VMException("EmuVMSnapShot is NULL!");
		logging.debug(LOG_NAME, "merge images  " + path + " and " + qFLAmWzT.getPath());
		File FE4EnOSR = new File(path);
		File drABfUCi = new File(qFLAmWzT.getPath());
		if (FE4EnOSR.isDirectory() || drABfUCi.isDirectory())
			return;
		try {
			FileInputStream mBflCZRv = new FileInputStream(qFLAmWzT.getPath());
			FileChannel kem9wWNv = mBflCZRv.getChannel();
			FileOutputStream mN7Dr6Dp = new FileOutputStream(path, true);
			FileChannel VluD4xv5 = mN7Dr6Dp.getChannel();
			VluD4xv5.transferFrom(kem9wWNv, 0, kem9wWNv.size());
			VluD4xv5.close();
			kem9wWNv.close();
		} catch (IOException IhaZ7CAL) {
			throw new VMException(IhaZ7CAL);
		}
	}

}