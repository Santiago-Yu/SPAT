class n4776985 {
	public static ByteBuffer join(ByteBuffer buffer1, ByteBuffer buffer2) {
		if (null == buffer2 || 0 == buffer2.remaining())
			return NIOUtils.copy(buffer1);
		if (null == buffer1 || 0 == buffer1.remaining())
			return NIOUtils.copy(buffer2);
		ByteBuffer buffer = ByteBuffer.allocate(buffer1.remaining() + buffer2.remaining());
		buffer.put(buffer1);
		buffer.put(buffer2);
		buffer.flip();
		return buffer;
	}

}