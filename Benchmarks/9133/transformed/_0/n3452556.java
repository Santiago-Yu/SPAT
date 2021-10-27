class n3452556 {
	public void doPost(HttpServletRequest F2fK3L5W, HttpServletResponse chcrXGyp) throws IOException, ServletException {
		Git MrdsZNQj = Git.getCurrent(F2fK3L5W.getSession());
		GitComponentReader wnhLaY2E = MrdsZNQj.getComponentReader("warpinjector");
		String WLh6I7qU = F2fK3L5W.getParameter("id");
		GitElement MT3XoWTL = wnhLaY2E.getElement(WLh6I7qU);
		String x5ds224M = (String) MT3XoWTL.getAttribute("targetdir");
		File vqJyV1UP = new File(x5ds224M);
		PrintWriter nUFTiSyi = helper.getPrintWriter(chcrXGyp);
		MessageBundle DtBYCTbN = new MessageBundle("net.sf.warpcore.cms/servlets/InjectorServletMessages");
		Locale y5vcTM6g = F2fK3L5W.getLocale();
		helper.header(nUFTiSyi, DtBYCTbN, y5vcTM6g);
		if (MrdsZNQj.getUser() == null) {
			helper.notLoggedIn(nUFTiSyi, DtBYCTbN, y5vcTM6g);
		} else {
			try {
				MultiPartRequest m8I7QISq = new MultiPartRequest(F2fK3L5W);
				FileInfo SDizLRGy = m8I7QISq.getFileInfo("userfile");
				File hgEhIgV3 = SDizLRGy.getFile();
				nUFTiSyi.println("tempfile found: " + hgEhIgV3.getPath() + "<br>");
				String HDL2jtuX = SDizLRGy.getFileName();
				File hxhwKolH = new File(vqJyV1UP, HDL2jtuX);
				nUFTiSyi.println("copying tempfile to: " + hxhwKolH.getPath() + "<br>");
				FileInputStream PFGxRxPN = new FileInputStream(hgEhIgV3);
				FileOutputStream doZj542f = new FileOutputStream(hxhwKolH);
				byte LOdLng5F[] = new byte[1024];
				int juyROFb3;
				while ((juyROFb3 = PFGxRxPN.read(LOdLng5F)) > 0)
					doZj542f.write(LOdLng5F, 0, juyROFb3);
				PFGxRxPN.close();
				doZj542f.close();
				nUFTiSyi.println("copy successful - deleting old tempfile<br>");
				nUFTiSyi.println("deletion result. " + hgEhIgV3.delete() + "<p>");
				nUFTiSyi.println(DtBYCTbN.getMessage("Done. The file {0} has been uploaded",
						new String[] { "'" + HDL2jtuX + "'" }, y5vcTM6g));
				nUFTiSyi.println("<p><a href=\"" + F2fK3L5W.getRequestURI() + "?id=" + F2fK3L5W.getParameter("id")
						+ "\">" + DtBYCTbN.getMessage("Click here to import another file.", y5vcTM6g) + "</a>");
			} catch (Exception O7IcKqgS) {
				nUFTiSyi.println(
						DtBYCTbN.getMessage("An error occured: {0}", new String[] { O7IcKqgS.getMessage() }, y5vcTM6g));
			}
		}
		helper.footer(nUFTiSyi);
	}

}