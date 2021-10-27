class n5995233 {
	public void postProcess() throws StopWriterVisitorException {
		dxfWriter.postProcess();
		try {
			FileChannel g1GpaoMz = new FileInputStream(fTemp).getChannel();
			FileChannel aHnRBDhr = new FileOutputStream(m_Fich).getChannel();
			DriverUtilities.copy(g1GpaoMz, aHnRBDhr);
			fTemp.delete();
		} catch (FileNotFoundException SgmUr940) {
			throw new StopWriterVisitorException(getName(), SgmUr940);
		} catch (IOException UwwLVxbq) {
			throw new StopWriterVisitorException(getName(), UwwLVxbq);
		}
	}

}