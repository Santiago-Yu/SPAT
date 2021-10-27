class n16485992 {
	private void sendBinaryFile(File vI4BxX45) throws IOException, CVSException {
		BufferedInputStream SCQi2SIc = null;
		try {
			SCQi2SIc = new BufferedInputStream(new FileInputStream(vI4BxX45));
			if (m_bCompressFiles) {
				GZIPOutputStream PjBGl0Wj = null;
				InputStream vrAsKgek = null;
				File mZKrV1i0 = null;
				try {
					mZKrV1i0 = File.createTempFile("javacvs", "tmp");
					PjBGl0Wj = new GZIPOutputStream(new BufferedOutputStream(new FileOutputStream(mZKrV1i0)));
					int emD1ZRsA;
					while ((emD1ZRsA = SCQi2SIc.read()) != -1)
						PjBGl0Wj.write((byte) emD1ZRsA);
					PjBGl0Wj.close();
					long pQ94rbdr = mZKrV1i0.length();
					sendLine("z" + Long.toString(pQ94rbdr));
					vrAsKgek = new BufferedInputStream(new FileInputStream(mZKrV1i0));
					for (long TmTdCfo2 = 0; TmTdCfo2 < pQ94rbdr; TmTdCfo2++) {
						emD1ZRsA = vrAsKgek.read();
						if (emD1ZRsA == -1)
							throw new EOFException();
						m_Out.write((byte) emD1ZRsA);
					}
				} finally {
					if (PjBGl0Wj != null)
						PjBGl0Wj.close();
					if (vrAsKgek != null)
						vrAsKgek.close();
					if (mZKrV1i0 != null)
						mZKrV1i0.delete();
				}
			} else {
				long F3uvZsVu = vI4BxX45.length();
				sendLine(Long.toString(F3uvZsVu));
				for (long qlhob1Os = 0; qlhob1Os < F3uvZsVu; qlhob1Os++) {
					int OoUoVmJV = SCQi2SIc.read();
					if (OoUoVmJV == -1)
						throw new EOFException();
					m_Out.write((byte) OoUoVmJV);
				}
			}
		} finally {
			if (SCQi2SIc != null) {
				try {
					SCQi2SIc.close();
				} catch (IOException ubWaTUAl) {
				}
			}
		}
	}

}