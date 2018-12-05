package com.xuhuang.model;

import static com.xuhuang.constant.Constants.SUCCESS;

public class RestResponse
{
    private long totalNum;

    private Object detail;

    private String result;

    private int status;

    public RestResponse()
    {
        this.status = 200;
        this.result = SUCCESS;
    }

    public RestResponse(int status, String result, Object detail)
    {
        this.status = status;
        this.result = result;
        this.detail = detail;
    }

    public RestResponse(long totalNum, Object detail)
    {
        this.totalNum = totalNum;
        this.status = 200;
        this.detail = detail;
        this.result = SUCCESS;
    }

    public long getTotalNum()
    {
        return totalNum;
    }

    public void setTotalNum(long totalNum)
    {
        this.totalNum = totalNum;
    }

    public Object getDetail()
    {
        return detail;
    }

    public void setDetail(Object detail)
    {
        this.detail = detail;
    }

    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }
}
