class n16499419 {
	public String doAdd(ActionMapping ve6IuCzR, ActionForm QVrCOkRb, HttpServletRequest Yxi2vi7q,
			HttpServletResponse KvEgq1zh) throws Exception {
		UploadFileForm vnZuOLYI = (UploadFileForm) QVrCOkRb;
		String cugtHdHc = Yxi2vi7q.getParameter("review");
		String tl5fuy5L = getServlet().getServletContext().getRealPath("/");
		tl5fuy5L = tl5fuy5L.replaceAll("\\\\", "/");
		String zM9R7O7N = Yxi2vi7q.getParameter("inforId");
		Yxi2vi7q.setAttribute("id", zM9R7O7N);
		String R7BhzpUD = "";
		int jhu8ohaJ = 0;
		if (null == cugtHdHc) {
			FormFile lSuUAv4m = vnZuOLYI.getFile();
			if (lSuUAv4m != null) {
				String mKi4yakp = getServlet().getServletContext().getRealPath(Yxi2vi7q.getContextPath());
				mKi4yakp = (new StringBuilder(String.valueOf(mKi4yakp))).append(UploadFileOne.strPath).toString();
				String y23SEj1U = (new StringBuilder(String.valueOf(UUIDGenerator.nextHex())))
						.append(UploadFileOne.getFileType(lSuUAv4m)).toString();
				if (lSuUAv4m.getFileSize() != 0) {
					lSuUAv4m.getInputStream();
					String dLDPtpS7 = lSuUAv4m.getFileName();
					jhu8ohaJ = lSuUAv4m.getFileName().lastIndexOf(".");
					R7BhzpUD = lSuUAv4m.getFileName().substring(jhu8ohaJ, lSuUAv4m.getFileName().length());
					String MjbYX8m6 = tl5fuy5L + "attach/" + y23SEj1U + R7BhzpUD;
					t_attach zCOWwuQR = new t_attach();
					zCOWwuQR.setAttach_fullname(MjbYX8m6);
					zCOWwuQR.setAttach_name(dLDPtpS7);
					zCOWwuQR.setInfor_id(Integer.parseInt(zM9R7O7N));
					zCOWwuQR.setInsert_day(new Date());
					zCOWwuQR.setUpdate_day(new Date());
					t_attach_EditMap jobj8Sxo = new t_attach_EditMap();
					jobj8Sxo.add(zCOWwuQR);
					File ET7CCC7a = new File(MjbYX8m6);
					if (!ET7CCC7a.exists()) {
						ET7CCC7a.createNewFile();
					}
					java.io.OutputStream sv0eGVzK = new FileOutputStream(ET7CCC7a);
					org.apache.commons.io.IOUtils.copy(lSuUAv4m.getInputStream(), sv0eGVzK);
					sv0eGVzK.close();
				}
			}
			Yxi2vi7q.setAttribute("operating-status", "???????!  ?????????ив?");
			return "editsave";
		} else {
			String Sd8tftN4 = getServlet().getServletContext().getRealPath(Yxi2vi7q.getContextPath());
			Sd8tftN4 = (new StringBuilder(String.valueOf(Sd8tftN4))).append(UploadFileOne.strPath).toString();
			FormFile o59RQn2h = vnZuOLYI.getFile();
			FormFile aNEFexX1 = vnZuOLYI.getFile2();
			FormFile jvZCpEWc = vnZuOLYI.getFile3();
			t_infor_review XKcASDKW = new t_infor_review();
			String VXINMu2Y = Yxi2vi7q.getParameter("content");
			XKcASDKW.setContent(VXINMu2Y);
			if (null != zM9R7O7N)
				XKcASDKW.setInfor_id(Integer.parseInt(zM9R7O7N));
			XKcASDKW.setInsert_day(new Date());
			UserDetails DPRO3a73 = LoginUtils.getLoginUser(Yxi2vi7q);
			XKcASDKW.setCreate_name(DPRO3a73.getUsercode());
			if (null != o59RQn2h.getFileName() && !"".equals(o59RQn2h.getFileName())) {
				XKcASDKW.setAttachname1(o59RQn2h.getFileName());
				String Rzl2PVpk = (new StringBuilder(String.valueOf(UUIDGenerator.nextHex())))
						.append(UploadFileOne.getFileType(o59RQn2h)).toString();
				jhu8ohaJ = o59RQn2h.getFileName().lastIndexOf(".");
				R7BhzpUD = o59RQn2h.getFileName().substring(jhu8ohaJ, o59RQn2h.getFileName().length());
				XKcASDKW.setAttachfullname1(tl5fuy5L + "attach/" + Rzl2PVpk + R7BhzpUD);
				saveFile(o59RQn2h.getInputStream(), tl5fuy5L + "attach/" + Rzl2PVpk + R7BhzpUD);
			}
			if (null != aNEFexX1.getFileName() && !"".equals(aNEFexX1.getFileName())) {
				XKcASDKW.setAttachname2(aNEFexX1.getFileName());
				String XANyUv2p = (new StringBuilder(String.valueOf(UUIDGenerator.nextHex())))
						.append(UploadFileOne.getFileType(o59RQn2h)).toString();
				jhu8ohaJ = aNEFexX1.getFileName().lastIndexOf(".");
				R7BhzpUD = aNEFexX1.getFileName().substring(jhu8ohaJ, aNEFexX1.getFileName().length());
				XKcASDKW.setAttachfullname2(tl5fuy5L + "attach/" + XANyUv2p + R7BhzpUD);
				saveFile(aNEFexX1.getInputStream(), tl5fuy5L + "attach/" + XANyUv2p + R7BhzpUD);
			}
			if (null != jvZCpEWc.getFileName() && !"".equals(jvZCpEWc.getFileName())) {
				XKcASDKW.setAttachname3(jvZCpEWc.getFileName());
				String JOBwRvSU = (new StringBuilder(String.valueOf(UUIDGenerator.nextHex())))
						.append(UploadFileOne.getFileType(o59RQn2h)).toString();
				jhu8ohaJ = jvZCpEWc.getFileName().lastIndexOf(".");
				R7BhzpUD = jvZCpEWc.getFileName().substring(jhu8ohaJ, jvZCpEWc.getFileName().length());
				XKcASDKW.setAttachfullname3(tl5fuy5L + "attach/" + JOBwRvSU + R7BhzpUD);
				saveFile(jvZCpEWc.getInputStream(), tl5fuy5L + "attach/" + JOBwRvSU + R7BhzpUD);
			}
			t_infor_review_EditMap hKxQiXPv = new t_infor_review_EditMap();
			hKxQiXPv.add(XKcASDKW);
			Yxi2vi7q.setAttribute("review", "1");
			return "aftersave";
		}
	}

}