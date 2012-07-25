/*

    gl-core  Core interfaces and classes for the gl project.
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
package org.immunogenomics.gl;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableList;

/**
 * Unit test for MultilocusUnphasedGenotype.
 */
public final class MultilocusUnphasedGenotypeTest {
    private final Locus a = new Locus("http://immunogenomics.org/locus/0", "HLA-A");
    private final Locus b = new Locus("http://immunogenomics.org/locus/1", "HLA-B");
    private final Allele allele0 = new Allele("http://immunogenomics.org/allele/0", "A00001", "HLA-A*01:01:01:01", a);
    private final Allele allele1 = new Allele("http://immunogenomics.org/allele/1", "A00002", "HLA-A*02:01:01:01", a);
    private final Allele allele2 = new Allele("http://immunogenomics.org/allele/2", "B00001", "HLA-B*01:01:01:01", b);
    private final Allele allele3 = new Allele("http://immunogenomics.org/allele/3", "B00002", "HLA-B*02:01:01:01", b);
    private final AlleleList aAlleleList0 = new AlleleList("http://immunogenomics.org/allele-list/0", ImmutableList.of(allele0));
    private final AlleleList aAlleleList1 = new AlleleList("http://immunogenomics.org/allele-list/1", ImmutableList.of(allele1));
    private final AlleleList bAlleleList0 = new AlleleList("http://immunogenomics.org/allele-list/2", ImmutableList.of(allele2));
    private final AlleleList bAlleleList1 = new AlleleList("http://immunogenomics.org/allele-list/3", ImmutableList.of(allele3));
    private final List<AlleleList> aAlleleLists = ImmutableList.of(aAlleleList0, aAlleleList1);
    private final List<AlleleList> bAlleleLists = ImmutableList.of(bAlleleList0, bAlleleList1);
    private final List<Haplotype> emptyHaplotypes = Collections.emptyList();
    private final Genotype aGenotype = new Genotype("http://immunogenomics.org/genotype/0", aAlleleLists, emptyHaplotypes);
    private final Genotype bGenotype = new Genotype("http://immunogenomics.org/genotype/1", bAlleleLists, emptyHaplotypes);
    private final List<Genotype> aGenotypes = ImmutableList.of(aGenotype);
    private final List<Genotype> bGenotypes = ImmutableList.of(bGenotype);
    private final GenotypeList aGenotypeList = new GenotypeList("http://immunogenomics.org/genotype-list/0", aGenotypes);
    private final GenotypeList bGenotypeList = new GenotypeList("http://immunogenomics.org/genotype-list/1", bGenotypes);
    private final List<GenotypeList> empty = Collections.emptyList();
    private final List<GenotypeList> single = ImmutableList.of(aGenotypeList);
    private final List<GenotypeList> genotypeLists = ImmutableList.of(aGenotypeList, bGenotypeList);

    @Test(expected=NullPointerException.class)
    public void testConstructorNullIdentifier() {
        new MultilocusUnphasedGenotype(null, genotypeLists);
    }

    @Test(expected=NullPointerException.class)
    public void testConstructorNullGenotypeLists() {
        new MultilocusUnphasedGenotype("http://immunogenomics.org/multilocus-unphased-genotype/0", null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testConstructorEmptyGenotypeLists() {
        new MultilocusUnphasedGenotype("http://immunogenomics.org/multilocus-unphased-genotype/0", empty);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testConstructorNotEnoughGenotypeLists() {
        new MultilocusUnphasedGenotype("http://immunogenomics.org/multilocus-unphased-genotype/0", single);
    }

    @Test
    public void testId() {
        MultilocusUnphasedGenotype genotype = new MultilocusUnphasedGenotype("http://immunogenomics.org/multilocus-unphased-genotype/0", genotypeLists);
        assertEquals("http://immunogenomics.org/multilocus-unphased-genotype/0", genotype.getId());
    }

    @Test
    public void testGlstring() {
        MultilocusUnphasedGenotype genotype = new MultilocusUnphasedGenotype("http://immunogenomics.org/multilocus-unphased-genotype/0", genotypeLists);
        assertEquals("HLA-A*01:01:01:01+HLA-A*02:01:01:01^HLA-B*01:01:01:01+HLA-B*02:01:01:01", genotype.getGlstring());
    }

    @Test
    public void testGenotypeLists() {
        MultilocusUnphasedGenotype genotype = new MultilocusUnphasedGenotype("http://immunogenomics.org/multilocus-unphased-genotype/0", genotypeLists);
        assertEquals(genotypeLists, genotype.getGenotypeLists());
    }

    @Test
    public void testToStringIsGlstring() {
        MultilocusUnphasedGenotype genotype = new MultilocusUnphasedGenotype("http://immunogenomics.org/multilocus-unphased-genotype/0", genotypeLists);
        assertEquals(genotype.getGlstring(), genotype.toString());
    }
}