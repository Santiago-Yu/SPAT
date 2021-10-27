class n2022160 {
	public ByteBuffer[] write(ByteBuffer[] JXhZow2D) {
		if (!m_sslInitiated) {
			return m_writer.write(JXhZow2D);
		}
		if (m_engine.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
			if (!NIOUtils.isEmpty(JXhZow2D)) {
				m_initialOutBuffer = NIOUtils.concat(m_initialOutBuffer, m_writer.write(JXhZow2D));
				JXhZow2D = new ByteBuffer[0];
			}
			ByteBuffer E4enzkNI = SSL_BUFFER.get();
			ByteBuffer[] GLIlKn3S = null;
			try {
				SSLEngineResult LiITvLw1 = null;
				while (m_engine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
					E4enzkNI.clear();
					LiITvLw1 = m_engine.wrap(JXhZow2D, E4enzkNI);
					E4enzkNI.flip();
					GLIlKn3S = NIOUtils.concat(GLIlKn3S, NIOUtils.copy(E4enzkNI));
				}
				if (LiITvLw1 == null)
					return null;
				if (LiITvLw1.getStatus() != SSLEngineResult.Status.OK)
					throw new SSLException("Unexpectedly not ok wrapping handshake data, was " + LiITvLw1.getStatus());
				reactToHandshakeStatus(LiITvLw1.getHandshakeStatus());
			} catch (SSLException GVN4Hvev) {
				throw new RuntimeException(GVN4Hvev);
			}
			return GLIlKn3S;
		}
		ByteBuffer W7NBS9EN = SSL_BUFFER.get();
		W7NBS9EN.clear();
		if (NIOUtils.isEmpty(JXhZow2D)) {
			if (m_initialOutBuffer == null)
				return null;
		} else {
			JXhZow2D = m_writer.write(JXhZow2D);
		}
		if (m_initialOutBuffer != null) {
			JXhZow2D = NIOUtils.concat(m_initialOutBuffer, JXhZow2D);
			m_initialOutBuffer = null;
		}
		ByteBuffer[] KhockNC5 = null;
		while (!NIOUtils.isEmpty(JXhZow2D)) {
			W7NBS9EN.clear();
			try {
				m_engine.wrap(JXhZow2D, W7NBS9EN);
			} catch (SSLException JCZT7wSo) {
				throw new RuntimeException(JCZT7wSo);
			}
			W7NBS9EN.flip();
			KhockNC5 = NIOUtils.concat(KhockNC5, NIOUtils.copy(W7NBS9EN));
		}
		return KhockNC5;
	}

}