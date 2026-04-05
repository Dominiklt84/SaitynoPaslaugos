<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:output method="html" encoding="UTF-8" indent="yes"/>

    <xsl:template match="/">

        <html>
            <head>
                <title>Restaurant Report</title>

                <style>
                    body {
                    font-family: Arial;
                    background-color: #f5f5f5;
                    }

                    h1 {
                    text-align: center;
                    }

                    table {
                    width: 90%;
                    margin: auto;
                    border-collapse: collapse;
                    background: white;
                    }

                    th, td {
                    border: 1px solid black;
                    padding: 8px;
                    text-align: center;
                    }

                    th {
                    background-color: #cccccc;
                    }

                    tr:nth-child(even) {
                    background-color: #f9f9f9;
                    }

                    .open {
                    color: green;
                    font-weight: bold;
                    }

                    .closed {
                    color: red;
                    font-weight: bold;
                    }

                    .menu {
                    text-align: left;
                    }

                    img.icon {
                    width: 20px;
                    vertical-align: middle;
                    }
                </style>

            </head>

            <body>

                <h1>Restaurant Report</h1>

                <table>
                    <tr>
                        <th>Name</th>
                        <th>Location</th>
                        <th>Rating</th>
                        <th>Status</th>
                        <th>Menu</th>
                    </tr>

                    <xsl:for-each select="restaurants/restaurant">

                        <tr>
                            <!-- NAME -->
                            <td>
                                <xsl:value-of select="name"/>
                            </td>

                            <!-- LOCATION + ICON -->
                            <td>
                                <img class="icon" src="images/city.svg"/>
                                <xsl:text> </xsl:text>
                                <xsl:value-of select="location"/>
                            </td>

                            <!-- RATING -->
                            <td>
                                <img class="icon" src="images/star.svg"/>
                                <xsl:text> </xsl:text>
                                <xsl:value-of select="rating"/>
                            </td>

                            <!-- STATUS -->
                            <td>
                                <xsl:choose>
                                    <xsl:when test="open='true'">
                                        <span class="open">
                                            <img class="icon" src="images/open.svg"/> Open
                                        </span>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <span class="closed">
                                            <img class="icon" src="images/closed.svg"/> Closed
                                        </span>
                                    </xsl:otherwise>
                                </xsl:choose>
                            </td>

                            <!-- MENU -->
                            <td class="menu">
                                <xsl:choose>
                                    <xsl:when test="menu/item">
                                        <ul>
                                            <xsl:for-each select="menu/item">
                                                <li>
                                                    <xsl:value-of select="name"/>
                                                    ($<xsl:value-of select="price"/>)
                                                </li>
                                            </xsl:for-each>
                                        </ul>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <i>No menu</i>
                                    </xsl:otherwise>
                                </xsl:choose>
                            </td>

                        </tr>

                    </xsl:for-each>

                </table>

            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>