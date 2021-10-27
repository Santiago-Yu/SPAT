class n10207809 {
	@SuppressWarnings("finally")
	private void decompress(final File U7YRJMT9) throws IOException {
		final String mxe7joIa = U7YRJMT9.getPath();
		checkSourceFile(U7YRJMT9);
		final boolean PqGfRToY = this.switches.contains(Switch.test);

		final File pcSSalA6;
		if (PqGfRToY)
			pcSSalA6 = File.createTempFile("jaxlib-bzip", null);
		else {
			if (mxe7joIa.endsWith(".bz2"))
				pcSSalA6 = new File(mxe7joIa.substring(0, mxe7joIa.length() - 4));
			else {
				this.log.println("WARNING: Can't guess original name, using extension \".out\":").println(mxe7joIa);
				pcSSalA6 = new File(mxe7joIa + ".out");
			}
		}
		if (!checkDestFile(pcSSalA6))
			return;

		final boolean EJaYkwJz = this.switches.contains(Switch.showProgress);

		BZip2InputStream LK4h2397 = null;
		FileOutputStream qXDxgxAC = null;
		FileChannel c4J16E8D = null;
		FileLock maI2SAgN = null;
		FileLock FNkEV8n4 = null;

		try {
			final FileInputStream SyTRT2KM = new FileInputStream(U7YRJMT9);
			final FileChannel aPGwVKFp = SyTRT2KM.getChannel();
			final long YdxCrsGP = aPGwVKFp.size();

			maI2SAgN = aPGwVKFp.tryLock(0, YdxCrsGP, true);
			if (maI2SAgN == null)
				throw error("source file locked by another process: " + U7YRJMT9);

			LK4h2397 = new BZip2InputStream(new BufferedXInputStream(SyTRT2KM, 8192));
			qXDxgxAC = new FileOutputStream(pcSSalA6);
			c4J16E8D = qXDxgxAC.getChannel();

			FNkEV8n4 = c4J16E8D.tryLock();
			if (FNkEV8n4 == null)
				throw error("destination file locked by another process: " + pcSSalA6);

			if (EJaYkwJz || this.verbose) {
				this.log.print("source: " + U7YRJMT9).print(": size=").println(YdxCrsGP);
				this.log.println("target: " + pcSSalA6);
			}

			long zKqBoz8W = 0;
			int mU1xokLa = 0;
			final long vfWnxmnY = EJaYkwJz ? Math.max(8192, YdxCrsGP / MAX_PROGRESS) : Integer.MAX_VALUE;

			while (true) {
				final long vdjUO8BS = c4J16E8D.transferFrom(LK4h2397, zKqBoz8W, vfWnxmnY);
				if (vdjUO8BS <= 0) {
					final long r6NRpOfc = aPGwVKFp.size();
					if (r6NRpOfc != YdxCrsGP)
						throw error("file " + U7YRJMT9 + " has been modified concurrently by another process");

					if (aPGwVKFp.position() >= YdxCrsGP) {
						if (EJaYkwJz) {
							for (int lUS2Jqph = mU1xokLa; lUS2Jqph < MAX_PROGRESS; lUS2Jqph++)
								this.log.print('#');
							this.log.println(" done");
						}
						break;
					}
				} else {
					zKqBoz8W += vdjUO8BS;
					if (EJaYkwJz) {
						final double GCeMVV5S = (double) aPGwVKFp.position() / (double) YdxCrsGP;
						final int lnAFnowH = (int) (MAX_PROGRESS * GCeMVV5S);
						for (int qPn3IMSm = mU1xokLa; qPn3IMSm < lnAFnowH; qPn3IMSm++)
							this.log.print('#');
						mU1xokLa = lnAFnowH;
					}
				}
			}

			final long eGiWGWiV = c4J16E8D.size();
			LK4h2397.close();
			qXDxgxAC.close();

			if (this.verbose) {
				final double qvByO7a8 = (eGiWGWiV == 0) ? (YdxCrsGP * 100) : ((double) YdxCrsGP / (double) eGiWGWiV);
				this.log.print("compressed size: ").print(YdxCrsGP).print("; decompressed size: ").print(eGiWGWiV)
						.print("; compression ratio: ").print(qvByO7a8).println('%');
			}

			if (!PqGfRToY && !this.switches.contains(Switch.keep)) {
				if (!U7YRJMT9.delete())
					throw error("unable to delete sourcefile: " + U7YRJMT9);
			}

			if (PqGfRToY && !pcSSalA6.delete())
				throw error("unable to delete testfile: " + pcSSalA6);
		} catch (final IOException rqnX0Lc9) {
			IO.tryClose(LK4h2397);
			IO.tryClose(qXDxgxAC);
			IO.tryRelease(maI2SAgN);
			IO.tryRelease(FNkEV8n4);
			try {
				this.log.println();
			} finally {
				throw rqnX0Lc9;
			}
		}

	}

}