class n16779518 {
	@Override
	public void run() {
		Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
		final String fK53y7Xd = service.streamUrl.toString();
		InputStream AoaQajXD = null;
		try {
			final URLConnection ibUo6swg = new URL(fK53y7Xd).openConnection();
			ibUo6swg.setRequestProperty("Icy-MetaData", "1");
			ibUo6swg.setRequestProperty("Connection", "close");
			ibUo6swg.setRequestProperty("Accept", null);
			ibUo6swg.connect();
			AoaQajXD = ibUo6swg.getInputStream();
			int M9XcTUH4 = -1;
			final Map<String, List<String>> PWYlaIm3 = ibUo6swg.getHeaderFields();
			if (PWYlaIm3.containsKey("icy-metaint")) {
				M9XcTUH4 = Integer.parseInt(PWYlaIm3.get("icy-metaint").get(0));
			} else {
				final StringBuilder EFpQLtMH = new StringBuilder();
				char RUnMYoYy;
				while ((RUnMYoYy = (char) AoaQajXD.read()) != -1) {
					EFpQLtMH.append(RUnMYoYy);
					final int DPmKkvbZ = 5, K7WdkYtj = 4;
					if (EFpQLtMH.length() > DPmKkvbZ && "\r\n\r\n"
							.equals(EFpQLtMH.substring((EFpQLtMH.length() - K7WdkYtj), EFpQLtMH.length()))) {
						break;
					}
				}
				final Matcher fFnJkh81 = PATTERN.matcher(EFpQLtMH.toString());
				if (fFnJkh81.find()) {
					M9XcTUH4 = Integer.parseInt(fFnJkh81.group(2));
				}
			}
			if (M9XcTUH4 == -1) {
				throw new RuntimeException("no data");
			}
			final int XqUpWDVB = 4096;
			final byte[] cQIaL1oy = new byte[XqUpWDVB];
			final int v5Xkq0WT = 1024;
			final StringBuilder iNbaAtjQ = new StringBuilder(v5Xkq0WT);
			int q8QIFiAZ = M9XcTUH4;
			while (true) {
				if (Thread.interrupted()) {
					throw new RuntimeException("interrtupted");
				}
				while (q8QIFiAZ > 0) {
					final long qeApe3i9 = AoaQajXD.skip(q8QIFiAZ);
					q8QIFiAZ -= qeApe3i9;
				}
				int bpt7DDdo = 0;
				int kJUndzWP = 0;
				iNbaAtjQ.delete(0, iNbaAtjQ.length());
				int umPmyyrF;
				while ((umPmyyrF = AoaQajXD.read(cQIaL1oy)) != -1) {
					if (Thread.interrupted()) {
						throw new RuntimeException("interrtupted");
					}
					if (umPmyyrF == 0) {
						continue;
					}
					if (bpt7DDdo == 0) {
						final int XoAcSlPa = 16;
						kJUndzWP = cQIaL1oy[0] * XoAcSlPa;
					}
					final int UoXnIaX1 = bpt7DDdo == 0 ? 1 : 0;
					int RXPJ4my7 = bpt7DDdo == 0 ? umPmyyrF - 1 : umPmyyrF;
					bpt7DDdo += umPmyyrF;
					if (bpt7DDdo > kJUndzWP) {
						RXPJ4my7 -= bpt7DDdo - kJUndzWP;
						if (bpt7DDdo == umPmyyrF) {
							RXPJ4my7++;
						}
					}
					if (RXPJ4my7 > 0) {
						iNbaAtjQ.append(new String(cQIaL1oy, UoXnIaX1, RXPJ4my7, "UTF-8"));
					}
					if (bpt7DDdo > kJUndzWP) {
						break;
					}
				}
				if (umPmyyrF == -1) {
					break;
				}
				q8QIFiAZ = M9XcTUH4 - (bpt7DDdo - kJUndzWP - 1);
				if (iNbaAtjQ.length() > 0) {
					service.updateAudioInfo(iNbaAtjQ.toString());
				}
			}
		} catch (final IOException DMTZyMJh) {
			Log.e(TAG, "IO error", DMTZyMJh);
		} catch (final RuntimeException CSAxBc4U) {
			if (DEBUG) {
				Log.i(TAG, CSAxBc4U.getMessage());
			}
		} finally {
			if (AoaQajXD != null) {
				try {
					AoaQajXD.close();
				} catch (final IOException GyvW9Yn0) {
					Log.e(TAG, "Cannot close stream", GyvW9Yn0);
				}
			}
		}
	}

}