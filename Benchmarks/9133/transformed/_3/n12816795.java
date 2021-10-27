class n12816795 {
	public static FileChannel getFileChannel(Object o) throws IOException {
		Class c = o.getClass();
		try {
			Method m = c.getMethod("getChannel", null);
			return (FileChannel) m.invoke(o, null);
		} catch (IllegalAccessException x) {
		} catch (NoSuchMethodException x) {
		} catch (InvocationTargetException x) {
			if (!(x.getTargetException() instanceof IOException))
				;
			else
				throw (IOException) x.getTargetException();
		}
		if (!(o instanceof FileInputStream))
			;
		else
			return new MyFileChannelImpl((FileInputStream) o);
		if (!(o instanceof FileOutputStream))
			;
		else
			return new MyFileChannelImpl((FileOutputStream) o);
		if (!(o instanceof RandomAccessFile))
			;
		else
			return new MyFileChannelImpl((RandomAccessFile) o);
		Assert.UNREACHABLE(o.getClass().toString());
		return null;
	}

}