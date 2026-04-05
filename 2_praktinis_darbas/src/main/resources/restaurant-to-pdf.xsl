<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format"
                version="1.0">

    <xsl:output encoding="UTF-8" indent="yes"/>

    <xsl:template match="/">

        <fo:root>

            <!-- LAYOUT -->
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4"
                                       page-height="297mm"
                                       page-width="210mm"
                                       margin="10mm">

                    <fo:region-body margin-top="30mm"/>
                    <fo:region-before extent="25mm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <!-- PAGE -->
            <fo:page-sequence master-reference="A4">

                <!-- HEADER -->
                <fo:static-content flow-name="xsl-region-before">
                    <fo:block text-align="center" font-size="16pt" font-weight="bold">
                        RESTAURANT REPORT
                    </fo:block>
                </fo:static-content>

                <!-- BODY -->
                <fo:flow flow-name="xsl-region-body">

                    <!-- LOGO -->
                    <fo:block text-align="center" space-after="10mm">
                        <fo:external-graphic src="url('classpath:/images/restaurant.svg')" content-width="80mm"/>
                    </fo:block>

                    <!-- TABLE -->
                    <fo:table width="100%" table-layout="fixed" border="0.5pt solid black" border-collapse="collapse">

                        <fo:table-column column-width="20%"/>
                        <fo:table-column column-width="20%"/>
                        <fo:table-column column-width="20%"/>
                        <fo:table-column column-width="15%"/>
                        <fo:table-column column-width="25%"/>

                        <!-- HEADER -->
                        <fo:table-header>
                            <fo:table-row background-color="#eeeeee">
                                <fo:table-cell border="0.5pt solid black" padding="3pt"><fo:block text-align="center" font-weight="bold">Name</fo:block></fo:table-cell>
                                <fo:table-cell border="0.5pt solid black" padding="3pt"><fo:block text-align="center" font-weight="bold">Location</fo:block></fo:table-cell>
                                <fo:table-cell border="0.5pt solid black" padding="3pt"><fo:block text-align="center" font-weight="bold">Rating</fo:block></fo:table-cell>
                                <fo:table-cell border="0.5pt solid black" padding="3pt"><fo:block text-align="center" font-weight="bold">Status</fo:block></fo:table-cell>
                                <fo:table-cell border="0.5pt solid black" padding="3pt"><fo:block text-align="center" font-weight="bold">Menu</fo:block></fo:table-cell>
                            </fo:table-row>
                        </fo:table-header>

                        <!-- BODY -->
                        <fo:table-body>

                            <xsl:for-each select="restaurants/restaurant">

                                <fo:table-row>

                                    <!-- NAME -->
                                    <fo:table-cell border="0.5pt solid black" padding="3pt">
                                        <fo:block>
                                            <xsl:value-of select="name"/>
                                        </fo:block>
                                    </fo:table-cell>

                                    <!-- LOCATION -->
                                    <fo:table-cell border="0.5pt solid black" padding="3pt">
                                        <fo:block>
                                            <fo:external-graphic src="url('classpath:/images/city.svg')" content-width="6mm"/>
                                            <fo:inline>
                                                <xsl:text> </xsl:text>
                                                <xsl:value-of select="location"/>
                                            </fo:inline>
                                        </fo:block>
                                    </fo:table-cell>

                                    <!-- RATING WITH STARS -->
                                    <fo:table-cell border="0.5pt solid black" padding="3pt">
                                        <fo:block>
                                            <fo:external-graphic src="url('classpath:/images/star.svg')" content-width="5mm"/>
                                            <fo:inline>
                                                <xsl:text> </xsl:text>
                                                <xsl:value-of select="rating"/>
                                            </fo:inline>
                                        </fo:block>
                                    </fo:table-cell>

                                    <!-- STATUS -->
                                    <fo:table-cell border="0.5pt solid black" padding="3pt">
                                        <fo:block>
                                            <xsl:choose>
                                                <xsl:when test="open='true'">
                                                    <fo:external-graphic src="url('classpath:/images/open.svg')" content-width="8mm"/>
                                                    Open
                                                </xsl:when>
                                                <xsl:otherwise>
                                                    <fo:external-graphic src="url('classpath:/images/closed.svg')" content-width="8mm"/>
                                                    Closed
                                                </xsl:otherwise>
                                            </xsl:choose>
                                        </fo:block>
                                    </fo:table-cell>

                                    <!-- MENU -->
                                    <fo:table-cell border="0.5pt solid black" padding="3pt">
                                        <fo:block>

                                            <xsl:choose>
                                                <xsl:when test="menu/item">
                                                    <xsl:for-each select="menu/item">
                                                        • <xsl:value-of select="name"/> ($<xsl:value-of select="price"/>)
                                                        <fo:block/>
                                                    </xsl:for-each>
                                                </xsl:when>

                                                <xsl:otherwise>
                                                    <fo:inline font-style="italic">No menu</fo:inline>
                                                </xsl:otherwise>

                                            </xsl:choose>

                                        </fo:block>
                                    </fo:table-cell>

                                </fo:table-row>

                            </xsl:for-each>

                        </fo:table-body>

                    </fo:table>

                </fo:flow>
            </fo:page-sequence>

        </fo:root>

    </xsl:template>

</xsl:stylesheet>