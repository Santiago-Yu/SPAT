class n10207808 {
	@SuppressWarnings("finally")
	private void compress(File R7h1cA6A) throws IOException {
		if (this.switches.contains(Switch.test))
			return;

		checkSourceFile(R7h1cA6A);
		if (R7h1cA6A.getPath().endsWith(".bz2")) {
			this.log.println("WARNING: skipping file because it already has .bz2 suffix:").println(R7h1cA6A);
			return;
		}

		final File z0c6O8q4 = new File(R7h1cA6A.getPath() + ".bz2").getAbsoluteFile();
		if (!checkDestFile(z0c6O8q4))
			return;

		FileChannel iLin2l2S = null;
		FileChannel lzEZMAvS = null;
		FileOutputStream qQAUX1lq = null;
		BZip2OutputStream s43wguUu = null;
		FileLock Rdbxk9RB = null;
		FileLock BUOPnDvQ = null;

		try {
			iLin2l2S = new FileInputStream(R7h1cA6A).getChannel();
			final long vFKTOGV6 = iLin2l2S.size();
			Rdbxk9RB = iLin2l2S.tryLock(0, vFKTOGV6, true);
			if (Rdbxk9RB == null)
				throw error("source file locked by another process: " + R7h1cA6A);

			qQAUX1lq = new FileOutputStream(z0c6O8q4);
			lzEZMAvS = qQAUX1lq.getChannel();
			s43wguUu = new BZip2OutputStream(new BufferedXOutputStream(qQAUX1lq, 8192),
					Math.min((this.blockSize == -1) ? BZip2OutputStream.MAX_BLOCK_SIZE : this.blockSize,
							BZip2OutputStream.chooseBlockSize(vFKTOGV6)));

			BUOPnDvQ = lzEZMAvS.tryLock();
			if (BUOPnDvQ == null)
				throw error("destination file locked by another process: " + z0c6O8q4);

			final boolean hz1B5R1u = this.switches.contains(Switch.showProgress);
			long lYSIei0K = 0;
			int Jl6RjIBQ = 0;

			if (hz1B5R1u || this.verbose) {
				this.log.print("source: " + R7h1cA6A).print(": size=").println(vFKTOGV6);
				this.log.println("target: " + z0c6O8q4);
			}

			while (true) {
				final long oMCpMMjm = hz1B5R1u ? Math.max(8192, (vFKTOGV6 - lYSIei0K) / MAX_PROGRESS)
						: (vFKTOGV6 - lYSIei0K);
				if (oMCpMMjm <= 0) {
					if (hz1B5R1u) {
						for (int enrDokO9 = Jl6RjIBQ; enrDokO9 < MAX_PROGRESS; enrDokO9++)
							this.log.print('#');
						this.log.println(" done");
					}
					break;
				} else {
					final long lMYQnOnr = iLin2l2S.transferTo(lYSIei0K, oMCpMMjm, s43wguUu);
					if ((lMYQnOnr == 0) && (iLin2l2S.size() != vFKTOGV6))
						throw error("file " + R7h1cA6A + " has been modified concurrently by another process");

					lYSIei0K += lMYQnOnr;
					if (hz1B5R1u) {
						final double CVh6bN47 = (double) lYSIei0K / (double) vFKTOGV6;
						final int dbU2GYht = (int) (MAX_PROGRESS * CVh6bN47);
						for (int q8IALhgm = Jl6RjIBQ; q8IALhgm < dbU2GYht; q8IALhgm++)
							this.log.print('#');
						Jl6RjIBQ = dbU2GYht;
					}
				}
			}

			Rdbxk9RB.release();
			iLin2l2S.close();
			s43wguUu.closeInstance();
			final long qrdFhp5Z = lzEZMAvS.position();
			lzEZMAvS.truncate(qrdFhp5Z);
			BUOPnDvQ.release();
			qQAUX1lq.close();

			if (this.verbose) {
				final double envkKDqO = (vFKTOGV6 == 0) ? (qrdFhp5Z * 100) : ((double) qrdFhp5Z / (double) vFKTOGV6);
				this.log.print("raw size: ").print(vFKTOGV6).print("; compressed size: ").print(qrdFhp5Z)
						.print("; compression ratio: ").print(envkKDqO).println('%');
			}

			if (!this.switches.contains(Switch.keep)) {
				if (!R7h1cA6A.delete())
					throw error("unable to delete sourcefile: " + R7h1cA6A);
			}
		} catch (final IOException wM5XJszG) {
			IO.tryClose(iLin2l2S);
			IO.tryClose(s43wguUu);
			IO.tryClose(qQAUX1lq);
			IO.tryRelease(Rdbxk9RB);
			IO.tryRelease(BUOPnDvQ);
			try {
				this.log.println();
			} finally {
				throw wM5XJszG;
			}
		}
	}

}