class n14093044 {
	@Override
	public boolean insert(String IU9vyz29, boolean gkof1sFa, int kw583zFb, Connection mZQHnzdv) throws SQLException {
		filasInsert = 0;
		if (!IU9vyz29.contains(";")) {
			this.tipoConsulta = new Scanner(IU9vyz29);
			if (this.tipoConsulta.hasNext()) {
				execConsulta = this.tipoConsulta.next();
				if (execConsulta.equalsIgnoreCase("insert")) {
					Connection Ey8hn20P = mZQHnzdv;
					Statement eD3zxL3A = null;
					try {
						Ey8hn20P.setAutoCommit(gkof1sFa);
						if (kw583zFb == 1 || kw583zFb == 2 || kw583zFb == 4 || kw583zFb == 8) {
							Ey8hn20P.setTransactionIsolation(kw583zFb);
						} else {
							throw new IllegalArgumentException(
									"Valor invalido sobre TransactionIsolation,\n TRANSACTION_NONE no es soportado por MySQL");
						}
						eD3zxL3A = (Statement) Ey8hn20P.createStatement(ResultSetImpl.TYPE_SCROLL_SENSITIVE,
								ResultSetImpl.CONCUR_UPDATABLE);
						Ey8hn20P.setReadOnly(false);
						filasInsert = eD3zxL3A.executeUpdate(IU9vyz29.trim(), Statement.RETURN_GENERATED_KEYS);
						if (filasInsert > -1) {
							if (gkof1sFa == false) {
								Ey8hn20P.commit();
							}
							return true;
						} else {
							return false;
						}
					} catch (MySQLIntegrityConstraintViolationException B8bgVoI1) {
						System.out.println("Posible duplicacion de DATOS");
						if (gkof1sFa == false) {
							try {
								Ey8hn20P.rollback();
								System.out.println("Se ejecuto un Rollback");
							} catch (MySQLTransactionRollbackException j6LsNHCv) {
								System.out.println("No se ejecuto un Rollback");
								j6LsNHCv.printStackTrace();
							} catch (SQLException XT4a4Sju) {
								XT4a4Sju.printStackTrace();
							}
						}
						B8bgVoI1.printStackTrace();
						return false;
					} catch (MySQLNonTransientConnectionException uQZcnqwy) {
						if (gkof1sFa == false) {
							try {
								Ey8hn20P.rollback();
								System.out.println("Se ejecuto un Rollback");
							} catch (MySQLTransactionRollbackException OVcgWuho) {
								System.out.println("No se ejecuto un Rollback");
								OVcgWuho.printStackTrace();
							} catch (SQLException AhlluIhb) {
								AhlluIhb.printStackTrace();
							}
						}
						uQZcnqwy.printStackTrace();
						return false;
					} catch (MySQLDataException UPzAU37H) {
						System.out.println("Datos incorrectos");
						if (gkof1sFa == false) {
							try {
								Ey8hn20P.rollback();
								System.out.println("Se ejecuto un Rollback");
							} catch (MySQLTransactionRollbackException u2LAG5vI) {
								System.out.println("No se ejecuto un Rollback");
								u2LAG5vI.printStackTrace();
							} catch (SQLException BYJqUVj6) {
								BYJqUVj6.printStackTrace();
							}
						}
						return false;
					} catch (MySQLSyntaxErrorException BWnZJ7xi) {
						System.out.println("Error en la sintaxis de la Consulta en MySQL");
						if (gkof1sFa == false) {
							try {
								Ey8hn20P.rollback();
								System.out.println("Se ejecuto un Rollback");
							} catch (MySQLTransactionRollbackException Mj1MVWmR) {
								System.out.println("No se ejecuto un Rollback");
								Mj1MVWmR.printStackTrace();
							} catch (SQLException ve9n6aF7) {
								ve9n6aF7.printStackTrace();
							}
						}
						return false;
					} catch (SQLException kfahtw41) {
						if (gkof1sFa == false) {
							try {
								Ey8hn20P.rollback();
								System.out.println("Se ejecuto un Rollback");
							} catch (MySQLTransactionRollbackException CmD2w0eX) {
								System.out.println("No se ejecuto un Rollback");
								CmD2w0eX.printStackTrace();
							} catch (SQLException LcDKLmPj) {
								LcDKLmPj.printStackTrace();
							}
						}
						kfahtw41.printStackTrace();
						return false;
					} finally {
						try {
							if (eD3zxL3A != null) {
								if (!eD3zxL3A.isClosed()) {
									eD3zxL3A.close();
								}
							}
							if (!Ey8hn20P.isClosed()) {
								Ey8hn20P.close();
							}
						} catch (NullPointerException aYiF58Dt) {
							aYiF58Dt.printStackTrace();
						} catch (SQLException Kojge7S3) {
							Kojge7S3.printStackTrace();
						}
					}
				} else {
					throw new IllegalArgumentException("No es una instruccion Insert");
				}
			} else {
				try {
					throw new JMySQLException("Error Grave , notifique al departamento de Soporte Tecnico \n" + email);
				} catch (JMySQLException bXKK7Uzy) {
					Logger.getLogger(JMySQL.class.getName()).log(Level.SEVERE, null, bXKK7Uzy);
					return false;
				}
			}
		} else {
			throw new IllegalArgumentException("No estan permitidas las MultiConsultas en este metodo");
		}
	}

}