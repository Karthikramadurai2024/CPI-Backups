<?xml version="1.0" encoding="UTF-8"?>
<!--Get AssocationIds of particular site-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:S="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ns5="http://sim.aravo.com/soapservices/v4_2/AssociationService">
	<xsl:output omit-xml-declaration="no" indent="yes"/>
	<xsl:param name="supplierId"/>
	<xsl:template match="ns5:getAssociatedEntitiesResponse">
		<Output>
    <xsl:for-each select="return">
      <request>
            <brType>Site</brType>
            <brid><xsl:value-of select="id"/></brid>
            <bridType>internalId</bridType>
            <sid><xsl:value-of select="$supplierId"/></sid>
            <sidType>internalId</sidType>
      </request>
    </xsl:for-each>
    <xsl:for-each select="return/associatedEntities[subtypeKey = 'Banking']">
        <xsl:sort select="id" data-type="text" order="ascending"/>
      <request>
            <brType><xsl:value-of select="subtypeKey"/></brType>
            <brid><xsl:value-of select="id"/></brid>
            <bridType>internalId</bridType>
            <sid><xsl:value-of select="$supplierId"/></sid>
            <sidType>internalId</sidType>
      </request>
    </xsl:for-each>
    <xsl:for-each select="return/associatedEntities[subtypeKey = 'Contact']">
      <request>
            <supplierContactId><xsl:value-of select="id"/></supplierContactId>
      </request>
    </xsl:for-each>
		</Output>
	</xsl:template>
	<xsl:template match="text()" priority="-100"> </xsl:template>
</xsl:stylesheet>