package com.aliouswang.olympic.playground;

import com.aliouswang.olympic.util.Log;

public class Test {

    public static void main(String[] args) {

        int COUNT_BITS = Integer.SIZE - 3;

        final int RUNNING    = -1 << COUNT_BITS;
        final int SHUTDOWN   =  0 << COUNT_BITS;
        final int STOP       =  1 << COUNT_BITS;
        final int TIDYING    =  2 << COUNT_BITS;
        final int TERMINATED =  3 << COUNT_BITS;

        Log.d(TIDYING + "," + TERMINATED);
    }

}
