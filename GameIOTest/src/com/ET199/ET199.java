

package com.ET199;





public class ET199 {

	public static native int ETEnum(ET_CONTEXT aet_context[], int ai[]);

	public static native int ETOpen(ET_CONTEXT et_context);

	public static native int ETClose(ET_CONTEXT et_context);

	public static native int ETControl(ET_CONTEXT et_context, int i,
			byte abyte0[], int j, byte abyte1[], int k, int ai[]);

	public static native int ETCreateDir(ET_CONTEXT et_context, String s,
			int i, int j);

	public static native int ETChangeDir(ET_CONTEXT et_context, String s);

	public static native int ETEraseDir(ET_CONTEXT et_context, String s);

	public static native int ETVerifyPin(ET_CONTEXT et_context, byte abyte0[],
			int i);

	public static native int ETChangePin(ET_CONTEXT et_context, byte abyte0[],
			int i, byte abyte1[], int j, int k, byte byte0);

	public static native int ETWriteFile(ET_CONTEXT et_context, String s,
			int i, byte abyte0[], int j);

	public static native int ETExecute(ET_CONTEXT et_context, String s,
			byte abyte0[], int i, byte abyte1[], int j, int ai[]);

	public static native int ETCreateFile(ET_CONTEXT et_context, String s,
			int i, byte byte0);

	public static native int ETGenRsaKey(ET_CONTEXT et_context, short word0,
			int i, String s, String s1, byte abyte0[], int ai[], byte abyte1[],
			int ai1[]);

	public static native int ETFormatErrorMessage(int i, String as[]);

	public ET199() {
		System.out.println("ET199 open");
		m_ctx = null;
	}

	public ET199(int nDevIndex) throws ET_EXCEPTION {
		System.out.println("ET199 open2");
		Open(nDevIndex);
	}

	public int GetVersion() {
		return m_ctx.dwVersion;
	}

	public int GetCustomer() {
		return m_ctx.dwCustomer;
	}

	public byte[] GetAtr() {
		return m_ctx.bAtr;
	}

	public byte[] GetID() {
		return m_ctx.bID;
	}

	public static int Enum() throws ET_EXCEPTION {
		int nDevCount[] = new int[1];
		int nRet = ETEnum(null, nDevCount);
		if (nRet != 0 && nRet != 0xf0000004)
			throw new ET_EXCEPTION(nRet);
		else
			return nDevCount[0];
	}

	public void Open(int nDevIndex) throws ET_EXCEPTION {
		m_ctx = new ET_CONTEXT(nDevIndex);
		int nRet = ETOpen(m_ctx);
		if (nRet != 0)
			throw new ET_EXCEPTION(nRet);
		else
			return;
	}

	public void Close() throws ET_EXCEPTION {
		int nRet = ETClose(m_ctx);
		if (nRet != 0)
			throw new ET_EXCEPTION(nRet);
		else
			return;
	}

	public void Control(int nCtrlCode, byte byInBuf[], int nInDataSize,
			byte byOutBuf[], int lpBytesReturn[]) throws ET_EXCEPTION {
		int nRet = ETControl(m_ctx, nCtrlCode, byInBuf, nInDataSize, byOutBuf,
				0, lpBytesReturn);
		if (nRet != 0)
			throw new ET_EXCEPTION(nRet);
		else
			return;
	}

	public void CreateDir(String strDirID, int nDirSize, int nFlags)
			throws ET_EXCEPTION {
		int nRet = ETCreateDir(m_ctx, strDirID, nDirSize, nFlags);
		if (nRet != 0)
			throw new ET_EXCEPTION(nRet);
		else
			return;
	}

	public void ChangeDir(String strPath) throws ET_EXCEPTION {
		int nRet = ETChangeDir(m_ctx, strPath);
		if (nRet != 0)
			throw new ET_EXCEPTION(nRet);
		else
			return;
	}

	public void EraseDir(String strSubDirID) throws ET_EXCEPTION {
		int nRet = ETEraseDir(m_ctx, strSubDirID);
		if (nRet != 0)
			throw new ET_EXCEPTION(nRet);
		else
			return;
	}

	public void VerifyPin(byte pbPin[], int nPinType) throws ET_EXCEPTION {
		int nRet = ETVerifyPin(m_ctx, pbPin, nPinType);
		if (nRet != 0)
			throw new ET_EXCEPTION(nRet);
		else
			return;
	}

	public void ChangePin(byte byOldPin[], byte byNewPin[], int nPinType,
			byte byNewTryCount) throws ET_EXCEPTION {
		int nRet = ETChangePin(m_ctx, byOldPin, 0, byNewPin, 0, nPinType,
				byNewTryCount);
		if (nRet != 0)
			throw new ET_EXCEPTION(nRet);
		else
			return;
	}

	public void WriteFile(String strFileID, int nOffset, byte pBuffer[],
			int nDataSize) throws ET_EXCEPTION {
		int nRet = ETWriteFile(m_ctx, strFileID, nOffset, pBuffer, nDataSize);
		if (nRet != 0)
			throw new ET_EXCEPTION(nRet);
		else
			return;
	}

	public void Execute(String strFileID, byte pInBuf[], int nInDataSize,
			byte pOutBuf[], int pnBytesReturn[]) throws ET_EXCEPTION {
		int nRet = ETExecute(m_ctx, strFileID, pInBuf, nInDataSize, pOutBuf, 0,
				pnBytesReturn);
		if (nRet != 0)
			throw new ET_EXCEPTION(nRet);
		else
			return;
	}

