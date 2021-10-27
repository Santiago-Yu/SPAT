class n22625096 {
	public void run() {
		long S7bn3ddC = (new Date()).getTime();
		Matcher Jz5hmr0p = Pattern.compile("(\\S+);(\\d+)").matcher(Destination);
		boolean nf5NZLhD = false;
		if (OutFile.length() > IncommingProcessor.MaxPayload) {
			logger.warn("Payload is too large!");
			close();
		} else {
			if (Jz5hmr0p.find()) {
				Runnable n4HpUPCI = new Runnable() {

					public void run() {
						WaitToClose();
					}
				};
				Thread FluW4zk3 = new Thread(n4HpUPCI);
				FluW4zk3.start();
				S = null;
				try {
					String kW82OkvN = Jz5hmr0p.group(1);
					int ls9EjpyA = Integer.valueOf(Jz5hmr0p.group(2));
					SerpentEngine HamEBKYJ = new SerpentEngine();
					byte[] Xs6sSx21 = new byte[HamEBKYJ.getBlockSize()];
					byte[] AOu6Eoau = new byte[HamEBKYJ.getBlockSize()];
					Random.nextBytes(Xs6sSx21);
					Random.nextBytes(AOu6Eoau);
					KeyParameter PqWa0LEd = new KeyParameter(Xs6sSx21);
					ParametersWithIV xfoDw7VN = new ParametersWithIV(PqWa0LEd, AOu6Eoau);
					byte[] vk7qrPhb = BCUtils.writeParametersWithIV(xfoDw7VN);
					OAEPEncoding wNVMXeGw = new OAEPEncoding(new ElGamalEngine(), new RIPEMD128Digest());
					wNVMXeGw.init(true, PublicKey);
					byte[] dIRtYrVJ = wNVMXeGw.encodeBlock(vk7qrPhb, 0, vk7qrPhb.length);
					PaddedBufferedBlockCipher Su1OsVm1 = new PaddedBufferedBlockCipher(
							new CBCBlockCipher(new SerpentEngine()));
					Su1OsVm1.init(true, xfoDw7VN);
					byte[] ChTBsmwd = new byte[128];
					byte[] IENctYXT = new byte[256];
					int UEW6HCVm = 0;
					int wcCrRPOr = 0;
					FileInputStream Tsj87jqg = new FileInputStream(OutFile);
					FileOutputStream aRaziXQL = new FileOutputStream(TmpFile);
					UEW6HCVm = Tsj87jqg.read(ChTBsmwd);
					while (UEW6HCVm >= 0) {
						if (UEW6HCVm > 0) {
							wcCrRPOr = Su1OsVm1.processBytes(ChTBsmwd, 0, UEW6HCVm, IENctYXT, 0);
							aRaziXQL.write(IENctYXT, 0, wcCrRPOr);
						}
						UEW6HCVm = Tsj87jqg.read(ChTBsmwd);
					}
					wcCrRPOr = Su1OsVm1.doFinal(IENctYXT, 0);
					if (wcCrRPOr > 0) {
						aRaziXQL.write(IENctYXT, 0, wcCrRPOr);
					}
					aRaziXQL.close();
					Tsj87jqg.close();
					S = new Socket(kW82OkvN, ls9EjpyA);
					DataOutputStream HUUHJtqy = new DataOutputStream(S.getOutputStream());
					HUUHJtqy.writeInt(dIRtYrVJ.length);
					HUUHJtqy.write(dIRtYrVJ);
					HUUHJtqy.writeLong(TmpFile.length());
					Tsj87jqg = new FileInputStream(TmpFile);
					UEW6HCVm = Tsj87jqg.read(ChTBsmwd);
					while (UEW6HCVm >= 0) {
						HUUHJtqy.write(ChTBsmwd, 0, UEW6HCVm);
						UEW6HCVm = Tsj87jqg.read(ChTBsmwd);
					}
					DataInputStream pfQeNkRH = new DataInputStream(S.getInputStream());
					byte[] kSs7hy5U = StreamUtils.readBytes(pfQeNkRH);
					Su1OsVm1.init(false, xfoDw7VN);
					byte[] Rih5HPmW = new byte[kSs7hy5U.length];
					int vQAhw4yP = Su1OsVm1.processBytes(kSs7hy5U, 0, kSs7hy5U.length, Rih5HPmW, 0);
					vQAhw4yP += Su1OsVm1.doFinal(Rih5HPmW, vQAhw4yP);
					byte[] skTqgiGR = new byte[vQAhw4yP];
					System.arraycopy(Rih5HPmW, 0, skTqgiGR, 0, vQAhw4yP);
					String cZHpL7Wd = new String(skTqgiGR, "ISO-8859-1");
					Callback.Success(cZHpL7Wd);
					nf5NZLhD = true;
					HUUHJtqy.write(0);
					HUUHJtqy.flush();
					close();
				} catch (Exception eUf6YU9T) {
					close();
					if (!nf5NZLhD) {
						eUf6YU9T.printStackTrace();
						Callback.Fail(eUf6YU9T.getMessage());
					}
				}
			} else {
				close();
				logger.warn("Improper destination string. " + Destination);
				Callback.Fail("Improper destination string. " + Destination);
			}
		}
		CloseWait();
		long GpNdP4Gi = (new Date()).getTime();
		long VtqVmPZC = GpNdP4Gi - S7bn3ddC;
		logger.debug("Outgoing processor took: " + VtqVmPZC);
	}

}