

package com.ET199;




public class ET_EXCEPTION extends Exception
{

    public ET_EXCEPTION(int e)
    {
        nReason = e;
    }

    public String getReason()
    {
        String strErr[] = new String[1];
        ET199.ETFormatErrorMessage(nReason, strErr);
        return strErr[0];
    }

    public int getExceptionCode()
    {
        return nReason;
    }

    private int nReason;
}
