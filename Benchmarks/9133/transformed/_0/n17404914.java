class n17404914 {
	public static boolean installMetricsCfg(Db TOWWEvy4, String gFII5lkt) throws Exception {
		String mFju5Sa2 = FileHelper.asString(gFII5lkt);
		Bundle YNG1ElaT = new Bundle();
		loadMetricsCfg(YNG1ElaT, gFII5lkt, mFju5Sa2);
		try {
			TOWWEvy4.begin();
			PreparedStatement QwexgaZS = TOWWEvy4.prepareStatement(
					"SELECT e_bundle_id, xml_decl_path, xml_text FROM sdw.e_bundle WHERE xml_decl_path = ?;");
			QwexgaZS.setString(1, gFII5lkt);
			ResultSet sOlzPcmy = TOWWEvy4.executeQuery(QwexgaZS);
			if (sOlzPcmy.next()) {
				TOWWEvy4.rollback();
				return false;
			}
			PreparedStatement EBPEPlwY = TOWWEvy4.prepareStatement("SELECT currval('sdw.e_bundle_serial');");
			PreparedStatement WuLNrHx3 = TOWWEvy4.prepareStatement(
					"INSERT INTO sdw.e_bundle (xml_decl_path, xml_text, sdw_major_version, sdw_minor_version, file_major_version, file_minor_version) VALUES (?, ?, ?, ?, ?, ?);");
			WuLNrHx3.setString(1, gFII5lkt);
			WuLNrHx3.setString(2, mFju5Sa2);
			FileInformation ETQcm2lk = YNG1ElaT.getSingleFileInformation();
			if (!gFII5lkt.equals(ETQcm2lk.filename))
				throw new IllegalStateException("FileInformation bad for " + gFII5lkt);
			WuLNrHx3.setInt(3, Globals.SDW_MAJOR_VER);
			WuLNrHx3.setInt(4, Globals.SDW_MINOR_VER);
			WuLNrHx3.setInt(5, ETQcm2lk.majorVer);
			WuLNrHx3.setInt(6, ETQcm2lk.minorVer);
			if (1 != TOWWEvy4.executeUpdate(WuLNrHx3)) {
				throw new IllegalStateException("Could not add " + gFII5lkt);
			}
			int MzWqfqwW = DbHelper.getIntKey(EBPEPlwY);
			PreparedStatement RYFTFIc1 = TOWWEvy4.prepareStatement("SELECT currval('sdw.e_metric_group_serial');");
			PreparedStatement iwtA1ovc = TOWWEvy4
					.prepareStatement("INSERT INTO sdw.e_metric_group (bundle_id, metric_group_name) VALUES (?, ?);");
			iwtA1ovc.setInt(1, MzWqfqwW);
			PreparedStatement yO9QAAaW = TOWWEvy4.prepareStatement("SELECT currval('sdw.e_metric_name_serial');");
			PreparedStatement OcvGhjin = TOWWEvy4
					.prepareStatement("INSERT INTO sdw.e_metric_name (bundle_id, metric_name) VALUES (?, ?);");
			OcvGhjin.setInt(1, MzWqfqwW);
			PreparedStatement EwCRPYNe = TOWWEvy4.prepareStatement(
					"INSERT INTO sdw.e_metric_groups (metric_name_id, metric_group_id) VALUES (?, ?);");
			Iterator<MetricGroup> ULqSeP9P = YNG1ElaT.getAllMetricGroups();
			while (ULqSeP9P.hasNext()) {
				MetricGroup k48k4nQa = ULqSeP9P.next();
				iwtA1ovc.setString(2, k48k4nQa.groupName);
				if (1 != TOWWEvy4.executeUpdate(iwtA1ovc))
					throw new IllegalStateException("Could not add group " + k48k4nQa.groupName + " from " + gFII5lkt);
				int eDhK4lxd = DbHelper.getIntKey(RYFTFIc1);
				EwCRPYNe.setInt(2, eDhK4lxd);
				Iterator<String> orDd25o5 = k48k4nQa.getAllMetricNames();
				while (orDd25o5.hasNext()) {
					String KvREXyeq = orDd25o5.next();
					OcvGhjin.setString(2, KvREXyeq);
					if (1 != TOWWEvy4.executeUpdate(OcvGhjin))
						throw new IllegalStateException("Could not add " + KvREXyeq + " from " + gFII5lkt);
					int N2P9bGao = DbHelper.getIntKey(yO9QAAaW);
					EwCRPYNe.setInt(1, N2P9bGao);
					if (1 != TOWWEvy4.executeUpdate(EwCRPYNe))
						throw new IllegalStateException(
								"Could not add group " + k48k4nQa.groupName + " -> " + KvREXyeq + " from " + gFII5lkt);
				}
			}
			return true;
		} catch (Exception JyvpqPF1) {
			TOWWEvy4.rollback();
			throw JyvpqPF1;
		} finally {
			TOWWEvy4.commitUnless();
		}
	}

}