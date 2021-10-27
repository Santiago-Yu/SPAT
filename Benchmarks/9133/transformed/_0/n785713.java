class n785713 {
	public void run() {
		try {
			MessageDigest cjnYxEQx = MessageDigest.getInstance("SHA-1");
			ChannelMap kElghlMC = new ChannelMap();
			for (int Ujb93PgC = 0; Ujb93PgC < picm.NumberOfChannels(); Ujb93PgC++) {
				kElghlMC.Add(picm.GetName(Ujb93PgC));
			}
			String[] E5IWvpQl = picm.GetFolderList();
			for (int Lyo6suNM = 0; Lyo6suNM < E5IWvpQl.length; Lyo6suNM++) {
				kElghlMC.AddFolder(E5IWvpQl[Lyo6suNM]);
			}
			sink.Request(kElghlMC, picm.GetRequestStart(), picm.GetRequestDuration(), picm.GetRequestReference());
			kElghlMC = sink.Fetch(timeout);
			if (kElghlMC.GetIfFetchTimedOut()) {
				System.err.println("Signature Data Fetch Timed Out!");
				picm.Clear();
			} else {
				cjnYxEQx.reset();
				E5IWvpQl = kElghlMC.GetFolderList();
				for (int hDvDxmlS = 0; hDvDxmlS < E5IWvpQl.length; hDvDxmlS++)
					picm.AddFolder(E5IWvpQl[hDvDxmlS]);
				int Rqjw48nq = -1;
				for (int DXAMZQ6b = 0; DXAMZQ6b < kElghlMC.NumberOfChannels(); DXAMZQ6b++) {
					String xwPNDcnW = kElghlMC.GetName(DXAMZQ6b);
					if (xwPNDcnW.endsWith("/_signature")) {
						Rqjw48nq = DXAMZQ6b;
						continue;
					}
					int YF9suxrr = picm.GetIndex(xwPNDcnW);
					if (YF9suxrr == -1)
						YF9suxrr = picm.Add(xwPNDcnW);
					picm.PutTimeRef(kElghlMC, DXAMZQ6b);
					picm.PutDataRef(YF9suxrr, kElghlMC, DXAMZQ6b);
					cjnYxEQx.update(kElghlMC.GetData(DXAMZQ6b));
					cjnYxEQx.update((new Double(kElghlMC.GetTimeStart(DXAMZQ6b))).toString().getBytes());
				}
				if (kElghlMC.NumberOfChannels() > 0) {
					byte[] Yomy2Hj9 = cjnYxEQx.digest(signature.getBytes());
					if (Rqjw48nq >= 0) {
						if (MessageDigest.isEqual(Yomy2Hj9, kElghlMC.GetDataAsByteArray(Rqjw48nq)[0])) {
							System.err.println(pluginName + ": signature matched for: " + kElghlMC.GetName(0));
						} else {
							System.err.println(pluginName + ": failed signature test, sending null response");
							picm.Clear();
						}
					} else {
						System.err.println(pluginName + ": _signature attached for: " + kElghlMC.GetName(0));
						int XGT9YXp3 = picm.Add("_signature");
						picm.PutTime(0., 0.);
						picm.PutDataAsByteArray(XGT9YXp3, Yomy2Hj9);
					}
				}
			}
			plugin.Flush(picm);
		} catch (Exception DqH7DRLA) {
			DqH7DRLA.printStackTrace();
		}
		if (threadStack.size() < 4)
			threadStack.push(this);
		else
			sink.CloseRBNBConnection();
	}

}