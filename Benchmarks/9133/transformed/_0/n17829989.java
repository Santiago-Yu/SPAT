class n17829989 {
	@Override
	public void run() {
		File N6yPIh3V = new File(loggingDir);
		if (!N6yPIh3V.isDirectory()) {
			logger.error("Logging directory \"" + N6yPIh3V.getAbsolutePath() + "\" does not exist.");
			return;
		}
		File eu6dZOF3 = new File(N6yPIh3V, new Date().toString().replaceAll("[ ,:]", "") + "LoadBalancerLog.txt");
		FileWriter CodpNO81;
		try {
			CodpNO81 = new FileWriter(eu6dZOF3);
		} catch (IOException kwsqqpGc) {
			kwsqqpGc.printStackTrace();
			return;
		}
		int WSK9rcEP = 0;
		while (!isInterrupted() && WSK9rcEP < numProbes) {
			try {
				CodpNO81.write(System.currentTimeMillis() + "," + currentPending + "," + currentThreads + ","
						+ droppedTasks + "," + executionExceptions + "," + currentWeight + "," + averageWaitTime + ","
						+ averageExecutionTime + "#");
				CodpNO81.flush();
			} catch (IOException fAcoCdcP) {
				fAcoCdcP.printStackTrace();
				break;
			}
			WSK9rcEP++;
			try {
				sleep(probeTime);
			} catch (InterruptedException SRnwFEOP) {
				SRnwFEOP.printStackTrace();
				break;
			}
		}
		try {
			CodpNO81.close();
		} catch (IOException PEM4Apk9) {
			PEM4Apk9.printStackTrace();
			return;
		}
		FileReader sbKMQot4;
		try {
			sbKMQot4 = new FileReader(eu6dZOF3);
		} catch (FileNotFoundException BJ7NH6fw) {
			BJ7NH6fw.printStackTrace();
			return;
		}
		Vector<StatStorage> wrYXcYaQ = new Vector<StatStorage>();
		int MX7o5mNu;
		try {
			MX7o5mNu = sbKMQot4.read();
		} catch (IOException xa8FAVYH) {
			xa8FAVYH.printStackTrace();
			MX7o5mNu = -1;
		}
		String qbgsYuR4 = "";
		Date qgkyqxF7 = null;
		Date F1lNFqqp = null;
		while (MX7o5mNu != -1) {
			if (MX7o5mNu == 35) {
				String OmZRW2uw[] = qbgsYuR4.split(",");
				if (qgkyqxF7 == null)
					qgkyqxF7 = new Date(Long.parseLong(OmZRW2uw[0]));
				if (OmZRW2uw.length > 0)
					wrYXcYaQ.add(parse(OmZRW2uw));
				F1lNFqqp = new Date(Long.parseLong(OmZRW2uw[0]));
				qbgsYuR4 = "";
			} else {
				qbgsYuR4 += (char) MX7o5mNu;
			}
			try {
				MX7o5mNu = sbKMQot4.read();
			} catch (IOException pJq62guk) {
				pJq62guk.printStackTrace();
			}
		}
		try {
			sbKMQot4.close();
		} catch (IOException RIwTgAc0) {
			RIwTgAc0.printStackTrace();
		}
		if (wrYXcYaQ.size() > 0) {
			int[] lPMnwWsm = new int[wrYXcYaQ.size()];
			int[] VNSTaVEx = new int[wrYXcYaQ.size()];
			long[] aG3WuuDd = new long[wrYXcYaQ.size()];
			long[] CjyRYdpD = new long[wrYXcYaQ.size()];
			int[] Ljjg7Yzi = new int[wrYXcYaQ.size()];
			long[] Bl95rjFp = new long[wrYXcYaQ.size()];
			long[] OUpem0av = new long[wrYXcYaQ.size()];
			for (int VcP3ZroK = 0; VcP3ZroK < wrYXcYaQ.size(); VcP3ZroK++) {
				lPMnwWsm[VcP3ZroK] = wrYXcYaQ.get(VcP3ZroK).pending;
				VNSTaVEx[VcP3ZroK] = wrYXcYaQ.get(VcP3ZroK).occupied;
				aG3WuuDd[VcP3ZroK] = wrYXcYaQ.get(VcP3ZroK).dropped;
				CjyRYdpD[VcP3ZroK] = wrYXcYaQ.get(VcP3ZroK).exceptions;
				Ljjg7Yzi[VcP3ZroK] = wrYXcYaQ.get(VcP3ZroK).currentWeight;
				Bl95rjFp[VcP3ZroK] = (long) wrYXcYaQ.get(VcP3ZroK).executionTime;
				OUpem0av[VcP3ZroK] = (long) wrYXcYaQ.get(VcP3ZroK).waitTime;
			}
			String gM9EifFe = qgkyqxF7.toString();
			gM9EifFe = gM9EifFe.replaceAll("[ ,:]", "");
			eu6dZOF3 = new File(N6yPIh3V, gM9EifFe + "pending.gif");
			SimpleChart.drawChart(eu6dZOF3, 640, 480, lPMnwWsm, qgkyqxF7, F1lNFqqp, new Color(0, 0, 0));
			eu6dZOF3 = new File(N6yPIh3V, gM9EifFe + "occupied.gif");
			SimpleChart.drawChart(eu6dZOF3, 640, 480, VNSTaVEx, qgkyqxF7, F1lNFqqp, new Color(0, 0, 0));
			eu6dZOF3 = new File(N6yPIh3V, gM9EifFe + "dropped.gif");
			SimpleChart.drawChart(eu6dZOF3, 640, 480, aG3WuuDd, qgkyqxF7, F1lNFqqp, new Color(0, 0, 0));
			eu6dZOF3 = new File(N6yPIh3V, gM9EifFe + "exceptions.gif");
			SimpleChart.drawChart(eu6dZOF3, 640, 480, CjyRYdpD, qgkyqxF7, F1lNFqqp, new Color(0, 0, 0));
			eu6dZOF3 = new File(N6yPIh3V, gM9EifFe + "weight.gif");
			SimpleChart.drawChart(eu6dZOF3, 640, 480, Ljjg7Yzi, qgkyqxF7, F1lNFqqp, new Color(0, 0, 0));
			eu6dZOF3 = new File(N6yPIh3V, gM9EifFe + "execution.gif");
			SimpleChart.drawChart(eu6dZOF3, 640, 480, Bl95rjFp, qgkyqxF7, F1lNFqqp, new Color(0, 0, 0));
			eu6dZOF3 = new File(N6yPIh3V, gM9EifFe + "wait.gif");
			SimpleChart.drawChart(eu6dZOF3, 640, 480, OUpem0av, qgkyqxF7, F1lNFqqp, new Color(0, 0, 0));
		}
		recordedExecutionThreads = 0;
		recordedWaitingThreads = 0;
		averageExecutionTime = 0;
		averageWaitTime = 0;
		if (!isLocked) {
			debugThread = new DebugThread();
			debugThread.start();
		}
	}

}