	public void CreateFile(String strFileID, int nFileSize, byte bFileType)
			throws ET_EXCEPTION {
		int nRet = ETCreateFile(m_ctx, strFileID, nFileSize, bFileType);
		if (nRet != 0)
			throw new ET_EXCEPTION(nRet);
		else
			return;
	}

	public void GenRsaKey(short wKeySize, int nExp, String strPubFileID,
			String strPriFileID, byte pbPubKey[], int nPubDataSize[],
			byte pbPriKey[], int nPriDataSize[]) throws ET_EXCEPTION {
		int nRet = ETGenRsaKey(m_ctx, wKeySize, nExp, strPubFileID,
				strPriFileID, pbPubKey, nPubDataSize, pbPriKey, nPriDataSize);
		if (nRet != 0)
			throw new ET_EXCEPTION(nRet);
		else
			return;
	}

	public static final int ET_S_SUCCESS = 0;
	public static final int ET_E_KEY_REMOVED = 0xf0000001;
	public static final int ET_E_INVALID_PARAMETER = 0xf0000002;
	public static final int ET_E_COMM_ERROR = 0xf0000003;
	public static final int ET_E_INSUFFICIENT_BUFFER = 0xf0000004;
	public static final int ET_E_NO_LIST = 0xf0000005;
	public static final int ET_E_DEVPIN_NOT_CHECK = 0xf0000006;
	public static final int ET_E_USERPIN_NOT_CHECK = 0xf0000007;
	public static final int ET_E_RSA_FILE_FORMAT_ERROR = 0xf0000008;
	public static final int ET_E_DIR_NOT_FOUND = 0xf0000009;
	public static final int ET_E_ACCESS_DENIED = 0xf000000a;
	public static final int ET_E_ALREADY_INITIALIZED = 0xf000000b;
	public static final int ET_E_INCORRECT_PIN = 0xf000000c;
	public static final int ET_E_DF_SIZE = 0xf000000d;
	public static final int ET_E_FILE_EXISTED = 0xf000000e;
	public static final int ET_E_UNSUPPORTED = 0xf000000f;
	public static final int ET_E_FILE_NOT_FOUND = 0xf0000010;
	public static final int ET_E_ALREADY_OPENED = 0xf0000011;
	public static final int ET_E_DIRECTORY_EXIST = 0xf0000012;
	public static final int ET_E_CODE_RANGE = 0xf0000013;
	public static final int ET_E_INVALID_POINTER = 0xf0000014;
	public static final int ET_E_GENERAL_FILESYSTEM = 0xf0000015;
	public static final int ET_E_OFFSET_BEYOND = 0xf0000016;
	public static final int ET_E_FILE_TYPE_MISMATCH = 0xf0000017;
	public static final int ET_E_PIN_BLOCKED = 0xf0000018;
	public static final int ET_E_INVALID_CONTEXT = 0xf0000019;
	public static final int ET_E_ERROR_UNKNOWN = -1;
	public static final int MAX_ATR_LEN = 16;
	public static final int MAX_ID_LEN = 8;
	public static final int ET_USER_PIN = 0;
	public static final int ET_DEV_PIN = 1;
	public static final int ET_ROOT_DIR = 0;
	public static final int ET_SUB_DIR = 1;
	public static final int ET_LED_UP = 1;
	public static final int ET_LED_DOWN = 2;
	public static final int ET_LED_WINK = 3;
	public static final int ET_GET_DEVICE_TYPE = 17;
	public static final int ET_GET_SERIAL_NUMBER = 18;
	public static final int ET_GET_DEVICE_USABLE_SPACE = 19;
	public static final int ET_GET_DEVICE_ATR = 20;
	public static final int ET_GET_CUSTOMER_NAME = 21;
	public static final int ET_GET_MANUFACTURE_DATE = 22;
	public static final int ET_GET_DF_AVAILABLE_SPACE = 23;
	public static final int ET_GET_EF_INFO = 24;
	public static final int ET_GET_COS_VERSION = 25;
	public static final int ET_SET_DEVICE_ATR = 33;
	public static final int ET_SET_DEVICE_TYPE = 34;
	public static final int ET_SET_SHELL_KEY = 35;
	public static final int ET_SET_CUSTOMER_NAME = 36;
	public static final byte ET_RESET_DEVICE = 49;
	public static final byte ET_TOKEN_TYPE_PKI = 1;
	public static final byte ET_TOKEN_TYPE_DONGLE = 2;
	public static final byte ET_TOKEN_TYPE_EMPTY = 4;
	public static final byte ET_DEFAULT_TRY = -1;
	public static final int ET_DEV_PIN_LEN = 24;
	public static final int ET_USER_PIN_LEN = 8;
	public static final byte FILE_TYPE_EXE = 0;
	public static final byte FILE_TYPE_DATA = 1;
	public static final byte FILE_TYPE_RSA_PUBLIC = 2;
	public static final byte FILE_TYPE_RSA_PRIVATE = 3;
	public static final byte FILE_TYPE_INTERNAL_EXE = 4;
	public static final byte ET_DEFAULT_DEV_PIN[] = { 31, 32, 33, 34, 35, 36,
			37, 38, 31, 32, 33, 34, 35, 36, 37, 38, 31, 32, 33, 34, 35, 36, 37,
			38 };
	public static final byte ET_DEFAULT_USER_PIN[] = { 31, 32, 33, 34, 35, 36,
			37, 38 };
	private ET_CONTEXT m_ctx;

	static {
		System.loadLibrary("JavaET199");
	}
}
