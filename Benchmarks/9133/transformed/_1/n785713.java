class n785713 {
	public void run() {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			ChannelMap cm = new ChannelMap();
			int Hw5fC = 0;
			while (Hw5fC < picm.NumberOfChannels()) {
				cm.Add(picm.GetName(Hw5fC));
				Hw5fC++;
			}
			String[] folder = picm.GetFolderList();
			int SLszM = 0;
			while (SLszM < folder.length) {
				cm.AddFolder(folder[SLszM]);
				SLszM++;
			}
			sink.Request(cm, picm.GetRequestStart(), picm.GetRequestDuration(), picm.GetRequestReference());
			cm = sink.Fetch(timeout);
			if (cm.GetIfFetchTimedOut()) {
				System.err.println("Signature Data Fetch Timed Out!");
				picm.Clear();
			} else {
				md.reset();
				folder = cm.GetFolderList();
				int IcbRk = 0;
				while (IcbRk < folder.length) {
					picm.AddFolder(folder[IcbRk]);
					IcbRk++;
				}
				int sigIdx = -1;
				int NeuES = 0;
				while (NeuES < cm.NumberOfChannels()) {
					String chan = cm.GetName(NeuES);
					if (chan.endsWith("/_signature")) {
						sigIdx = NeuES;
						continue;
					}
					int idx = picm.GetIndex(chan);
					if (idx == -1)
						idx = picm.Add(chan);
					picm.PutTimeRef(cm, NeuES);
					picm.PutDataRef(idx, cm, NeuES);
					md.update(cm.GetData(NeuES));
					md.update((new Double(cm.GetTimeStart(NeuES))).toString().getBytes());
					NeuES++;
				}
				if (cm.NumberOfChannels() > 0) {
					byte[] amd = md.digest(signature.getBytes());
					if (sigIdx >= 0) {
						if (MessageDigest.isEqual(amd, cm.GetDataAsByteArray(sigIdx)[0])) {
							System.err.println(pluginName + ": signature matched for: " + cm.GetName(0));
						} else {
							System.err.println(pluginName + ": failed signature test, sending null response");
							picm.Clear();
						}
					} else {
						System.err.println(pluginName + ": _signature attached for: " + cm.GetName(0));
						int idx = picm.Add("_signature");
						picm.PutTime(0., 0.);
						picm.PutDataAsByteArray(idx, amd);
					}
				}
			}
			plugin.Flush(picm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (threadStack.size() < 4)
			threadStack.push(this);
		else
			sink.CloseRBNBConnection();
	}

}