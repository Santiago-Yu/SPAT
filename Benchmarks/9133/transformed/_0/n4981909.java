class n4981909 {
	public static File enregistrerFichier(String CVT7e19W, File RLGdFuXo, String jHBguIOC, String zpGsSHh1)
			throws Exception {
		if (RLGdFuXo != null) {
			try {
				HttpServletRequest sLA12QuA = ServletActionContext.getRequest();
				HttpSession uLOs6cpB = sLA12QuA.getSession();
				String tvfvl7wR = uLOs6cpB.getServletContext().getRealPath(jHBguIOC) + File.separator + CVT7e19W;
				File fLvqf2Nq = new File(tvfvl7wR);
				String[] URDqOKcJ = CVT7e19W.split("\\.");
				String jAC5iRQN = URDqOKcJ[URDqOKcJ.length - 1];
				StringBuffer ohkd7UzD = new StringBuffer(URDqOKcJ[0]);
				for (int LAtq2Fcy = 1; LAtq2Fcy < URDqOKcJ.length - 1; LAtq2Fcy++) {
					ohkd7UzD.append(".").append(URDqOKcJ[LAtq2Fcy]);
				}
				String yU6t3Qfn = ohkd7UzD.toString();
				String djlBGEA3 = CVT7e19W;
				for (int j84rt6hd = 0; !fLvqf2Nq.createNewFile(); j84rt6hd++) {
					djlBGEA3 = yU6t3Qfn + "_" + +j84rt6hd + "." + jAC5iRQN;
					tvfvl7wR = uLOs6cpB.getServletContext().getRealPath(jHBguIOC) + File.separator + djlBGEA3;
					fLvqf2Nq = new File(tvfvl7wR);
				}
				logger.debug(" enregistrerFichier - Enregistrement du fichier : " + tvfvl7wR);
				FileChannel Qsjfln68 = null;
				FileChannel Leq8MHCg = null;
				try {
					Qsjfln68 = new FileInputStream(RLGdFuXo).getChannel();
					Leq8MHCg = new FileOutputStream(fLvqf2Nq).getChannel();
					Qsjfln68.transferTo(0, Qsjfln68.size(), Leq8MHCg);
				} catch (Exception FHDHAXDm) {
					FHDHAXDm.printStackTrace();
				} finally {
					if (Qsjfln68 != null) {
						try {
							Qsjfln68.close();
						} catch (IOException JWDY26GY) {
						}
					}
					if (Leq8MHCg != null) {
						try {
							Leq8MHCg.close();
						} catch (IOException Nm363dlG) {
						}
					}
				}
				return fLvqf2Nq;
			} catch (IOException el1y51sR) {
				logger.error("Erreur lors de l'enregistrement de l'image ", el1y51sR);
				throw new Exception("Erreur lors de l'enregistrement de l'image ");
			}
		}
		return null;
	}

}