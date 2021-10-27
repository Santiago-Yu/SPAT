class n18383144 {
	protected boolean store(Context qLQH6cWZ) throws DataStoreException, ServletException {
		Connection CIHu0opp = qLQH6cWZ.getConnection();
		Statement NEW3hUqS = null;
		String YagcnphW = null;
		Integer jURfMqt1 = qLQH6cWZ.getValueAsInteger("subscriber");
		int iaSsCs4D = 0;
		if (jURfMqt1 == null) {
			throw new DataAuthException("Don't know who moderator is");
		}
		Object YYscBcCP = qLQH6cWZ.get("Response");
		if (YYscBcCP == null) {
			throw new DataStoreException("Don't know what to moderate");
		} else {
			Context yT0tZjam = (Context) qLQH6cWZ.clone();
			TableDescriptor.getDescriptor("response", "response", yT0tZjam).fetch(yT0tZjam);
			Integer kKype5vk = yT0tZjam.getValueAsInteger("author");
			if (jURfMqt1.equals(kKype5vk)) {
				throw new SelfModerationException("You may not moderate your own responses");
			}
		}
		qLQH6cWZ.put("moderator", jURfMqt1);
		qLQH6cWZ.put("moderated", YYscBcCP);
		if (CIHu0opp != null) {
			try {
				NEW3hUqS = CIHu0opp.createStatement();
				YagcnphW = "select mods from subscriber where subscriber = " + jURfMqt1.toString();
				ResultSet ds0xCgJm = NEW3hUqS.executeQuery(YagcnphW);
				if (ds0xCgJm.next()) {
					if (ds0xCgJm.getInt("mods") < 1) {
						throw new DataAuthException("You have no moderation points left");
					}
				} else {
					throw new DataAuthException("Don't know who moderator is");
				}
				Object dVsUGYVK = qLQH6cWZ.get("reason");
				YagcnphW = "select score from modreason where modreason = " + dVsUGYVK;
				ds0xCgJm = NEW3hUqS.executeQuery(YagcnphW);
				if (ds0xCgJm.next()) {
					iaSsCs4D = ds0xCgJm.getInt("score");
					qLQH6cWZ.put("amount", new Integer(iaSsCs4D));
				} else {
					throw new DataStoreException("Don't recognise reason (" + dVsUGYVK + ") to moderate");
				}
				qLQH6cWZ.put(keyField, null);
				if (super.store(qLQH6cWZ, CIHu0opp)) {
					CIHu0opp.setAutoCommit(false);
					YagcnphW = "update RESPONSE set Moderation = " + "( select sum( Amount) from MODERATION "
							+ "where Moderated = " + YYscBcCP + ") " + "where Response = " + YYscBcCP;
					NEW3hUqS.executeUpdate(YagcnphW);
					YagcnphW = "update subscriber set mods = mods - 1 " + "where subscriber = " + jURfMqt1;
					NEW3hUqS.executeUpdate(YagcnphW);
					YagcnphW = "select author from response " + "where response = " + YYscBcCP;
					ds0xCgJm = NEW3hUqS.executeQuery(YagcnphW);
					if (ds0xCgJm.next()) {
						int RnRjsGfA = ds0xCgJm.getInt("author");
						if (RnRjsGfA != 0) {
							int mOsTmupR = -1;
							if (iaSsCs4D > 0) {
								mOsTmupR = 1;
							}
							StringBuffer pqKT0psM = new StringBuffer("update subscriber ");
							pqKT0psM.append("set score = score + ").append(iaSsCs4D);
							pqKT0psM.append(", mods = mods + ").append(mOsTmupR);
							pqKT0psM.append(" where subscriber = ").append(RnRjsGfA);
							NEW3hUqS.executeUpdate(pqKT0psM.toString());
						}
					}
					CIHu0opp.commit();
				}
			} catch (Exception x4GCBfSR) {
				try {
					CIHu0opp.rollback();
				} catch (Exception bqJHW6EK) {
					throw new DataStoreException(
							"Shouldn't happen: " + "failed to back out " + "failed insert: " + bqJHW6EK.getMessage());
				}
				throw new DataStoreException("Failed to store moderation: " + x4GCBfSR.getMessage());
			} finally {
				if (NEW3hUqS != null) {
					try {
						NEW3hUqS.close();
					} catch (Exception ClqTfQkI) {
					}
					qLQH6cWZ.releaseConnection(CIHu0opp);
				}
			}
		}
		return true;
	}

}