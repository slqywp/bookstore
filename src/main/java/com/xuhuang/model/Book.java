package com.xuhuang.model;

public class Book
{
    private Long id;

    private String name;

    private String author;

    private String brief;

    private String cover;

    private String type;

    private String adaptAge;

    private long invNum;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getBrief()
    {
        return brief;
    }

    public void setBrief(String brief)
    {
        this.brief = brief;
    }

    public String getCover()
    {
        return cover;
    }

    public void setCover(String cover)
    {
        this.cover = cover;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getAdaptAge()
    {
        return adaptAge;
    }

    public void setAdaptAge(String adaptAge)
    {
        this.adaptAge = adaptAge;
    }

    public long getInvNum()
    {
        return invNum;
    }

    public void setInvNum(long invNum)
    {
        this.invNum = invNum;
    }
}
