

package com.ET199;


class ET_CONTEXT
{

    public ET_CONTEXT(int nIndex)
    {
        dwIndex = nIndex;
        dwVersion = 0;
        hLock = 0;
        dwCustomer = 0;
        reserve = null;
        bAtr = null;
        bID = null;
    }

    public int dwIndex;
    public int dwVersion;
    public int hLock;
    public int dwCustomer;
    public byte bAtr[];
    public byte bID[];
    public byte reserve[];
}
