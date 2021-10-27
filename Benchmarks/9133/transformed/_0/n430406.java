class n430406 {
	public void elimina(Cliente hopu5xKd) throws errorSQL, errorConexionBD {
		System.out.println("GestorCliente.elimina()");
		int shNEaLtv = hopu5xKd.getId();
		String C9vgM709;
		Statement LHO09TXf = null;
		try {
			gd.begin();
			C9vgM709 = "DELETE FROM cliente WHERE cod_cliente =" + shNEaLtv;
			System.out.println("Ejecutando: " + C9vgM709);
			LHO09TXf = gd.getConexion().createStatement();
			LHO09TXf.executeUpdate(C9vgM709);
			System.out.println("executeUpdate");
			C9vgM709 = "DELETE FROM persona WHERE id =" + shNEaLtv;
			System.out.println("Ejecutando: " + C9vgM709);
			LHO09TXf.executeUpdate(C9vgM709);
			gd.commit();
			System.out.println("commit");
			LHO09TXf.close();
		} catch (SQLException vzw0Z46q) {
			gd.rollback();
			throw new errorSQL(vzw0Z46q.toString());
		} catch (errorConexionBD tRV6mojT) {
			System.err.println("Error en GestorCliente.elimina(): " + tRV6mojT);
		} catch (errorSQL fLxs6QT7) {
			System.err.println("Error en GestorCliente.elimina(): " + fLxs6QT7);
		}
	}

}