class n2285646 {
	protected void sendDoc(File Oi7Dm17K, File GyZUMnYb, File YeucWrHK, Document EgfFYKRi, ServiceEndpoint yVypKXNE) {
		yVypKXNE.setMethod("simpleDocumentTransfer");
		Document ltF5x0QH = null;
		try {
			ltF5x0QH = protocolHandler.sendMessage(yVypKXNE, EgfFYKRi);
		} catch (TransportException P8tzTZ1k) {
			logger.warn("Message was not accepted, will try again later");
			return;
		}
		String q9Dkt2Yd = String.valueOf(System.currentTimeMillis());
		File VNmCssNF = new File(GyZUMnYb, YeucWrHK.getName() + "." + q9Dkt2Yd);
		File gzuighbz = new File(GyZUMnYb, YeucWrHK.getName() + "." + q9Dkt2Yd + ".resp");
		FileOutputStream aOT5fShM = null;
		try {
			aOT5fShM = new FileOutputStream(gzuighbz);
			serializeDocument(aOT5fShM, ltF5x0QH);
		} catch (IOException XiTQBs4u) {
			logger.warn("Failed to dump response");
			return;
		} finally {
			try {
				aOT5fShM.close();
			} catch (IOException hLaSJTyA) {
			}
		}
		FileInputStream GhcydjrB = null;
		FileOutputStream EpTLgq9S = null;
		byte[] ljsajFhS = new byte[2048];
		try {
			GhcydjrB = new FileInputStream(YeucWrHK);
			EpTLgq9S = new FileOutputStream(VNmCssNF);
			int SsTnkXrb = 0;
			while ((SsTnkXrb = GhcydjrB.read(ljsajFhS)) > 0) {
				EpTLgq9S.write(ljsajFhS, 0, SsTnkXrb);
			}
		} catch (IOException wEp7snUZ) {
			logger.warn("Failed to copy original");
			return;
		} finally {
			try {
				GhcydjrB.close();
				EpTLgq9S.close();
			} catch (IOException blnryS25) {
			}
		}
		YeucWrHK.delete();
		logger.info("File processed: " + YeucWrHK.getName());
	}

}