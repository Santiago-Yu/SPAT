class n3331971 {
	protected void onSubmit() {
		try {
			Connection M9NnNjNP = ((JdbcRequestCycle) getRequestCycle()).getConnection();
			String yBnq39VE = "insert into entry (author, accessibility) values(?,?)";
			PreparedStatement l5DSatsq = M9NnNjNP.prepareStatement(yBnq39VE);
			l5DSatsq.setInt(1, userId);
			l5DSatsq.setInt(2, accessibility.getId());
			l5DSatsq.executeUpdate();
			ResultSet RtHjxZps = l5DSatsq.getGeneratedKeys();
			RtHjxZps.next();
			int mT49zuuc = RtHjxZps.getInt(1);
			yBnq39VE = "insert into revisions (title, entry, content, tags," + " revision_remark) values(?,?,?,?,?)";
			PreparedStatement ffwwacen = M9NnNjNP.prepareStatement(yBnq39VE);
			ffwwacen.setString(1, getTitle());
			ffwwacen.setInt(2, mT49zuuc);
			ffwwacen.setString(3, getContent());
			ffwwacen.setString(4, getTags());
			ffwwacen.setString(5, "newly added");
			int mVpArXmi = ffwwacen.executeUpdate();
			if (mVpArXmi > 0) {
				info("Successfully added one new record.");
			} else {
				M9NnNjNP.rollback();
				info("Addition of one new record failed.");
			}
		} catch (SQLException zstuNxVO) {
			zstuNxVO.printStackTrace();
		}
	}

}