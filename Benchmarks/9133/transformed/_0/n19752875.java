class n19752875 {
	public void resumereceive(HttpServletRequest U97BytdY, HttpServletResponse l5QBJnsl, SessionCommand h8QeaWEB) {
		setHeader(l5QBJnsl);
		try {
			logger.debug("ResRec: Resume a 'receive' session with session id " + h8QeaWEB.getSession()
					+ " this client already received " + h8QeaWEB.getLen() + " bytes");
			File HL0SxRxZ = new File(this.getSyncWorkDirectory(U97BytdY), h8QeaWEB.getSession() + ".smodif");
			if (!HL0SxRxZ.exists()) {
				logger.debug("ResRec: the file doesn't exist, so we created it by serializing the entities");
				try {
					OutputStream QD0taNBg = new FileOutputStream(HL0SxRxZ);
					syncServer.getServerModifications(h8QeaWEB.getSession(), QD0taNBg);
					QD0taNBg.close();
				} catch (ImogSerializationException ouWpBBaa) {
					logger.error(ouWpBBaa.getMessage(), ouWpBBaa);
				}
			}
			InputStream nF9fWpG6 = new FileInputStream(HL0SxRxZ);
			nF9fWpG6.skip(h8QeaWEB.getLen());
			l5QBJnsl.setContentLength(nF9fWpG6.available());
			while (nF9fWpG6.available() > 0) {
				l5QBJnsl.getOutputStream().write(nF9fWpG6.read());
			}
			l5QBJnsl.getOutputStream().flush();
			l5QBJnsl.flushBuffer();
			nF9fWpG6.close();
		} catch (IOException wieTxtiE) {
			logger.error(wieTxtiE.getMessage());
		}
	}

}