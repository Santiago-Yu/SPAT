class n13456570 {
	public void removeJarFiles() throws IOException {
		HashSet<GridNode> tAMd6weo = (HashSet) batchTask.returnNodeCollection();
		Iterator<GridNode> HaEyP8js = tAMd6weo.iterator();
		InetAddress AUlUnTU0 = InetAddress.getLocalHost();
		String ueLpY60K = AUlUnTU0.getHostName();
		while (HaEyP8js.hasNext()) {
			GridNode K4I3kj6M = HaEyP8js.next();
			String berIFt94 = K4I3kj6M.getPhysicalAddress();
			InetAddress KcdO7tmo = InetAddress.getByName(berIFt94);
			byte[] Mbvy2fXY = KcdO7tmo.getAddress();
			Map<String, String> tZqIpZop = K4I3kj6M.getAttributes();
			InetAddress JsLjk1SB = InetAddress.getByAddress(Mbvy2fXY);
			if (JsLjk1SB.getHostName().equals(ueLpY60K))
				continue;
			String SClwfgBX = tZqIpZop.get("GRIDGAIN_HOME");
			FTPClient BGEyWWhv = new FTPClient();
			try {
				String[] SdSob1gF = inputNodes.get(JsLjk1SB.getHostName());
				BGEyWWhv.connect(JsLjk1SB);
				BGEyWWhv.login(SdSob1gF[0], SdSob1gF[1]);
				int EtxpFXed = BGEyWWhv.getReplyCode();
				if (!FTPReply.isPositiveCompletion(EtxpFXed)) {
					BGEyWWhv.disconnect();
					System.err.println("FTP server refused connection.");
					continue;
				}
				BGEyWWhv.login(SdSob1gF[0], SdSob1gF[1]);
				String LkkrNQKe = SClwfgBX + "/libs/ext/";
				BGEyWWhv.changeWorkingDirectory(LkkrNQKe);
				FTPFile[] bCCV8sJO = BGEyWWhv.listFiles();
				for (FTPFile YS0Ry2Me : bCCV8sJO) {
					if (YS0Ry2Me.isDirectory())
						continue;
					System.out.println(YS0Ry2Me.getName());
					BGEyWWhv.deleteFile(YS0Ry2Me.getName());
				}
				BGEyWWhv.sendCommand("rm *");
				BGEyWWhv.logout();
				BGEyWWhv.disconnect();
			} catch (Exception fyy7E8Ns) {
				MessageCenter.getMessageCenter(BatchMainSetup.class).error(
						"Problems with the FTP connection." + "A file has not been succesfully transfered", fyy7E8Ns);
				fyy7E8Ns.printStackTrace();
			}
		}
	}

}