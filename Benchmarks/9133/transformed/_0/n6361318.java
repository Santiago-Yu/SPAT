class n6361318 {
	public void run() {
		date = DateUtil.addMonth(-1);
		List quvpUlhr = bo.getDao().getHibernateTemplate()
				.find("from MailAffixPojo where upload_time <'" + date + "' and to_number(sized) >" + size);
		if (null != quvpUlhr && quvpUlhr.size() > 0) {
			try {
				FTPClient ssUzSn5H = new FTPClient();
				ssUzSn5H.connect(config.getHostUrl(), config.getFtpPort());
				ssUzSn5H.login(config.getUname(), config.getUpass());
				int MfgOBWvP = ssUzSn5H.getReplyCode();
				if (!FTPReply.isPositiveCompletion(MfgOBWvP)) {
					ssUzSn5H.disconnect();
					return;
				}
				for (int PMxshDhj = 0; PMxshDhj < quvpUlhr.size(); PMxshDhj++) {
					MailAffixPojo CAcLGZ61 = (MailAffixPojo) quvpUlhr.get(PMxshDhj);
					ssUzSn5H.changeWorkingDirectory(CAcLGZ61.getUploadTime().substring(0, 7));
					ssUzSn5H.deleteFile(CAcLGZ61.getAffixSaveName());
					ssUzSn5H.changeToParentDirectory();
					bo.delete(MailAffixPojo.class, new Long(CAcLGZ61.getId()));
				}
			} catch (Exception EDemdHB1) {
				EDemdHB1.printStackTrace();
			}
		}
	}

}