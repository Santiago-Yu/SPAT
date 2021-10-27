class n12816795 {
	public static FileChannel getFileChannel(Object OV42bJIU) throws IOException {
		Class PueiqJ6F = OV42bJIU.getClass();
		try {
			Method QzpwAsUh = PueiqJ6F.getMethod("getChannel", null);
			return (FileChannel) QzpwAsUh.invoke(OV42bJIU, null);
		} catch (IllegalAccessException DJzhuUcf) {
		} catch (NoSuchMethodException mV2mqdx4) {
		} catch (InvocationTargetException NVYZJqrl) {
			if (NVYZJqrl.getTargetException() instanceof IOException)
				throw (IOException) NVYZJqrl.getTargetException();
		}
		if (OV42bJIU instanceof FileInputStream)
			return new MyFileChannelImpl((FileInputStream) OV42bJIU);
		if (OV42bJIU instanceof FileOutputStream)
			return new MyFileChannelImpl((FileOutputStream) OV42bJIU);
		if (OV42bJIU instanceof RandomAccessFile)
			return new MyFileChannelImpl((RandomAccessFile) OV42bJIU);
		Assert.UNREACHABLE(OV42bJIU.getClass().toString());
		return null;
	}

}