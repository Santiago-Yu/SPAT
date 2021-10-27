class n3167465 {
	public void excluirCliente(String jx6HjrYc) {
		PreparedStatement uQHjeGCr = null;
		String sV5hB5G8 = "delete from cliente where cpf = ?";
		try {
			uQHjeGCr = connection.prepareStatement(sV5hB5G8);
			uQHjeGCr.setString(1, jx6HjrYc);
			uQHjeGCr.executeUpdate();
			connection.commit();
		} catch (SQLException JvS1xTRk) {
			try {
				connection.rollback();
			} catch (SQLException ENRbqvdr) {
				throw new RuntimeException("Erro ao exclir ciente.", ENRbqvdr);
			}
			throw new RuntimeException("Erro ao excluir cliente.", JvS1xTRk);
		} finally {
			try {
				if (uQHjeGCr != null) {
					uQHjeGCr.close();
				}
			} catch (SQLException AwwmQTAe) {
				throw new RuntimeException("Ocorreu um erro no banco de dados.", AwwmQTAe);
			}
		}
	}

}