class n3167466 {
	public void alterarCliente(ClienteBean VwKl2HHw, String ATfGATOP) {
		PreparedStatement RGxIOI3s = null;
		String SD8Iiu6V = "UPDATE cliente SET nome = ?," + "cpf = ?," + "telefone = ?," + "cursoCargo = ?,"
				+ "bloqueado = ?," + "ativo = ?," + "tipo = ? WHERE cpf = ?";
		try {
			RGxIOI3s = connection.prepareStatement(SD8Iiu6V);
			RGxIOI3s.setString(1, VwKl2HHw.getNome());
			RGxIOI3s.setString(2, VwKl2HHw.getCPF());
			RGxIOI3s.setString(3, VwKl2HHw.getTelefone());
			RGxIOI3s.setString(4, VwKl2HHw.getCursoCargo());
			RGxIOI3s.setString(5, VwKl2HHw.getBloqueado());
			RGxIOI3s.setString(6, VwKl2HHw.getAtivo());
			RGxIOI3s.setString(7, VwKl2HHw.getTipo());
			RGxIOI3s.setString(8, ATfGATOP);
			RGxIOI3s.executeUpdate();
			connection.commit();
		} catch (SQLException xhyZkNoO) {
			try {
				connection.rollback();
			} catch (SQLException PUbWgv96) {
				throw new RuntimeException("Erro ao atualizar cliente.", PUbWgv96);
			}
			throw new RuntimeException("Erro ao atualizar cliente.", xhyZkNoO);
		} finally {
			try {
				if (RGxIOI3s != null)
					RGxIOI3s.close();
			} catch (SQLException tN0k5gZr) {
				throw new RuntimeException("Ocorreu um erro no banco de dados.", tN0k5gZr);
			}
		}
	}

}