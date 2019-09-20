/**
 * @author Moti
 */
package com.quest.continents.country.flag.poc.model;

import java.io.Serializable;

/**
 * The Class Countres.
 */
public class Countries implements Serializable {
	    
	/**
	 * 
	 */
	private static final long serialVersionUID = -1807383900653659635L;

	/** The flag. */
	private String flag;
    
	/** The name. */
    private String name;

    public Countries(String name, String flag) {
		this.name = name;
		this.flag = flag;
	}

    /**
	 * Gets the flag.
	 *
	 * @return the flag
	 */
	public String getFlag ()
    {
        return flag;
    }

    public void setFlag (String flag)
    {
        this.flag = flag;
    }

    /**
	 * Gets the name.
	 *
	 * @return the name
	 */
    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString()
    {
        return "ClassPojo [flag = "+flag+", name = "+name+"]";
    }
}