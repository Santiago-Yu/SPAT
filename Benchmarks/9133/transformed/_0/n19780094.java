class n19780094 {
	protected PTask commit_result(Result liPrbJU6, SyrupConnection eMULLEAZ) throws Exception {
		try {
			int eTmk4D42 = LogEntry.ENDED;
			String wHp5bPsL = liPrbJU6.context().task().key();
			if (liPrbJU6.in_1_consumed() && liPrbJU6.context().in_1_link() != null) {
				sqlImpl().updateFunctions().updateInLink(wHp5bPsL, false, null, eMULLEAZ);
				eTmk4D42 = eTmk4D42 | LogEntry.IN_1;
			}
			if (liPrbJU6.in_2_consumed() && liPrbJU6.context().in_2_link() != null) {
				sqlImpl().updateFunctions().updateInLink(wHp5bPsL, true, null, eMULLEAZ);
				eTmk4D42 = eTmk4D42 | LogEntry.IN_2;
			}
			if (liPrbJU6.out_1_result() != null && liPrbJU6.context().out_1_link() != null) {
				sqlImpl().updateFunctions().updateOutLink(wHp5bPsL, false, liPrbJU6.out_1_result(), eMULLEAZ);
				eTmk4D42 = eTmk4D42 | LogEntry.OUT_1;
			}
			if (liPrbJU6.out_2_result() != null && liPrbJU6.context().out_2_link() != null) {
				sqlImpl().updateFunctions().updateOutLink(wHp5bPsL, true, liPrbJU6.out_2_result(), eMULLEAZ);
				eTmk4D42 = eTmk4D42 | LogEntry.OUT_2;
			}
			sqlImpl().loggingFunctions().log(liPrbJU6.context().task().key(), eTmk4D42, eMULLEAZ);
			boolean yN80bQHO = liPrbJU6.context().task().isParent();
			if (liPrbJU6 instanceof Workflow) {
				Workflow J9nEuv6q = (Workflow) liPrbJU6;
				Task[] rAJYilTZ = J9nEuv6q.tasks();
				Link[] ogUgTbiR = J9nEuv6q.links();
				Hashtable ryphbtpi = new Hashtable();
				for (int UOScGlib = 0; UOScGlib < rAJYilTZ.length; UOScGlib++) {
					String hemqS0nz = sqlImpl().creationFunctions().newTask(rAJYilTZ[UOScGlib],
							liPrbJU6.context().task(), eMULLEAZ);
					ryphbtpi.put(rAJYilTZ[UOScGlib], hemqS0nz);
				}
				for (int G0zSTBNE = 0; G0zSTBNE < ogUgTbiR.length; G0zSTBNE++) {
					sqlImpl().creationFunctions().newLink(ogUgTbiR[G0zSTBNE], ryphbtpi, eMULLEAZ);
				}
				String e736UWQJ = sqlImpl().queryFunctions().readInTask(wHp5bPsL, false, eMULLEAZ);
				String B6KkHwqY = sqlImpl().queryFunctions().readInTask(wHp5bPsL, true, eMULLEAZ);
				String zU4rzEyK = sqlImpl().queryFunctions().readOutTask(wHp5bPsL, false, eMULLEAZ);
				String X7Y7Lxnq = sqlImpl().queryFunctions().readOutTask(wHp5bPsL, true, eMULLEAZ);
				sqlImpl().updateFunctions().rewireInLink(wHp5bPsL, false, J9nEuv6q.in_1_binding(), ryphbtpi, eMULLEAZ);
				sqlImpl().updateFunctions().rewireInLink(wHp5bPsL, true, J9nEuv6q.in_2_binding(), ryphbtpi, eMULLEAZ);
				sqlImpl().updateFunctions().rewireOutLink(wHp5bPsL, false, J9nEuv6q.out_1_binding(), ryphbtpi,
						eMULLEAZ);
				sqlImpl().updateFunctions().rewireOutLink(wHp5bPsL, true, J9nEuv6q.out_2_binding(), ryphbtpi, eMULLEAZ);
				for (int tCuQW2hN = 0; tCuQW2hN < rAJYilTZ.length; tCuQW2hN++) {
					String A4ewvSCw = (String) ryphbtpi.get(rAJYilTZ[tCuQW2hN]);
					sqlImpl().updateFunctions().checkAndUpdateDone(A4ewvSCw, eMULLEAZ);
				}
				sqlImpl().updateFunctions().checkAndUpdateDone(e736UWQJ, eMULLEAZ);
				sqlImpl().updateFunctions().checkAndUpdateDone(B6KkHwqY, eMULLEAZ);
				sqlImpl().updateFunctions().checkAndUpdateDone(zU4rzEyK, eMULLEAZ);
				sqlImpl().updateFunctions().checkAndUpdateDone(X7Y7Lxnq, eMULLEAZ);
				for (int Eiychk8H = 0; Eiychk8H < rAJYilTZ.length; Eiychk8H++) {
					String w3wu5Nvq = (String) ryphbtpi.get(rAJYilTZ[Eiychk8H]);
					sqlImpl().updateFunctions().checkAndUpdateTargetExecutable(w3wu5Nvq, eMULLEAZ);
				}
				sqlImpl().updateFunctions().checkAndUpdateTargetExecutable(e736UWQJ, eMULLEAZ);
				sqlImpl().updateFunctions().checkAndUpdateTargetExecutable(B6KkHwqY, eMULLEAZ);
				sqlImpl().updateFunctions().checkAndUpdateTargetExecutable(zU4rzEyK, eMULLEAZ);
				sqlImpl().updateFunctions().checkAndUpdateTargetExecutable(X7Y7Lxnq, eMULLEAZ);
				yN80bQHO = true;
			}
			sqlImpl().updateFunctions().checkAndUpdateDone(wHp5bPsL, eMULLEAZ);
			sqlImpl().updateFunctions().checkAndUpdateTargetExecutable(wHp5bPsL, eMULLEAZ);
			PreparedStatement dQBOUK7y = null;
			dQBOUK7y = eMULLEAZ.prepareStatementFromCache(sqlImpl().sqlStatements().updateTaskModificationStatement());
			java.util.Date G8gNSWeY = new java.util.Date();
			dQBOUK7y.setLong(1, G8gNSWeY.getTime());
			dQBOUK7y.setBoolean(2, yN80bQHO);
			dQBOUK7y.setString(3, liPrbJU6.context().task().key());
			dQBOUK7y.executeUpdate();
			sqlImpl().loggingFunctions().log(wHp5bPsL, LogEntry.ENDED, eMULLEAZ);
			eMULLEAZ.commit();
			return sqlImpl().queryFunctions().readPTask(wHp5bPsL, eMULLEAZ);
		} finally {
			eMULLEAZ.rollback();
		}
	}

}