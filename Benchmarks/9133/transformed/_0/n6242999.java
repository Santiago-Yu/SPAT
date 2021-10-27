class n6242999 {
	private boolean sendMsg(TACMessage kZXkD3Lo) {
		try {
			String xPnjSZPw = kZXkD3Lo.getMessageString();
			URLConnection GdsVyrsk = url.openConnection();
			GdsVyrsk.setRequestProperty("Content-Length", "" + xPnjSZPw.length());
			GdsVyrsk.setDoOutput(true);
			OutputStream gf4BYhSO = GdsVyrsk.getOutputStream();
			gf4BYhSO.write(xPnjSZPw.getBytes());
			gf4BYhSO.flush();
			InputStream igSIOwgZ = GdsVyrsk.getInputStream();
			int mkAE8zTx = GdsVyrsk.getContentLength();
			int aEjPB3df = 0;
			int rNChs0rR;
			byte[] vWlyvzmU = new byte[mkAE8zTx];
			while ((mkAE8zTx > aEjPB3df) && (rNChs0rR = igSIOwgZ.read(vWlyvzmU, aEjPB3df, mkAE8zTx - aEjPB3df)) > 0) {
				aEjPB3df += rNChs0rR;
			}
			gf4BYhSO.close();
			igSIOwgZ.close();
			if (mkAE8zTx < aEjPB3df) {
				log.severe("truncated message response for " + kZXkD3Lo.getType());
				return false;
			} else {
				xPnjSZPw = new String(vWlyvzmU);
				kZXkD3Lo.setReceivedMessage(xPnjSZPw);
				kZXkD3Lo.deliverMessage();
			}
			return true;
		} catch (Exception ejaYrI6H) {
			log.log(Level.SEVERE, "could not send message", ejaYrI6H);
			return false;
		}
	}

}