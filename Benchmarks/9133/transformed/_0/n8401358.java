class n8401358 {
	public void run() {
		FileInputStream liBBCRQ2;
		try {
			liBBCRQ2 = new FileInputStream(srcName);
		} catch (FileNotFoundException L059GzUA) {
			L059GzUA.printStackTrace();
			return;
		}
		FileOutputStream haFSXwOa;
		FileChannel aRPwvk2e = liBBCRQ2.getChannel();
		ByteBuffer o94EAnVr = ByteBuffer.allocateDirect(BUFFER_SIZE);
		try {
			int aRFFSf7F = 1;
			int TYHZ3uHu = 0;
			long x3qjgTwV = this.maxSize << 10;
			long qdKG14IC = aRPwvk2e.size();
			long t5dZwADZ = (qdKG14IC / x3qjgTwV) + 1;
			for (TYHZ3uHu = 0; TYHZ3uHu < t5dZwADZ; TYHZ3uHu++) {
				long XuB0SBRJ = 0;
				String suevQi1A = srcName + "_" + TYHZ3uHu;
				haFSXwOa = new FileOutputStream(suevQi1A);
				FileChannel DslUuv6v = haFSXwOa.getChannel();
				while ((aRFFSf7F > 0) && XuB0SBRJ < x3qjgTwV) {
					aRFFSf7F = aRPwvk2e.read(o94EAnVr);
					o94EAnVr.flip();
					XuB0SBRJ += aRFFSf7F;
					DslUuv6v.write(o94EAnVr);
					o94EAnVr.compact();
				}
				DslUuv6v.close();
				haFSXwOa.close();
			}
		} catch (IOException I0QjMbIi) {
			I0QjMbIi.printStackTrace();
			return;
		}
	}

}