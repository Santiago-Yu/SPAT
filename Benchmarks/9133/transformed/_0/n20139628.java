class n20139628 {
	public void postProcess() throws StopWriterVisitorException {
		dbfWriter.postProcess();
		try {
			short g10SxHAN = dbf.getDbaseHeader().getLanguageID();
			File NTjkMnpF = fTemp;
			FileChannel zL0NfRXY = new FileInputStream(NTjkMnpF).getChannel();
			FileChannel gy2zsWVW = new FileOutputStream(file).getChannel();
			DriverUtilities.copy(zL0NfRXY, gy2zsWVW);
			fTemp.delete();
			close();
			RandomAccessFile ta1KQ9Ku = new RandomAccessFile(file, "rw");
			ta1KQ9Ku.seek(29);
			ta1KQ9Ku.writeByte(g10SxHAN);
			ta1KQ9Ku.close();
			open(file);
		} catch (FileNotFoundException CQuPdz8r) {
			throw new StopWriterVisitorException(getName(), CQuPdz8r);
		} catch (IOException TdR18inr) {
			throw new StopWriterVisitorException(getName(), TdR18inr);
		} catch (CloseDriverException G19LsLGK) {
			throw new StopWriterVisitorException(getName(), G19LsLGK);
		} catch (OpenDriverException WRagJ8jo) {
			throw new StopWriterVisitorException(getName(), WRagJ8jo);
		}
	}

}