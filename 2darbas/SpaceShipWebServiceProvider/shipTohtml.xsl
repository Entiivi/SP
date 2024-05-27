<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <!-- Match the root element -->
    <xsl:template match="/starship">
        <html>
            <head>
                <title>Starship Crew</title>
            </head>
            <body>
                <h1>Starship Crew</h1>
                <table border="1">
                    <tr>
                        <th>Ship Name</th>
                        <td><xsl:value-of select="shipName"/></td>
                    </tr>
                </table>
                <h2>Crew Members</h2>
                <table border="1">
                    <tr>
                        <th>Name</th>
                        <th>Crew Member Number</th>
                        <th>Responsibility</th>
                        <th>Interest</th>
                    </tr>
                    <xsl:apply-templates select="crewMember"/>
                </table>
            </body>
        </html>
    </xsl:template>

    <!-- Match each crew member -->
    <xsl:template match="crewMember">
        <tr>
            <td><xsl:value-of select="name"/></td>
            <td><xsl:value-of select="crewMemberNumber"/></td>
            <td><xsl:value-of select="responsibility"/></td>
            <td><xsl:value-of select="interest"/></td>
        </tr>
    </xsl:template>

</xsl:stylesheet>
