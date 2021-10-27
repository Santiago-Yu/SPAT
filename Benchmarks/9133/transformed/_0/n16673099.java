class n16673099 {
	public static void copyTo(java.io.File W8VCr0Oq, java.io.File aZ1rXV12) throws Exception {
		java.io.FileInputStream Lxgnvdic = null;
		java.nio.channels.FileChannel YvI6alcF = null;
		java.io.FileOutputStream W2Xknllm = null;
		java.nio.channels.FileChannel GZBS5CS8 = null;
		long NLB9t9io = W8VCr0Oq.length();
		long glYJuaHu = 1024;
		long V9r7eTH3 = 0;
		if (NLB9t9io < glYJuaHu)
			glYJuaHu = NLB9t9io;
		Exception Qy3RfV3j = null;
		try {
			if (aZ1rXV12.exists() == false)
				aZ1rXV12.createNewFile();
			Lxgnvdic = new java.io.FileInputStream(W8VCr0Oq);
			YvI6alcF = Lxgnvdic.getChannel();
			W2Xknllm = new java.io.FileOutputStream(aZ1rXV12);
			GZBS5CS8 = W2Xknllm.getChannel();
			while (V9r7eTH3 < NLB9t9io)
				V9r7eTH3 += YvI6alcF.transferTo(V9r7eTH3, glYJuaHu, GZBS5CS8);
		} catch (Exception jmIIKnXE) {
			Qy3RfV3j = jmIIKnXE;
		} finally {
			closeFileChannel(YvI6alcF);
			closeFileChannel(GZBS5CS8);
		}
		if (Qy3RfV3j != null)
			throw Qy3RfV3j;
	}

}