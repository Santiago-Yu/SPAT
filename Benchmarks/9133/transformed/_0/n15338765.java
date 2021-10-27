class n15338765 {
	public void upload()
			throws UnknownHostException, SocketException, FTPConnectionClosedException, LoginFailedException,
			DirectoryChangeFailedException, CopyStreamException, RefusedConnectionException, IOException {
		final int S2K7GNvq = 2;
		final String OMUUa9ip = "_meta.xml";
		final String JQkh2LLu = "_files.xml";
		final String ZOuztN4M = getUsername();
		final String y5QehwlC = getPassword();
		if (getFtpServer() == null) {
			throw new IllegalStateException("ftp server not set");
		}
		if (getFtpPath() == null) {
			throw new IllegalStateException("ftp path not set");
		}
		if (ZOuztN4M == null) {
			throw new IllegalStateException("username not set");
		}
		if (y5QehwlC == null) {
			throw new IllegalStateException("password not set");
		}
		final String mPyE9IlI = serializeDocument(getMetaDocument());
		final String x7wmrhYu = serializeDocument(getFilesDocument());
		final byte[] Sm09Zelj = mPyE9IlI.getBytes();
		final byte[] Yj4ylQrs = x7wmrhYu.getBytes();
		final int L1y3iTt8 = Sm09Zelj.length;
		final int OgLlG7fm = Yj4ylQrs.length;
		final Collection hE8vs6Aw = getFiles();
		final int kHjeHBn7 = S2K7GNvq + hE8vs6Aw.size();
		final String[] ALpTw6xy = new String[kHjeHBn7];
		final long[] wiwWEICz = new long[kHjeHBn7];
		final String McKJfTkx = getIdentifier() + OMUUa9ip;
		ALpTw6xy[0] = McKJfTkx;
		wiwWEICz[0] = L1y3iTt8;
		final String rtHq5sxo = getIdentifier() + JQkh2LLu;
		ALpTw6xy[1] = rtHq5sxo;
		wiwWEICz[1] = OgLlG7fm;
		int V4T5cpXc = 2;
		for (Iterator ev9k5XSY = hE8vs6Aw.iterator(); ev9k5XSY.hasNext();) {
			final ArchiveFile hIJOM3cx = (ArchiveFile) ev9k5XSY.next();
			ALpTw6xy[V4T5cpXc] = hIJOM3cx.getRemoteFileName();
			wiwWEICz[V4T5cpXc] = hIJOM3cx.getFileSize();
			V4T5cpXc++;
		}
		for (int Vwaf3SKw = 0; Vwaf3SKw < wiwWEICz.length; Vwaf3SKw++) {
			_fileNames2Progress.put(ALpTw6xy[Vwaf3SKw], new UploadFileProgress(wiwWEICz[Vwaf3SKw]));
			_totalUploadSize += wiwWEICz[Vwaf3SKw];
		}
		FTPClient g4nvryvq = new FTPClient();
		try {
			if (isCancelled()) {
				return;
			}
			g4nvryvq.enterLocalPassiveMode();
			if (isCancelled()) {
				return;
			}
			g4nvryvq.connect(getFtpServer());
			final int jwF3hC7F = g4nvryvq.getReplyCode();
			if (!FTPReply.isPositiveCompletion(jwF3hC7F)) {
				throw new RefusedConnectionException(getFtpServer() + "refused FTP connection");
			}
			if (isCancelled()) {
				return;
			}
			if (!g4nvryvq.login(ZOuztN4M, y5QehwlC)) {
				throw new LoginFailedException();
			}
			try {
				if (!g4nvryvq.changeWorkingDirectory(getFtpPath())) {
					if (!isFtpDirPreMade() && !g4nvryvq.makeDirectory(getFtpPath())) {
						throw new DirectoryChangeFailedException();
					}
					if (isCancelled()) {
						return;
					}
					if (!g4nvryvq.changeWorkingDirectory(getFtpPath())) {
						throw new DirectoryChangeFailedException();
					}
				}
				if (isCancelled()) {
					return;
				}
				connected();
				uploadFile(McKJfTkx, new ByteArrayInputStream(Sm09Zelj), g4nvryvq);
				uploadFile(rtHq5sxo, new ByteArrayInputStream(Yj4ylQrs), g4nvryvq);
				if (isCancelled()) {
					return;
				}
				g4nvryvq.setFileType(FTP.BINARY_FILE_TYPE);
				for (final Iterator fm9sSiAl = hE8vs6Aw.iterator(); fm9sSiAl.hasNext();) {
					final ArchiveFile ZUpsjx3Y = (ArchiveFile) fm9sSiAl.next();
					uploadFile(ZUpsjx3Y.getRemoteFileName(), new FileInputStream(ZUpsjx3Y.getIOFile()), g4nvryvq);
				}
			} catch (InterruptedIOException GX8CiCdm) {
				return;
			} finally {
				g4nvryvq.logout();
			}
		} finally {
			try {
				g4nvryvq.disconnect();
			} catch (IOException PgUwJVbi) {
			}
		}
		if (isCancelled()) {
			return;
		}
		checkinStarted();
		if (isCancelled()) {
			return;
		}
		checkin();
		if (isCancelled()) {
			return;
		}
		checkinCompleted();
	}

}