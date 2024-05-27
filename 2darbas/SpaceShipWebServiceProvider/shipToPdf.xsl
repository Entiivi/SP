<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">

    <xsl:template match="starship">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="page" page-height="29.7cm" page-width="21cm"
                                       margin-top="1cm" margin-bottom="1cm" margin-left="1cm" margin-right="1cm">
                    <fo:region-body margin-top="3cm" margin-bottom="3cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-size="18pt" font-weight="bold" text-align="center">Starship Crew</fo:block>
                    <fo:block font-size="14pt" font-weight="bold" margin-top="20pt">Captain</fo:block>
                    <fo:block margin-left="20pt">
                        <xsl:apply-templates select="//captain"/>
                    </fo:block>
                    <fo:block font-size="14pt" font-weight="bold" margin-top="20pt">Crew Members</fo:block>
                    <fo:block margin-left="20pt">
                        <xsl:apply-templates select="//crewMember"/>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

    <xsl:template match="captain | crewMember">
        <fo:block font-size="12pt" margin-bottom="10pt">
            <xsl:value-of select="name"/>
            <fo:inline font-style="italic">
                <xsl:text> (</xsl:text>
                <xsl:value-of select="responsibility"/>
                <xsl:text>)</xsl:text>
            </fo:inline>
        </fo:block>
    </xsl:template>

</xsl:stylesheet>
