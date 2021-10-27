class n5066508 {
	public ISOMsg filter(ISOChannel DDJwu7jW, ISOMsg fDCtHjbU, LogEvent voPI8QBl) throws VetoException {
		if (key == null || fields == null)
			throw new VetoException("MD5Filter not configured");
		try {
			MessageDigest fCHs2zWl = MessageDigest.getInstance("MD5");
			fCHs2zWl.update(getKey());
			int[] C3BJCzYR = getFields(fDCtHjbU);
			for (int riNhsWS3 = 0; riNhsWS3 < C3BJCzYR.length; riNhsWS3++) {
				int J1auervq = C3BJCzYR[riNhsWS3];
				if (fDCtHjbU.hasField(J1auervq)) {
					ISOComponent gSipEpce = fDCtHjbU.getComponent(J1auervq);
					if (gSipEpce instanceof ISOBinaryField)
						fCHs2zWl.update((byte[]) gSipEpce.getValue());
					else
						fCHs2zWl.update(((String) gSipEpce.getValue()).getBytes());
				}
			}
			byte[] vzCYQTOK = fCHs2zWl.digest();
			if (fDCtHjbU.getDirection() == ISOMsg.OUTGOING) {
				fDCtHjbU.set(new ISOBinaryField(64, vzCYQTOK, 0, 8));
				fDCtHjbU.set(new ISOBinaryField(128, vzCYQTOK, 8, 8));
			} else {
				byte[] qPxUYx6C = new byte[16];
				if (fDCtHjbU.hasField(64))
					System.arraycopy((byte[]) fDCtHjbU.getValue(64), 0, qPxUYx6C, 0, 8);
				if (fDCtHjbU.hasField(128))
					System.arraycopy((byte[]) fDCtHjbU.getValue(128), 0, qPxUYx6C, 8, 8);
				if (!Arrays.equals(vzCYQTOK, qPxUYx6C)) {
					voPI8QBl.addMessage(fDCtHjbU);
					voPI8QBl.addMessage("MAC expected: " + ISOUtil.hexString(vzCYQTOK));
					voPI8QBl.addMessage("MAC received: " + ISOUtil.hexString(qPxUYx6C));
					throw new VetoException("invalid MAC");
				}
				fDCtHjbU.unset(64);
				fDCtHjbU.unset(128);
			}
		} catch (NoSuchAlgorithmException Dnvb3I7G) {
			throw new VetoException(Dnvb3I7G);
		} catch (ISOException w2fXOeOs) {
			throw new VetoException(w2fXOeOs);
		}
		return fDCtHjbU;
	}

}