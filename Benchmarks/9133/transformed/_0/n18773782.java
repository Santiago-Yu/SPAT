class n18773782 {
	@Override
	public void render(IContentNode NxMzke5J, Request J1Cno7SL, Response TofRlXAm, Application KyPfe6iq,
			ServerInfo q3RtItkf) {
		Node vkhOUFGb = NxMzke5J.getNode();
		try {
			Node KbNusEV3 = vkhOUFGb.getNode("jcr:content");
			if (checkLastModified(KbNusEV3, J1Cno7SL.getServletRequset(), TofRlXAm.getServletResponse())) {
				return;
			}
			Property iFhQmqf1 = KbNusEV3.getProperty("jcr:data");
			InputStream n2CP0oeH = iFhQmqf1.getBinary().getStream();
			int oOBHidVB = (int) iFhQmqf1.getBinary().getSize();
			String afj25C4p;
			if (KbNusEV3.hasProperty("jcr:mimeType")) {
				afj25C4p = KbNusEV3.getProperty("jcr:mimeType").getString();
			} else {
				afj25C4p = q3RtItkf.getSerlvetContext().getMimeType(vkhOUFGb.getName());
			}
			if (afj25C4p != null && afj25C4p.startsWith("image")) {
				int XKkdApLx = J1Cno7SL.getInt("w", 0);
				int D0X7Jsqh = J1Cno7SL.getInt("h", 0);
				String uJPSIhe0 = J1Cno7SL.get("fmt");
				if (XKkdApLx != 0 || D0X7Jsqh != 0 || uJPSIhe0 != null) {
					Resource QeQtI5FL = ImageResource.create(n2CP0oeH, afj25C4p.substring(6), XKkdApLx, D0X7Jsqh,
							J1Cno7SL.getInt("cut", 0), uJPSIhe0);
					QeQtI5FL.process(q3RtItkf);
					return;
				}
			}
			TofRlXAm.getServletResponse().setContentType(afj25C4p);
			TofRlXAm.getServletResponse().setContentLength(oOBHidVB);
			OutputStream pIN9tbD0 = TofRlXAm.getServletResponse().getOutputStream();
			IOUtils.copy(n2CP0oeH, pIN9tbD0);
			pIN9tbD0.flush();
			pIN9tbD0.close();
		} catch (PathNotFoundException DehVx7MS) {
			DehVx7MS.printStackTrace();
		} catch (RepositoryException XisSCQ7S) {
			XisSCQ7S.printStackTrace();
		} catch (IOException iV1EZwao) {
			iV1EZwao.printStackTrace();
		}
	}

}