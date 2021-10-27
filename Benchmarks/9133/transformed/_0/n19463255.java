class n19463255 {
	public boolean updateLOB(String Bhy5u2Zq, int uFiQX8Td, Object s3gypcYX, String mMYUKlK9, SecurityToken i6rkbW8X) {
		validateSecurityToken(i6rkbW8X);
		if (Bhy5u2Zq == null || s3gypcYX == null) {
			log.fine("No sql or data");
			return false;
		}
		log.fine(Bhy5u2Zq);
		Trx ZRB5t69G = null;
		if (mMYUKlK9 != null && mMYUKlK9.trim().length() > 0) {
			ZRB5t69G = Trx.get(mMYUKlK9, false);
			if (ZRB5t69G == null)
				throw new RuntimeException("Transaction lost - " + mMYUKlK9);
		}
		m_updateLOBCount++;
		boolean LZWi2iPw = true;
		Connection zlEDP8tI = ZRB5t69G != null ? ZRB5t69G.getConnection()
				: DB.createConnection(false, Connection.TRANSACTION_READ_COMMITTED);
		PreparedStatement c9SrCYfg = null;
		try {
			c9SrCYfg = zlEDP8tI.prepareStatement(Bhy5u2Zq);
			if (uFiQX8Td == DisplayType.TextLong)
				c9SrCYfg.setString(1, (String) s3gypcYX);
			else
				c9SrCYfg.setBytes(1, (byte[]) s3gypcYX);
			int uBr2b3xC = c9SrCYfg.executeUpdate();
		} catch (Exception TYedg6TX) {
			log.log(Level.FINE, Bhy5u2Zq, TYedg6TX);
			LZWi2iPw = false;
		} finally {
			DB.close(c9SrCYfg);
			c9SrCYfg = null;
		}
		if (LZWi2iPw && ZRB5t69G == null) {
			try {
				zlEDP8tI.commit();
			} catch (Exception YoiDXRYQ) {
				log.log(Level.SEVERE, "commit", YoiDXRYQ);
				LZWi2iPw = false;
			} finally {
				try {
					zlEDP8tI.close();
				} catch (SQLException FlkYdUPI) {
				}
				zlEDP8tI = null;
			}
		}
		if (!LZWi2iPw) {
			log.severe("rollback");
			if (ZRB5t69G == null) {
				try {
					zlEDP8tI.rollback();
				} catch (Exception ioo8b61P) {
					log.log(Level.SEVERE, "rollback", ioo8b61P);
				} finally {
					try {
						zlEDP8tI.close();
					} catch (SQLException z2MxdgYX) {
					}
					zlEDP8tI = null;
				}
			} else {
				ZRB5t69G.rollback();
			}
		}
		return LZWi2iPw;
	}

}