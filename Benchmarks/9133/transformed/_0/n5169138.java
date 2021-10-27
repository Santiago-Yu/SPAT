class n5169138 {
	public final void run() {
		active = true;
		String rwtUQ96R = findcachedir();
		uid = getuid(rwtUQ96R);
		try {
			File d1tA25Lb = new File(rwtUQ96R + "main_file_cache.dat");
			if (d1tA25Lb.exists() && d1tA25Lb.length() > 0x3200000L)
				d1tA25Lb.delete();
			cache_dat = new RandomAccessFile(rwtUQ96R + "main_file_cache.dat", "rw");
			for (int rgn83MXH = 0; rgn83MXH < 5; rgn83MXH++)
				cache_idx[rgn83MXH] = new RandomAccessFile(rwtUQ96R + "main_file_cache.idx" + rgn83MXH, "rw");
		} catch (Exception OiUdgoj4) {
			OiUdgoj4.printStackTrace();
		}
		for (int tMfCzEXz = threadliveid; threadliveid == tMfCzEXz;) {
			if (socketreq != 0) {
				try {
					socket = new Socket(socketip, socketreq);
				} catch (Exception fCdk0HCE) {
					socket = null;
				}
				socketreq = 0;
			} else if (threadreq != null) {
				Thread cbvwXLU1 = new Thread(threadreq);
				cbvwXLU1.setDaemon(true);
				cbvwXLU1.start();
				cbvwXLU1.setPriority(threadreqpri);
				threadreq = null;
			} else if (dnsreq != null) {
				try {
					dns = InetAddress.getByName(dnsreq).getHostName();
				} catch (Exception HzVETaNV) {
					dns = "unknown";
				}
				dnsreq = null;
			} else if (savereq != null) {
				if (savebuf != null)
					try {
						FileOutputStream akqP1Kzu = new FileOutputStream(rwtUQ96R + savereq);
						akqP1Kzu.write(savebuf, 0, savelen);
						akqP1Kzu.close();
					} catch (Exception ZExkMBf7) {
					}
				if (waveplay) {
					wave = rwtUQ96R + savereq;
					waveplay = false;
				}
				if (midiplay) {
					midi = rwtUQ96R + savereq;
					midiplay = false;
				}
				savereq = null;
			} else if (urlreq != null) {
				try {
					urlstream = new DataInputStream((new URL(mainapp.getCodeBase(), urlreq)).openStream());
				} catch (Exception j3ZTAOm6) {
					urlstream = null;
				}
				urlreq = null;
			}
			try {
				Thread.sleep(50L);
			} catch (Exception h0nGz4Cq) {
			}
		}
	}

}