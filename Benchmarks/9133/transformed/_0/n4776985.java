class n4776985 {
	public static ByteBuffer join(ByteBuffer W5GxYgOq, ByteBuffer bCbTZBEC) {
		if (bCbTZBEC == null || bCbTZBEC.remaining() == 0)
			return NIOUtils.copy(W5GxYgOq);
		if (W5GxYgOq == null || W5GxYgOq.remaining() == 0)
			return NIOUtils.copy(bCbTZBEC);
		ByteBuffer z9HY6WYN = ByteBuffer.allocate(W5GxYgOq.remaining() + bCbTZBEC.remaining());
		z9HY6WYN.put(W5GxYgOq);
		z9HY6WYN.put(bCbTZBEC);
		z9HY6WYN.flip();
		return z9HY6WYN;
	}

}