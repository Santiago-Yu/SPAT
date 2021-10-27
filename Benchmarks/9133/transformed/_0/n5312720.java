class n5312720 {
	public void putMedia(Media z31zvsIU) {
		if (z31zvsIU == null) {
			return;
		}
		if (_conn == null) {
			log.error("DatabaseDatastore not connected!");
			return;
		}
		if (log.isTraceEnabled()) {
			log.trace("Writing Media " + z31zvsIU.toString() + " to database");
		}
		try {
			try {
				long q5xwdewP = getLocalID(z31zvsIU, _conn);
				if (z31zvsIU.isBaseDirty()) {
					if (log.isTraceEnabled()) {
						log.trace("Need to update base " + z31zvsIU.getID() + " to database");
					}
					Integer YhoyfNID = getArtistID(z31zvsIU, _conn);
					Integer fLOrUPb6 = getAuthorID(z31zvsIU, _conn);
					Integer XfrqXfKD = getArtistAliasID(z31zvsIU, _conn);
					PreparedStatement sGjEuZW5 = _conn.prepareStatement(
							"update media_track set track_name=?,track_artist_id=?,track_author_id=?,track_artist_alias_id=?,track_audit_timestamp=CURRENT_TIMESTAMP where track_id = ?");
					sGjEuZW5.setString(1, z31zvsIU.getName());
					if (YhoyfNID != null) {
						sGjEuZW5.setLong(2, YhoyfNID);
					} else {
						sGjEuZW5.setNull(2, Types.BIGINT);
					}
					if (fLOrUPb6 != null) {
						sGjEuZW5.setLong(3, fLOrUPb6);
					} else {
						sGjEuZW5.setNull(3, Types.BIGINT);
					}
					if (XfrqXfKD != null) {
						sGjEuZW5.setLong(4, XfrqXfKD);
					} else {
						sGjEuZW5.setNull(4, Types.BIGINT);
					}
					sGjEuZW5.setLong(5, q5xwdewP);
					sGjEuZW5.executeUpdate();
					sGjEuZW5.close();
				}
				if (z31zvsIU.isUserDirty()) {
					if (log.isTraceEnabled()) {
						log.trace("Need to update user " + z31zvsIU.getID() + " to database");
					}
					PreparedStatement hkpZzzyX = _conn.prepareStatement(
							"update media_track_rating set rating=?, play_count=? where track_id=? and user_id=?");
					hkpZzzyX.setFloat(1, z31zvsIU.getRating());
					hkpZzzyX.setLong(2, z31zvsIU.getPlayCount());
					hkpZzzyX.setLong(3, q5xwdewP);
					hkpZzzyX.setLong(4, userid);
					if (hkpZzzyX.executeUpdate() != 1) {
						hkpZzzyX.close();
					}
					hkpZzzyX.close();
				}
				if (z31zvsIU.isContentDirty()) {
					updateLocation(z31zvsIU, _conn);
				}
				_conn.commit();
				z31zvsIU.resetDirty();
				if (log.isTraceEnabled()) {
					log.trace("Committed " + z31zvsIU.getID() + " to database");
				}
			} catch (Exception EnuFuQMH) {
				log.error(EnuFuQMH.toString(), EnuFuQMH);
				_conn.rollback();
			}
		} catch (Exception frT6fedM) {
			log.error(frT6fedM.toString(), frT6fedM);
		}
	}

}