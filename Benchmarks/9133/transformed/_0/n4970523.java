class n4970523 {
	@Override
	public void execute(JobExecutionContext jvsuoulo) throws JobExecutionException {
		super.execute(jvsuoulo);
		debug("Start execute job " + this.getClass().getName());
		String qQhFFpSw = this.path_app_root + "/" + this.properties.get("dir") + "/";
		try {
			File m1hTpycj = new File(qQhFFpSw);
			if (!m1hTpycj.exists()) {
				debug("(0) - make dir: " + m1hTpycj + " - ");
				org.apache.commons.io.FileUtils.forceMkdir(m1hTpycj);
			}
		} catch (IOException S9YLgNsG) {
			fatal("IOException", S9YLgNsG);
		}
		debug("Files:" + this.properties.get("url"));
		String[] mpGPeFaY = properties.get("url").split(";");
		for (String eldLKV4u : mpGPeFaY) {
			if (StringUtil.isNullOrEmpty(eldLKV4u)) {
				continue;
			}
			eldLKV4u = StringUtil.trim(eldLKV4u);
			debug("(0) url: " + eldLKV4u);
			String P02oxFAk = eldLKV4u.substring(eldLKV4u.lastIndexOf("/"), eldLKV4u.length());
			debug("(1) - start download: " + eldLKV4u + " to file name: "
					+ new File(qQhFFpSw + "/" + P02oxFAk).toString());
			com.utils.HttpUtil.downloadData(eldLKV4u, new File(qQhFFpSw + "/" + P02oxFAk).toString());
		}
		try {
			conn_stats.setAutoCommit(false);
		} catch (SQLException LwrZH7O7) {
			fatal("SQLException", LwrZH7O7);
		}
		String[] ysnPNw95 = properties.get("query_delete").split(";");
		for (String kDQq1PWK : ysnPNw95) {
			if (StringUtil.isNullOrEmpty(kDQq1PWK)) {
				continue;
			}
			kDQq1PWK = StringUtil.trim(kDQq1PWK);
			debug("(2) - " + kDQq1PWK);
			try {
				Statement U5KEw5Hu = conn_stats.createStatement();
				U5KEw5Hu.executeUpdate(kDQq1PWK);
				U5KEw5Hu.close();
			} catch (SQLException KIXQIBhz) {
				try {
					conn_stats.rollback();
				} catch (SQLException RkBieDrr) {
					fatal("SQLException", RkBieDrr);
				}
				fatal("SQLException", KIXQIBhz);
			}
		}
		for (String GCrbt4Ur : mpGPeFaY) {
			if (StringUtil.isNullOrEmpty(GCrbt4Ur)) {
				continue;
			}
			GCrbt4Ur = StringUtil.trim(GCrbt4Ur);
			try {
				Statement GZT3ZECE = conn_stats.createStatement();
				String pBuRHJiE = new File(
						qQhFFpSw + "/" + GCrbt4Ur.substring(GCrbt4Ur.lastIndexOf("/"), GCrbt4Ur.length())).toString();
				debug("(3) - start import: " + pBuRHJiE);
				BigFile cZO0aTme = new BigFile(pBuRHJiE);
				int t4GWizvW = 0;
				for (String cERMQr2R : cZO0aTme) {
					String WxoAqUwQ[] = cERMQr2R.split(",");
					String HbsMAaql = "";
					if (pBuRHJiE.indexOf("hip_countries.csv") != -1) {
						HbsMAaql = "insert into hip_countries values (" + WxoAqUwQ[0] + ",'" + normalize(WxoAqUwQ[1])
								+ "','" + normalize(WxoAqUwQ[2]) + "')";
					} else if (pBuRHJiE.indexOf("hip_ip4_city_lat_lng.csv") != -1) {
						HbsMAaql = "insert into hip_ip4_city_lat_lng values (" + WxoAqUwQ[0] + ",'"
								+ normalize(WxoAqUwQ[1]) + "'," + WxoAqUwQ[2] + "," + WxoAqUwQ[3] + ")";
					} else if (pBuRHJiE.indexOf("hip_ip4_country.csv") != -1) {
						HbsMAaql = "insert into hip_ip4_country values (" + WxoAqUwQ[0] + "," + WxoAqUwQ[1] + ")";
					}
					debug(t4GWizvW + " - " + HbsMAaql);
					GZT3ZECE.executeUpdate(HbsMAaql);
					t4GWizvW++;
				}
				debug("(4) tot import per il file" + pBuRHJiE + " : " + t4GWizvW);
				GZT3ZECE.close();
				new File(pBuRHJiE).delete();
			} catch (SQLException eszSPo8Q) {
				fatal("SQLException", eszSPo8Q);
				try {
					conn_stats.rollback();
				} catch (SQLException FtOJSCRR) {
					fatal("SQLException", FtOJSCRR);
				}
			} catch (IOException lLRAS9Zk) {
				fatal("IOException", lLRAS9Zk);
			} catch (Exception TnXrTXue) {
				fatal("Exception", TnXrTXue);
			}
		}
		try {
			conn_stats.commit();
		} catch (SQLException HPVynjWG) {
			fatal("SQLException", HPVynjWG);
		}
		try {
			conn_stats.setAutoCommit(true);
		} catch (SQLException PiLbtvos) {
			fatal("SQLException", PiLbtvos);
		}
		try {
			debug("(6) Vacuum");
			Statement atAcgBdu = this.conn_stats.createStatement();
			atAcgBdu.executeUpdate("VACUUM");
			atAcgBdu.close();
		} catch (SQLException VUcaRYrQ) {
			fatal("SQLException", VUcaRYrQ);
		}
		debug("End execute job " + this.getClass().getName());
	}

}