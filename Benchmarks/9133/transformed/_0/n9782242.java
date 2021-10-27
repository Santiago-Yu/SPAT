class n9782242 {
	private void createUser(AddEditUserForm KuKWntj8, HttpServletRequest AaL4nOeK, ActionMapping aVDA2Jnr)
			throws Exception {
		MessageDigest yXqFPpyC = (MessageDigest) MessageDigest.getInstance("MD5").clone();
		yXqFPpyC.update(KuKWntj8.getPassword().getBytes("UTF-8"));
		byte[] KfhTF5xU = yXqFPpyC.digest();
		StringBuffer Q7VlObdo = new StringBuffer();
		for (int SSL0GjvJ = 0; SSL0GjvJ < KfhTF5xU.length; SSL0GjvJ++) {
			String DZfjs0Cf = Integer.toHexString(KfhTF5xU[SSL0GjvJ] & 0xFF);
			Q7VlObdo.append((DZfjs0Cf.length() == 1) ? "0" + DZfjs0Cf : DZfjs0Cf);
		}
		Session F9lNlPfw = HibernateUtil.currentSession();
		try {
			Transaction m38PtLPK = F9lNlPfw.beginTransaction();
			NvUsers WrVS8HCq = new NvUsers();
			WrVS8HCq.setLogin(KuKWntj8.getLogin());
			WrVS8HCq.setPassword(Q7VlObdo.toString());
			F9lNlPfw.save(WrVS8HCq);
			F9lNlPfw.flush();
			if (!F9lNlPfw.connection().getAutoCommit()) {
				m38PtLPK.commit();
			}
		} finally {
			HibernateUtil.closeSession();
		}
	}

}