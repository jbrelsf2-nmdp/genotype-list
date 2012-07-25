/*

    gl-service  URI-based RESTful service for the gl project.
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
package org.immunogenomics.gl.service.writer;

import org.apache.velocity.app.VelocityEngine;

import com.google.inject.Inject;

/**
 * Writer for XML format which validates against gl-resource-xlink.xsd.
 */
public final class XlinkXmlGlWriter extends AbstractTemplatedGlWriter {
    private static final String CONTENT_TYPE = "text/xml";

    @Inject
    public XlinkXmlGlWriter(final VelocityEngine velocityEngine) {
        locusTemplate = velocityEngine.getTemplate("/org/immunogenomics/gl/service/writer/locus.xlink-xml.wm");
        alleleTemplate = velocityEngine.getTemplate("/org/immunogenomics/gl/service/writer/allele.xlink-xml.wm");
        alleleListTemplate = velocityEngine.getTemplate("/org/immunogenomics/gl/service/writer/alleleList.xlink-xml.wm");
        haplotypeTemplate = velocityEngine.getTemplate("/org/immunogenomics/gl/service/writer/haplotype.xlink-xml.wm");
        genotypeTemplate = velocityEngine.getTemplate("/org/immunogenomics/gl/service/writer/genotype.xlink-xml.wm");
        genotypeListTemplate = velocityEngine.getTemplate("/org/immunogenomics/gl/service/writer/genotypeList.xlink-xml.wm");
        multilocusUnphasedGenotypeTemplate = velocityEngine.getTemplate("/org/immunogenomics/gl/service/writer/multilocusUnphasedGenotype.xlink-xml.wm");
    }


    @Override
    public String getContentType() {
        return CONTENT_TYPE;
    }
}