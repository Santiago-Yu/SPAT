class n23548073 {
	public static boolean update(Cargo NR3exqhR) {
		int kbNRaeuf = 0;
		Connection aL2PJxRZ = DBConnection.getConnection();
		PreparedStatement n4T3bAMV = null;
		if (aL2PJxRZ == null) {
			return false;
		}
		try {
			aL2PJxRZ.setAutoCommit(false);
			String bl24VCAT = "update cargo set nome = (?) where id_cargo= ?";
			n4T3bAMV = aL2PJxRZ.prepareStatement(bl24VCAT);
			n4T3bAMV.setString(1, NR3exqhR.getNome());
			n4T3bAMV.setInt(2, NR3exqhR.getCodigo());
			kbNRaeuf = n4T3bAMV.executeUpdate();
			aL2PJxRZ.commit();
		} catch (SQLException yAPVbi1V) {
			try {
				aL2PJxRZ.rollback();
			} catch (SQLException IHqUy29W) {
				IHqUy29W.printStackTrace();
			}
			System.out.println("[CargoDAO.update] Erro ao atualizar -> " + yAPVbi1V.getMessage());
		} finally {
			DBConnection.closePreparedStatement(n4T3bAMV);
			DBConnection.closeConnection(aL2PJxRZ);
		}
		if (kbNRaeuf > 0) {
			return true;
		} else {
			return false;
		}
	}

}