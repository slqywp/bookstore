package com.xuhuang.util;

import static com.xuhuang.constant.Constants.INT_0;

public class PaginationUtil
{
    public static int trans2DataStart(Integer pageNo, Integer pageSize)
    {
        if (pageNo == null || pageNo < 1)
        {
            return INT_0;
        }
        return (pageNo - 1) * pageSize;
    }
}
