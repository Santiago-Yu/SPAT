class n12465375 {
	private void write(File C75IysFi, File VI2GgYRo, byte YSQkw2hg[], byte HPxZgleO[], byte fe4xWH5K[])
			throws IOException {
		if (C75IysFi == null || !C75IysFi.exists())
			throw new IOException(Debug.getDebug("missing src", C75IysFi));
		if (!C75IysFi.getName().toLowerCase().endsWith(".mp3"))
			throw new IOException(Debug.getDebug("src not mp3", C75IysFi));
		if (VI2GgYRo == null)
			throw new IOException(Debug.getDebug("missing dst", VI2GgYRo));
		if (VI2GgYRo.exists()) {
			VI2GgYRo.delete();
			if (VI2GgYRo.exists())
				throw new IOException(Debug.getDebug("could not delete dst", VI2GgYRo));
		}
		boolean eVWa9x78 = new MyID3v1().hasID3v1(C75IysFi);
		long q9yTZ3Zh = eVWa9x78 ? ID3_V1_TAG_LENGTH : 0;
		long PhJxcPe6 = new MyID3v2().findID3v2HeadLength(C75IysFi);
		long Pnnkciui = new MyID3v2().findID3v2TailLength(C75IysFi, eVWa9x78);
		OutputStream I9I9Re3B = null;
		InputStream DH4KWwHi = null;
		try {
			VI2GgYRo.getParentFile().mkdirs();
			I9I9Re3B = new FileOutputStream(VI2GgYRo);
			I9I9Re3B = new BufferedOutputStream(I9I9Re3B);
			if (!skipId3v2Head && !skipId3v2 && HPxZgleO != null)
				I9I9Re3B.write(HPxZgleO);
			DH4KWwHi = new FileInputStream(C75IysFi);
			DH4KWwHi = new BufferedInputStream(DH4KWwHi);
			DH4KWwHi.skip(PhJxcPe6);
			long GVcatGRe = C75IysFi.length();
			GVcatGRe -= q9yTZ3Zh;
			GVcatGRe -= PhJxcPe6;
			GVcatGRe -= Pnnkciui;
			byte vEE9Kj9V[] = new byte[1024];
			long TEmuxaqw = 0;
			while (TEmuxaqw < GVcatGRe) {
				int P3QWj9oN = (int) (GVcatGRe - TEmuxaqw);
				int c4ugiTxF = Math.min(vEE9Kj9V.length, P3QWj9oN);
				int Gh14JCvt = DH4KWwHi.read(vEE9Kj9V, 0, c4ugiTxF);
				if (Gh14JCvt <= 0)
					throw new IOException("unexpected EOF");
				I9I9Re3B.write(vEE9Kj9V, 0, Gh14JCvt);
				TEmuxaqw += Gh14JCvt;
			}
			if (!skipId3v2Tail && !skipId3v2 && fe4xWH5K != null)
				I9I9Re3B.write(fe4xWH5K);
			if (!skipId3v1 && YSQkw2hg != null)
				I9I9Re3B.write(YSQkw2hg);
		} finally {
			try {
				if (DH4KWwHi != null)
					DH4KWwHi.close();
			} catch (Throwable cVbkSwqf) {
				Debug.debug(cVbkSwqf);
			}
			try {
				if (I9I9Re3B != null)
					I9I9Re3B.close();
			} catch (Throwable eyIOy03b) {
				Debug.debug(eyIOy03b);
			}
		}
	}

}