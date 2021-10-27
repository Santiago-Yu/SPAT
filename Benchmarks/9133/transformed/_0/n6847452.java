class n6847452 {
	public void doPost(HttpServletRequest ZqDpHn2A, HttpServletResponse HxMfLcDw) throws ServletException, IOException {
		try {
			String GmfVmRqe = ZqDpHn2A.getParameter("act");
			if (null == GmfVmRqe) {
			} else if ("down".equalsIgnoreCase(GmfVmRqe)) {
				String QIHRl3c4 = ZqDpHn2A.getParameter("vest");
				String oN47i42R = ZqDpHn2A.getParameter("id");
				if (null == QIHRl3c4) {
					t_attach_Form w4FUX7Ri = null;
					t_attach_QueryMap YRC1X7ts = new t_attach_QueryMap();
					w4FUX7Ri = YRC1X7ts.getByID(oN47i42R);
					if (null != w4FUX7Ri) {
						String uiZXQXj4 = w4FUX7Ri.getAttach_name();
						String TF0VWgRQ = w4FUX7Ri.getAttach_fullname();
						HxMfLcDw.addHeader("Content-Disposition", "attachment;filename=" + uiZXQXj4 + "");
						File Rd8BtcIx = new File(TF0VWgRQ);
						if (Rd8BtcIx.exists()) {
							java.io.FileInputStream EGZzqAfA = new FileInputStream(Rd8BtcIx);
							org.apache.commons.io.IOUtils.copy(EGZzqAfA, HxMfLcDw.getOutputStream());
						}
					}
				} else if ("review".equalsIgnoreCase(QIHRl3c4)) {
					t_infor_review_QueryMap rr7rQJxi = new t_infor_review_QueryMap();
					t_infor_review_Form bbbuO39r = rr7rQJxi.getByID(oN47i42R);
					String y4Ja7YAK = ZqDpHn2A.getParameter("seq");
					String tJvPKArO = null, ZPXPe6MC = null;
					if ("1".equals(y4Ja7YAK)) {
						tJvPKArO = bbbuO39r.getAttachname1();
						ZPXPe6MC = bbbuO39r.getAttachfullname1();
					} else if ("2".equals(y4Ja7YAK)) {
						tJvPKArO = bbbuO39r.getAttachname2();
						ZPXPe6MC = bbbuO39r.getAttachfullname2();
					} else if ("3".equals(y4Ja7YAK)) {
						tJvPKArO = bbbuO39r.getAttachname3();
						ZPXPe6MC = bbbuO39r.getAttachfullname3();
					}
					String r2v2HVsZ = DownType.getInst().getDownTypeByFileName(tJvPKArO);
					logger.debug("filename=" + tJvPKArO + " downtype=" + r2v2HVsZ);
					HxMfLcDw.setContentType(r2v2HVsZ);
					HxMfLcDw.addHeader("Content-Disposition", "attachment;filename=" + tJvPKArO + "");
					File aX7Iwskk = new File(ZPXPe6MC);
					if (aX7Iwskk.exists()) {
						java.io.FileInputStream L5AfFfJT = new FileInputStream(aX7Iwskk);
						org.apache.commons.io.IOUtils.copy(L5AfFfJT, HxMfLcDw.getOutputStream());
						L5AfFfJT.close();
					}
				}
			} else if ("upload".equalsIgnoreCase(GmfVmRqe)) {
				String eHvMwCPZ = ZqDpHn2A.getParameter("inforId");
				logger.debug("infoId=" + eHvMwCPZ);
			}
		} catch (Exception cU4KYC0l) {
		}
	}

}