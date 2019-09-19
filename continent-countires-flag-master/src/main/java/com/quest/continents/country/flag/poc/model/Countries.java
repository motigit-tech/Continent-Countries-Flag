package com.quest.continents.country.flag.poc.model;

public class Countries
{
    private String flag;

    private String name;

    public Countries(String name, String flag) {
		this.name = name;
		this.flag = flag;
	}

	public String getFlag ()
    {
        return flag;
    }

    public void setFlag (String flag)
    {
        this.flag = flag;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [flag = "+flag+", name = "+name+"]";
    }
}