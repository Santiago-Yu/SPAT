class n20493867 {
	@Override
	public void execute(JobExecutionContext u9w3JJwm) throws JobExecutionException {
		super.execute(u9w3JJwm);
		debug("Start execute job " + this.getClass().getName());
		try {
			String qzgjXn65 = "nixspam-ip.dump.gz";
			String ufIuQDtM = this.path_app_root + "/" + this.properties.get("dir") + "/";
			try {
				org.apache.commons.io.FileUtils.forceMkdir(new File(ufIuQDtM));
			} catch (IOException fLDryfYn) {
				fatal("IOException", fLDryfYn);
			}
			ufIuQDtM += "/" + qzgjXn65;
			String ia74V4jo = "http://www.dnsbl.manitu.net/download/" + qzgjXn65;
			debug("(1) - start download: " + ia74V4jo);
			com.utils.HttpUtil.downloadData(ia74V4jo, ufIuQDtM);
			com.utils.IOUtil.unzip(ufIuQDtM, ufIuQDtM.replace(".gz", ""));
			File zbDtSyZ2 = new File(ufIuQDtM.replaceAll(".gz", ""));
			BigFile BKIFtPCN = null;
			try {
				BKIFtPCN = new BigFile(zbDtSyZ2.toString());
			} catch (Exception cdObQMRx) {
				fatal("Excpetion", cdObQMRx);
				return;
			}
			try {
				Statement wuhVR9N8 = conn_url.createStatement();
				wuhVR9N8.executeUpdate(properties.get("query_delete"));
				wuhVR9N8.close();
			} catch (SQLException wPEgd0Hi) {
				fatal("SQLException", wPEgd0Hi);
			}
			try {
				conn_url.setAutoCommit(false);
			} catch (SQLException XNnessNL) {
				fatal("SQLException", XNnessNL);
			}
			boolean zYMj9SKJ = true;
			int yqBfHCsB = 0;
			for (String znT4XseO : BKIFtPCN) {
				if (StringUtil.isEmpty(znT4XseO) || znT4XseO.indexOf(" ") == -1) {
					continue;
				}
				try {
					znT4XseO = znT4XseO.substring(znT4XseO.indexOf(" "));
					znT4XseO = znT4XseO.trim();
					if (getIPException(znT4XseO)) {
						continue;
					}
					Statement zKskNiu2 = this.conn_url.createStatement();
					zKskNiu2.executeUpdate("insert into blacklist(url) values('" + znT4XseO + "')");
					zKskNiu2.close();
					yqBfHCsB++;
				} catch (SQLException nk0eLEto) {
					fatal("SQLException", nk0eLEto);
					try {
						conn_url.rollback();
					} catch (SQLException NZZlDB91) {
						fatal("SQLException", NZZlDB91);
					}
					zYMj9SKJ = false;
					break;
				}
			}
			boolean UkF4xY2A = zbDtSyZ2.delete();
			debug("File " + zbDtSyZ2 + " del:" + UkF4xY2A);
			qzgjXn65 = "spam-ip.com_" + DateTimeUtil.getNowWithFormat("MM-dd-yyyy") + ".csv";
			ufIuQDtM = this.path_app_root + "/" + this.properties.get("dir") + "/";
			org.apache.commons.io.FileUtils.forceMkdir(new File(ufIuQDtM));
			ufIuQDtM += "/" + qzgjXn65;
			ia74V4jo = "http://spam-ip.com/csv_dump/" + qzgjXn65;
			debug("(2) - start download: " + ia74V4jo);
			com.utils.HttpUtil.downloadData(ia74V4jo, ufIuQDtM);
			zbDtSyZ2 = new File(ufIuQDtM);
			try {
				BKIFtPCN = new BigFile(zbDtSyZ2.toString());
			} catch (Exception den9WXoe) {
				fatal("Exception", den9WXoe);
				return;
			}
			try {
				conn_url.setAutoCommit(false);
			} catch (SQLException iCn7rQmx) {
				fatal("SQLException", iCn7rQmx);
			}
			zYMj9SKJ = true;
			for (String Szp5msoY : BKIFtPCN) {
				if (StringUtil.isEmpty(Szp5msoY) || Szp5msoY.indexOf(" ") == -1) {
					continue;
				}
				try {
					Szp5msoY = Szp5msoY.split(",")[1];
					Szp5msoY = Szp5msoY.trim();
					if (getIPException(Szp5msoY)) {
						continue;
					}
					Statement LDPzXhSO = this.conn_url.createStatement();
					LDPzXhSO.executeUpdate("insert into blacklist(url) values('" + Szp5msoY + "')");
					LDPzXhSO.close();
					yqBfHCsB++;
				} catch (SQLException XAfs7fLB) {
					fatal("SQLException", XAfs7fLB);
					try {
						conn_url.rollback();
					} catch (SQLException kzkapSgp) {
						fatal("SQLException", kzkapSgp);
					}
					zYMj9SKJ = false;
					break;
				}
			}
			UkF4xY2A = zbDtSyZ2.delete();
			debug("File " + zbDtSyZ2 + " del:" + UkF4xY2A);
			if (zYMj9SKJ) {
				debug("Import della BlackList Concluso tot righe: " + yqBfHCsB);
				try {
					conn_url.commit();
				} catch (SQLException oeeIDLpf) {
					fatal("SQLException", oeeIDLpf);
				}
			} else {
				fatal("Problemi con la Blacklist");
			}
			try {
				conn_url.setAutoCommit(true);
			} catch (SQLException QHbmdoU0) {
				fatal("SQLException", QHbmdoU0);
			}
			try {
				Statement ONYj1Dq0 = this.conn_url.createStatement();
				ONYj1Dq0.executeUpdate("VACUUM");
				ONYj1Dq0.close();
			} catch (SQLException iDaQFlw7) {
				fatal("SQLException", iDaQFlw7);
			}
		} catch (IOException ju7WfiEg) {
			fatal("IOException", ju7WfiEg);
		}
		debug("End execute job " + this.getClass().getName());
	}

}