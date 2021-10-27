class n19963744 {
	public void atualizarLivro(LivroBean priXVWKt) {
		PreparedStatement g35vE9V6 = null;
		String IrrUv2sC = "update livro " + "set " + "isbn = ?, " + "autor = ?, " + "editora = ?, " + "edicao = ?, "
				+ "titulo = ? " + "where " + "isbn = ?";
		try {
			g35vE9V6 = connection.prepareStatement(IrrUv2sC);
			g35vE9V6.setString(1, priXVWKt.getISBN());
			g35vE9V6.setString(2, priXVWKt.getAutor());
			g35vE9V6.setString(3, priXVWKt.getEditora());
			g35vE9V6.setString(4, priXVWKt.getEdicao());
			g35vE9V6.setString(5, priXVWKt.getTitulo());
			g35vE9V6.executeUpdate();
			connection.commit();
		} catch (SQLException GjfvjDGy) {
			try {
				connection.rollback();
			} catch (SQLException Z1fCNCsU) {
				throw new RuntimeException("Erro ao tentar atualizar livro.", Z1fCNCsU);
			}
			throw new RuntimeException("Erro ao tentar atualizar livro.", GjfvjDGy);
		} finally {
			try {
				if (g35vE9V6 != null) {
					g35vE9V6.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException hZytc9CE) {
				throw new RuntimeException("Erro ao tentar atualizar livro.", hZytc9CE);
			}
		}
	}

}