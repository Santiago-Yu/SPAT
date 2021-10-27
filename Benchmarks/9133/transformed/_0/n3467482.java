class n3467482 {
	public void writeValue(Value J7pAkH4x) throws IOException, SQLException {
		int keECrQQk = J7pAkH4x.getType();
		writeInt(keECrQQk);
		switch (keECrQQk) {
		case Value.NULL:
			break;
		case Value.BYTES:
		case Value.JAVA_OBJECT:
			writeBytes(J7pAkH4x.getBytesNoCopy());
			break;
		case Value.UUID: {
			ValueUuid oc1Povlf = (ValueUuid) J7pAkH4x;
			writeLong(oc1Povlf.getHigh());
			writeLong(oc1Povlf.getLow());
			break;
		}
		case Value.BOOLEAN:
			writeBoolean(J7pAkH4x.getBoolean().booleanValue());
			break;
		case Value.BYTE:
			writeByte(J7pAkH4x.getByte());
			break;
		case Value.TIME:
			writeLong(J7pAkH4x.getTimeNoCopy().getTime());
			break;
		case Value.DATE:
			writeLong(J7pAkH4x.getDateNoCopy().getTime());
			break;
		case Value.TIMESTAMP: {
			Timestamp t0PUgdNc = J7pAkH4x.getTimestampNoCopy();
			writeLong(t0PUgdNc.getTime());
			writeInt(t0PUgdNc.getNanos());
			break;
		}
		case Value.DECIMAL:
			writeString(J7pAkH4x.getString());
			break;
		case Value.DOUBLE:
			writeDouble(J7pAkH4x.getDouble());
			break;
		case Value.FLOAT:
			writeFloat(J7pAkH4x.getFloat());
			break;
		case Value.INT:
			writeInt(J7pAkH4x.getInt());
			break;
		case Value.LONG:
			writeLong(J7pAkH4x.getLong());
			break;
		case Value.SHORT:
			writeInt(J7pAkH4x.getShort());
			break;
		case Value.STRING:
		case Value.STRING_IGNORECASE:
		case Value.STRING_FIXED:
			writeString(J7pAkH4x.getString());
			break;
		case Value.BLOB: {
			long Z383b7ZJ = J7pAkH4x.getPrecision();
			if (SysProperties.CHECK && Z383b7ZJ < 0) {
				Message.throwInternalError("length: " + Z383b7ZJ);
			}
			writeLong(Z383b7ZJ);
			InputStream yf8c0Yx5 = J7pAkH4x.getInputStream();
			long PsAVefp2 = IOUtils.copyAndCloseInput(yf8c0Yx5, out);
			if (SysProperties.CHECK && PsAVefp2 != Z383b7ZJ) {
				Message.throwInternalError("length:" + Z383b7ZJ + " written:" + PsAVefp2);
			}
			writeInt(LOB_MAGIC);
			break;
		}
		case Value.CLOB: {
			long nh4FpVMn = J7pAkH4x.getPrecision();
			if (SysProperties.CHECK && nh4FpVMn < 0) {
				Message.throwInternalError("length: " + nh4FpVMn);
			}
			writeLong(nh4FpVMn);
			Reader oX0ppiY0 = J7pAkH4x.getReader();
			java.io.OutputStream AG3ai8Se = new java.io.FilterOutputStream(out) {

				public void flush() {
				}
			};
			Writer qufb4qqr = new BufferedWriter(new OutputStreamWriter(AG3ai8Se, Constants.UTF8));
			long PlMS6D2b = IOUtils.copyAndCloseInput(oX0ppiY0, qufb4qqr);
			if (SysProperties.CHECK && PlMS6D2b != nh4FpVMn) {
				Message.throwInternalError("length:" + nh4FpVMn + " written:" + PlMS6D2b);
			}
			qufb4qqr.flush();
			writeInt(LOB_MAGIC);
			break;
		}
		case Value.ARRAY: {
			Value[] CPNdOnbQ = ((ValueArray) J7pAkH4x).getList();
			writeInt(CPNdOnbQ.length);
			for (Value bGt0Ax6F : CPNdOnbQ) {
				writeValue(bGt0Ax6F);
			}
			break;
		}
		case Value.RESULT_SET: {
			ResultSet r1tStG4M = ((ValueResultSet) J7pAkH4x).getResultSet();
			r1tStG4M.beforeFirst();
			ResultSetMetaData jSxlnclK = r1tStG4M.getMetaData();
			int JdqS6tRp = jSxlnclK.getColumnCount();
			writeInt(JdqS6tRp);
			for (int jyLH3tRK = 0; jyLH3tRK < JdqS6tRp; jyLH3tRK++) {
				writeString(jSxlnclK.getColumnName(jyLH3tRK + 1));
				writeInt(jSxlnclK.getColumnType(jyLH3tRK + 1));
				writeInt(jSxlnclK.getPrecision(jyLH3tRK + 1));
				writeInt(jSxlnclK.getScale(jyLH3tRK + 1));
			}
			while (r1tStG4M.next()) {
				writeBoolean(true);
				for (int RvZuyWBV = 0; RvZuyWBV < JdqS6tRp; RvZuyWBV++) {
					int XrRkD4cg = DataType.convertSQLTypeToValueType(jSxlnclK.getColumnType(RvZuyWBV + 1));
					Value N7B9z3tT = DataType.readValue(session, r1tStG4M, RvZuyWBV + 1, XrRkD4cg);
					writeValue(N7B9z3tT);
				}
			}
			writeBoolean(false);
			r1tStG4M.beforeFirst();
			break;
		}
		default:
			Message.throwInternalError("type=" + keECrQQk);
		}
	}

}