/*
 * Copyright (C) 2005-2007 Les Hazlewood
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General
 * Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the
 *
 * Free Software Foundation, Inc.
 * 59 Temple Place, Suite 330
 * Boston, MA 02111-1307
 * USA
 *
 * Or, you may view it online at
 * http://www.opensource.org/licenses/lgpl-license.php
 */
package org.jsecurity.web.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @since 0.1
 * @author Les Hazlewood
 */
public abstract class RoleTag extends SecureTag {

    private String name = null;

    public RoleTag(){}

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public int onDoStartTag() throws JspException {
        boolean show = showTagBody( getName() );
        if ( show ) {
            return TagSupport.EVAL_BODY_INCLUDE;
        } else {
            return TagSupport.SKIP_BODY;
        }
    }

    protected abstract boolean showTagBody( String roleName );

}
