/*

    gl-service-functional-tests  Functional tests for the URI-based RESTful service for the gl project.
    Copyright (c) 2012 National Marrow Donor Program (NMDP)

    This library is free software; you can redistribute it and/or modify it
    under the terms of the GNU Lesser General Public License as published
    by the Free Software Foundation; either version 3 of the License, or (at
    your option) any later version.

    This library is distributed in the hope that it will be useful, but WITHOUT
    ANY WARRANTY; with out even the implied warranty of MERCHANTABILITY or
    FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public
    License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with this library;  if not, write to the Free Software Foundation,
    Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307  USA.

    > http://www.fsf.org/licensing/licenses/lgpl.html
    > http://www.opensource.org/licenses/lgpl-license.php

*/
package org.immunogenomics.gl.service.ft;

import org.junit.Before;

import com.jayway.restassured.http.ContentType;

/**
 * Functional test for /locus html content type.
 */
public final class LocusHtmlFT extends AbstractReadOnlyFunctionalTest {
    @Before
    public void setUp() {
        uri = "http://localhost:10080/gl/locus";
        contentType = ContentType.HTML;
        fileExtension = ".html";
        validId = "0";
        invalidId = "invalid id";
        validResponse = readResource("locus.html");
    }
}