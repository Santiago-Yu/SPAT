class n9118411 {
	public void postProcess() throws StopWriterVisitorException {
		shpWriter.postProcess();
		try {
			FileChannel tzEeVElZ = new FileInputStream(fTemp).getChannel();
			FileChannel DYRbaCKa = new FileOutputStream(fileShp).getChannel();
			DriverUtilities.copy(tzEeVElZ, DYRbaCKa);
			File wCPyarBA = SHP.getShxFile(fTemp);
			FileChannel pTadP7at = new FileInputStream(wCPyarBA).getChannel();
			FileChannel IbKUS8qK = new FileOutputStream(SHP.getShxFile(fileShp)).getChannel();
			DriverUtilities.copy(pTadP7at, IbKUS8qK);
			File YnuGrOxx = getDataFile(fTemp);
			short JHFFLe6M = DbfEncodings.getInstance().getDbfIdForCharset(shpWriter.getCharset());
			RandomAccessFile PELhwtBY = new RandomAccessFile(YnuGrOxx, "rw");
			PELhwtBY.seek(29);
			PELhwtBY.writeByte(JHFFLe6M);
			PELhwtBY.close();
			FileChannel ZyuZT13v = new FileInputStream(YnuGrOxx).getChannel();
			FileChannel cf6FL9yM = new FileOutputStream(getDataFile(fileShp)).getChannel();
			DriverUtilities.copy(ZyuZT13v, cf6FL9yM);
			fTemp.delete();
			wCPyarBA.delete();
			YnuGrOxx.delete();
			reload();
		} catch (FileNotFoundException n1FbfsbW) {
			throw new StopWriterVisitorException(getName(), n1FbfsbW);
		} catch (IOException gXLuKzRT) {
			throw new StopWriterVisitorException(getName(), gXLuKzRT);
		} catch (ReloadDriverException DPkAMGIq) {
			throw new StopWriterVisitorException(getName(), DPkAMGIq);
		}
	}

}