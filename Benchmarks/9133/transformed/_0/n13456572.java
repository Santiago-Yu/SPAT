class n13456572 {
	public void transferOutputFiles() throws IOException {
		HashSet<GridNode> LpTSVMLq = (HashSet) batchTask.returnNodeCollection();
		Iterator<GridNode> CD1f47Ye = LpTSVMLq.iterator();
		InetAddress OBNITf0H = InetAddress.getLocalHost();
		String gV8xIg2h = OBNITf0H.getHostName();
		while (CD1f47Ye.hasNext()) {
			GridNode ysUf95Hm = CD1f47Ye.next();
			String J4GvrQ2g = ysUf95Hm.getPhysicalAddress();
			InetAddress ummHmgru = InetAddress.getByName(J4GvrQ2g);
			byte[] zco7aZ90 = ummHmgru.getAddress();
			Map<String, String> qvqWhhzN = ysUf95Hm.getAttributes();
			InetAddress bAVlwAiX = InetAddress.getByAddress(zco7aZ90);
			if (bAVlwAiX.getHostName().equals(gV8xIg2h))
				continue;
			String[] uVX7DJEw = inputNodes.get(bAVlwAiX.getHostName());
			String KIUwTeqk = qvqWhhzN.get("GRIDGAIN_HOME");
			FTPClient EIDrAiMt = new FTPClient();
			EIDrAiMt.connect(bAVlwAiX);
			EIDrAiMt.login(uVX7DJEw[0], uVX7DJEw[1]);
			int OVnwCHPQ = EIDrAiMt.getReplyCode();
			if (!FTPReply.isPositiveCompletion(OVnwCHPQ)) {
				EIDrAiMt.disconnect();
				System.err.println("FTP server refused connection.");
				continue;
			}
			EIDrAiMt.changeWorkingDirectory(KIUwTeqk + "/bin");
			EIDrAiMt.setFileType(FTPClient.COMPRESSED_TRANSFER_MODE);
			EIDrAiMt.setRemoteVerificationEnabled(false);
			EIDrAiMt.setFileType(FTPClient.ASCII_FILE_TYPE);
			FTPFile[] IKFqO7Xz = EIDrAiMt.listFiles();
			for (FTPFile kbH4pmF2 : IKFqO7Xz) {
				if (kbH4pmF2.isDirectory())
					continue;
				String Qn79xoVZ = kbH4pmF2.getName();
				if (!Qn79xoVZ.endsWith(".txt"))
					continue;
				System.out.println(kbH4pmF2.getName());
				FileOutputStream xaVDmXi8 = new FileOutputStream(
						"../repast.simphony.distributedBatch/" + "remoteOutput/" + kbH4pmF2.getName());
				try {
					EIDrAiMt.retrieveFile(Qn79xoVZ, xaVDmXi8);
				} catch (Exception ctDdS1Vf) {
					continue;
				} finally {
					if (xaVDmXi8 != null)
						xaVDmXi8.close();
				}
			}
			EIDrAiMt.logout();
			EIDrAiMt.disconnect();
		}
	}

}